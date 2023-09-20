package job_asset_master_mgmt.service;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CopyOnWriteArrayList;
import job_asset_master_mgmt.model.dto.JobAssetMaster_DTO;
import job_asset_master_mgmt.model.master.JobAssetMasterPK;

public interface I_JobAssetMasterPublicRead_Service 
{
	public CompletableFuture<CopyOnWriteArrayList<JobAssetMaster_DTO>> getAllJobAssets();
	public CompletableFuture<CopyOnWriteArrayList<JobAssetMaster_DTO>> getSelectJobAssets(CopyOnWriteArrayList<JobAssetMasterPK> jobAssetMasterPKs);	
	public CompletableFuture<CopyOnWriteArrayList<JobAssetMaster_DTO>> getSelectJobAssetsByJobs( CopyOnWriteArrayList<Long> jobSeqNos);
	public CompletableFuture<CopyOnWriteArrayList<JobAssetMaster_DTO>> getSelectJobAssetsByTargets( CopyOnWriteArrayList<Long> trgSeqNos);
	public CompletableFuture<CopyOnWriteArrayList<JobAssetMaster_DTO>> getSelectJobAssetsByAssets( CopyOnWriteArrayList<Long> assetSeqNos);		
	public CompletableFuture<CopyOnWriteArrayList<JobAssetMaster_DTO>> getSelectAssetsByDirection(Character dFlag);
}