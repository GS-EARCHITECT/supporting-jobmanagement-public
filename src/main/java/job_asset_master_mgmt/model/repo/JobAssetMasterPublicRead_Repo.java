package job_asset_master_mgmt.model.repo;

import java.util.concurrent.CopyOnWriteArrayList;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import job_asset_master_mgmt.model.master.JobAssetMaster;
import job_asset_master_mgmt.model.master.JobAssetMasterPK;

@Repository("jobAssetMasterPublicReadRepo")
public interface JobAssetMasterPublicRead_Repo extends JpaRepository<JobAssetMaster, JobAssetMasterPK> 
{
	@Query(value = "SELECT * FROM JOB_ASSET_MASTER a WHERE a.job_seq_no in :jobSeqNos order by asset_seq_no", nativeQuery = true)
	CopyOnWriteArrayList<JobAssetMaster> getSelectAssetsByJobs(@Param("jobSeqNos") CopyOnWriteArrayList<Long> jobSeqNos);
	
	@Query(value = "SELECT * FROM JOB_ASSET_MASTER a WHERE a.target_seq_no in :trgSeqNos order by asset_seq_no", nativeQuery = true)
	CopyOnWriteArrayList<JobAssetMaster> getSelectAssetsByTargets(@Param("trgSeqNos") CopyOnWriteArrayList<Long> trgSeqNos);
	
	@Query(value = "SELECT * FROM JOB_ASSET_MASTER a WHERE a.asset_seq_no in :assetSeqNos order by asset_seq_no", nativeQuery = true)
	CopyOnWriteArrayList<JobAssetMaster> getSelectAssetsByAssets(@Param("assetSeqNos") CopyOnWriteArrayList<Long> assetSeqNos);
	
	}
