package job_master_mgmt.model.repo;

import java.util.ArrayList;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import job_master_mgmt.model.master.JobMaster;

@Repository("jobMasterRepo")
public interface JobMaster_Repo extends JpaRepository<JobMaster, Long> 
{

	@Query(value = "select * from JOB_MASTER where JOB_SEQ_NO in :ids ORDER BY JOB_SEQ_NO", nativeQuery = true)
	ArrayList<JobMaster> getSelectJobMasters(@Param("ids") ArrayList<Long> ids);

	@Query(value = "SELECT * from  JOB_MASTER where party_SEQ_NO in :ids ORDER BY JOB_SEQ_NO", nativeQuery = true)
	ArrayList<JobMaster> getSelectJobMastersByParties(@Param("pids") ArrayList<Long> pids);

	@Query(value = "delete from JOB_MASTER  where (JOB_SEQ_NO in :ids and par_JOB_SEQ_NO in :pids)", nativeQuery = true)
	void delSelectJobMasters(@Param("ids") ArrayList<Long> ids);

	@Query(value = "delete from  JOB_MASTER where party_SEQ_NO in :ids ORDER BY JOB_SEQ_NO", nativeQuery = true)
	void delSelectJobMastersByParties(@Param("pids") ArrayList<Long> pids);

}