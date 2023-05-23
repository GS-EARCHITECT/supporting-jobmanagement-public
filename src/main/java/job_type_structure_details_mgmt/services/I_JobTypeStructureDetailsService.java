package job_type_structure_details_mgmt.services;

import java.util.ArrayList;

import job_type_structure_details_mgmt.model.details.JobTypeStructureDetailsPK;
import job_type_structure_details_mgmt.model.dto.JobTypeStructureDetailsDTO;

public interface I_JobTypeStructureDetailsService 
{
	abstract public JobTypeStructureDetailsDTO newJobTypeStructureDetails(JobTypeStructureDetailsDTO jobTypeStructureDetailsDTO);
	abstract void updJobTypeStructureDetails(JobTypeStructureDetailsDTO jobTypeStructureDetailsDTO);
	abstract public ArrayList<JobTypeStructureDetailsDTO> getAllJobTypeStructureDetailss();
	public ArrayList<JobTypeStructureDetailsDTO> getSelectJobTypeStructureDetails(ArrayList<JobTypeStructureDetailsPK>  jobTypeStructureDetailsPKs);
	abstract public JobTypeStructureDetailsDTO getJobTypeStructureDetailsById(Long jobTypeStructureDetailsSeqNo, Long parJobTypeStructureDetailsSeqNo);
	abstract ArrayList<JobTypeStructureDetailsDTO> getSelectJobTypeStructureDetailss(ArrayList<Long> jobTypeStructureDetailsNos);
	abstract void delJobTypeStructureDetails(Long jobTypeStructureDetailsSeqNo, Long parJobTypeStructureDetailsSeqNo);
	abstract void delSelectJobTypeStructureDetailss(ArrayList<Long> jobTypeStructureDetailsSeqNos);
	abstract public void delAllJobTypeStructureDetailss();
}