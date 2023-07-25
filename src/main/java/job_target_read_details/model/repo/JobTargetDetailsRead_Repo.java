package job_target_read_details.model.repo;

import java.util.concurrent.CopyOnWriteArrayList;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import job_target_read_details.model.master.JobTargetDetail;
import job_target_read_details.model.master.JobTargetDetailPK;

@Repository("jobTargetDetailsReadRepo")
public interface JobTargetDetailsRead_Repo extends JpaRepository<JobTargetDetail, JobTargetDetailPK> 
{	
	@Query(value = "SELECT * from  JOB_TYPE_TARGET_DETAILS where JOB_TYPE_SEQ_NO in :jobTargetDetailsSeqNos ORDER BY JOB_TYPE_SEQ_NO",nativeQuery = true) 
	CopyOnWriteArrayList<JobTargetDetail> getSelectJobTargetDetails(@Param("jobTargetDetailsSeqNos") CopyOnWriteArrayList<Long> jobTargetDetailsSeqNos);
	
	@Query(value = "SELECT coalesce(DUR_DAYS,0) from  JOB_TYPE_TARGET_DETAILS where JOB_TYPE_SEQ_NO = :jobSeqNo ",nativeQuery = true) 
	Integer getJobDurDays(@Param("jobSeqNo") Long jobSeqNo);
	
	@Query(value = "SELECT coalesce(DUR_HOURS,0) from  JOB_TYPE_TARGET_DETAILS where JOB_TYPE_SEQ_NO = :jobSeqNo ",nativeQuery = true) 
	Integer getJobDurHours(@Param("jobSeqNo") Long jobSeqNo);
	
	@Query(value = "SELECT coalesce(DUR_SECONDS,0) from  JOB_TYPE_TARGET_DETAILS where JOB_TYPE_SEQ_NO = :jobSeqNo ",nativeQuery = true) 
	Integer getJobDurSeconds(@Param("jobSeqNo") Long jobSeqNo);
	
	@Query(value = "SELECT coalesce(DUR_MINUTES,0) from  JOB_TYPE_TARGET_DETAILS where JOB_TYPE_SEQ_NO = :jobSeqNo ",nativeQuery = true) 
	Integer getJobDurMinutes(@Param("jobSeqNo") Long jobSeqNo);
	
	@Query(value = "SELECT coalesce(DUR_WEEKS,0) from JOB_TYPE_TARGET_DETAILS where JOB_TYPE_SEQ_NO = :jobSeqNo ",nativeQuery = true) 
	Integer getJobDurWeeks(@Param("jobSeqNo") Long jobSeqNo);
			
	@Query(value = "SELECT coalesce(DUR_MONTHS,0) from  JOB_TYPE_TARGET_DETAILS where JOB_TYPE_SEQ_NO = :jobSeqNo ",nativeQuery = true) 
	Integer getJobDurMonths(@Param("jobSeqNo") Long jobSeqNo);	
}