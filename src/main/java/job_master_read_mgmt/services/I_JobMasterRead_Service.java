package job_master_read_mgmt.services;


import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.ExecutionException;

import job_master_read_mgmt.model.dto.JobMaster_DTO;

public interface I_JobMasterRead_Service 
{
	public CopyOnWriteArrayList<JobMaster_DTO> getSelectJobMasters(CopyOnWriteArrayList<Long> ids) throws InterruptedException, ExecutionException;
	public CopyOnWriteArrayList<JobMaster_DTO> getSelectJobMastersByParties(CopyOnWriteArrayList<Long> pids) throws InterruptedException, ExecutionException;
	public CopyOnWriteArrayList<JobMaster_DTO> getAllJobMasters() throws InterruptedException, ExecutionException;
}