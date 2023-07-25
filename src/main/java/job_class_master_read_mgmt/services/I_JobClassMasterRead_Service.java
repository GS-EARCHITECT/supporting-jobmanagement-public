package job_class_master_read_mgmt.services;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.ExecutionException;

import job_class_master_read_mgmt.model.dto.JobClassMaster_DTO;

public interface I_JobClassMasterRead_Service 
{
	public CompletableFuture<CopyOnWriteArrayList<JobClassMaster_DTO>> getSelectJobClasses(CopyOnWriteArrayList<Long> ids) throws InterruptedException, ExecutionException;
	public CompletableFuture<CopyOnWriteArrayList<JobClassMaster_DTO>> getAllJobClasses() throws InterruptedException, ExecutionException;
}