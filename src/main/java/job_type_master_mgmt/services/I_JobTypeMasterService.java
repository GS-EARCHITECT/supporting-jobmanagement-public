package job_type_master_mgmt.services;

import java.util.ArrayList;
import job_type_master_mgmt.model.dto.JobTypeMasterDTO;

public interface I_JobTypeMasterService 
{
	abstract public JobTypeMasterDTO newJobTypeMaster(JobTypeMasterDTO jobDTO);
	abstract void updJobTypeMaster(JobTypeMasterDTO jobTypeMasterDTO);
	abstract public ArrayList<JobTypeMasterDTO> getAllJobTypeMasters();
	abstract public JobTypeMasterDTO getJobTypeMasterById(Long jobTypeMasterSeqNo);
	abstract ArrayList<JobTypeMasterDTO> getSelectJobTypeMasters(ArrayList<Long> jobTypeMasterNos);
	abstract void delJobTypeMaster(Long jobTypeMasterNo);
	abstract void delSelectJobTypeMasters(ArrayList<Long> jobTypeMasterSeqNos);
	abstract public void delAllJobTypeMasters();
}