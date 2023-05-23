package job_template_details_mgmt.services;

import java.math.BigDecimal;
import java.util.ArrayList;
import job_template_details_mgmt.model.dto.JobTemplateDetailsDTO;

public interface I_JobTemplateDetailsService 
{
	abstract public JobTemplateDetailsDTO newJobTemplateDetails(JobTemplateDetailsDTO jobTemplateDetailsDTO);
	abstract void updJobTemplateDetails(JobTemplateDetailsDTO jobTemplateDetailsDTO);
	abstract public ArrayList<JobTemplateDetailsDTO> getAllJobTemplateDetails();
	abstract public JobTemplateDetailsDTO getJobTemplateDetailsById(long jobTemplateSeqNo, long jobLevelNo, long seqNo, Long jobTypeSeqNo, long targetSeqNo, BigDecimal targetTypeSeqNo);
	abstract ArrayList<JobTemplateDetailsDTO> getSelectJobTemplateDetails(ArrayList<Long> jobTemplateDetailsNos);
	abstract void delJobTemplateDetails(long jobTemplateSeqNo, long jobLevelNo, long seqNo, Long jobTypeSeqNo, long targetSeqNo, BigDecimal targetTypeSeqNo);
	abstract void delSelectJobTemplateDetails(ArrayList<Long> jobTemplateDetailsSeqNos);
	abstract public void delAllJobTemplateDetails();

}