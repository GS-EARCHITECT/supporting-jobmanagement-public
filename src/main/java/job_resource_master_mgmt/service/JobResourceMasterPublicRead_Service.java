package job_resource_master_mgmt.service;

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
import job_resource_master_mgmt.model.dto.JobResourceMaster_DTO;
import job_resource_master_mgmt.model.master.JobResourceMaster;
import job_resource_master_mgmt.model.repo.JobResourceMasterPublicRead_Repo;

@Service("jobResourceMasterPublicReadServ")
@Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.READ_COMMITTED)
public class JobResourceMasterPublicRead_Service implements I_JobResourceMasterPublicRead_Service {

	@Autowired
	private JobResourceMasterPublicRead_Repo jobResourceMasterPublicReadRepo;

	@Autowired
	private Executor asyncExecutor;

	public CompletableFuture<CopyOnWriteArrayList<JobResourceMaster_DTO>> getAllJobResources() {
		CompletableFuture<CopyOnWriteArrayList<JobResourceMaster_DTO>> future = CompletableFuture.supplyAsync(() -> {
			CopyOnWriteArrayList<JobResourceMaster> resourceList = (CopyOnWriteArrayList<JobResourceMaster>) jobResourceMasterPublicReadRepo
					.getAllJobResources();
			CopyOnWriteArrayList<JobResourceMaster_DTO> lMasterss = resourceList != null
					? this.getJobResourceMaster_DTOs(resourceList)
					: null;
			return lMasterss;
		}, asyncExecutor);
		return future;
	}

	public CompletableFuture<CopyOnWriteArrayList<JobResourceMaster_DTO>> getSelectJobResourcesByJobs(
			CopyOnWriteArrayList<Long> jobSeqNos) {
		CompletableFuture<CopyOnWriteArrayList<JobResourceMaster_DTO>> future = CompletableFuture.supplyAsync(() -> {
			CopyOnWriteArrayList<JobResourceMaster> resourceList = (CopyOnWriteArrayList<JobResourceMaster>) jobResourceMasterPublicReadRepo
					.getSelectResourcesByJobs(jobSeqNos);
			CopyOnWriteArrayList<JobResourceMaster_DTO> lMasterss = resourceList != null
					? this.getJobResourceMaster_DTOs(resourceList)
					: null;
			return lMasterss;
		}, asyncExecutor);
		return future;
	}

	public CompletableFuture<CopyOnWriteArrayList<JobResourceMaster_DTO>> getSelectJobResourcesByTargets(
			CopyOnWriteArrayList<Long> trgSeqNos) {
		CompletableFuture<CopyOnWriteArrayList<JobResourceMaster_DTO>> future = CompletableFuture.supplyAsync(() -> {
			CopyOnWriteArrayList<JobResourceMaster> resourceList = (CopyOnWriteArrayList<JobResourceMaster>) jobResourceMasterPublicReadRepo
					.getSelectResourcesByTargets(trgSeqNos);
			CopyOnWriteArrayList<JobResourceMaster_DTO> lMasterss = resourceList != null
					? this.getJobResourceMaster_DTOs(resourceList)
					: null;
			return lMasterss;
		}, asyncExecutor);
		return future;
	}

	public CompletableFuture<CopyOnWriteArrayList<JobResourceMaster_DTO>> getSelectJobResourcesByResources(
			CopyOnWriteArrayList<Long> resourceSeqNos) {
		CompletableFuture<CopyOnWriteArrayList<JobResourceMaster_DTO>> future = CompletableFuture.supplyAsync(() -> {
			CopyOnWriteArrayList<JobResourceMaster> resourceList = (CopyOnWriteArrayList<JobResourceMaster>) jobResourceMasterPublicReadRepo
					.getSelectResourcesByResources(resourceSeqNos);
			CopyOnWriteArrayList<JobResourceMaster_DTO> lMasterss = resourceList != null
					? this.getJobResourceMaster_DTOs(resourceList)
					: null;
			return lMasterss;
		}, asyncExecutor);
		return future;
	}

	private synchronized CopyOnWriteArrayList<JobResourceMaster_DTO> getJobResourceMaster_DTOs(
			CopyOnWriteArrayList<JobResourceMaster> lMasters) {
		JobResourceMaster_DTO lDTO = null;
		CopyOnWriteArrayList<JobResourceMaster_DTO> lMasterDTOs = new CopyOnWriteArrayList<JobResourceMaster_DTO>();
		for (int i = 0; i < lMasters.size(); i++) {
			lDTO = getJobResourceMaster_DTO(lMasters.get(i));
			lMasterDTOs.add(lDTO);
		}
		return lMasterDTOs;
	}

	private synchronized JobResourceMaster_DTO getJobResourceMaster_DTO(JobResourceMaster lMaster) {
		JobResourceMaster_DTO lDTO = new JobResourceMaster_DTO();
		lDTO.setQtySeqNo(lMaster.getQtySeqNo());
		lDTO.setQty(lMaster.getQty());
		lDTO.setResourceSeqNo(lMaster.getId().getResourceSeqNo());
		lDTO.setFrLocSeqNo(lMaster.getId().getFrLocSeqNo());
		lDTO.setToLocSeqNo(lMaster.getId().getToLocSeqNo());
		lDTO.setJobSeqNo(lMaster.getId().getJobSeqNo());
		lDTO.setTargetSeqNo(lMaster.getId().getTargetSeqNo());
		lDTO.setUnitRate(lMaster.getUnitRate());
		lDTO.setModeSeqNo(lMaster.getId().getModeSeqNo());
		lDTO.setRateSeqNo(lMaster.getRateSeqNo());
		lDTO.setReturnflag(lMaster.getReturnflag());
		return lDTO;
	}

}