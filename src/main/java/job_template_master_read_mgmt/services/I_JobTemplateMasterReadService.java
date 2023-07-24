package job_template_master_read_mgmt.services;

import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.ExecutionException;

import job_template_master_read_mgmt.model.dto.JobTemplateMaster_DTO;

public interface I_JobTemplateMasterReadService 
{
	abstract public CopyOnWriteArrayList<JobTemplateMaster_DTO> getAllJobTemplateMasters() throws InterruptedException, ExecutionException;	
	abstract public CopyOnWriteArrayList<JobTemplateMaster_DTO> getSelectJobTemplateMasters(CopyOnWriteArrayList<Long> jobTemplateMasterNos) throws InterruptedException, ExecutionException;	
}