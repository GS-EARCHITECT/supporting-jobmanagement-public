package job_structure_details_mgmt.model.repo;

import java.util.ArrayList;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import job_structure_details_mgmt.model.master.JobStructureDetail;
import job_structure_details_mgmt.model.master.JobStructureDetailPK;

@Repository("jobStructureDetailsRepo")
public interface JobStructureDetail_Repo extends JpaRepository<JobStructureDetail, JobStructureDetailPK> 
{

	@Query(value = "select * from JOB_STRUCTURE_DETAILS  where JOB_SEQ_NO in :ids  ORDER BY JOB_SEQ_NO", nativeQuery = true)
	ArrayList<JobStructureDetail> getSelectJobStructureDetails(@Param("ids") ArrayList<Long> ids);

	@Query(value = "select * from JOB_STRUCTURE_DETAILS  where par_JOB_SEQ_NO in :pids ORDER BY JOB_SEQ_NO", nativeQuery = true)
	ArrayList<JobStructureDetail> getSelectJobStructureDetailsByParents(@Param("pids") ArrayList<Long> pids);

	@Query(value = "delete from JOB_STRUCTURE_DETAILS  where JOB_SEQ_NO in :ids  ORDER BY JOB_SEQ_NO", nativeQuery = true)
	void delSelectJobStructureDetails(@Param("ids") ArrayList<Long> ids);

	@Query(value = "delete from JOB_STRUCTURE_DETAILS  where par_JOB_SEQ_NO in :pids ORDER BY JOB_SEQ_NO", nativeQuery = true)
	void delSelectJobStructureDetailsByParents( @Param("pids") ArrayList<Long> pids);

}