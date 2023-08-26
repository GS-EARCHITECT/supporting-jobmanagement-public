package job_class_structure_mgmt.model.repo;

import java.util.concurrent.CopyOnWriteArrayList;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import job_class_structure_mgmt.model.master.JobClassStructure;
import job_class_structure_mgmt.model.master.JobClassStructurePK;

@Repository("jobClassStructureReadRepo")
public interface JobClassStructureRead_Repo extends JpaRepository<JobClassStructure, JobClassStructurePK> 
{

	@Query(value = "select * from JOB_CLASS_STRUCTURE  where (JOB_CLASS_SEQ_NO in :ids and par_JOB_CLASS_SEQ_NO in :pids) ORDER BY JOB_CLASS_SEQ_NO", nativeQuery = true)
	CopyOnWriteArrayList<JobClassStructure> getSelectJobClassStructures(@Param("ids") CopyOnWriteArrayList<Long> ids, @Param("ids") CopyOnWriteArrayList<Long> pids);

	@Query(value = "SELECT * from  JOB_CLASS_STRUCTURE where PAR_JOB_CLASS_SEQ_NO in :ids ORDER BY JOB_CLASS_SEQ_NO", nativeQuery = true)
	CopyOnWriteArrayList<JobClassStructure> getSelectJobClassesByParents(@Param("ids") CopyOnWriteArrayList<Long> ids);

	@Query(value = "SELECT * from  JOB_CLASS_STRUCTURE where party_SEQ_NO in :ids ORDER BY JOB_CLASS_SEQ_NO", nativeQuery = true)
	CopyOnWriteArrayList<JobClassStructure> getSelectJobClassesByParties(@Param("pids") CopyOnWriteArrayList<Long> pids);
	
}