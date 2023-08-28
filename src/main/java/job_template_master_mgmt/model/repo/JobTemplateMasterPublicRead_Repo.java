package job_template_master_mgmt.model.repo;

import java.util.concurrent.CopyOnWriteArrayList;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import job_template_master_mgmt.model.master.JobTemplateMaster;
import job_template_master_mgmt.model.master.JobTemplateMasterPK;

@Repository("jobTemplateMasterPublicReadRepo")
public interface JobTemplateMasterPublicRead_Repo extends JpaRepository<JobTemplateMaster, JobTemplateMasterPK> 
{
	@Query(value = "SELECT * JOB_TEMPLATE_MASTER ORDER BY JOB_template_SEQ_NO",nativeQuery = true) 
	CopyOnWriteArrayList<JobTemplateMaster> getAllJobTemplateMasters();
	
	@Query(value = "SELECT * JOB_TEMPLATE_MASTER where JOB_template_SEQ_NO in :jobTemplateMasterSeqNos ORDER BY JOB_template_SEQ_NO",nativeQuery = true) 
	CopyOnWriteArrayList<JobTemplateMaster> getSelectJobTemplateMasters(@Param("jobTemplateMasterSeqNos") CopyOnWriteArrayList<Long> jobTemplateMasterSeqNos);
}