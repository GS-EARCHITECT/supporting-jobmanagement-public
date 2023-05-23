package job_metrics_mgmt.model.repo;


import java.util.Optional;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import job_metrics_mgmt.model.master.LogiJobCostMaster;
import job_metrics_mgmt.model.master.LogiJobCostMasterPK;

@Repository("jobCostingRepo")
public interface JobCostingRepo extends CrudRepository<LogiJobCostMaster, LogiJobCostMasterPK> 
{
	@Query(value = "SELECT * FROM LOGI_JOB_COST_MASTER where rownum=1 and job_TYPE_SEQ_NO = :jobTypeSeqNo and target_TYPE_SEQ_NO = :tTypeSeqNo",nativeQuery = true) 
	Optional<LogiJobCostMaster> getJobCostDetailsForJobType(@Param("jobTypeSeqNo") Integer jobTypeSeqNo, @Param("tTypeSeqNo") Integer tTypeSeqNo);
	
	/*	
 * 
 * 
	@Query(value = "INSERT INTO LOGI_PRODUCT_MASTER (PRODUCT_SEQ_NO,PRODUCT,REMARKS,ASSET_ID,PARENT_PRODUCT_SEQ_NO,STATUS) \r\n" + 
			"	select LOGI_LOCATION_SEQ_NO.NEXTVAL,'new','myremarks','assetssid',2,'no' from DUAL d\r\n" + 
			"	where not exists (SELECT 1 FROM  LOGI_PRODUCT_MASTER x WHERE  x.PRODUCT_SEQ_NO = 1 )",nativeQuery = true) 
	void delProjectStatus(@Param("projectSeqNo") Integer projectSeqNo);
	*/
}