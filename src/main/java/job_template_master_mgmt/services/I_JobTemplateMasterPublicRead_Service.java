package job_template_master_mgmt.services;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CopyOnWriteArrayList;
import job_template_master_mgmt.model.dto.JobTemplateMaster_DTO;

public interface I_JobTemplateMasterPublicRead_Service 
{
	abstract public CompletableFuture<CopyOnWriteArrayList<JobTemplateMaster_DTO>> getAllJobTemplateMasters();	
	abstract public CompletableFuture<CopyOnWriteArrayList<JobTemplateMaster_DTO>> getSelectJobTemplateMasters(CopyOnWriteArrayList<Long> jobTemplateMasterNos);	
}