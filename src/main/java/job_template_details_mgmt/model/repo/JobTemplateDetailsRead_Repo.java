package job_template_details_mgmt.model.repo;

import java.util.concurrent.CopyOnWriteArrayList;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import job_template_details_mgmt.model.details.JobTemplateDetails;
import job_template_details_mgmt.model.details.JobTemplateDetailsPK;

@Repository("jobTemplateDetailsReadRepo")
public interface JobTemplateDetailsRead_Repo extends CrudRepository<JobTemplateDetails, JobTemplateDetailsPK> 
{
	@Query(value = "SELECT * JOB_TEMPLATE_DETAILS where JOB_TEMPLATE_SEQ_NO in :jobTemplateDetailsSeqNos ORDER BY JOB_TEMPLATE_SEQ_NO", nativeQuery = true)
	CopyOnWriteArrayList<JobTemplateDetails> getSelectJobTemplateDetails(@Param("jobTemplateDetailsSeqNos") CopyOnWriteArrayList<Long> jobTemplateDetailsSeqNos);
	
	@Query(value = "SELECT * FROM JOB_TEMPLATE_DETAILS where job_template_seq_no = :jobTemplateSeqNo ORDER BY seq_no",nativeQuery = true) 
	CopyOnWriteArrayList<JobTemplateDetails> getJobsForTemplate(@Param("jobTemplateSeqNo") Long jobTemplateSeqNo);
	
}