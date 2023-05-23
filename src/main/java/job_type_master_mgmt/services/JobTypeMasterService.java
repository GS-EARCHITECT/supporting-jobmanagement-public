package job_type_master_mgmt.services;

import java.util.ArrayList;
import java.util.Optional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import job_type_master_mgmt.model.dto.JobTypeMasterDTO;
import job_type_master_mgmt.model.master.JobTypeMaster;
import job_type_master_mgmt.model.repo.JobTypeMasterRepo;

@Service("jobTypeMasterServ")
@Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.READ_COMMITTED)
public class JobTypeMasterService implements I_JobTypeMasterService {
	@SuppressWarnings("unused")
	private static final Logger logger = LoggerFactory.getLogger(JobTypeMasterService.class);

	@Autowired
	private JobTypeMasterRepo jobTypeMasterRepo;

	@Override
	public JobTypeMasterDTO newJobTypeMaster(JobTypeMasterDTO jobDTO) {
		JobTypeMaster JobTypeMaster = jobTypeMasterRepo.save(this.setJobTypeMaster(jobDTO));
		jobDTO = getJobTypeMasterDTO(JobTypeMaster);
		return jobDTO;
	}

	@Override
	public ArrayList<JobTypeMasterDTO> getAllJobTypeMasters() {
		ArrayList<JobTypeMaster> jobList = (ArrayList<JobTypeMaster>) jobTypeMasterRepo.findAll();
		ArrayList<JobTypeMasterDTO> jobDTOs = new ArrayList<JobTypeMasterDTO>();
		jobDTOs = jobList != null ? this.getJobTypeMasterDTOs(jobList) : null;
		return jobDTOs;
	}

	@Override
	public ArrayList<JobTypeMasterDTO> getSelectJobTypeMasters(ArrayList<Long> jobTypeMasterSeqNos) {
		ArrayList<JobTypeMaster> jobTypeMaster2s = null;
		ArrayList<JobTypeMasterDTO> jobTypeMasterDTOs = null;

		if (jobTypeMasterSeqNos != null) {
			jobTypeMaster2s = jobTypeMasterRepo.getSelectJobTypeMasters(jobTypeMasterSeqNos);
			if (jobTypeMaster2s != null) {
				jobTypeMasterDTOs = this.getJobTypeMasterDTOs(jobTypeMaster2s);
			}
		}
		return jobTypeMasterDTOs;
	}

	@Override
	public JobTypeMasterDTO getJobTypeMasterById(Long jobTypeMasterSeqNo) {
		Optional<JobTypeMaster> jobTypeMaster2 = jobTypeMasterRepo.findById(jobTypeMasterSeqNo);
		JobTypeMasterDTO jobTypeMasterDTO = null;

		if (jobTypeMaster2.isPresent()) {
			jobTypeMasterDTO = getJobTypeMasterDTO(jobTypeMaster2.get());
		}
		return jobTypeMasterDTO;
	}

	@Override
	public void updJobTypeMaster(JobTypeMasterDTO jobTypeMasterDTO) {
		Optional<JobTypeMaster> jobTypeMaster = jobTypeMasterRepo.findById(jobTypeMasterDTO.getJobTypeSeqNo());
		@SuppressWarnings("unused")
		JobTypeMasterDTO jobTypeMasterDTO2 = null;
		JobTypeMaster jobTypeMaster2 = null;

		if (jobTypeMaster.isPresent()) 
		{
			jobTypeMaster2 = this.setJobTypeMaster(jobTypeMasterDTO);
			jobTypeMasterRepo.save(jobTypeMaster2);
		}
	}

	@Override
	public void delJobTypeMaster(Long jobTypeMasterSeqNo) {
		if (jobTypeMasterRepo.existsById(jobTypeMasterSeqNo)) {
			jobTypeMasterRepo.deleteById(jobTypeMasterSeqNo);
		}
	}

	@Override
	public void delAllJobTypeMasters() {
		jobTypeMasterRepo.deleteAll();
	}

	@Override
	public void delSelectJobTypeMasters(ArrayList<Long> jobTypeMasterSeqNos) {
		jobTypeMasterRepo.deleteSelectJobTypeMasters(jobTypeMasterSeqNos);
	}

	private ArrayList<JobTypeMasterDTO> getJobTypeMasterDTOs(ArrayList<JobTypeMaster> jobMasters) {
		JobTypeMasterDTO jobDTO = null;
		ArrayList<JobTypeMasterDTO> jobDTOs = new ArrayList<JobTypeMasterDTO>();

		for (int i = 0; i < jobMasters.size(); i++) {
			jobDTO = getJobTypeMasterDTO(jobMasters.get(i));
			jobDTOs.add(jobDTO);
		}
		return jobDTOs;
	}

	private JobTypeMasterDTO getJobTypeMasterDTO(JobTypeMaster jobTypeMaster2) {
		JobTypeMasterDTO jobTypeMasterDTO = new JobTypeMasterDTO();
		jobTypeMasterDTO = new JobTypeMasterDTO();
		jobTypeMasterDTO.setJobTypeSeqNo(jobTypeMaster2.getJobTypeSeqNo());
		jobTypeMasterDTO.setMasterJobTypeSeqNo(jobTypeMaster2.getMasterJobTypeSeqNo());
		jobTypeMasterDTO.setJobLevelSeqNo(jobTypeMaster2.getJobLevelSeqNo());
		jobTypeMasterDTO.setJobType(jobTypeMaster2.getJobType());
		jobTypeMasterDTO.setRemarks(jobTypeMaster2.getRemarks());
		jobTypeMasterDTO.setStatus(jobTypeMaster2.getStatus());
		return jobTypeMasterDTO;
	}

	private JobTypeMaster setJobTypeMaster(JobTypeMasterDTO cDTO) {
		JobTypeMaster jobTypeMaster2 = new JobTypeMaster();
		jobTypeMaster2.setMasterJobTypeSeqNo(cDTO.getMasterJobTypeSeqNo());
		jobTypeMaster2.setJobLevelSeqNo(cDTO.getJobLevelSeqNo());
		jobTypeMaster2.setJobType(cDTO.getJobType());
		jobTypeMaster2.setRemarks(cDTO.getRemarks());
		jobTypeMaster2.setStatus(cDTO.getStatus());
		return jobTypeMaster2;
	}
}