package job_metrics_mgmt.model.repo;

import java.util.Optional;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import job_metrics_mgmt.model.master.LogiBillingMaster;
import job_metrics_mgmt.model.master.LogiJobCostMaster;
import job_metrics_mgmt.model.master.LogiJobTripCostMaster;

@Repository("costingBillingRepo")
public interface CostingBillingRepo extends CrudRepository<LogiBillingMaster, Long> 
{
	@Query(value = "SELECT * FROM LOGI_JOB_TRIP_COST_MASTER where rownum=1 and job_TYPE_SEQ_NO = :jobTypeSeqNo and target_TYPE_SEQ_NO = :tTypeSeqNo and mode_SEQ_NO = :modeSeqNo and fr_loc_SEQ_NO = :frLocSeqNo and to_loc_SEQ_NO = :toLocSeqNo",nativeQuery = true) 
	Optional<LogiJobTripCostMaster> getJobTripCostDetailsForJobType(@Param("jobTypeSeqNo") Integer jobTypeSeqNo, @Param("tTypeSeqNo") Integer tTypeSeqNo, @Param("modeSeqNo") Integer modeSeqNo, @Param("frLocSeqNo") Long frLocSeqNo, @Param("toLocSeqNo") Long toLocSeqNo);
	
	@Query(value = "SELECT * FROM LOGI_JOB_COST_MASTER where rownum=1 and job_TYPE_SEQ_NO = :jobTypeSeqNo and target_TYPE_SEQ_NO = :tTypeSeqNo",nativeQuery = true) 
	Optional<LogiJobCostMaster> getJobCostDetailsForJobType(@Param("jobTypeSeqNo") Integer jobTypeSeqNo, @Param("tTypeSeqNo") Integer tTypeSeqNo);
					
	/*@Query(value = "SELECT * FROM LOGI_JOBTYPE_RESCATE_MASTER where rownum=1 and job_TYPE_SEQ_NO = :jobTypeSeqNo and target_TYPE_SEQ_NO = :tTypeSeqNo and FR_LOC_SEQ_NO = :frLocSeqNo and TO_LOC_SEQ_NO = :toLocSeqNo and mode_seq_no = :modeSeqNo and RESOURCE_SEQ_NO = :resSeqNo",nativeQuery = true) 
	Optional<LogiJobTypeResourceCategoryMaster> getResourceCostDetailsForJobType(@Param("jobTypeSeqNo") Integer jobTypeSeqNo, @Param("tTypeSeqNo") Integer tTypeSeqNo, @Param("frLocSeqNo") Long frLocSeqNo, @Param("toLocSeqNo") Long toLocSeqNo, @Param("resSeqNo") Long resSeqNo, @Param("modeSeqNo") Integer modeSeqNo);
		*/
		
	/*
	@Query(value = "SELECT * FROM LOGI_JOBTYPE_RESASSET_MASTER where rownum=1 and job_TYPE_SEQ_NO = :jobTypeSeqNo and target_TYPE_SEQ_NO = :tTypeSeqNo and FR_LOC_SEQ_NO = :frLocSeqNo and TO_LOC_SEQ_NO = :toLocSeqNo and mode_seq_no = :modeSeqNo and ASSET_SEQ_NO = :assSeqNo",nativeQuery = true) 
	Optional<LogiJobTypeResAssetMaster> getAssetCostDetailsForJobType(@Param("jobTypeSeqNo") Integer jobTypeSeqNo, @Param("tTypeSeqNo") Integer tTypeSeqNo, @Param("frLocSeqNo") Long frLocSeqNo, @Param("toLocSeqNo") Long toLocSeqNo, @Param("assSeqNo") Long assSeqNo, @Param("modeSeqNo") Integer modeSeqNo);
	*/
	
	@Query(value = "select target_units / source_units from uom_master b where b.source_seq_no = :sourceSeqNo and b.target_seq_no = :targetSeqNo;",nativeQuery = true) 
	Float getUnitValueInTargetMeasure(@Param("sourceSeqNo") Integer sourceSeqNo, @Param("targetSeqNo") Integer targetSeqNo);
							
/*	
 * 
 * 
	@Query(value = "INSERT INTO LOGI_PRODUCT_MASTER (PRODUCT_SEQ_NO,PRODUCT,REMARKS,ASSET_ID,PARENT_PRODUCT_SEQ_NO,STATUS) \r\n" + 
			"	select LOGI_LOCATION_SEQ_NO.NEXTVAL,'new','myremarks','assetssid',2,'no' from DUAL d\r\n" + 
			"	where not exists (SELECT 1 FROM  LOGI_PRODUCT_MASTER x WHERE  x.PRODUCT_SEQ_NO = 1 )",nativeQuery = true) 
	void delProjectStatus(@Param("projectSeqNo") Integer projectSeqNo);
	*/
}