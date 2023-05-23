package job_metrics_mgmt.model.repo;


import java.util.Optional;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import job_metrics_mgmt.model.master.LogiJobTripCostMaster;
import job_metrics_mgmt.model.master.LogiJobTripCostMasterPK;

@Repository("jobTripCostingRepo")
public interface JobTripCostingRepo extends CrudRepository<LogiJobTripCostMaster, LogiJobTripCostMasterPK> 
{
	@Query(value = "SELECT * FROM LOGI_JOB_TRIP_COST_MASTER where rownum=1 and job_TYPE_SEQ_NO = :jobTypeSeqNo and target_TYPE_SEQ_NO = :tTypeSeqNo and mode_SEQ_NO = :modeSeqNo and fr_loc_SEQ_NO = :frLocSeqNo and to_loc_SEQ_NO = :toLocSeqNo",nativeQuery = true) 
	Optional<LogiJobTripCostMaster> getJobTripCostDetailsForJobType(@Param("jobTypeSeqNo") Integer jobTypeSeqNo, @Param("tTypeSeqNo") Integer tTypeSeqNo, @Param("modeSeqNo") Integer modeSeqNo, @Param("frLocSeqNo") Long frLocSeqNo, @Param("toLocSeqNo") Long toLocSeqNo);
					
/*	
 * 
 * 
	@Query(value = "INSERT INTO LOGI_PRODUCT_MASTER (PRODUCT_SEQ_NO,PRODUCT,REMARKS,ASSET_ID,PARENT_PRODUCT_SEQ_NO,STATUS) \r\n" + 
			"	select LOGI_LOCATION_SEQ_NO.NEXTVAL,'new','myremarks','assetssid',2,'no' from DUAL d\r\n" + 
			"	where not exists (SELECT 1 FROM  LOGI_PRODUCT_MASTER x WHERE  x.PRODUCT_SEQ_NO = 1 )",nativeQuery = true) 
	void delProjectStatus(@Param("projectSeqNo") Integer projectSeqNo);
	*/
}