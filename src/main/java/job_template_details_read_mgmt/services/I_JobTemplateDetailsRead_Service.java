package job_template_details_read_mgmt.services;

import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.ExecutionException;

import job_template_details_read_mgmt.model.dto.JobTemplateDetails_DTO;

public interface I_JobTemplateDetailsRead_Service 
{
	abstract public CopyOnWriteArrayList<JobTemplateDetails_DTO> getAllJobTemplateDetails() throws InterruptedException, ExecutionException;
	abstract public CopyOnWriteArrayList<JobTemplateDetails_DTO> getSelectJobTemplateDetails(CopyOnWriteArrayList<Long> jobTemplateDetailsNos) throws InterruptedException, ExecutionException;
}