package job_party_master.model.repo;

import java.util.concurrent.CopyOnWriteArrayList;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import job_party_master.model.master.JobPartyMaster;

@Repository("jobPartyMasterPublicReadRepo")
public interface JobPartyMasterPublicRead_Repo extends JpaRepository<JobPartyMaster, Long> {

	@Query(value = "SELECT * from  JOB_PARTY_MASTER ORDER BY JOB_SEQ_NO", nativeQuery = true)
	CopyOnWriteArrayList<JobPartyMaster> getAllJobPartyMasters();

	@Query(value = "SELECT * from  JOB_PARTY_MASTER where party_SEQ_NO in :ids ORDER BY JOB_SEQ_NO", nativeQuery = true)
	CopyOnWriteArrayList<JobPartyMaster> getSelectJobPartyMastersByParties(
			@Param("pids") CopyOnWriteArrayList<Long> pids);

	@Query(value = "SELECT * from  JOB_PARTY_MASTER where master_job_SEQ_NO in :ids ORDER BY JOB_SEQ_NO", nativeQuery = true)
	CopyOnWriteArrayList<JobPartyMaster> getSelectJobPartyMastersByMasterJobs(
			@Param("ids") CopyOnWriteArrayList<Long> ids);

}