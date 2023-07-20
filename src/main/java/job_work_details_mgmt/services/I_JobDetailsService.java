package job_work_details_mgmt.services;

import java.math.BigDecimal;
import java.util.ArrayList;

import job_work_details_mgmt.model.dto.JobDetailsDTO;

public interface I_JobDetailsService 
{
	public JobDetailsDTO newJobDetails(JobDetailsDTO jobDetailsDTO);
	public void updJobDetails(JobDetailsDTO jobDetailsDTO);
	public ArrayList<JobDetailsDTO> getAllJobDetails();
	public JobDetailsDTO getJobDetailsById(Long serviceWorkSeqNo);
	public ArrayList<JobDetailsDTO> getSelectJobDetails(ArrayList<Long> jobSeqNos);
	public ArrayList<JobDetailsDTO> processJobDetails(Long jobTemplateSeqNo, String startDateTime, BigDecimal opFlag);
	public ArrayList<JobDetailsDTO> getSelectJobDetailsForService(Long servWorkSeqNo);
	public ArrayList<JobDetailsDTO> getSelectJobDetailsForServices(ArrayList<Long> servWorkSeqNos);
	public ArrayList<JobDetailsDTO> getSelectJobDetailsBetweenPlanTimes(String frDtTm, String toDtTm);
	public ArrayList<JobDetailsDTO> getSelectJobDetailsBetweenActualTimes(String frDtTm, String toDtTm);
	public void delJobDetails(Long jobSeqNo);
	public void delAllJobDetails();
	public void delSelectJobDetails(ArrayList<Long> jobSeqNos);
	public void delSelectJobDetailsForServices(ArrayList<Long> servWorkSeqNos);
	public void delSelectJobDetailsBetweenPlanTimes(String frDtTm, String toDtTm);
	public void delSelectJobDetailsBetweenActualTimes(String frDtTm, String toDtTm);
}