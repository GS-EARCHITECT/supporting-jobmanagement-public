package job_class_structure_mgmt.services;

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
import job_class_structure_mgmt.model.dto.JobClassStructure_DTO;
import job_class_structure_mgmt.model.master.JobClassStructure;
import job_class_structure_mgmt.model.master.JobClassStructurePK;
import job_class_structure_mgmt.model.repo.JobClassStructure_Repo;

@Service("jobClassStructureServ")
@Scope(value = "prototype", proxyMode = ScopedProxyMode.TARGET_CLASS)
@Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.READ_COMMITTED)
public class JobClassStructure_Service implements I_JobClassStructure_Service 
{

//	private static final Logger logger = LoggerFactory.getLogger(JobClassStructureService.class);

	@Autowired
	private JobClassStructure_Repo jobClassStructureRepo;

	@Override
	public JobClassStructure_DTO newJobClassStructure(JobClassStructure_DTO jcsDTO) 
	{
		JobClassStructurePK jobClassStructurePK = new JobClassStructurePK();
		jobClassStructurePK.setJobClassSeqNo(jcsDTO.getJobClassSeqNo());
		jobClassStructurePK.setParJobClassSeqNo(jcsDTO.getParJobClassSeqNo());
		jobClassStructurePK.setPartySeqNo(jcsDTO.getPartySeqNo());
		
		if(!jobClassStructureRepo.existsById(jobClassStructurePK))
				{
		JobClassStructure JobClassStructure = jobClassStructureRepo.save(this.setJobClassStructure(jcsDTO));
		jcsDTO = getJobClassStructure_DTO(JobClassStructure);
		}
		return jcsDTO;
	}

	@Override
	public ArrayList<JobClassStructure_DTO> getAllJobClassStructures() 
	{
		ArrayList<JobClassStructure> jobList = (ArrayList<JobClassStructure>) jobClassStructureRepo.findAll();
		ArrayList<JobClassStructure_DTO> jobDTOs = new ArrayList<JobClassStructure_DTO>();
		jobDTOs = jobList != null ? this.getJobClassStructure_DTOs(jobList) : null;
		return jobDTOs;
	}

	@Override
	public ArrayList<JobClassStructure_DTO> getSelectJobClassStructures(ArrayList<Long> ids, ArrayList<Long> pids) 
{
		ArrayList<JobClassStructure> jobList = (ArrayList<JobClassStructure>) jobClassStructureRepo.getSelectJobClassStructures(ids, pids);
		ArrayList<JobClassStructure_DTO> jcmDTOs = new ArrayList<JobClassStructure_DTO>();
		jcmDTOs = jobList != null ? this.getJobClassStructure_DTOs(jobList) : null;
		return jcmDTOs;
	}

	@Override
	public ArrayList<JobClassStructure_DTO> getSelectJobClassesByParents(ArrayList<Long> ids) 
{
		ArrayList<JobClassStructure> jobList = (ArrayList<JobClassStructure>) jobClassStructureRepo.getSelectJobClassesByParents(ids);
		ArrayList<JobClassStructure_DTO> jcmDTOs = new ArrayList<JobClassStructure_DTO>();
		jcmDTOs = jobList != null ? this.getJobClassStructure_DTOs(jobList) : null;
		return jcmDTOs;
	}

	@Override
	public ArrayList<JobClassStructure_DTO> getSelectJobClassesByParties(ArrayList<Long> ids) 
{
		ArrayList<JobClassStructure> jobList = (ArrayList<JobClassStructure>) jobClassStructureRepo.getSelectJobClassesByParties(ids);
		ArrayList<JobClassStructure_DTO> jcmDTOs = new ArrayList<JobClassStructure_DTO>();
		jcmDTOs = jobList != null ? this.getJobClassStructure_DTOs(jobList) : null;
		return jcmDTOs;
	}
	
	@Override
	public void updJobClassStructure(JobClassStructure_DTO jcsDTO) 
	{
		JobClassStructurePK jobClassStructurePK = new JobClassStructurePK();
		jobClassStructurePK.setJobClassSeqNo(jcsDTO.getJobClassSeqNo());
		jobClassStructurePK.setParJobClassSeqNo(jcsDTO.getParJobClassSeqNo());
		jobClassStructurePK.setPartySeqNo(jcsDTO.getPartySeqNo());
		JobClassStructure jobClassStructure2 = null;

		if (jobClassStructureRepo.existsById(jobClassStructurePK)) 
		{
			jobClassStructure2 = this.setJobClassStructure(jcsDTO);
			jobClassStructureRepo.save(jobClassStructure2);
		}
	}

	@Override
	public void delAllJobClassStructures() 
	{
		jobClassStructureRepo.deleteAll();
	}

	@Override
	public void delSelectJobClassStructures(ArrayList<Long> ids, ArrayList<Long> pids) 
	{
		jobClassStructureRepo.delSelectJobClassStructures(ids, pids);
	}

	@Override
	public void delSelectJobClassesByParents(ArrayList<Long> ids) 
	{
		jobClassStructureRepo.delSelectJobClassesByParents(ids);
	}
	
	@Override
	public void delSelectJobClassesByParties(ArrayList<Long> ids) 
	{
		jobClassStructureRepo.delSelectJobClassesByParties(ids);
	}
	
	private ArrayList<JobClassStructure_DTO> getJobClassStructure_DTOs(ArrayList<JobClassStructure> jobStructures) {
		JobClassStructure_DTO jobDTO = null;
		ArrayList<JobClassStructure_DTO> jobDTOs = new ArrayList<JobClassStructure_DTO>();

		for (int i = 0; i < jobStructures.size(); i++) {
			jobDTO = getJobClassStructure_DTO(jobStructures.get(i));
			jobDTOs.add(jobDTO);
		}
		return jobDTOs;
	}

	private JobClassStructure_DTO getJobClassStructure_DTO(JobClassStructure jobClassStructure2) {
		JobClassStructure_DTO jobClassStructureDTO = new JobClassStructure_DTO();
		jobClassStructureDTO = new JobClassStructure_DTO();
		jobClassStructureDTO.setJobClassSeqNo(jobClassStructure2.getId().getJobClassSeqNo());
		jobClassStructureDTO.setParJobClassSeqNo(jobClassStructure2.getId().getParJobClassSeqNo());
		jobClassStructureDTO.setPartySeqNo(jobClassStructure2.getId().getPartySeqNo());
		return jobClassStructureDTO;
	}

	private JobClassStructure setJobClassStructure(JobClassStructure_DTO jDTO) 
	{
		JobClassStructurePK jobClassStructurePK = new JobClassStructurePK();
		jobClassStructurePK.setJobClassSeqNo(jDTO.getJobClassSeqNo());
		jobClassStructurePK.setParJobClassSeqNo(jDTO.getParJobClassSeqNo());
		jobClassStructurePK.setPartySeqNo(jDTO.getPartySeqNo());
		JobClassStructure jobClassStructure2 = new JobClassStructure();
		jobClassStructure2.setId(jobClassStructurePK);		
		return jobClassStructure2;
	}
}