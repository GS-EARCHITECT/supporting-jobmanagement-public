package job_type_structure_details_mgmt.model.repo;

import java.util.ArrayList;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import job_type_structure_details_mgmt.model.details.JobTypeStructureDetails;
import job_type_structure_details_mgmt.model.details.JobTypeStructureDetailsPK;

@Repository("jobTypeStructureDetailsRepo")
public interface JobTypeStructureDetailsRepo extends CrudRepository<JobTypeStructureDetails, JobTypeStructureDetailsPK> 
{	
	@Modifying
	@Query(value="delete from JOB_TYPE_STRUCTURE_DETAILS where JOB_TYPE_SEQ_NO in :jobTypeSeqNos", nativeQuery = true)
	void deleteSelectJobTypeStructureDetailss(@Param(value = "jobTypeSeqNos") ArrayList<Long> jobTypeSeqNos);
	
	@Query(value = "SELECT * from JOB_TYPE_STRUCTURE_DETAILS where JOB_TYPE_SEQ_NO in :jobTypeSeqNos ORDER BY JOB_TYPE_SEQ_NO",nativeQuery = true) 
	ArrayList<JobTypeStructureDetails> getSelectJobTypeStructureDetails(@Param(value = "jobTypeSeqNos") ArrayList<Long> jobTypeSeqNos);
	
	@Query(value = "SELECT * from JOB_TYPE_STRUCTURE_DETAILS where (par_JOB_TYPE_SEQ_NO = :jobTypeSeqNo and par_target_SEQ_NO = :parTargetSeqNo) ORDER BY SEQ_NO",nativeQuery = true) 
	ArrayList<JobTypeStructureDetails> getSelectJobTypeStructureDetailsForParent(@Param(value = "jobTypeSeqNo") Long jobTypeSeqNo, @Param(value = "parTargetSeqNo") Long parTargetSeqNo);
}