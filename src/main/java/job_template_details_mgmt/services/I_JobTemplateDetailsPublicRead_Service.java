package job_template_details_mgmt.services;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CopyOnWriteArrayList;
import job_template_details_mgmt.model.dto.JobTemplateDetails_DTO;

public interface I_JobTemplateDetailsPublicRead_Service 
{
	abstract public CompletableFuture<CopyOnWriteArrayList<JobTemplateDetails_DTO>> getAllJobTemplateDetails(); 
	abstract public CompletableFuture<CopyOnWriteArrayList<JobTemplateDetails_DTO>> getSelectJobTemplateDetails(CopyOnWriteArrayList<Long> jobTemplateDetailsNos); 
}