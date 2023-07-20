package job_structure_details_mgmt.services;

import java.util.ArrayList;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import job_structure_details_mgmt.model.dto.JobStructureDetail_DTO;
import job_structure_details_mgmt.model.master.JobStructureDetail;
import job_structure_details_mgmt.model.master.JobStructureDetailPK;
import job_structure_details_mgmt.model.repo.JobStructureDetail_Repo;

@Service("jobStructureDetailsServ")
@Scope(value = "prototype", proxyMode = ScopedProxyMode.TARGET_CLASS)
@Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.READ_COMMITTED)
public class JobStructureDetail_Service implements I_JobStructureDetails_Service 
{

//	private static final Logger logger = LoggerFactory.getLogger(JobStructureDetailService.class);

	@Autowired
	private JobStructureDetail_Repo jobStructureDetailsRepo;

	@Override
	public JobStructureDetail_DTO newJobStructureDetail(JobStructureDetail_DTO jcsDTO) 
	{
		JobStructureDetailPK jobJobStructureDetailPK = new JobStructureDetailPK();
		jobJobStructureDetailPK.setJobClassSeqNo(jcsDTO.getJobClassSeqNo());
		jobJobStructureDetailPK.setJobClassSeqNo(jcsDTO.getJobClassSeqNo());
		jobJobStructureDetailPK.setParJobSeqNo(jcsDTO.getParJobSeqNo());
		
		if(!jobStructureDetailsRepo.existsById(jobJobStructureDetailPK))
		{
		JobStructureDetail JobStructureDetail = jobStructureDetailsRepo.save(this.setJobStructureDetail(jcsDTO));
		jcsDTO = getJobStructureDetail_DTO(JobStructureDetail);
		}
		return jcsDTO;
	}

	@Override
	public ArrayList<JobStructureDetail_DTO> getAllJobStructureDetails() 
	{
		ArrayList<JobStructureDetail> jobList = (ArrayList<JobStructureDetail>) jobStructureDetailsRepo.findAll();
		ArrayList<JobStructureDetail_DTO> jobDTOs = new ArrayList<JobStructureDetail_DTO>();
		jobDTOs = jobList != null ? this.getJobStructureDetail_DTOs(jobList) : null;
		return jobDTOs;
	}

	@Override
	public ArrayList<JobStructureDetail_DTO> getSelectJobStructureDetails(ArrayList<Long> ids) 
	{
		ArrayList<JobStructureDetail> jobList = (ArrayList<JobStructureDetail>) jobStructureDetailsRepo.getSelectJobStructureDetails(ids);
		ArrayList<JobStructureDetail_DTO> jcmDTOs = new ArrayList<JobStructureDetail_DTO>();
		jcmDTOs = jobList != null ? this.getJobStructureDetail_DTOs(jobList) : null;
		return jcmDTOs;
	}

	@Override
	public ArrayList<JobStructureDetail_DTO> getSelectJobStructureDetailsByParents(ArrayList<Long> pids) 
	{
		ArrayList<JobStructureDetail> jobList = (ArrayList<JobStructureDetail>) jobStructureDetailsRepo.getSelectJobStructureDetailsByParents(pids);
		ArrayList<JobStructureDetail_DTO> jcmDTOs = new ArrayList<JobStructureDetail_DTO>();
		jcmDTOs = jobList != null ? this.getJobStructureDetail_DTOs(jobList) : null;
		return jcmDTOs;
	}

	@Override
	public void updJobStructureDetail(JobStructureDetail_DTO jcsDTO) 
	{
		JobStructureDetailPK jobJobStructureDetailPK = new JobStructureDetailPK();
		jobJobStructureDetailPK.setJobClassSeqNo(jcsDTO.getJobClassSeqNo());
		jobJobStructureDetailPK.setParJobSeqNo(jcsDTO.getParJobSeqNo());
		jobJobStructureDetailPK.setJobSeqNo(jcsDTO.getJobSeqNo());
		JobStructureDetail jobJobStructureDetail2 = null;

		if (jobStructureDetailsRepo.existsById(jobJobStructureDetailPK)) 
		{
			jobJobStructureDetail2 = this.setJobStructureDetail(jcsDTO);
			jobStructureDetailsRepo.save(jobJobStructureDetail2);
		}
	}

	@Override
	public void delAllJobStructureDetails() 
	{
		jobStructureDetailsRepo.deleteAll();
	}

	@Override
	public void delSelectJobStructureDetails(ArrayList<Long> ids) 
	{
		jobStructureDetailsRepo.delSelectJobStructureDetails(ids);
	}

	@Override
	public void delSelectJobStructureDetailsByParents(ArrayList<Long> pids) 
	{
		jobStructureDetailsRepo.delSelectJobStructureDetailsByParents(pids);
	}
	
	private ArrayList<JobStructureDetail_DTO> getJobStructureDetail_DTOs(ArrayList<JobStructureDetail> jobStructures) {
		JobStructureDetail_DTO jobDTO = null;
		ArrayList<JobStructureDetail_DTO> jobDTOs = new ArrayList<JobStructureDetail_DTO>();

		for (int i = 0; i < jobStructures.size(); i++) {
			jobDTO = getJobStructureDetail_DTO(jobStructures.get(i));
			jobDTOs.add(jobDTO);
		}
		return jobDTOs;
	}

	private JobStructureDetail_DTO getJobStructureDetail_DTO(JobStructureDetail jobJobStructureDetail2) {
		JobStructureDetail_DTO jobJobStructureDetailDTO = new JobStructureDetail_DTO();
		jobJobStructureDetailDTO = new JobStructureDetail_DTO();
		jobJobStructureDetailDTO.setJobClassSeqNo(jobJobStructureDetail2.getId().getJobClassSeqNo());
		jobJobStructureDetailDTO.setParJobSeqNo(jobJobStructureDetail2.getId().getParJobSeqNo());
		jobJobStructureDetailDTO.setJobSeqNo(jobJobStructureDetail2.getId().getJobSeqNo());
		return jobJobStructureDetailDTO;
	}

	private JobStructureDetail setJobStructureDetail(JobStructureDetail_DTO jDTO) 
	{
		JobStructureDetailPK jobJobStructureDetailPK = new JobStructureDetailPK();
		jobJobStructureDetailPK.setJobClassSeqNo(jDTO.getJobClassSeqNo());
		jobJobStructureDetailPK.setParJobSeqNo(jDTO.getParJobSeqNo());
		jobJobStructureDetailPK.setJobSeqNo(jDTO.getJobSeqNo());
		JobStructureDetail jobJobStructureDetail2 = new JobStructureDetail();
		jobJobStructureDetail2.setId(jobJobStructureDetailPK);		
		return jobJobStructureDetail2;
	}
}