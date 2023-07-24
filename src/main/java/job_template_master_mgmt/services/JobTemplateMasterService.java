package job_template_master_mgmt.services;

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
import job_template_master_mgmt.model.dto.JobTemplateMaster_DTO;
import job_template_master_mgmt.model.master.JobTemplateMaster;
import job_template_master_mgmt.model.repo.JobTemplateMasterRepo;

@Service("jobTemplateMasterServ")
@Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.READ_COMMITTED)
public class JobTemplateMasterService implements I_JobTemplateMasterService 
{
	@SuppressWarnings("unused")
	private static final Logger logger = LoggerFactory.getLogger(JobTemplateMasterService.class);

	@Autowired
	private JobTemplateMasterRepo jobTemplateMasterRepo;
	
	@Autowired
	private Executor asyncExecutor;

	@Override
	public CopyOnWriteArrayList<JobTemplateMaster_DTO> getAllJobTemplateMasters() throws InterruptedException, ExecutionException 
	{
		CompletableFuture<CopyOnWriteArrayList<JobTemplateMaster_DTO>> future = CompletableFuture.supplyAsync(() -> 
		{			
		CopyOnWriteArrayList<JobTemplateMaster> jobList = (CopyOnWriteArrayList<JobTemplateMaster>) jobTemplateMasterRepo.findAll();
		CopyOnWriteArrayList<JobTemplateMaster_DTO> jobTemplateMasterDTOs = this.getJobTemplateMaster_DTOs(jobList);
		return jobTemplateMasterDTOs;
		},asyncExecutor);

		return future.get();

	}

	@Override
	public CopyOnWriteArrayList<JobTemplateMaster_DTO> getSelectJobTemplateMasters(CopyOnWriteArrayList<Long> jobTemplateMasterSeqNos) throws InterruptedException, ExecutionException 
	{
		CompletableFuture<CopyOnWriteArrayList<JobTemplateMaster_DTO>> future = CompletableFuture.supplyAsync(() -> 
		{
		CopyOnWriteArrayList<JobTemplateMaster> jobTemplateMasters = null;
		CopyOnWriteArrayList<JobTemplateMaster_DTO> jobTemplateMasterDTOs = null;

		if (jobTemplateMasterSeqNos != null) {
			jobTemplateMasters = jobTemplateMasterRepo.getSelectJobTemplateMasters(jobTemplateMasterSeqNos);
			if (jobTemplateMasters != null) {
				jobTemplateMasterDTOs = this.getJobTemplateMaster_DTOs(jobTemplateMasters);
			}
		}
		return jobTemplateMasterDTOs;
		},asyncExecutor);

		return future.get();		
	}

	private synchronized CopyOnWriteArrayList<JobTemplateMaster_DTO> getJobTemplateMaster_DTOs(
			CopyOnWriteArrayList<JobTemplateMaster> jobTemplateMasters)  
	{
		JobTemplateMaster_DTO jobTemplateMasterDTO = null;
		CopyOnWriteArrayList<JobTemplateMaster_DTO> jobTemplateMasterDTOs = new CopyOnWriteArrayList<JobTemplateMaster_DTO>();
		for (int i = 0; i < jobTemplateMasters.size(); i++) 
		{
			jobTemplateMasterDTO = this.getJobTemplateMaster_DTO(jobTemplateMasters.get(i));
			jobTemplateMasterDTOs.add(jobTemplateMasterDTO);
		}
		return jobTemplateMasterDTOs;
	}

	private JobTemplateMaster_DTO getJobTemplateMaster_DTO(JobTemplateMaster jobTemplateMaster) 
	{
		JobTemplateMaster_DTO jobTemplateMasterDTO = new JobTemplateMaster_DTO();
		jobTemplateMasterDTO.setJobTemplateSeqNo(jobTemplateMaster.getId().getJobTemplateSeqNo());
		jobTemplateMasterDTO.setServiceSeqNo(jobTemplateMaster.getId().getServiceSeqNo());
		jobTemplateMasterDTO.setRemarks(jobTemplateMaster.getRemarks());
		jobTemplateMasterDTO.setStatus(jobTemplateMaster.getStatus());
		return jobTemplateMasterDTO;
	}
	
}