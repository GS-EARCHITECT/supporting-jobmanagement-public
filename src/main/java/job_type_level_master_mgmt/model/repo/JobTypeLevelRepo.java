package job_type_level_master_mgmt.model.repo;

import java.util.ArrayList;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import job_type_level_master_mgmt.model.master.JobTypeLevelMaster;

@Repository("jobTypeLevelRepo")
public interface JobTypeLevelRepo extends CrudRepository<JobTypeLevelMaster, Long> 
{	
	@Modifying
	@Query(value="delete from JOB_TYPE_LEVEL_MASTER  where JOB_TYPE_LEVEL_SEQ_NO in :jobTypeLevelSeqNos", nativeQuery = true)
	void deleteSelectJobTypeLevels(@Param(value = "jobTypeLevelSeqNos") ArrayList<Long> jobTypeLevelSeqNos);
	
	@Query(value = "SELECT * JOB_TYPE_LEVEL_MASTER where JOB_TYPE_LEVEL_SEQ_NO in :jobTypeLevelSeqNos ORDER BY JOB_TYPE_LEVEL_SEQ_NO",nativeQuery = true) 
	ArrayList<JobTypeLevelMaster> getSelectJobTypeLevels(@Param("jobTypeLevelSeqNos") ArrayList<Long> jobTypeLevelSeqNos);
}