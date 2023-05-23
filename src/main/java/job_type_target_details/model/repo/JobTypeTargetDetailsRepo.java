package job_type_target_details.model.repo;

import java.util.ArrayList;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import job_type_target_details.model.master.JobTypeTargetDetails;
import job_type_target_details.model.master.JobTypeTargetDetailsPK;

@Repository("jobTypeTargetDetailsRepo")
public interface JobTypeTargetDetailsRepo extends CrudRepository<JobTypeTargetDetails, JobTypeTargetDetailsPK> 
{	
	@Modifying
	@Query(value="delete from JOB_TYPE_TARGET_DETAILS  where JOB_TYPE_SEQ_NO in :jobTypeSeqNos", nativeQuery = true)
	void deleteSelectJobTypeTargetDetails(@Param("jobTypeSeqNos") ArrayList<Long> jobTypeSeqNos);
	
	@Query(value = "SELECT * from  JOB_TYPE_TARGET_DETAILS where JOB_TYPE_SEQ_NO in :jobTypeTargetDetailsSeqNos ORDER BY JOB_TYPE_SEQ_NO",nativeQuery = true) 
	ArrayList<JobTypeTargetDetails> getSelectJobTypeTargetDetails(@Param("jobTypeTargetDetailsSeqNos") ArrayList<Long> jobTypeTargetDetailsSeqNos);
	
	@Query(value = "SELECT coalesce(DUR_DAYS,0) from  JOB_TYPE_TARGET_DETAILS where JOB_TYPE_SEQ_NO = :jobTypeSeqNo ",nativeQuery = true) 
	Integer getJobTypeDurDays(@Param("jobTypeSeqNo") Long jobTypeSeqNo);
	
	@Query(value = "SELECT coalesce(DUR_HOURS,0) from  JOB_TYPE_TARGET_DETAILS where JOB_TYPE_SEQ_NO = :jobTypeSeqNo ",nativeQuery = true) 
	Integer getJobTypeDurHours(@Param("jobTypeSeqNo") Long jobTypeSeqNo);
	
	@Query(value = "SELECT coalesce(DUR_SECONDS,0) from  JOB_TYPE_TARGET_DETAILS where JOB_TYPE_SEQ_NO = :jobTypeSeqNo ",nativeQuery = true) 
	Integer getJobTypeDurSeconds(@Param("jobTypeSeqNo") Long jobTypeSeqNo);
	
	@Query(value = "SELECT coalesce(DUR_MINUTES,0) from  JOB_TYPE_TARGET_DETAILS where JOB_TYPE_SEQ_NO = :jobTypeSeqNo ",nativeQuery = true) 
	Integer getJobTypeDurMinutes(@Param("jobTypeSeqNo") Long jobTypeSeqNo);
	
	@Query(value = "SELECT coalesce(DUR_WEEKS,0) from JOB_TYPE_TARGET_DETAILS where JOB_TYPE_SEQ_NO = :jobTypeSeqNo ",nativeQuery = true) 
	Integer getJobTypeDurWeeks(@Param("jobTypeSeqNo") Long jobTypeSeqNo);
			
	@Query(value = "SELECT coalesce(DUR_MONTHS,0) from  JOB_TYPE_TARGET_DETAILS where JOB_TYPE_SEQ_NO = :jobTypeSeqNo ",nativeQuery = true) 
	Integer getJobTypeDurMonths(@Param("jobTypeSeqNo") Long jobTypeSeqNo);	
}