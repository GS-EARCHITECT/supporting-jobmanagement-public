package job_resource_master_mgmt.service;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CopyOnWriteArrayList;
import job_resource_master_mgmt.model.dto.JobResourceMaster_DTO;

public interface I_JobResourceMasterPublicRead_Service 
{
	public CompletableFuture<CopyOnWriteArrayList<JobResourceMaster_DTO>> getAllJobResources(); 	
	public CompletableFuture<CopyOnWriteArrayList<JobResourceMaster_DTO>> getSelectJobResourcesByJobs( CopyOnWriteArrayList<Long> jobSeqNos);
	public CompletableFuture<CopyOnWriteArrayList<JobResourceMaster_DTO>> getSelectJobResourcesByTargets( CopyOnWriteArrayList<Long> trgSeqNos);
	public CompletableFuture<CopyOnWriteArrayList<JobResourceMaster_DTO>> getSelectJobResourcesByResources( CopyOnWriteArrayList<Long> resourceSeqNos);		
	public CompletableFuture<CopyOnWriteArrayList<JobResourceMaster_DTO>> getSelectJobResourcesByDirection( Character dFlag);
}