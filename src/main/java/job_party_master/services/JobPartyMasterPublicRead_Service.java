package job_party_master.services;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.Executor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import job_party_master.model.dto.JobPartyMaster_DTO;
import job_party_master.model.master.JobPartyMaster;
import job_party_master.model.repo.JobPartyMasterPublicRead_Repo;

@Service("jobPartyMasterPublicReadServ")
@Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.READ_COMMITTED)
public class JobPartyMasterPublicRead_Service implements I_JobPartyMasterPublicRead_Service 
{

//	private static final Logger logger = LoggerFactory.getLogger(JobPartyMasterService.class);

	@Autowired
	private JobPartyMasterPublicRead_Repo jobPartyMasterPublicReadRepo;
	
	@Autowired
	private Executor asyncExecutor;
	
	@Override
	public CompletableFuture<CopyOnWriteArrayList<JobPartyMaster_DTO>> getSelectJobPartyMasters(CopyOnWriteArrayList<Long> jcmSeqNos) 
	{
		CompletableFuture<CopyOnWriteArrayList<JobPartyMaster_DTO>> future = CompletableFuture.supplyAsync(() -> {	
		CopyOnWriteArrayList<JobPartyMaster> jobList = (CopyOnWriteArrayList<JobPartyMaster>) jobPartyMasterPublicReadRepo.findAllById(jcmSeqNos);
		CopyOnWriteArrayList<JobPartyMaster_DTO> jcmDTOs = jobList != null ? this.getJobPartyMaster_DTOs(jobList) : null;
		return jcmDTOs;
		}, asyncExecutor);
		return future;	
	}

	@Override
	public CompletableFuture<CopyOnWriteArrayList<JobPartyMaster_DTO>> getSelectJobPartyMastersByParties(CopyOnWriteArrayList<Long> pids) 
	{
		CompletableFuture<CopyOnWriteArrayList<JobPartyMaster_DTO>> future = CompletableFuture.supplyAsync(() -> {
		CopyOnWriteArrayList<JobPartyMaster> jobList = jobPartyMasterPublicReadRepo.getSelectJobPartyMastersByParties(pids);
		CopyOnWriteArrayList<JobPartyMaster_DTO> jcmDTOs = new CopyOnWriteArrayList<JobPartyMaster_DTO>();
		jcmDTOs = jobList != null ? this.getJobPartyMaster_DTOs(jobList) : null;
		return jcmDTOs;
		}, asyncExecutor);
		return future;	
	
	}

	@Override
	public CompletableFuture<CopyOnWriteArrayList<JobPartyMaster_DTO>> getSelectJobPartyMastersByMasterJobs(CopyOnWriteArrayList<Long> ids) 
	{
		CompletableFuture<CopyOnWriteArrayList<JobPartyMaster_DTO>> future = CompletableFuture.supplyAsync(() -> {
		CopyOnWriteArrayList<JobPartyMaster> jobList = jobPartyMasterPublicReadRepo.getSelectJobPartyMastersByMasterJobs(ids);
		CopyOnWriteArrayList<JobPartyMaster_DTO> jcmDTOs = new CopyOnWriteArrayList<JobPartyMaster_DTO>();
		jcmDTOs = jobList != null ? this.getJobPartyMaster_DTOs(jobList) : null;
		return jcmDTOs;
		}, asyncExecutor);
		return future;	

	}
	
	@Override
	public CompletableFuture<CopyOnWriteArrayList<JobPartyMaster_DTO>> getAllJobPartyMasters() 
	{
		CompletableFuture<CopyOnWriteArrayList<JobPartyMaster_DTO>> future = CompletableFuture.supplyAsync(() -> {
		CopyOnWriteArrayList<JobPartyMaster> jobList = (CopyOnWriteArrayList<JobPartyMaster>) jobPartyMasterPublicReadRepo.getAllJobPartyMasters();
		CopyOnWriteArrayList<JobPartyMaster_DTO> jobDTOs = jobList != null ? this.getJobPartyMaster_DTOs(jobList) : null;
		return jobDTOs;
		}, asyncExecutor);
		return future;
	}

	private synchronized CopyOnWriteArrayList<JobPartyMaster_DTO> getJobPartyMaster_DTOs(CopyOnWriteArrayList<JobPartyMaster> jobMasters) {
		JobPartyMaster_DTO jobDTO = null;
		CopyOnWriteArrayList<JobPartyMaster_DTO> jobDTOs = new CopyOnWriteArrayList<JobPartyMaster_DTO>();

		for (int i = 0; i < jobMasters.size(); i++) {
			jobDTO = getJobPartyMaster_DTO(jobMasters.get(i));
			jobDTOs.add(jobDTO);
		}
		return jobDTOs;
	}

	private synchronized JobPartyMaster_DTO getJobPartyMaster_DTO(JobPartyMaster jobMaster2) 
	{
		JobPartyMaster_DTO jobMasterDTO = new JobPartyMaster_DTO();
		jobMasterDTO.setJobSeqNo(jobMaster2.getJobSeqNo());
		jobMasterDTO.setMasterJobSeqNo(jobMaster2.getMasterJobSeqNo());
		jobMasterDTO.setPartySeqNo(jobMaster2.getPartySeqNo());
		jobMasterDTO.setDescription(jobMaster2.getDescription());
		jobMasterDTO.setDiscPer(jobMaster2.getDiscPer());
		jobMasterDTO.setDiscSeqNo(jobMaster2.getDiscSeqNo());
		jobMasterDTO.setDiscVal(jobMaster2.getDiscVal());
		jobMasterDTO.setDuration(jobMaster2.getDuration());
		jobMasterDTO.setJob(jobMaster2.getJob());
		jobMasterDTO.setJobId(jobMaster2.getJobId());
		jobMasterDTO.setSpecificationSeqNo(jobMaster2.getSpecificationSeqNo());
		jobMasterDTO.setStatus(jobMaster2.getStatus());
		jobMasterDTO.setTaxPer(jobMaster2.getTaxPer());
		jobMasterDTO.setTaxSeqNo(jobMaster2.getTaxSeqNo());
		jobMasterDTO.setTaxVal(jobMaster2.getTaxVal());
		jobMasterDTO.setUnitRate(jobMaster2.getUnitRate());
		jobMasterDTO.setUnitRateSeqNo(jobMaster2.getUnitRateSeqNo());
		jobMasterDTO.setDurationCodeSeqNo(jobMaster2.getDurationCodeSeqNo());		
		return jobMasterDTO;
	}

	private JobPartyMaster setJobPartyMaster(JobPartyMaster_DTO cDTO) 
	{
		JobPartyMaster jobMaster2 = new JobPartyMaster();		
		jobMaster2.setMasterJobSeqNo(cDTO.getMasterJobSeqNo());
		jobMaster2.setPartySeqNo(cDTO.getPartySeqNo());
		jobMaster2.setDescription(cDTO.getDescription());
		jobMaster2.setDiscPer(cDTO.getDiscPer());
		jobMaster2.setDiscSeqNo(cDTO.getDiscSeqNo());
		jobMaster2.setDiscVal(cDTO.getDiscVal());
		jobMaster2.setDuration(cDTO.getDuration());
		jobMaster2.setJob(cDTO.getJob());
		jobMaster2.setJobId(cDTO.getJobId());
		jobMaster2.setSpecificationSeqNo(cDTO.getSpecificationSeqNo());
		jobMaster2.setStatus(cDTO.getStatus());
		jobMaster2.setTaxPer(jobMaster2.getTaxPer());
		jobMaster2.setTaxSeqNo(jobMaster2.getTaxSeqNo());
		jobMaster2.setTaxVal(jobMaster2.getTaxVal());
		jobMaster2.setUnitRate(jobMaster2.getUnitRate());
		jobMaster2.setUnitRateSeqNo(jobMaster2.getUnitRateSeqNo());
		jobMaster2.setDurationCodeSeqNo(jobMaster2.getDurationCodeSeqNo());
		return jobMaster2;
	}
}