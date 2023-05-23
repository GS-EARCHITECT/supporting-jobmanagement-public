package job_type_target_details.services;

import java.util.ArrayList;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import job_type_target_details.model.dto.JobTypeTargetDetailsDTO;
import job_type_target_details.model.master.JobTypeTargetDetails;
import job_type_target_details.model.master.JobTypeTargetDetailsPK;
import job_type_target_details.model.repo.JobTypeTargetDetailsRepo;

@Service("jobTypeTargetDetailsServ")
@Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.READ_COMMITTED)
public class JobTypeTargetDetailsService implements I_JobTypeTargetDetailsService {
	@SuppressWarnings("unused")
	private static final Logger logger = LoggerFactory.getLogger(JobTypeTargetDetailsService.class);

	@Autowired
	private JobTypeTargetDetailsRepo jobTypeTargetDetailsRepo;

	@Override
	public JobTypeTargetDetailsDTO newJobTypeTargetDetails(JobTypeTargetDetailsDTO jobTypeTargetDetailsDTO) 
	{
	
		JobTypeTargetDetailsPK jobTypeTargetDetailsPK = new JobTypeTargetDetailsPK();
		jobTypeTargetDetailsPK.setJobTypeSeqNo(jobTypeTargetDetailsDTO.getJobTypeSeqNo());
		jobTypeTargetDetailsPK.setTargetSeqNo(jobTypeTargetDetailsDTO.getTargetSeqNo());
		JobTypeTargetDetails jobTypeTargetDetails = null;
			
		if(!jobTypeTargetDetailsRepo.existsById(jobTypeTargetDetailsPK))
		{		
		jobTypeTargetDetailsDTO = getJobTypeTargetDetailsDTO(jobTypeTargetDetailsRepo.save(this.setJobTypeTargetDetails(jobTypeTargetDetailsDTO)));
		}
		return jobTypeTargetDetailsDTO;
	}

	@Override
	public ArrayList<JobTypeTargetDetailsDTO> getAllJobTypeTargetDetails() 
	{
		ArrayList<JobTypeTargetDetails> jobList = (ArrayList<JobTypeTargetDetails>) jobTypeTargetDetailsRepo.findAll();
		ArrayList<JobTypeTargetDetailsDTO> jobTypeTargetDetailsDTOs = new ArrayList<JobTypeTargetDetailsDTO>();
		jobTypeTargetDetailsDTOs = jobList != null ? this.getJobTypeTargetDetailsDTOs(jobList) : null;
		return jobTypeTargetDetailsDTOs;
	}

	@Override
	public ArrayList<JobTypeTargetDetailsDTO> getSelectJobTypeTargetDetails(ArrayList<JobTypeTargetDetailsDTO> jobTypeTargetDetailsDTOs) 
	{
		ArrayList<JobTypeTargetDetailsPK> jobTypeTargetDetailsPKs = new ArrayList<JobTypeTargetDetailsPK>();
		JobTypeTargetDetailsPK jobTypeTargetDetailsPK = null;
		ArrayList<JobTypeTargetDetails> jobTypeTargetDetails = null;
		
		if(jobTypeTargetDetailsDTOs!=null)
		{
		for (int i = 0; i < jobTypeTargetDetailsDTOs.size(); i++) 
		{
		jobTypeTargetDetailsPK = new JobTypeTargetDetailsPK();
		jobTypeTargetDetailsPK.setJobTypeSeqNo(jobTypeTargetDetailsDTOs.get(i).getJobTypeSeqNo());
		jobTypeTargetDetailsPK.setTargetSeqNo(jobTypeTargetDetailsDTOs.get(i).getTargetSeqNo());
		jobTypeTargetDetailsPKs.add(jobTypeTargetDetailsPK);
		}
		jobTypeTargetDetails = (ArrayList<JobTypeTargetDetails>) jobTypeTargetDetailsRepo.findAllById(jobTypeTargetDetailsPKs);
		}
				
		if (jobTypeTargetDetails != null) {
		
			if (jobTypeTargetDetails != null) {
				jobTypeTargetDetailsDTOs = this.getJobTypeTargetDetailsDTOs(jobTypeTargetDetails);
			}
		}
		return jobTypeTargetDetailsDTOs;
	}

	@Override
	public JobTypeTargetDetailsDTO getJobTypeTargetDetailsById(JobTypeTargetDetailsDTO jobTypeTargetDetailsDTO) 
	{
		JobTypeTargetDetailsPK jobTypeTargetDetailsPK = new JobTypeTargetDetailsPK();
		jobTypeTargetDetailsPK.setJobTypeSeqNo(jobTypeTargetDetailsDTO.getJobTypeSeqNo());
		jobTypeTargetDetailsPK.setTargetSeqNo(jobTypeTargetDetailsDTO.getTargetSeqNo());
		JobTypeTargetDetails jobTypeTargetDetails = null;
			
		if(jobTypeTargetDetailsRepo.existsById(jobTypeTargetDetailsPK))
		{		
		jobTypeTargetDetailsDTO = getJobTypeTargetDetailsDTO(jobTypeTargetDetailsRepo.findById(jobTypeTargetDetailsPK).get());
		}

		return jobTypeTargetDetailsDTO;
	}

	@Override
	public void updJobTypeTargetDetails(JobTypeTargetDetailsDTO jobTypeTargetDetailsDTO) 
	{
		JobTypeTargetDetailsPK jobTypeTargetDetailsPK = new JobTypeTargetDetailsPK();
		jobTypeTargetDetailsPK.setJobTypeSeqNo(jobTypeTargetDetailsDTO.getJobTypeSeqNo());
		jobTypeTargetDetailsPK.setTargetSeqNo(jobTypeTargetDetailsDTO.getTargetSeqNo());
		JobTypeTargetDetails jobTypeTargetDetails = null;
		
		if(jobTypeTargetDetailsRepo.existsById(jobTypeTargetDetailsPK))
		{		
		jobTypeTargetDetails = this.setJobTypeTargetDetails(jobTypeTargetDetailsDTO);
		jobTypeTargetDetailsRepo.save(jobTypeTargetDetails);
		}
	}

	@Override
	public void delJobTypeTargetDetails(JobTypeTargetDetailsDTO jobTypeTargetDetailsDTO) 
	{
		JobTypeTargetDetailsPK jobTypeTargetDetailsPK = new JobTypeTargetDetailsPK();
		jobTypeTargetDetailsPK.setJobTypeSeqNo(jobTypeTargetDetailsDTO.getJobTypeSeqNo());
		jobTypeTargetDetailsPK.setTargetSeqNo(jobTypeTargetDetailsDTO.getTargetSeqNo());
		JobTypeTargetDetails jobTypeTargetDetails = null;	 
	
		if (jobTypeTargetDetailsRepo.existsById(jobTypeTargetDetailsPK)) 
		{
			jobTypeTargetDetailsRepo.deleteById(jobTypeTargetDetailsPK);
		}
	}

	@Override
	public void delAllJobTypeTargetDetails() 
	{
		jobTypeTargetDetailsRepo.deleteAll();
	}

	@Override
	public void delSelectJobTypeTargetDetails(ArrayList<JobTypeTargetDetailsDTO> jobTypeTargetDetailsDTOs) 
	{
		ArrayList<JobTypeTargetDetailsPK> jobTypeTargetDetailsPKs = new ArrayList<JobTypeTargetDetailsPK>();
		JobTypeTargetDetailsPK jobTypeTargetDetailsPK = null;
		ArrayList<JobTypeTargetDetails> jobTypeTargetDetails = null;
		
		if(jobTypeTargetDetailsDTOs!=null)
		{
		for (int i = 0; i < jobTypeTargetDetailsDTOs.size(); i++) 
		{
		jobTypeTargetDetailsPK = new JobTypeTargetDetailsPK();
		jobTypeTargetDetailsPK.setJobTypeSeqNo(jobTypeTargetDetailsDTOs.get(i).getJobTypeSeqNo());
		jobTypeTargetDetailsPK.setTargetSeqNo(jobTypeTargetDetailsDTOs.get(i).getTargetSeqNo());
		jobTypeTargetDetailsPKs.add(jobTypeTargetDetailsPK);
		}
		jobTypeTargetDetailsRepo.deleteAllById(jobTypeTargetDetailsPKs);
		}
	}

	private ArrayList<JobTypeTargetDetailsDTO> getJobTypeTargetDetailsDTOs(ArrayList<JobTypeTargetDetails> jobTargetDetails) {
		JobTypeTargetDetailsDTO jobTypeTargetDetailsDTO = null;
		ArrayList<JobTypeTargetDetailsDTO> jobTypeTargetDetailsDTOs = new ArrayList<JobTypeTargetDetailsDTO>();

		for (int i = 0; i < jobTargetDetails.size(); i++) {
			jobTypeTargetDetailsDTO = getJobTypeTargetDetailsDTO(jobTargetDetails.get(i));
			jobTypeTargetDetailsDTOs.add(jobTypeTargetDetailsDTO);
		}
		return jobTypeTargetDetailsDTOs;
	}

	private JobTypeTargetDetailsDTO getJobTypeTargetDetailsDTO(JobTypeTargetDetails jobTypeTargetDetails) 
	{
		JobTypeTargetDetailsDTO jobTypeTargetDetailsDTO = new JobTypeTargetDetailsDTO();
		jobTypeTargetDetailsDTO = new JobTypeTargetDetailsDTO();
		jobTypeTargetDetailsDTO.setJobTypeSeqNo(jobTypeTargetDetails.getId().getJobTypeSeqNo());
		jobTypeTargetDetailsDTO.setTargetSeqNo(jobTypeTargetDetails.getId().getTargetSeqNo());
		jobTypeTargetDetailsDTO.setDuration(jobTypeTargetDetails.getDuration());
		jobTypeTargetDetailsDTO.setDurationSeqNo(jobTypeTargetDetails.getDurationSeqNo());
		jobTypeTargetDetailsDTO.setDurMonths(jobTypeTargetDetails.getDurMonths());
		jobTypeTargetDetailsDTO.setDurWeeks(jobTypeTargetDetails.getDurWeeks());
		jobTypeTargetDetailsDTO.setDurDays(jobTypeTargetDetails.getDurDays());
		jobTypeTargetDetailsDTO.setDurHours(jobTypeTargetDetails.getDurHours());
		jobTypeTargetDetailsDTO.setDurMinutes(jobTypeTargetDetails.getDurMinutes());
		jobTypeTargetDetailsDTO.setDurSeconds(jobTypeTargetDetails.getDurSeconds());
		jobTypeTargetDetailsDTO.setRateSeqNo(jobTypeTargetDetails.getRateSeqNo());
		jobTypeTargetDetailsDTO.setUnitRate(jobTypeTargetDetails.getUnitRate());		
		jobTypeTargetDetailsDTO.setRemarks(jobTypeTargetDetails.getRemarks());
		jobTypeTargetDetailsDTO.setStatus(jobTypeTargetDetails.getStatus());		
		return jobTypeTargetDetailsDTO;
	}

	private JobTypeTargetDetails setJobTypeTargetDetails(JobTypeTargetDetailsDTO cDTO) 
	{
		JobTypeTargetDetails jobTypeTargetDetails = new JobTypeTargetDetails();
		JobTypeTargetDetailsPK jobTypeTargetDetailsPK = new JobTypeTargetDetailsPK();
		jobTypeTargetDetailsPK.setJobTypeSeqNo(cDTO.getJobTypeSeqNo());
		jobTypeTargetDetailsPK.setTargetSeqNo(cDTO.getTargetSeqNo());		
		jobTypeTargetDetails.setDuration(cDTO.getDuration());
		jobTypeTargetDetails.setDurationSeqNo(cDTO.getDurationSeqNo());
		jobTypeTargetDetails.setDurMonths(cDTO.getDurMonths());
		jobTypeTargetDetails.setDurWeeks(cDTO.getDurWeeks());
		jobTypeTargetDetails.setDurDays(cDTO.getDurDays());
		jobTypeTargetDetails.setDurHours(cDTO.getDurHours());
		jobTypeTargetDetails.setDurMinutes(cDTO.getDurMinutes());
		jobTypeTargetDetails.setDurSeconds(cDTO.getDurSeconds());
		jobTypeTargetDetails.setRateSeqNo(cDTO.getRateSeqNo());
		jobTypeTargetDetails.setUnitRate(cDTO.getUnitRate());		
		jobTypeTargetDetails.setRemarks(cDTO.getRemarks());
		jobTypeTargetDetails.setStatus(cDTO.getStatus());
		jobTypeTargetDetails.setId(jobTypeTargetDetailsPK);
		return jobTypeTargetDetails;
	}
}