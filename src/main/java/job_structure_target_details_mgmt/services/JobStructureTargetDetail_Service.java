package job_structure_target_details_mgmt.services;

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

import job_structure_target_details_mgmt.model.details.JobStructureTargetDetail;
import job_structure_target_details_mgmt.model.details.JobStructureTargetDetailPK;
import job_structure_target_details_mgmt.model.dto.JobStructureTargetDetail_DTO;
import job_structure_target_details_mgmt.model.repo.JobStructureTargetDetailsRead_Repo;

@Service("jobStructureTargetDetailsReadServ")
@Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.READ_COMMITTED)
public class JobStructureTargetDetail_Service implements I_JobStructureTargetDetailsRead_Service {

	// private static final Logger logger =
	// LoggerFactory.getLogger(JobStructureTargetDetailService.class);

	@Autowired
	private JobStructureTargetDetailsRead_Repo jobStructureTargetDetailsReadRepo;

	@Autowired
	private Executor asyncExecutor;

	@Override
	public CompletableFuture<CopyOnWriteArrayList<JobStructureTargetDetail_DTO>> getAllJobStructureTargetDetails()
			throws InterruptedException, ExecutionException {
		CompletableFuture<CopyOnWriteArrayList<JobStructureTargetDetail_DTO>> future = CompletableFuture
				.supplyAsync(() -> {
					CopyOnWriteArrayList<JobStructureTargetDetail> jobList = (CopyOnWriteArrayList<JobStructureTargetDetail>) jobStructureTargetDetailsReadRepo
							.findAll();
					CopyOnWriteArrayList<JobStructureTargetDetail_DTO> jobStructureDetailsDTOs = new CopyOnWriteArrayList<JobStructureTargetDetail_DTO>();
					jobStructureDetailsDTOs = jobList != null ? this.getJobStructureTargetDetail_DTOs(jobList) : null;
					return jobStructureDetailsDTOs;
				}, asyncExecutor);
		return future;
	}

	@Override
	public CompletableFuture<CopyOnWriteArrayList<JobStructureTargetDetail_DTO>> getSelectJobStructureTargetDetailsForJobs(
			CopyOnWriteArrayList<Long> jobSeqNos) throws InterruptedException, ExecutionException 
	{
		
		CompletableFuture<CopyOnWriteArrayList<JobStructureTargetDetail_DTO>> future = CompletableFuture
				.supplyAsync(() -> {
		CopyOnWriteArrayList<JobStructureTargetDetail> jobStructureTargetDetails = (CopyOnWriteArrayList<JobStructureTargetDetail>) jobStructureTargetDetailsReadRepo
				.getSelectJobStructureTargetDetailsForJobs(jobSeqNos);
		CopyOnWriteArrayList<JobStructureTargetDetail_DTO> jobStructureTargetDetailsDTOs = jobStructureTargetDetails != null
				? this.getJobStructureTargetDetail_DTOs(jobStructureTargetDetails)
				: null;
				return jobStructureTargetDetailsDTOs;
				}, asyncExecutor);
		return future;
	}

	@Override
	public CompletableFuture<CopyOnWriteArrayList<JobStructureTargetDetail_DTO>> getSelectJobStructureTargetDetails(
			CopyOnWriteArrayList<JobStructureTargetDetailPK> jobStructureTargetDetailPKs)
			throws InterruptedException, ExecutionException 
	{
		CompletableFuture<CopyOnWriteArrayList<JobStructureTargetDetail_DTO>> future = CompletableFuture
				.supplyAsync(() -> {

		CopyOnWriteArrayList<JobStructureTargetDetail> jobStructureTargetDetails = (CopyOnWriteArrayList<JobStructureTargetDetail>) jobStructureTargetDetailsReadRepo
				.findAllById(jobStructureTargetDetailPKs);
		CopyOnWriteArrayList<JobStructureTargetDetail_DTO> jobStructureTargetDetailsDTOs = jobStructureTargetDetails != null
				? this.getJobStructureTargetDetail_DTOs(jobStructureTargetDetails)
				: null;
				return jobStructureTargetDetailsDTOs;
				}, asyncExecutor);
		return future;
	}

	@Override
	public CompletableFuture<CopyOnWriteArrayList<JobStructureTargetDetail_DTO>> getSelectJobStructureTargetDetailsForParents(
			CopyOnWriteArrayList<Long> jobSeqNos, CopyOnWriteArrayList<Long> parTargetSeqNos)
			throws InterruptedException, ExecutionException 
	{
		CompletableFuture<CopyOnWriteArrayList<JobStructureTargetDetail_DTO>> future = CompletableFuture
				.supplyAsync(() -> {
		CopyOnWriteArrayList<JobStructureTargetDetail> jobStructureTargetDetails = (CopyOnWriteArrayList<JobStructureTargetDetail>) jobStructureTargetDetailsReadRepo
				.getSelectJobStructureTargetDetailForParents(jobSeqNos, parTargetSeqNos);
		CopyOnWriteArrayList<JobStructureTargetDetail_DTO> jobStructureTargetDetailsDTOs = jobStructureTargetDetails != null
				? this.getJobStructureTargetDetail_DTOs(jobStructureTargetDetails)
				: null;
				return jobStructureTargetDetailsDTOs;
				}, asyncExecutor);
		return future;
	}

	private synchronized CopyOnWriteArrayList<JobStructureTargetDetail_DTO> getJobStructureTargetDetail_DTOs(
			CopyOnWriteArrayList<JobStructureTargetDetail> jobStructureDetailss) 
	{
	JobStructureTargetDetail_DTO jobStructureDetailsDTO = null;
		CopyOnWriteArrayList<JobStructureTargetDetail_DTO> jobStructureDetailsDTOs = new CopyOnWriteArrayList<JobStructureTargetDetail_DTO>();

		for (int i = 0; i < jobStructureDetailss.size(); i++) {
			jobStructureDetailsDTO = getJobStructureTargetDetail_DTO(jobStructureDetailss.get(i));
			jobStructureDetailsDTOs.add(jobStructureDetailsDTO);
		}
		return jobStructureDetailsDTOs;
	}

	private synchronized JobStructureTargetDetail_DTO getJobStructureTargetDetail_DTO(
			JobStructureTargetDetail jobStructureTargetDetails) {
		JobStructureTargetDetail_DTO jobStructureTargetDetailsDTO = new JobStructureTargetDetail_DTO();
		jobStructureTargetDetailsDTO.setJobClassSeqNo(jobStructureTargetDetails.getId().getJobClassSeqNo());
		jobStructureTargetDetailsDTO.setJobSeqNo(jobStructureTargetDetailsDTO.getJobSeqNo());
		jobStructureTargetDetailsDTO.setTargetSeqNo(jobStructureTargetDetailsDTO.getTargetSeqNo());
		jobStructureTargetDetailsDTO.setParJobClassSeqNo(jobStructureTargetDetails.getId().getParJobClassSeqNo());
		jobStructureTargetDetailsDTO.setParJobSeqNo(jobStructureTargetDetails.getId().getParJobSeqNo());
		jobStructureTargetDetailsDTO.setParTargetSeqNo(jobStructureTargetDetailsDTO.getParTargetSeqNo());
		jobStructureTargetDetailsDTO.setStatus(jobStructureTargetDetails.getStatus());
		jobStructureTargetDetailsDTO.setRemark(jobStructureTargetDetails.getRemark());
		jobStructureTargetDetailsDTO.setSeqNo(jobStructureTargetDetails.getSeqNo());
		return jobStructureTargetDetailsDTO;
	}

}