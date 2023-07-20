package job_master_mgmt.services;

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
import job_master_mgmt.model.dto.JobMaster_DTO;
import job_master_mgmt.model.master.JobMaster;
import job_master_mgmt.model.repo.JobMaster_Repo;

@Service("jobMasterServ")
@Scope(value = "prototype", proxyMode = ScopedProxyMode.TARGET_CLASS)
@Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.READ_COMMITTED)
public class JobMaster_Service implements I_JobMaster_Service 
{

//	private static final Logger logger = LoggerFactory.getLogger(JobMasterService.class);

	@Autowired
	private JobMaster_Repo jobMasterRepo;

	@Override
	public JobMaster_DTO newJobMaster(JobMaster_DTO jcmDTO) 
	{
		JobMaster JobMaster = jobMasterRepo.save(this.setJobMaster(jcmDTO));
		
		if(!jobMasterRepo.existsById(jcmDTO.getJobSeqNo()))
		{
		jcmDTO = this.getJobMaster_DTO(jobMasterRepo.save(this.setJobMaster(jcmDTO)));
		}
		return jcmDTO;
	}

	@Override
	public void updJobMaster(JobMaster_DTO jcmDTO) 
	{
		JobMaster_DTO jobMasterDTO2 = null;
		JobMaster jobMaster2 = null;

		if (jobMasterRepo.existsById(jcmDTO.getJobSeqNo())) 
		{
			jobMaster2 = this.setJobMaster(jcmDTO);
			jobMaster2.setJobSeqNo(jcmDTO.getJobSeqNo());
			jobMasterRepo.save(jobMaster2);
		}
	}

	
	@Override
	public ArrayList<JobMaster_DTO> getAllJobMasters() 
	{
		ArrayList<JobMaster> jobList = (ArrayList<JobMaster>) jobMasterRepo.findAll();
		ArrayList<JobMaster_DTO> jobDTOs = new ArrayList<JobMaster_DTO>();
		jobDTOs = jobList != null ? this.getJobMaster_DTOs(jobList) : null;
		return jobDTOs;
	}

	@Override
	public ArrayList<JobMaster_DTO> getSelectJobMasters(ArrayList<Long> jcmSeqNos) 
{
		ArrayList<JobMaster> jobList = (ArrayList<JobMaster>) jobMasterRepo.getSelectJobMasters(jcmSeqNos);
		ArrayList<JobMaster_DTO> jcmDTOs = new ArrayList<JobMaster_DTO>();
		jcmDTOs = jobList != null ? this.getJobMaster_DTOs(jobList) : null;
		return jcmDTOs;
	}

	@Override
	public ArrayList<JobMaster_DTO> getSelectJobMastersByParties(ArrayList<Long> pids) 
{
		ArrayList<JobMaster> jobList = (ArrayList<JobMaster>) jobMasterRepo.getSelectJobMastersByParties(pids);
		ArrayList<JobMaster_DTO> jcmDTOs = new ArrayList<JobMaster_DTO>();
		jcmDTOs = jobList != null ? this.getJobMaster_DTOs(jobList) : null;
		return jcmDTOs;
	}

	@Override
	public void delAllJobMasters() 
	{
		jobMasterRepo.deleteAll();
	}

	@Override
	public void delSelectJobMasters(ArrayList<Long> jcmSeqNos) 
	{
		jobMasterRepo.delSelectJobMasters(jcmSeqNos); 
	}

	@Override
	public void delSelectJobMastersByParties(ArrayList<Long> jcmSeqNos) 
	{
		jobMasterRepo.delSelectJobMastersByParties(jcmSeqNos); 
	}

	
	private ArrayList<JobMaster_DTO> getJobMaster_DTOs(ArrayList<JobMaster> jobMasters) {
		JobMaster_DTO jobDTO = null;
		ArrayList<JobMaster_DTO> jobDTOs = new ArrayList<JobMaster_DTO>();

		for (int i = 0; i < jobMasters.size(); i++) {
			jobDTO = getJobMaster_DTO(jobMasters.get(i));
			jobDTOs.add(jobDTO);
		}
		return jobDTOs;
	}

	private JobMaster_DTO getJobMaster_DTO(JobMaster jobMaster2) {
		JobMaster_DTO jobMasterDTO = new JobMaster_DTO();
		jobMasterDTO = new JobMaster_DTO();		
		jobMasterDTO.setJobSeqNo(jobMaster2.getJobSeqNo());
		jobMasterDTO.setDescription(jobMaster2.getDescription());
		jobMasterDTO.setDiscPer(jobMaster2.getDiscPer());
		jobMasterDTO.setDiscSeqNo(jobMaster2.getDiscSeqNo());
		jobMasterDTO.setDiscVal(jobMaster2.getDiscVal());
		jobMasterDTO.setDuration(jobMaster2.getDuration());
		jobMasterDTO.setDurationCodeSeqNo(jobMaster2.getDurationCodeSeqNo());
		jobMasterDTO.setJob(jobMaster2.getJob());
		jobMasterDTO.setJobId(jobMaster2.getJobId());
		jobMasterDTO.setPartySeqNo(jobMaster2.getPartySeqNo());
		jobMasterDTO.setSpecificationSeqNo(jobMaster2.getSpecificationSeqNo());
		jobMasterDTO.setTaxPer(jobMaster2.getTaxPer());
		jobMasterDTO.setTaxSeqNo(jobMaster2.getTaxSeqNo());
		jobMasterDTO.setTaxVal(jobMaster2.getTaxVal());
		jobMasterDTO.setUnitRate(jobMaster2.getUnitRate());
		jobMasterDTO.setUnitRateSeqNo(jobMaster2.getUnitRateSeqNo());
		jobMasterDTO.setRemark(jobMaster2.getRemark());
		jobMasterDTO.setStatus(jobMaster2.getStatus());
		return jobMasterDTO;
	}

	private JobMaster setJobMaster(JobMaster_DTO cDTO) 
	{
		JobMaster jobMaster2 = new JobMaster();
		jobMaster2.setDescription(cDTO.getDescription());
		jobMaster2.setDiscPer(cDTO.getDiscPer());
		jobMaster2.setDiscSeqNo(cDTO.getDiscSeqNo());
		jobMaster2.setDiscVal(cDTO.getDiscVal());
		jobMaster2.setDuration(cDTO.getDuration());
		jobMaster2.setDurationCodeSeqNo(cDTO.getDurationCodeSeqNo());
		jobMaster2.setJob(cDTO.getJob());
		jobMaster2.setJobId(cDTO.getJobId());
		jobMaster2.setPartySeqNo(cDTO.getPartySeqNo());
		jobMaster2.setSpecificationSeqNo(cDTO.getSpecificationSeqNo());
		jobMaster2.setTaxPer(cDTO.getTaxPer());
		jobMaster2.setTaxSeqNo(cDTO.getTaxSeqNo());
		jobMaster2.setTaxVal(cDTO.getTaxVal());
		jobMaster2.setUnitRate(cDTO.getUnitRate());
		jobMaster2.setUnitRateSeqNo(cDTO.getUnitRateSeqNo());
		jobMaster2.setRemark(cDTO.getRemark());
		jobMaster2.setStatus(cDTO.getStatus());
		return jobMaster2;
	}
}