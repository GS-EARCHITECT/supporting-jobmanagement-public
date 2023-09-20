package job_resource_master_mgmt.model.repo;

import java.util.concurrent.CopyOnWriteArrayList;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import job_resource_master_mgmt.model.master.JobResourceMaster;
import job_resource_master_mgmt.model.master.JobResourceMasterPK;

@Repository("jobResourceMasterPublicReadRepo")
public interface JobResourceMasterPublicRead_Repo extends JpaRepository<JobResourceMaster, JobResourceMasterPK> 
{
	@Query(value = "SELECT * FROM JOB_RESOURCE_MASTER a order by resource_seq_no", nativeQuery = true)
	CopyOnWriteArrayList<JobResourceMaster> getAllJobResources();
	
	@Query(value = "SELECT * FROM JOB_RESOURCE_MASTER a WHERE a.job_seq_no in :jobSeqNos order by resource_seq_no", nativeQuery = true)
	CopyOnWriteArrayList<JobResourceMaster> getSelectResourcesByJobs(@Param("jobSeqNos") CopyOnWriteArrayList<Long> jobSeqNos);
	
	@Query(value = "SELECT * FROM JOB_RESOURCE_MASTER a WHERE a.target_seq_no in :trgSeqNos order by resource_seq_no", nativeQuery = true)
	CopyOnWriteArrayList<JobResourceMaster> getSelectResourcesByTargets(@Param("trgSeqNos") CopyOnWriteArrayList<Long> trgSeqNos);
	
	@Query(value = "SELECT * FROM JOB_RESOURCE_MASTER a WHERE a.resource_seq_no in :resourceSeqNos order by resource_seq_no", nativeQuery = true)
	CopyOnWriteArrayList<JobResourceMaster> getSelectResourcesByResources(@Param("resourceSeqNos") CopyOnWriteArrayList<Long> resourceSeqNos);
	
	@Query(value = "SELECT * FROM JOB_RESOURCE_MASTER a WHERE upper(trim(a.directionflag)) = upper(trim(:dFlag)) order by resource_seq_no", nativeQuery = true)
	CopyOnWriteArrayList<JobResourceMaster> getSelectResourcesByDirection(@Param("dFlag") Character dFlag);
	
}
