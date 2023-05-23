package job_type_target_details.services;

import java.util.ArrayList;

import job_type_target_details.model.dto.JobTypeTargetDetailsDTO;

public interface I_JobTypeTargetDetailsService 
{
	public JobTypeTargetDetailsDTO newJobTypeTargetDetails(JobTypeTargetDetailsDTO jobTypeTargetDetails);
	public void updJobTypeTargetDetails(JobTypeTargetDetailsDTO jobTypeTargetDetailsDTO);
	public ArrayList<JobTypeTargetDetailsDTO> getAllJobTypeTargetDetails();
	public JobTypeTargetDetailsDTO getJobTypeTargetDetailsById(JobTypeTargetDetailsDTO jobTypeTargetDetails);
	public ArrayList<JobTypeTargetDetailsDTO> getSelectJobTypeTargetDetails(ArrayList<JobTypeTargetDetailsDTO> jobTypeTargetDetailsDTOs);
	public void delJobTypeTargetDetails(JobTypeTargetDetailsDTO jobTypeTargetDetailso);
	public void delSelectJobTypeTargetDetails(ArrayList<JobTypeTargetDetailsDTO> jobTypeTargetDetailsDTOs);
	public void delAllJobTypeTargetDetails();
}