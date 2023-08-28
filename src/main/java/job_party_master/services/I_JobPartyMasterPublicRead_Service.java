package job_party_master.services;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CopyOnWriteArrayList;
import job_party_master.model.dto.JobPartyMaster_DTO;

public interface I_JobPartyMasterPublicRead_Service 
{
	public CompletableFuture<CopyOnWriteArrayList<JobPartyMaster_DTO>> getSelectJobPartyMasters(CopyOnWriteArrayList<Long> ids);
	public CompletableFuture<CopyOnWriteArrayList<JobPartyMaster_DTO>> getSelectJobPartyMastersByParties(CopyOnWriteArrayList<Long> pids);
	public CompletableFuture<CopyOnWriteArrayList<JobPartyMaster_DTO>> getSelectJobPartyMastersByMasterJobs(CopyOnWriteArrayList<Long> ids);
	public CompletableFuture<CopyOnWriteArrayList<JobPartyMaster_DTO>> getAllJobPartyMasters();	
}