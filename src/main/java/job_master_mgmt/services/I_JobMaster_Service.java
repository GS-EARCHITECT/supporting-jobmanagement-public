package job_master_mgmt.services;

import java.util.ArrayList;
import job_master_mgmt.model.dto.JobMaster_DTO;

public interface I_JobMaster_Service 
{
	public JobMaster_DTO newJobMaster(JobMaster_DTO jcmDTO);
	public void updJobMaster(JobMaster_DTO jcmDTO);
	public ArrayList<JobMaster_DTO> getSelectJobMasters(ArrayList<Long> ids);
	public ArrayList<JobMaster_DTO> getSelectJobMastersByParties(ArrayList<Long> pids);
	public ArrayList<JobMaster_DTO> getAllJobMasters();
	public void delAllJobMasters();	
	public void delSelectJobMasters(ArrayList<Long> ids);
	public void delSelectJobMastersByParties(ArrayList<Long> pids);

}