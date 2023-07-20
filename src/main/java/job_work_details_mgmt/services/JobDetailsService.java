package job_work_details_mgmt.services;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Optional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import job_template_details_mgmt.model.details.JobTemplateDetails;
import job_template_details_mgmt.model.details.JobTemplateDetailsPK;
import job_template_details_mgmt.model.repo.JobTemplateDetailsRepo;
import job_type_master_mgmt.model.repo.JobTypeMasterRepo;
import job_type_structure_details_mgmt.model.details.JobTypeStructureDetails;
import job_type_structure_details_mgmt.model.repo.JobTypeStructureDetailsRepo;
import job_work_details_mgmt.model.details.JobDetails;
import job_work_details_mgmt.model.dto.JobDetailsDTO;
import job_work_details_mgmt.model.repo.JobDetailsRepo;
import job_work_master_mgmt.model.master.JobMaster;
import job_work_master_mgmt.model.repo.JobMasterRepo;

@Service("jobDetailsServ")
@Scope("prototype")
@Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.READ_COMMITTED)
public class JobDetailsService implements I_JobDetailsService {

	private static final Logger logger = LoggerFactory.getLogger(JobDetailsService.class);

	@Autowired
	private JobMasterRepo jobMasterRepo;

	@Autowired
	private JobDetailsRepo jobDetailsRepo;

	@Autowired
	JobTemplateDetailsRepo jobTemplateDetailsRepo;

	@Autowired
	JobTypeStructureDetailsRepo jobTypeStructureDetailsRepo;

	@Autowired
	JobTypeMasterRepo jobTypeMasterRepo;

	@Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.READ_COMMITTED)
	@Scheduled(fixedRate = 3000)
	public void scheduleJobs() {
		logger.info("started schedule task");
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
		ArrayList<JobMaster> jobMasters = jobMasterRepo.getJobsToBeScheduled();
		Long servWorkSeqNo = null;
		Long mgr_seq_no = null;
		Long jobTemplateSeqNo = null;
		BigDecimal opFlag = null;
		String startDateTime = null;

		if (jobMasters != null) {
			for (int i2 = 0; i2 < jobMasters.size(); i2++) {
				servWorkSeqNo = jobMasters.get(i2).getServiceWorkSeqNo();
				jobTemplateSeqNo = jobMasters.get(i2).getJobTemplateSeqNo();
				mgr_seq_no = jobMasters.get(i2).getManagerSeqNo();
				startDateTime = formatter.format(jobMasters.get(i2).getCreatedOn().toLocalDateTime());
				opFlag = jobMasters.get(i2).getOpFlag();
				doJobsForTemplate(servWorkSeqNo, jobTemplateSeqNo, mgr_seq_no, startDateTime, opFlag);
				jobMasterRepo.updateScheduledServiceWork(servWorkSeqNo);
			}
		}
		logger.info("stopped schedule task");
		return;
	}

	@Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.READ_COMMITTED)
	public ArrayList<Long> doJobsForTemplate(Long servWorkSeqNo, Long jobTemplateSeqNo, Long mgr_seq_no,
			String startDateTime, BigDecimal opFlag) {
		ArrayList<Long> jobSeqNos = new ArrayList<Long>();
		ArrayList<JobDetails> jobMasters2 = jobDetailsRepo.getSelectJobDetailsForService(servWorkSeqNo);
		
		if (jobMasters2 != null && jobMasters2.size() > 0) 
		{
			jobDetailsRepo.delSelectJobDetailsForService(servWorkSeqNo);
		}

		ArrayList<JobDetailsDTO> jobDetailsDTOs = this.processJobDetails(jobTemplateSeqNo, startDateTime, opFlag);

		// Create Job Schedule
		for (int i = 0; i < jobDetailsDTOs.size(); i++) 
		{
			jobDetailsDTOs.get(i).setManagerSeqNo(mgr_seq_no);
			jobDetailsDTOs.get(i).setServiceWorkSeqNo(servWorkSeqNo);
			jobSeqNos.add(jobDetailsRepo.save(this.setJobDetails(jobDetailsDTOs.get(i))).getJobSeqNo());
		}

		return jobSeqNos;
	}

	public ArrayList<JobDetailsDTO> processJobDetails(Long jobTemplateSeqNo, String startDateTime, BigDecimal opFlag) 
	{
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
		LocalDateTime ldt = LocalDateTime.parse(startDateTime, formatter);
		Timestamp currDate = Timestamp.valueOf(ldt);
		Timestamp endDate = null;
		Long seq_no = (long) 1;
		Long jobTypeSeqNo, jobTargetSeqNo;
		Integer months = 0, weeks = 0, days = 0, hours = 0, minutes = 0, seconds = 0, months_dur = 0, weeks_dur = 0, days_dur = 0, hours_dur = 0, mins_dur = 0, seconds_dur = 0;
		ArrayList<JobTemplateDetails> jobsTemplateDetails = null;
		ArrayList<JobTemplateDetails> jobsTemplateDetailsListFromParent = new ArrayList<JobTemplateDetails>();
		ArrayList<JobTypeStructureDetails> jobTypeStructureDetails = null;
		JobTemplateDetails jobTemplateDetailsFromParent = null;
		JobTemplateDetailsPK jobTemplateDetailsPK = null;
		JobDetails jobDetails5 = null;
		ArrayList<JobDetails> jobDetailsList = null;
		JobDetailsDTO jobDetails6 = null;
		ArrayList<JobDetailsDTO> jobDetailsDTOsList = null;

		/* Prepare Sequence Array from job_templates_details */
		jobsTemplateDetails = jobTemplateDetailsRepo.getJobsForTemplate(jobTemplateSeqNo);

		if (jobsTemplateDetails != null) {
			jobDetailsList = new ArrayList<JobDetails>();
			jobsTemplateDetails.sort((o1, o2) -> o1.getId().getSeqNo().compareTo(o2.getId().getSeqNo()));

			// Update Detailed Job Template
			for (int i = 0; i < jobsTemplateDetails.size(); i++) {
				jobTypeStructureDetails = null;
				jobTypeStructureDetails = jobTypeStructureDetailsRepo.getSelectJobTypeStructureDetailsForParent(
						jobsTemplateDetails.get(i).getId().getJobTypeSeqNo(),
						jobsTemplateDetails.get(i).getId().getTargetSeqNo());

				if (jobTypeStructureDetails != null && jobTypeStructureDetails.size() > 0) {
					jobsTemplateDetails.get(i).setDurationFlag('Y');
					jobsTemplateDetailsListFromParent = new ArrayList<JobTemplateDetails>();

					for (int j = 0; j < jobTypeStructureDetails.size(); j++) {
						jobTemplateDetailsFromParent = new JobTemplateDetails();
						jobTemplateDetailsPK = new JobTemplateDetailsPK();
						jobTemplateDetailsPK
								.setJobTemplateSeqNo(jobsTemplateDetails.get(i).getId().getJobTemplateSeqNo());
						jobTemplateDetailsPK.setJobTypeSeqNo(jobTypeStructureDetails.get(j).getId().getJobTypeSeqNo());
						jobTemplateDetailsPK.setTargetSeqNo(jobTypeStructureDetails.get(j).getTargetSeqNo());
						jobTemplateDetailsFromParent.setId(jobTemplateDetailsPK);
						jobsTemplateDetailsListFromParent.add(jobTemplateDetailsFromParent);
					}
					jobsTemplateDetails.addAll(i + 1, jobsTemplateDetailsListFromParent);
				}
			}

			seq_no = (long) 1;
			for (int i = 0; i < jobsTemplateDetails.size(); i++) {
				jobsTemplateDetails.get(i).getId().setSeqNo(seq_no);
				seq_no++;
			}

			// Create Job Schedule
			for (int i = 0; i < jobsTemplateDetails.size(); i++) {
				seq_no = jobsTemplateDetails.get(i).getId().getSeqNo();
				jobTypeSeqNo = jobsTemplateDetails.get(i).getId().getJobTypeSeqNo();
				jobTargetSeqNo = jobsTemplateDetails.get(i).getId().getTargetSeqNo();
				jobDetails5 = new JobDetails();

				if (jobsTemplateDetails.get(i).getDurationFlag() == null
						|| !jobsTemplateDetails.get(i).getDurationFlag().equals('Y')) {
					months_dur = jobTypeMasterRepo.getJobTypeDurMonths(jobTypeSeqNo);
					weeks_dur = jobTypeMasterRepo.getJobTypeDurWeeks(jobTypeSeqNo);
					days_dur = jobTypeMasterRepo.getJobTypeDurDays(jobTypeSeqNo);
					hours_dur = jobTypeMasterRepo.getJobTypeDurHours(jobTypeSeqNo);
					mins_dur = jobTypeMasterRepo.getJobTypeDurMinutes(jobTypeSeqNo);
					seconds_dur = jobTypeMasterRepo.getJobTypeDurSeconds(jobTypeSeqNo);
					months_dur = (months_dur == null) ? 0 : months_dur;
					months = (jobsTemplateDetails.get(i).getMonthsPlus() == null) ? 0
							: jobsTemplateDetails.get(i).getMonthsPlus();
					weeks_dur = (weeks_dur == null) ? 0 : weeks_dur;
					weeks = (jobsTemplateDetails.get(i).getWeeksPlus() == null) ? 0
							: jobsTemplateDetails.get(i).getWeeksPlus();
					days_dur = (days_dur == null) ? 0 : days_dur;
					days = (jobsTemplateDetails.get(i).getDaysPlus() == null) ? 0
							: jobsTemplateDetails.get(i).getDaysPlus();
					hours_dur = (hours_dur == null) ? 0 : hours_dur;
					hours = (jobsTemplateDetails.get(i).getHoursPlus() == null) ? 0
							: jobsTemplateDetails.get(i).getHoursPlus();
					mins_dur = (mins_dur == null) ? 0 : mins_dur;
					minutes = (jobsTemplateDetails.get(i).getMinutesPlus() == null) ? 0
							: jobsTemplateDetails.get(i).getMinutesPlus();
					seconds_dur = (seconds_dur == null) ? 0 : seconds_dur;
					seconds = (jobsTemplateDetails.get(i).getSecondsPlus() == null) ? 0
							: jobsTemplateDetails.get(i).getSecondsPlus();
					endDate = common.dateUtils.DateUtil.addDays(currDate, months_dur, weeks_dur, days_dur, hours_dur,
							mins_dur, seconds_dur);

					if (opFlag.compareTo(BigDecimal.valueOf(1)) == 0) {
						jobDetails5.setPlanStartDate(currDate);
						jobDetails5.setPlanEndDate(endDate);
					} else {
						jobDetails5.setActStartDate(currDate);
						jobDetails5.setActEndDate(endDate);
					}

				}

				jobDetails5.setJobTemplateSeqNo(jobTemplateSeqNo);
				jobDetails5.setTargetSeqNo(jobTargetSeqNo);
				jobDetails5.setJobTypeSeqNo(jobTypeSeqNo);
				jobDetails5.setSeqNo(seq_no);
				jobDetailsList.add(jobDetails5);

				if (jobsTemplateDetails.get(i).getDurationFlag() == null
						|| !jobsTemplateDetails.get(i).getDurationFlag().equals('Y')) {
					currDate = common.dateUtils.DateUtil.addDays(endDate, months, weeks, days, hours, minutes, seconds);
				}

			}

		}
		
		if(jobDetailsList!=null)
		{
		for (int j = 0; j < jobDetailsList.size(); j++) 
		{
		jobDetailsDTOsList = this.getJobDetailsDTOs(jobDetailsList);
		}	
		}
		
		return jobDetailsDTOsList;
	}

	@Override
	public JobDetailsDTO newJobDetails(JobDetailsDTO jobDTO) {
		JobDetails JobDetails = jobDetailsRepo.save(this.setJobDetails(jobDTO));
		jobDTO = getJobDetailsDTO(JobDetails);
		return jobDTO;
	}

	@Override
	public ArrayList<JobDetailsDTO> getAllJobDetails() {
		ArrayList<JobDetails> jobList = (ArrayList<JobDetails>) jobDetailsRepo.findAll();
		ArrayList<JobDetailsDTO> jobDTOs = new ArrayList<JobDetailsDTO>();
		jobDTOs = jobList != null ? this.getJobDetailsDTOs(jobList) : null;
		return jobDTOs;
	}

	@Override
	public ArrayList<JobDetailsDTO> getSelectJobDetails(ArrayList<Long> jobSeqNos) {
		ArrayList<JobDetails> jobDetails = null;
		ArrayList<JobDetailsDTO> jobDetailsDTOs = null;

		if (jobSeqNos != null) {
			jobDetails = jobDetailsRepo.getSelectJobDetails(jobSeqNos);
			if (jobDetails != null) {
				jobDetailsDTOs = this.getJobDetailsDTOs(jobDetails);
			}
		}
		return jobDetailsDTOs;
	}

	@Override
	public ArrayList<JobDetailsDTO> getSelectJobDetailsForService(Long servWorkSeqNo) {
		ArrayList<JobDetails> jobDetails = null;
		ArrayList<JobDetailsDTO> jobDetailsDTOs = null;

		if (servWorkSeqNo != null) {
			jobDetails = jobDetailsRepo.getSelectJobDetailsForService(servWorkSeqNo);
			if (jobDetails != null) {
				jobDetailsDTOs = this.getJobDetailsDTOs(jobDetails);
			}
		}
		return jobDetailsDTOs;
	}

	@Override
	public ArrayList<JobDetailsDTO> getSelectJobDetailsForServices(ArrayList<Long> servWorkSeqNos) {
		ArrayList<JobDetails> jobDetails = null;
		ArrayList<JobDetailsDTO> jobDetailsDTOs = null;

		if (servWorkSeqNos != null) {
			jobDetails = jobDetailsRepo.getSelectJobDetailsForServices(servWorkSeqNos);
			if (jobDetails != null) {
				jobDetailsDTOs = this.getJobDetailsDTOs(jobDetails);
			}
		}
		return jobDetailsDTOs;
	}

	@Override
	public ArrayList<JobDetailsDTO> getSelectJobDetailsBetweenPlanTimes(String frDtTm, String toDtTm) {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
		LocalDateTime lfrdttm = null;
		LocalDateTime ltodttm = null;
		ArrayList<JobDetails> jobDetails = null;
		ArrayList<JobDetailsDTO> jobDetailsDTOs = null;

		if (frDtTm != null && toDtTm != null) {
			lfrdttm = LocalDateTime.parse(frDtTm, formatter);
			ltodttm = LocalDateTime.parse(toDtTm, formatter);
			Timestamp frDateTime = Timestamp.valueOf(lfrdttm);
			Timestamp toDateTime = Timestamp.valueOf(ltodttm);
			jobDetails = null;
			jobDetails = jobDetailsRepo.getSelectJobDetailsBetweenPlanTimes(frDateTime, toDateTime);
			if (jobDetails != null) {
				jobDetailsDTOs = this.getJobDetailsDTOs(jobDetails);
			}
		}
		return jobDetailsDTOs;
	}

	@Override
	public ArrayList<JobDetailsDTO> getSelectJobDetailsBetweenActualTimes(String frDtTm, String toDtTm) {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
		LocalDateTime lfrdttm = null;
		LocalDateTime ltodttm = null;
		ArrayList<JobDetails> jobDetails = null;
		ArrayList<JobDetailsDTO> jobDetailsDTOs = null;

		if (frDtTm != null && toDtTm != null) {
			lfrdttm = LocalDateTime.parse(frDtTm, formatter);
			ltodttm = LocalDateTime.parse(toDtTm, formatter);
			Timestamp frDateTime = Timestamp.valueOf(lfrdttm);
			Timestamp toDateTime = Timestamp.valueOf(ltodttm);
			jobDetails = null;
			jobDetails = jobDetailsRepo.getSelectJobDetailsBetweenActualTimes(frDateTime, toDateTime);
			if (jobDetails != null) {
				jobDetailsDTOs = this.getJobDetailsDTOs(jobDetails);
			}
		}
		return jobDetailsDTOs;
	}

	@Override
	public JobDetailsDTO getJobDetailsById(Long serviceWorkSeqNo) {
		Optional<JobDetails> jobDetails = null;
		JobDetailsDTO jobDetailsDTO = null;

		if (serviceWorkSeqNo != null) {
			jobDetails = jobDetailsRepo.findById(serviceWorkSeqNo);
			if (jobDetails.isPresent()) {
				jobDetailsDTO = getJobDetailsDTO(jobDetails.get());
			}
		}
		return jobDetailsDTO;
	}

	@Override
	public void updJobDetails(JobDetailsDTO jobDetailsDTO) {
		Optional<JobDetails> jobDetails = null;

		if (jobDetailsDTO != null) {
			jobDetails = jobDetailsRepo.findById(jobDetailsDTO.getServiceWorkSeqNo());
			@SuppressWarnings("unused")
			JobDetailsDTO jobDetailsDTO2 = null;
			JobDetails jobDetails2 = null;

			if (jobDetails.isPresent()) {
				jobDetails2 = this.setJobDetails(jobDetailsDTO);
				jobDetailsRepo.save(jobDetails2);
			}
		}
	}

	@Override
	public void delJobDetails(Long jobDetailsSeqNo) {
		if (jobDetailsRepo.existsById(jobDetailsSeqNo)) {
			jobDetailsRepo.deleteById(jobDetailsSeqNo);
		}
	}

	@Override
	public void delAllJobDetails() {
		jobDetailsRepo.deleteAll();
	}

	@Override
	public void delSelectJobDetails(ArrayList<Long> jobSeqNos) {
		jobDetailsRepo.delSelectJobDetails(jobSeqNos);
	}

	@Override
	public void delSelectJobDetailsForServices(ArrayList<Long> servWorkSeqNos) {
		jobDetailsRepo.delSelectJobDetailsForServices(servWorkSeqNos);
	}

	@Override
	public void delSelectJobDetailsBetweenPlanTimes(String frDtTm, String toDtTm) {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
		LocalDateTime lfrdttm = null;
		LocalDateTime ltodttm = null;
		lfrdttm = LocalDateTime.parse(frDtTm, formatter);
		ltodttm = LocalDateTime.parse(toDtTm, formatter);
		Timestamp frDateTime = Timestamp.valueOf(lfrdttm);
		Timestamp toDateTime = Timestamp.valueOf(ltodttm);
		jobDetailsRepo.delSelectJobDetailsBetweenPlanPlanTimes(frDateTime, toDateTime);
		return;
	}

	@Override
	public void delSelectJobDetailsBetweenActualTimes(String frDtTm, String toDtTm) {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
		LocalDateTime lfrdttm = null;
		LocalDateTime ltodttm = null;
		lfrdttm = LocalDateTime.parse(frDtTm, formatter);
		ltodttm = LocalDateTime.parse(toDtTm, formatter);
		Timestamp frDateTime = Timestamp.valueOf(lfrdttm);
		Timestamp toDateTime = Timestamp.valueOf(ltodttm);
		jobDetailsRepo.delSelectJobDetailsBetweenPlanActualTimes(frDateTime, toDateTime);
		return;
	}

	private ArrayList<JobDetailsDTO> getJobDetailsDTOs(ArrayList<JobDetails> jobDetails) {
		JobDetailsDTO jobDTO = null;
		ArrayList<JobDetailsDTO> jobDTOs = new ArrayList<JobDetailsDTO>();

		for (int i = 0; i < jobDetails.size(); i++) {
			jobDTO = getJobDetailsDTO(jobDetails.get(i));
			jobDTOs.add(jobDTO);
		}
		return jobDTOs;
	}

	private JobDetailsDTO getJobDetailsDTO(JobDetails jobDetails) {
		JobDetailsDTO jobDetailsDTO = new JobDetailsDTO();
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
		jobDetailsDTO.setActEndDate(formatter.format(jobDetails.getActEndDate().toLocalDateTime()));
		jobDetailsDTO.setActStartDate(formatter.format(jobDetails.getActStartDate().toLocalDateTime()));
		jobDetailsDTO.setPlanStartDate(formatter.format(jobDetails.getPlanStartDate().toLocalDateTime()));
		jobDetailsDTO.setPlanEndDate(formatter.format(jobDetails.getPlanEndDate().toLocalDateTime()));
		jobDetailsDTO.setJobSeqNo(jobDetails.getJobSeqNo());
		jobDetailsDTO.setJobTypeSeqNo(jobDetails.getJobTypeSeqNo());
		jobDetailsDTO.setManagerSeqNo(jobDetails.getManagerSeqNo());
		jobDetailsDTO.setParentJobSeqNo(jobDetails.getParentJobSeqNo());
		jobDetailsDTO.setServiceWorkSeqNo(jobDetails.getServiceWorkSeqNo());
		jobDetailsDTO.setRemarks(jobDetails.getRemarks());
		jobDetailsDTO.setStatus(jobDetails.getStatus());
		return jobDetailsDTO;
	}

	private JobDetails setJobDetails(JobDetailsDTO cDTO) {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
		LocalDateTime plst = LocalDateTime.parse(cDTO.getPlanStartDate(), formatter);
		LocalDateTime plto = LocalDateTime.parse(cDTO.getPlanEndDate(), formatter);
		LocalDateTime acst = LocalDateTime.parse(cDTO.getActStartDate(), formatter);
		LocalDateTime acto = LocalDateTime.parse(cDTO.getActEndDate(), formatter);
		Timestamp pFrDateTime = Timestamp.valueOf(plst);
		Timestamp pToDateTime = Timestamp.valueOf(plto);
		Timestamp aFrDateTime = Timestamp.valueOf(acst);
		Timestamp aToDateTime = Timestamp.valueOf(acto);
		JobDetails jobDetails = new JobDetails();
		jobDetails.setActEndDate(aToDateTime);
		jobDetails.setActStartDate(aFrDateTime);
		jobDetails.setPlanStartDate(pFrDateTime);
		jobDetails.setPlanEndDate(pToDateTime);
		jobDetails.setJobTypeSeqNo(cDTO.getJobTypeSeqNo());
		jobDetails.setManagerSeqNo(cDTO.getManagerSeqNo());
		jobDetails.setParentJobSeqNo(cDTO.getParentJobSeqNo());
		jobDetails.setServiceWorkSeqNo(cDTO.getServiceWorkSeqNo());
		jobDetails.setRemarks(cDTO.getRemarks());
		jobDetails.setStatus(cDTO.getStatus());
		return jobDetails;
	}
}