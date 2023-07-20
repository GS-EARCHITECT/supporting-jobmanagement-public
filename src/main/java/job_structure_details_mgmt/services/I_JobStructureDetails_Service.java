package job_structure_details_mgmt.services;

import java.util.ArrayList;

import job_structure_details_mgmt.model.dto.JobStructureDetail_DTO;

public interface I_JobStructureDetails_Service 
{
	public JobStructureDetail_DTO newJobStructureDetail(JobStructureDetail_DTO jcsDTO);
	public void updJobStructureDetail(JobStructureDetail_DTO jcsDTO);
	public ArrayList<JobStructureDetail_DTO> getSelectJobStructureDetails(ArrayList<Long> ids);
	public ArrayList<JobStructureDetail_DTO> getSelectJobStructureDetailsByParents(ArrayList<Long> pids);
	public ArrayList<JobStructureDetail_DTO> getAllJobStructureDetails();
	public void delSelectJobStructureDetails(ArrayList<Long> ids);	
	public void delSelectJobStructureDetailsByParents(ArrayList<Long> pids);
	public void delAllJobStructureDetails();
}