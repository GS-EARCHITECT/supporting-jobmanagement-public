package job_type_level_master_mgmt.services;

import java.util.ArrayList;

import job_type_level_master_mgmt.model.dto.JobTypeLevelMasterDTO;

public interface I_JobTypeLevelService 
{
	abstract public JobTypeLevelMasterDTO newJobTypeLevel(JobTypeLevelMasterDTO jobDTO);
	abstract void updJobTypeLevel(JobTypeLevelMasterDTO jobTypeLevelDTO);
	abstract public ArrayList<JobTypeLevelMasterDTO> getAllJobTypeLevels();
	abstract public JobTypeLevelMasterDTO getJobTypeLevelById(Long jobTypeLevelSeqNo);
	abstract ArrayList<JobTypeLevelMasterDTO> getSelectJobTypeLevels(ArrayList<Long> jobTypeLevelNos);
	abstract void delJobTypeLevel(Long jobTypeLevelNo);
	abstract void delSelectJobTypeLevels(ArrayList<Long> jobTypeLevelSeqNos);
	abstract public void delAllJobTypeLevels();
}