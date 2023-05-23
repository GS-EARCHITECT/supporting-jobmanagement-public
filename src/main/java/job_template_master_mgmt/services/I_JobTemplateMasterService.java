package job_template_master_mgmt.services;

import java.math.BigDecimal;
import java.util.ArrayList;

import job_template_master_mgmt.model.dto.JobTemplateMasterDTO;

public interface I_JobTemplateMasterService 
{
	abstract public JobTemplateMasterDTO newJobTemplateMaster(JobTemplateMasterDTO jobTemplateMasterDTO);
	abstract void updJobTemplateMaster(JobTemplateMasterDTO jobTemplateMasterDTO);
	abstract public ArrayList<JobTemplateMasterDTO> getAllJobTemplateMasters();
	abstract public JobTemplateMasterDTO getJobTemplateMasterById(Long jobTemplateMasterSeqNo,Long serviceSeqNo, BigDecimal serviceCategorySeqNo);
	abstract ArrayList<JobTemplateMasterDTO> getSelectJobTemplateMasters(ArrayList<Long> jobTemplateMasterNos);
	abstract void delJobTemplateMaster(Long jobTemplateMasterSeqNo,Long serviceSeqNo, BigDecimal serviceCategorySeqNo);;
	abstract void delSelectJobTemplateMasters(ArrayList<Long> jobTemplateMasterSeqNos);
	abstract public void delAllJobTemplateMasters();
}