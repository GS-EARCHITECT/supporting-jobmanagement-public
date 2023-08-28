package job_template_details_mgmt.services;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import job_template_details_mgmt.model.details.JobTemplateDetails;
import job_template_details_mgmt.model.dto.JobTemplateDetails_DTO;
import job_template_details_mgmt.model.repo.JobTemplateDetailsRead_Repo;

@Service("jobTemplateDetailsServ")
@Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.READ_COMMITTED)
public class JobTemplateDetailsRead_Service implements I_JobTemplateDetailsPublicRead_Service 
{

//	private static final Logger logger = LoggerFactory.getLogger(JobTemplateDetailsService.class);

	@Autowired
	private JobTemplateDetailsRead_Repo jobTemplateDetailsReadRepo;
	
	@Autowired
	private Executor asyncExecutor;

	@Override
	public CompletableFuture<CopyOnWriteArrayList<JobTemplateDetails_DTO>> getAllJobTemplateDetails()  
	{
		CompletableFuture<CopyOnWriteArrayList<JobTemplateDetails_DTO>> future = CompletableFuture.supplyAsync(() -> 
		{			
		CopyOnWriteArrayList<JobTemplateDetails> jobList = (CopyOnWriteArrayList<JobTemplateDetails>) jobTemplateDetailsReadRepo.getAllJobTemplateDetails();
		CopyOnWriteArrayList<JobTemplateDetails_DTO> jobTemplateDetailsDTOs = new CopyOnWriteArrayList<JobTemplateDetails_DTO>();
		jobTemplateDetailsDTOs = jobList != null ? this.getJobTemplateDetailsDTOs(jobList) : null;
		return jobTemplateDetailsDTOs;
		},asyncExecutor);

		return future;

	}

	@Override
	public CompletableFuture<CopyOnWriteArrayList<JobTemplateDetails_DTO>> getSelectJobTemplateDetails(
			CopyOnWriteArrayList<Long> jobTemplateDetailsSeqNos) 
	{
		
		CompletableFuture<CopyOnWriteArrayList<JobTemplateDetails_DTO>> future = CompletableFuture.supplyAsync(() -> 
		{			
		CopyOnWriteArrayList<JobTemplateDetails> jobList = (CopyOnWriteArrayList<JobTemplateDetails>) jobTemplateDetailsReadRepo.getSelectJobTemplateDetails(jobTemplateDetailsSeqNos);
		CopyOnWriteArrayList<JobTemplateDetails_DTO> jobTemplateDetailsDTOs = new CopyOnWriteArrayList<JobTemplateDetails_DTO>();
		jobTemplateDetailsDTOs = jobList != null ? this.getJobTemplateDetailsDTOs(jobList) : null;
		return jobTemplateDetailsDTOs;
		},asyncExecutor);

		return future;
	}

	private synchronized CopyOnWriteArrayList<JobTemplateDetails_DTO> getJobTemplateDetailsDTOs(
			CopyOnWriteArrayList<JobTemplateDetails> jobTemplateDetails) {
		JobTemplateDetails_DTO jobTemplateDetailsDTO = null;
		CopyOnWriteArrayList<JobTemplateDetails_DTO> jobTemplateDetailsDTOs = new CopyOnWriteArrayList<JobTemplateDetails_DTO>();

		for (int i = 0; i < jobTemplateDetails.size(); i++) {
			jobTemplateDetailsDTO = getJobTemplateDetails_DTO(jobTemplateDetails.get(i));
			jobTemplateDetailsDTOs.add(jobTemplateDetailsDTO);
		}
		return jobTemplateDetailsDTOs;
	}

	private synchronized JobTemplateDetails_DTO getJobTemplateDetails_DTO(JobTemplateDetails jobTemplateDetails) 
	{
		JobTemplateDetails_DTO jobTemplateDetailsDTO = new JobTemplateDetails_DTO();
		jobTemplateDetailsDTO.setJobTemplateSeqNo(jobTemplateDetails.getId().getJobTemplateSeqNo());		
		jobTemplateDetailsDTO.setJobSeqNo(jobTemplateDetails.getId().getJOB_SEQ_NO());
		jobTemplateDetailsDTO.setSeqNo(jobTemplateDetails.getId().getSeqNo());
		jobTemplateDetailsDTO.setTargetSeqNo(jobTemplateDetails.getId().getTargetSeqNo());
		jobTemplateDetailsDTO.setTargetClassSeqNo(jobTemplateDetails.getId().getTargetClassSeqNo());
		jobTemplateDetailsDTO.setJobLevelNo(jobTemplateDetails.getId().getJobLevelNo());
		jobTemplateDetailsDTO.setDaysPlus(jobTemplateDetailsDTO.getDaysPlus());
		jobTemplateDetailsDTO.setDurDays(jobTemplateDetailsDTO.getDurDays());
		jobTemplateDetailsDTO.setDurHours(jobTemplateDetailsDTO.getDurHours());
		jobTemplateDetailsDTO.setDurMinutes(jobTemplateDetailsDTO.getDurMinutes());
		jobTemplateDetailsDTO.setDurMonths(jobTemplateDetailsDTO.getDurMonths());
		jobTemplateDetailsDTO.setDurSeconds(jobTemplateDetailsDTO.getDurSeconds());
		jobTemplateDetailsDTO.setHoursPlus(jobTemplateDetailsDTO.getHoursPlus());				
		jobTemplateDetailsDTO.setMinutesPlus(jobTemplateDetailsDTO.getMinutesPlus());
		jobTemplateDetailsDTO.setPredecessorSeqNo(jobTemplateDetailsDTO.getPredecessorSeqNo());
		jobTemplateDetailsDTO.setSecondsPlus(jobTemplateDetailsDTO.getSecondsPlus());				
		return jobTemplateDetailsDTO;
	}
}