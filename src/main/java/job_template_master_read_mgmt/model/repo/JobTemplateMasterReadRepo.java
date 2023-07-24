package job_template_master_read_mgmt.model.repo;

import java.util.concurrent.CopyOnWriteArrayList;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import job_template_master_read_mgmt.model.master.JobTemplateMaster;
import job_template_master_read_mgmt.model.master.JobTemplateMasterPK;

@Repository("jobTemplateMasterReadRepo")
public interface JobTemplateMasterReadRepo extends CrudRepository<JobTemplateMaster, JobTemplateMasterPK> 
{	
	@Modifying
	@Query(value="delete from JOB_TEMPLATE_MASTER  where JOB_TYPE_SEQ_NO in :jobTemplateMasterSeqNos", nativeQuery = true)
	void deleteSelectJobTemplateMasters(@Param("jobTemplateMasterSeqNos") CopyOnWriteArrayList<Long> jobTemplateMasterSeqNos);
	
	@Query(value = "SELECT * JOB_TEMPLATE_MASTER where JOB_TYPE_SEQ_NO in :jobTemplateMasterSeqNos ORDER BY JOB_TYPE_SEQ_NO",nativeQuery = true) 
	CopyOnWriteArrayList<JobTemplateMaster> getSelectJobTemplateMasters(@Param("jobTemplateMasterSeqNos") CopyOnWriteArrayList<Long> jobTemplateMasterSeqNos);
}