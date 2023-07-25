package job_class_master_read_mgmt.services;

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
import job_class_master_read_mgmt.model.dto.JobClassMaster_DTO;
import job_class_master_read_mgmt.model.master.JobClassMaster;
import job_class_master_read_mgmt.model.repo.JobClassMasterRead_Repo;

@Service("jobClassMasterReadServ")
@Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.READ_COMMITTED)
public class JobClassMasterRead_Service implements I_JobClassMasterRead_Service 
{

//	private static final Logger logger = LoggerFactory.getLogger(JobClassMasterService.class);

	@Autowired
	private JobClassMasterRead_Repo jobClassMasterReadRepo;

	@Autowired
	private Executor asyncExecutor;
	
	@Override
	public CompletableFuture<CopyOnWriteArrayList<JobClassMaster_DTO>> getAllJobClasses() throws InterruptedException, ExecutionException 
	{
		CompletableFuture<CopyOnWriteArrayList<JobClassMaster_DTO>> future = CompletableFuture.supplyAsync(() -> 
		{
		CopyOnWriteArrayList<JobClassMaster> jcmList = (CopyOnWriteArrayList<JobClassMaster>) jobClassMasterReadRepo.findAll();
		CopyOnWriteArrayList<JobClassMaster_DTO> jcmDTOs = new CopyOnWriteArrayList<JobClassMaster_DTO>();
		jcmDTOs = jcmList != null ? this.getJobClassMaster_DTOs(jcmList) : null;
		return jcmDTOs;
		},asyncExecutor);

		return future;

	}

	@Override
	public CompletableFuture<CopyOnWriteArrayList<JobClassMaster_DTO>> getSelectJobClasses(CopyOnWriteArrayList<Long> jcmSeqNos) throws InterruptedException, ExecutionException 
	{
		CompletableFuture<CopyOnWriteArrayList<JobClassMaster_DTO>> future = CompletableFuture.supplyAsync(() -> 
		{
		CopyOnWriteArrayList<JobClassMaster> jobList = (CopyOnWriteArrayList<JobClassMaster>) jobClassMasterReadRepo.getSelectJobClasses(jcmSeqNos);
		CopyOnWriteArrayList<JobClassMaster_DTO> jcmDTOs = new CopyOnWriteArrayList<JobClassMaster_DTO>();
		jcmDTOs = jobList != null ? this.getJobClassMaster_DTOs(jobList) : null;
		return jcmDTOs;
		},asyncExecutor);

		return future;

	}


	private synchronized CopyOnWriteArrayList<JobClassMaster_DTO> getJobClassMaster_DTOs(CopyOnWriteArrayList<JobClassMaster> jobMasters) {
		JobClassMaster_DTO jobDTO = null;
		CopyOnWriteArrayList<JobClassMaster_DTO> jobDTOs = new CopyOnWriteArrayList<JobClassMaster_DTO>();

		for (int i = 0; i < jobMasters.size(); i++) {
			jobDTO = getJobClassMaster_DTO(jobMasters.get(i));
			jobDTOs.add(jobDTO);
		}
		return jobDTOs;
	}

	private synchronized JobClassMaster_DTO getJobClassMaster_DTO(JobClassMaster jobClassMaster2) {
		JobClassMaster_DTO jobClassMasterDTO = new JobClassMaster_DTO();
		jobClassMasterDTO = new JobClassMaster_DTO();
		jobClassMasterDTO.setJobClassSeqNo(jobClassMaster2.getJobClassSeqNo());
		jobClassMasterDTO.setJobClass(jobClassMaster2.getJobClass());
		jobClassMasterDTO.setRemark(jobClassMaster2.getRemark());
		jobClassMasterDTO.setStatus(jobClassMaster2.getStatus());
		return jobClassMasterDTO;
	}

	
}