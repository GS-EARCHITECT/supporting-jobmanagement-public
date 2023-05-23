package job_type_level_master_mgmt.services;

import java.util.ArrayList;
import java.util.Optional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import job_type_level_master_mgmt.model.dto.JobTypeLevelMasterDTO;
import job_type_level_master_mgmt.model.master.JobTypeLevelMaster;
import job_type_level_master_mgmt.model.repo.JobTypeLevelRepo;

@Service("jobTypeLevelServ")
@Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.READ_COMMITTED)
public class JobTypeLevelService implements I_JobTypeLevelService {
	@SuppressWarnings("unused")
	private static final Logger logger = LoggerFactory.getLogger(JobTypeLevelService.class);

	@Autowired
	private JobTypeLevelRepo jobTypeLevelRepo;

	@Override
	public JobTypeLevelMasterDTO newJobTypeLevel(JobTypeLevelMasterDTO jobDTO) {
		JobTypeLevelMaster JobTypeLevelMaster = jobTypeLevelRepo.save(this.setJobTypeLevelMaster(jobDTO));
		jobDTO = getJobTypeLevelMasterDTO(JobTypeLevelMaster);
		return jobDTO;
	}

	@Override
	public ArrayList<JobTypeLevelMasterDTO> getAllJobTypeLevels() {
		ArrayList<JobTypeLevelMaster> jobList = (ArrayList<JobTypeLevelMaster>) jobTypeLevelRepo.findAll();
		ArrayList<JobTypeLevelMasterDTO> jobDTOs = new ArrayList<JobTypeLevelMasterDTO>();
		jobDTOs = jobList != null ? this.getJobTypeLevelMasterDTOs(jobList) : null;
		return jobDTOs;
	}

	@Override
	public ArrayList<JobTypeLevelMasterDTO> getSelectJobTypeLevels(ArrayList<Long> jobTypeLevelSeqNos) {
		ArrayList<JobTypeLevelMaster> jobTypeLevelMasters = null;
		ArrayList<JobTypeLevelMasterDTO> jobTypeLevelMasterDTOs = null;

		if (jobTypeLevelSeqNos != null) {
			jobTypeLevelMasters = jobTypeLevelRepo.getSelectJobTypeLevels(jobTypeLevelSeqNos);
			if (jobTypeLevelMasters != null) {
				jobTypeLevelMasterDTOs = this.getJobTypeLevelMasterDTOs(jobTypeLevelMasters);
			}
		}
		return jobTypeLevelMasterDTOs;
	}

	@Override
	public JobTypeLevelMasterDTO getJobTypeLevelById(Long jobTypeLevelSeqNo) {
		Optional<JobTypeLevelMaster> jobTypeLevelMaster = jobTypeLevelRepo.findById(jobTypeLevelSeqNo);
		JobTypeLevelMasterDTO jobTypeLevelMasterDTO = null;

		if (jobTypeLevelMaster.isPresent()) {
			jobTypeLevelMasterDTO = getJobTypeLevelMasterDTO(jobTypeLevelMaster.get());
		}
		return jobTypeLevelMasterDTO;
	}

	@Override
	public void updJobTypeLevel(JobTypeLevelMasterDTO jobTypeLevelMasterDTO) {
		Optional<JobTypeLevelMaster> jobTypeLevelMaster = jobTypeLevelRepo
				.findById(jobTypeLevelMasterDTO.getJobTypeLevelSeqNo());
		@SuppressWarnings("unused")
		JobTypeLevelMasterDTO jobTypeLevelMasterDTO2 = null;
		JobTypeLevelMaster jobTypeLevelMaster2 = null;

		if (jobTypeLevelMaster.isPresent()) {
			jobTypeLevelMaster2 = this.setJobTypeLevelMaster(jobTypeLevelMasterDTO);
			jobTypeLevelRepo.save(jobTypeLevelMaster2);
		}
	}

	@Override
	public void delJobTypeLevel(Long jobTypeLevelSeqNo) {
		if (jobTypeLevelRepo.existsById(jobTypeLevelSeqNo)) {
			jobTypeLevelRepo.deleteById(jobTypeLevelSeqNo);
		}
	}

	@Override
	public void delAllJobTypeLevels() {
		jobTypeLevelRepo.deleteAll();
	}

	@Override
	public void delSelectJobTypeLevels(ArrayList<Long> jobTypeLevelSeqNos) {
		jobTypeLevelRepo.deleteSelectJobTypeLevels(jobTypeLevelSeqNos);
	}

	private ArrayList<JobTypeLevelMasterDTO> getJobTypeLevelMasterDTOs(ArrayList<JobTypeLevelMaster> jobMasters) {
		JobTypeLevelMasterDTO jobDTO = null;
		ArrayList<JobTypeLevelMasterDTO> jobDTOs = new ArrayList<JobTypeLevelMasterDTO>();

		for (int i = 0; i < jobMasters.size(); i++) {
			jobDTO = getJobTypeLevelMasterDTO(jobMasters.get(i));
			jobDTOs.add(jobDTO);
		}
		return jobDTOs;
	}

	private JobTypeLevelMasterDTO getJobTypeLevelMasterDTO(JobTypeLevelMaster jobTypeLevelMaster) {
		JobTypeLevelMasterDTO jobTypeLevelDTO = new JobTypeLevelMasterDTO();
		jobTypeLevelDTO = new JobTypeLevelMasterDTO();
		jobTypeLevelDTO.setJobTypeLevelSeqNo(jobTypeLevelMaster.getJobTypeLevelSeqNo());
		jobTypeLevelDTO.setJobLevel(jobTypeLevelMaster.getJobLevel());
		jobTypeLevelDTO.setRemarks(jobTypeLevelMaster.getRemarks());
		jobTypeLevelDTO.setStatus(jobTypeLevelMaster.getStatus());
		return jobTypeLevelDTO;
	}

	private JobTypeLevelMaster setJobTypeLevelMaster(JobTypeLevelMasterDTO cDTO) {
		JobTypeLevelMaster jobTypeLevelMaster = new JobTypeLevelMaster();
		jobTypeLevelMaster.setJobLevel(cDTO.getJobLevel());
		jobTypeLevelMaster.setRemarks(cDTO.getRemarks());
		jobTypeLevelMaster.setStatus(cDTO.getStatus());
		return jobTypeLevelMaster;
	}
}