package job_asset_master_mgmt.service;

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
import job_asset_master_mgmt.model.dto.JobAssetMaster_DTO;
import job_asset_master_mgmt.model.master.JobAssetMaster;
import job_asset_master_mgmt.model.master.JobAssetMasterPK;
import job_asset_master_mgmt.model.repo.JobAssetMasterPublicRead_Repo;

@Service("jobAssetMasterPublicReadServ")
@Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.READ_COMMITTED)
public class JobAssetMasterPublicRead_Service implements I_JobAssetMasterPublicRead_Service {

	@Autowired
	private JobAssetMasterPublicRead_Repo jobAssetMasterPublicReadRepo;

	@Autowired
	private Executor asyncExecutor;

	public CompletableFuture<CopyOnWriteArrayList<JobAssetMaster_DTO>> getAllJobAssets() {
		CompletableFuture<CopyOnWriteArrayList<JobAssetMaster_DTO>> future = CompletableFuture.supplyAsync(() -> {
			CopyOnWriteArrayList<JobAssetMaster> assetList = (CopyOnWriteArrayList<JobAssetMaster>) jobAssetMasterPublicReadRepo.getAllJobAssets();
			CopyOnWriteArrayList<JobAssetMaster_DTO> lMasterss = assetList != null
					? this.getJobAssetMaster_DTOs(assetList)
					: null;
			return lMasterss;
		}, asyncExecutor);
		return future;
	}

	public CompletableFuture<CopyOnWriteArrayList<JobAssetMaster_DTO>> getSelectJobAssets(
			CopyOnWriteArrayList<JobAssetMasterPK> jobAssetMasterPKs) {
		CompletableFuture<CopyOnWriteArrayList<JobAssetMaster_DTO>> future = CompletableFuture.supplyAsync(() -> {
			CopyOnWriteArrayList<JobAssetMaster> assetList = (CopyOnWriteArrayList<JobAssetMaster>) jobAssetMasterPublicReadRepo
					.findAllById(jobAssetMasterPKs);
			CopyOnWriteArrayList<JobAssetMaster_DTO> lMasterss = assetList != null
					? this.getJobAssetMaster_DTOs(assetList)
					: null;
			return lMasterss;
		}, asyncExecutor);
		return future;
	}

	public CompletableFuture<CopyOnWriteArrayList<JobAssetMaster_DTO>> getSelectJobAssetsByJobs(
			CopyOnWriteArrayList<Long> jobSeqNos) {
		CompletableFuture<CopyOnWriteArrayList<JobAssetMaster_DTO>> future = CompletableFuture.supplyAsync(() -> {
			CopyOnWriteArrayList<JobAssetMaster> jobAssetMasters = jobAssetMasterPublicReadRepo
					.getSelectAssetsByJobs(jobSeqNos);
			CopyOnWriteArrayList<JobAssetMaster_DTO> jobAssetMaster_DTOs = jobAssetMasters != null
					? this.getJobAssetMaster_DTOs(jobAssetMasters)
					: null;
			return jobAssetMaster_DTOs;
		}, asyncExecutor);
		return future;
	}

	public CompletableFuture<CopyOnWriteArrayList<JobAssetMaster_DTO>> getSelectAssetsByDirection(Character dFlag) 
	{
		CompletableFuture<CopyOnWriteArrayList<JobAssetMaster_DTO>> future = CompletableFuture.supplyAsync(() -> {
			CopyOnWriteArrayList<JobAssetMaster> jobAssetMasters = jobAssetMasterPublicReadRepo.getSelectAssetsByDirection(dFlag);
			CopyOnWriteArrayList<JobAssetMaster_DTO> jobAssetMaster_DTOs = jobAssetMasters != null
					? this.getJobAssetMaster_DTOs(jobAssetMasters)
					: null;
			return jobAssetMaster_DTOs;
		}, asyncExecutor);
		return future;
	}

	
	public CompletableFuture<CopyOnWriteArrayList<JobAssetMaster_DTO>> getSelectJobAssetsByTargets(
			CopyOnWriteArrayList<Long> trgSeqNos) {
		CompletableFuture<CopyOnWriteArrayList<JobAssetMaster_DTO>> future = CompletableFuture.supplyAsync(() -> {
			CopyOnWriteArrayList<JobAssetMaster> jobAssetMasters = jobAssetMasterPublicReadRepo
					.getSelectAssetsByTargets(trgSeqNos);
			CopyOnWriteArrayList<JobAssetMaster_DTO> jobAssetMaster_DTOs = jobAssetMasters != null
					? this.getJobAssetMaster_DTOs(jobAssetMasters)
					: null;
			return jobAssetMaster_DTOs;
		}, asyncExecutor);
		return future;
	}

	public CompletableFuture<CopyOnWriteArrayList<JobAssetMaster_DTO>> getSelectJobAssetsByAssets(
			CopyOnWriteArrayList<Long> assetSeqNos) {
		CompletableFuture<CopyOnWriteArrayList<JobAssetMaster_DTO>> future = CompletableFuture.supplyAsync(() -> {
			CopyOnWriteArrayList<JobAssetMaster> jobAssetMasters = jobAssetMasterPublicReadRepo
					.getSelectAssetsByAssets(assetSeqNos);
			CopyOnWriteArrayList<JobAssetMaster_DTO> jobAssetMaster_DTOs = jobAssetMasters != null
					? this.getJobAssetMaster_DTOs(jobAssetMasters)
					: null;
			return jobAssetMaster_DTOs;
		}, asyncExecutor);
		return future;
	}

	private synchronized CopyOnWriteArrayList<JobAssetMaster_DTO> getJobAssetMaster_DTOs(
			CopyOnWriteArrayList<JobAssetMaster> lMasters) {
		JobAssetMaster_DTO lDTO = null;
		CopyOnWriteArrayList<JobAssetMaster_DTO> lMasterDTOs = new CopyOnWriteArrayList<JobAssetMaster_DTO>();
		for (int i = 0; i < lMasters.size(); i++) {
			lDTO = getJobAssetMaster_DTO(lMasters.get(i));
			lMasterDTOs.add(lDTO);
		}
		return lMasterDTOs;
	}

	private synchronized JobAssetMaster_DTO getJobAssetMaster_DTO(JobAssetMaster lMaster) {
		JobAssetMaster_DTO lDTO = new JobAssetMaster_DTO();
		lDTO.setAssetSeqNo(lMaster.getId().getAssetSeqNo());
		lDTO.setFrLocSeqNo(lMaster.getId().getFrLocSeqNo());
		lDTO.setToLocSeqNo(lMaster.getId().getToLocSeqNo());
		lDTO.setJobSeqNo(lMaster.getId().getJobSeqNo());
		lDTO.setTargetSeqNo(lMaster.getId().getTargetSeqNo());
		lDTO.setUnitRate(lMaster.getUnitRate());
		lDTO.setModeSeqNo(lMaster.getId().getModeSeqNo());
		lDTO.setRateSeqNo(lMaster.getRateSeqNo());
		lDTO.setReturnflag(lMaster.getReturnflag());
		lDTO.setDirectionflag(lMaster.getDirectionflag());
		return lDTO;
	}

}