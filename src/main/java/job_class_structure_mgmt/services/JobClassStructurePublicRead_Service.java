package job_class_structure_mgmt.services;

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
import job_class_structure_mgmt.model.dto.JobClassStructure_DTO;
import job_class_structure_mgmt.model.master.JobClassStructure;
import job_class_structure_mgmt.model.master.JobClassStructurePK;
import job_class_structure_mgmt.model.repo.JobClassStructurePublicRead_Repo;

@Service("jobClassStructurePublicReadServ")
@Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.READ_COMMITTED)
public class JobClassStructurePublicRead_Service implements I_JobClassStructurePublicRead_Service 
{

//	private static final Logger logger = LoggerFactory.getLogger(JobClassStructureService.class);

	@Autowired
	private JobClassStructurePublicRead_Repo jobClassStructurePublicReadRepo;
	
	@Autowired
	private Executor asyncExecutor;

	@Override
	public CompletableFuture<CopyOnWriteArrayList<JobClassStructure_DTO>> getAllJobClassStructures() throws InterruptedException, ExecutionException 
	{
		CompletableFuture<CopyOnWriteArrayList<JobClassStructure_DTO>> future = CompletableFuture.supplyAsync(() -> 
		{
		CopyOnWriteArrayList<JobClassStructure> jobList = (CopyOnWriteArrayList<JobClassStructure>) jobClassStructurePublicReadRepo.getAllJobClassStructures();
		CopyOnWriteArrayList<JobClassStructure_DTO> jcmDTOs = new CopyOnWriteArrayList<JobClassStructure_DTO>();
		jcmDTOs = jobList != null ? this.getJobClassStructure_DTOs(jobList) : null;
		return jcmDTOs;
		},asyncExecutor);

		return future;

	}

	@Override
	public CompletableFuture<CopyOnWriteArrayList<JobClassStructure_DTO>> getSelectJobClassStructures(CopyOnWriteArrayList<Long> ids, CopyOnWriteArrayList<Long> pids) throws InterruptedException, ExecutionException 
{
		CompletableFuture<CopyOnWriteArrayList<JobClassStructure_DTO>> future = CompletableFuture.supplyAsync(() -> 
		{
		CopyOnWriteArrayList<JobClassStructure> jobList = (CopyOnWriteArrayList<JobClassStructure>) jobClassStructurePublicReadRepo.getSelectJobClassStructures(ids, pids);
		CopyOnWriteArrayList<JobClassStructure_DTO> jcmDTOs = new CopyOnWriteArrayList<JobClassStructure_DTO>();
		jcmDTOs = jobList != null ? this.getJobClassStructure_DTOs(jobList) : null;
		return jcmDTOs;
		},asyncExecutor);

		return future;
	}

	@Override
	public CompletableFuture<CopyOnWriteArrayList<JobClassStructure_DTO>> getSelectJobClassesByParents(CopyOnWriteArrayList<Long> ids) throws InterruptedException, ExecutionException 
{
		CompletableFuture<CopyOnWriteArrayList<JobClassStructure_DTO>> future = CompletableFuture.supplyAsync(() -> 
		{
		CopyOnWriteArrayList<JobClassStructure> jobList = (CopyOnWriteArrayList<JobClassStructure>) jobClassStructurePublicReadRepo.getSelectJobClassesByParents(ids);
		CopyOnWriteArrayList<JobClassStructure_DTO> jcmDTOs = new CopyOnWriteArrayList<JobClassStructure_DTO>();
		jcmDTOs = jobList != null ? this.getJobClassStructure_DTOs(jobList) : null;
		return jcmDTOs;
		},asyncExecutor);
		return future;
	}

	@Override
	public CompletableFuture<CopyOnWriteArrayList<JobClassStructure_DTO>> getSelectJobClassesByParties(CopyOnWriteArrayList<Long> ids) throws InterruptedException, ExecutionException 
{
		CompletableFuture<CopyOnWriteArrayList<JobClassStructure_DTO>> future = CompletableFuture.supplyAsync(() -> 
		{
		CopyOnWriteArrayList<JobClassStructure> jobList = (CopyOnWriteArrayList<JobClassStructure>) jobClassStructurePublicReadRepo.getSelectJobClassesByParties(ids);
		CopyOnWriteArrayList<JobClassStructure_DTO> jcmDTOs = new CopyOnWriteArrayList<JobClassStructure_DTO>();
		jcmDTOs = jobList != null ? this.getJobClassStructure_DTOs(jobList) : null;
		return jcmDTOs;
		},asyncExecutor);
		return future;

	}

	private synchronized CopyOnWriteArrayList<JobClassStructure_DTO> getJobClassStructure_DTOs(CopyOnWriteArrayList<JobClassStructure> jobStructures) {
		JobClassStructure_DTO jobDTO = null;
		CopyOnWriteArrayList<JobClassStructure_DTO> jobDTOs = new CopyOnWriteArrayList<JobClassStructure_DTO>();

		for (int i = 0; i < jobStructures.size(); i++) {
			jobDTO = getJobClassStructure_DTO(jobStructures.get(i));
			jobDTOs.add(jobDTO);
		}
		return jobDTOs;
	}

	private synchronized JobClassStructure_DTO getJobClassStructure_DTO(JobClassStructure jobClassStructure2) {
		JobClassStructure_DTO jobClassStructureDTO = new JobClassStructure_DTO();
		jobClassStructureDTO = new JobClassStructure_DTO();
		jobClassStructureDTO.setJobClassSeqNo(jobClassStructure2.getId().getJobClassSeqNo());
		jobClassStructureDTO.setParJobClassSeqNo(jobClassStructure2.getId().getParJobClassSeqNo());
		jobClassStructureDTO.setPartySeqNo(jobClassStructure2.getId().getPartySeqNo());
		return jobClassStructureDTO;
	}

	private JobClassStructure setJobClassStructure(JobClassStructure_DTO jDTO) 
	{
		JobClassStructurePK jobClassStructurePK = new JobClassStructurePK();
		jobClassStructurePK.setJobClassSeqNo(jDTO.getJobClassSeqNo());
		jobClassStructurePK.setParJobClassSeqNo(jDTO.getParJobClassSeqNo());
		jobClassStructurePK.setPartySeqNo(jDTO.getPartySeqNo());
		JobClassStructure jobClassStructure2 = new JobClassStructure();
		jobClassStructure2.setId(jobClassStructurePK);		
		return jobClassStructure2;
	}
}