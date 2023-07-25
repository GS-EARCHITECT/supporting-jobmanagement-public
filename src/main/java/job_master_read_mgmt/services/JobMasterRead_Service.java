package job_master_read_mgmt.services;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import job_master_read_mgmt.model.dto.JobMaster_DTO;
import job_master_read_mgmt.model.master.JobMaster;
import job_master_read_mgmt.model.repo.JobMasterRead_Repo;

@Service("jobMasterReadServ")
@Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.READ_COMMITTED)
public class JobMasterRead_Service implements I_JobMasterRead_Service 
{

//	private static final Logger logger = LoggerFactory.getLogger(JobMasterService.class);

	@Autowired
	private JobMasterRead_Repo jobMasterReadRepo;
	
	@Autowired
	private Executor asyncExecutor;
	
	@Override
	public CompletableFuture<CopyOnWriteArrayList<JobMaster_DTO>> getAllJobMasters() throws InterruptedException, ExecutionException 
	{
		CompletableFuture<CopyOnWriteArrayList<JobMaster_DTO>> future = CompletableFuture.supplyAsync(() -> 
		{
		CopyOnWriteArrayList<JobMaster> jobList = (CopyOnWriteArrayList<JobMaster>) jobMasterReadRepo.findAll();
		CopyOnWriteArrayList<JobMaster_DTO> jcmDTOs = new CopyOnWriteArrayList<JobMaster_DTO>();
		jcmDTOs = jobList != null ? this.getJobMaster_DTOs(jobList) : null;
		return jcmDTOs;
		},asyncExecutor);

	return future;

	}

	@Override
	public CompletableFuture<CopyOnWriteArrayList<JobMaster_DTO>> getSelectJobMasters(CopyOnWriteArrayList<Long> jcmSeqNos) throws InterruptedException, ExecutionException 
{
		CompletableFuture<CopyOnWriteArrayList<JobMaster_DTO>> future = CompletableFuture.supplyAsync(() -> 
		{
		CopyOnWriteArrayList<JobMaster> jobList = (CopyOnWriteArrayList<JobMaster>) jobMasterReadRepo.getSelectJobMasters(jcmSeqNos);
		CopyOnWriteArrayList<JobMaster_DTO> jcmDTOs = new CopyOnWriteArrayList<JobMaster_DTO>();
		jcmDTOs = jobList != null ? this.getJobMaster_DTOs(jobList) : null;
		return jcmDTOs;
		},asyncExecutor);

	return future;
	}

	@Override
	public CompletableFuture<CopyOnWriteArrayList<JobMaster_DTO>> getSelectJobMastersByParties(CopyOnWriteArrayList<Long> pids) throws InterruptedException, ExecutionException
{
		CompletableFuture<CopyOnWriteArrayList<JobMaster_DTO>> future = CompletableFuture.supplyAsync(() -> 
		{
		CopyOnWriteArrayList<JobMaster> jobList = (CopyOnWriteArrayList<JobMaster>) jobMasterReadRepo.getSelectJobMastersByParties(pids);
		CopyOnWriteArrayList<JobMaster_DTO> jcmDTOs = new CopyOnWriteArrayList<JobMaster_DTO>();
		jcmDTOs = jobList != null ? this.getJobMaster_DTOs(jobList) : null;
		return jcmDTOs;
		},asyncExecutor);

	return future;
	}

	
	private synchronized CopyOnWriteArrayList<JobMaster_DTO> getJobMaster_DTOs(CopyOnWriteArrayList<JobMaster> jobMasters) {
		JobMaster_DTO jobDTO = null;
		CopyOnWriteArrayList<JobMaster_DTO> jobDTOs = new CopyOnWriteArrayList<JobMaster_DTO>();

		for (int i = 0; i < jobMasters.size(); i++) {
			jobDTO = getJobMaster_DTO(jobMasters.get(i));
			jobDTOs.add(jobDTO);
		}
		return jobDTOs;
	}

	private synchronized JobMaster_DTO getJobMaster_DTO(JobMaster jobMaster2) 
	{
		JobMaster_DTO jobMasterDTO = new JobMaster_DTO();
		jobMasterDTO = new JobMaster_DTO();		
		jobMasterDTO.setJobSeqNo(jobMaster2.getJobSeqNo());
		jobMasterDTO.setDescription(jobMaster2.getDescription());
		jobMasterDTO.setDiscPer(jobMaster2.getDiscPer());
		jobMasterDTO.setDiscSeqNo(jobMaster2.getDiscSeqNo());
		jobMasterDTO.setDiscVal(jobMaster2.getDiscVal());
		jobMasterDTO.setDuration(jobMaster2.getDuration());
		jobMasterDTO.setDurationCodeSeqNo(jobMaster2.getDurationCodeSeqNo());
		jobMasterDTO.setJob(jobMaster2.getJob());
		jobMasterDTO.setJobId(jobMaster2.getJobId());
		jobMasterDTO.setPartySeqNo(jobMaster2.getPartySeqNo());
		jobMasterDTO.setSpecificationSeqNo(jobMaster2.getSpecificationSeqNo());
		jobMasterDTO.setTaxPer(jobMaster2.getTaxPer());
		jobMasterDTO.setTaxSeqNo(jobMaster2.getTaxSeqNo());
		jobMasterDTO.setTaxVal(jobMaster2.getTaxVal());
		jobMasterDTO.setUnitRate(jobMaster2.getUnitRate());
		jobMasterDTO.setUnitRateSeqNo(jobMaster2.getUnitRateSeqNo());
		jobMasterDTO.setRemark(jobMaster2.getRemark());
		jobMasterDTO.setStatus(jobMaster2.getStatus());
		return jobMasterDTO;
	}

}