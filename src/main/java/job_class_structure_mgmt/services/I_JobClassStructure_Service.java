package job_class_structure_mgmt.services;

import java.util.ArrayList;
import job_class_structure_mgmt.model.dto.JobClassStructure_DTO;

public interface I_JobClassStructure_Service 
{
	public JobClassStructure_DTO newJobClassStructure(JobClassStructure_DTO jcsDTO);

	public void updJobClassStructure(JobClassStructure_DTO jcsDTO);

	public ArrayList<JobClassStructure_DTO> getSelectJobClassStructures(ArrayList<Long> ids, ArrayList<Long> pids);

	public ArrayList<JobClassStructure_DTO> getSelectJobClassesByParents(ArrayList<Long> ids);

	public ArrayList<JobClassStructure_DTO> getSelectJobClassesByParties(ArrayList<Long> pids);

	public ArrayList<JobClassStructure_DTO> getAllJobClassStructures();

	public void delSelectJobClassStructures(ArrayList<Long> ids, ArrayList<Long> pids);

	public void delSelectJobClassesByParents(ArrayList<Long> ids);

	public void delSelectJobClassesByParties(ArrayList<Long> pids);

	public void delAllJobClassStructures();
}