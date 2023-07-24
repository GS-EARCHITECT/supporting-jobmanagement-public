package job_master_read_mgmt.model.repo;

import java.util.concurrent.CopyOnWriteArrayList;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import job_master_read_mgmt.model.master.JobMaster;

@Repository("jobMasterReadRepo")
public interface JobMasterRead_Repo extends JpaRepository<JobMaster, Long> 
{

	@Query(value = "select * from JOB_MASTER where JOB_SEQ_NO in :ids ORDER BY JOB_SEQ_NO", nativeQuery = true)
	CopyOnWriteArrayList<JobMaster> getSelectJobMasters(@Param("ids") CopyOnWriteArrayList<Long> ids);

	@Query(value = "SELECT * from  JOB_MASTER where party_SEQ_NO in :ids ORDER BY JOB_SEQ_NO", nativeQuery = true)
	CopyOnWriteArrayList<JobMaster> getSelectJobMastersByParties(@Param("pids") CopyOnWriteArrayList<Long> pids);

}