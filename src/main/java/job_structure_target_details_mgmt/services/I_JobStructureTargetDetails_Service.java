package job_structure_target_details_mgmt.services;

import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.ExecutionException;

import job_structure_target_details_mgmt.model.details.JobStructureTargetDetailPK;
import job_structure_target_details_mgmt.model.dto.JobStructureTargetDetail_DTO;

public interface I_JobStructureTargetDetails_Service 
{
	public CopyOnWriteArrayList<JobStructureTargetDetail_DTO> getAllJobStructureTargetDetails() throws InterruptedException, ExecutionException;
	public CopyOnWriteArrayList<JobStructureTargetDetail_DTO> getSelectJobStructureTargetDetails(CopyOnWriteArrayList<JobStructureTargetDetailPK> jobStructureTargetDetailPKs) throws InterruptedException, ExecutionException;
	public CopyOnWriteArrayList<JobStructureTargetDetail_DTO> getSelectJobStructureTargetDetailsForJobs(CopyOnWriteArrayList<Long> jobSeqNos) throws InterruptedException, ExecutionException;
	public CopyOnWriteArrayList<JobStructureTargetDetail_DTO> getSelectJobStructureTargetDetailsForParents(CopyOnWriteArrayList<Long> jobSeqNos, CopyOnWriteArrayList<Long> parTargetSeqNo) throws InterruptedException, ExecutionException;
}