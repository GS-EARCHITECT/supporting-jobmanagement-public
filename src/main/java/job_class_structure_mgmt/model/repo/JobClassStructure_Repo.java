package job_class_structure_mgmt.model.repo;

import java.util.ArrayList;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import job_class_structure_mgmt.model.master.JobClassStructure;
import job_class_structure_mgmt.model.master.JobClassStructurePK;

@Repository("jobClassStructureRepo")
public interface JobClassStructure_Repo extends JpaRepository<JobClassStructure, JobClassStructurePK> 
{

	@Query(value = "select * from JOB_CLASS_STRUCTURE  where (JOB_CLASS_SEQ_NO in :ids and par_JOB_CLASS_SEQ_NO in :pids) ORDER BY JOB_CLASS_SEQ_NO", nativeQuery = true)
	ArrayList<JobClassStructure> getSelectJobClassStructures(@Param("ids") ArrayList<Long> ids, @Param("ids") ArrayList<Long> pids);

	@Query(value = "SELECT * from  JOB_CLASS_STRUCTURE where PAR_JOB_CLASS_SEQ_NO in :ids ORDER BY JOB_CLASS_SEQ_NO", nativeQuery = true)
	ArrayList<JobClassStructure> getSelectJobClassesByParents(@Param("ids") ArrayList<Long> ids);

	@Query(value = "SELECT * from  JOB_CLASS_STRUCTURE where party_SEQ_NO in :ids ORDER BY JOB_CLASS_SEQ_NO", nativeQuery = true)
	ArrayList<JobClassStructure> getSelectJobClassesByParties(@Param("pids") ArrayList<Long> pids);

	@Query(value = "delete from JOB_CLASS_STRUCTURE  where (JOB_CLASS_SEQ_NO in :ids and par_JOB_CLASS_SEQ_NO in :pids)", nativeQuery = true)
	void delSelectJobClassStructures(@Param("ids") ArrayList<Long> ids, @Param("ids") ArrayList<Long> pids);

	@Query(value = "delete from  JOB_CLASS_STRUCTURE where PAR_JOB_CLASS_SEQ_NO in :ids ORDER BY JOB_CLASS_SEQ_NO", nativeQuery = true)
	void delSelectJobClassesByParents(@Param("ids") ArrayList<Long> ids);

	@Query(value = "delete from  JOB_CLASS_STRUCTURE where party_SEQ_NO in :ids ORDER BY JOB_CLASS_SEQ_NO", nativeQuery = true)
	void delSelectJobClassesByParties(@Param("pids") ArrayList<Long> pids);


}