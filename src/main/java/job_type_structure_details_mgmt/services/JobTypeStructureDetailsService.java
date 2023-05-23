package job_type_structure_details_mgmt.services;

import java.util.ArrayList;
import java.util.Optional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import job_type_structure_details_mgmt.model.details.JobTypeStructureDetails;
import job_type_structure_details_mgmt.model.details.JobTypeStructureDetailsPK;
import job_type_structure_details_mgmt.model.dto.JobTypeStructureDetailsDTO;
import job_type_structure_details_mgmt.model.repo.JobTypeStructureDetailsRepo;

@Service("jobTypeStructureDetailsServ")
@Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.READ_COMMITTED)
public class JobTypeStructureDetailsService implements I_JobTypeStructureDetailsService {
	@SuppressWarnings("unused")
	private static final Logger logger = LoggerFactory.getLogger(JobTypeStructureDetailsService.class);

	@Autowired
	private JobTypeStructureDetailsRepo jobTypeStructureDetailsRepo;

	@Override
	public JobTypeStructureDetailsDTO newJobTypeStructureDetails(JobTypeStructureDetailsDTO jobStructureDetailsDTO) {
		JobTypeStructureDetailsPK jobTypeStructureDetailsPK = new JobTypeStructureDetailsPK();
		jobTypeStructureDetailsPK.setJobTypeSeqNo(jobStructureDetailsDTO.getJobTypeSeqNo());
		jobTypeStructureDetailsPK.setParJobTypeSeqNo(jobStructureDetailsDTO.getParJobTypeSeqNo());
		JobTypeStructureDetails jobTypeStructureDetails2 = null;
		JobTypeStructureDetailsDTO jobTypeStructureDetailsDTO = null;

		if (!jobTypeStructureDetailsRepo.existsById(jobTypeStructureDetailsPK)) {
			jobTypeStructureDetails2 = this.setJobTypeStructureDetails(jobStructureDetailsDTO);
			jobTypeStructureDetails2.setId(jobTypeStructureDetailsPK);
			jobTypeStructureDetailsDTO = this.getJobTypeStructureDetailsDTO(jobTypeStructureDetails2);
		}
		return jobTypeStructureDetailsDTO;
	}

	@Override
	public ArrayList<JobTypeStructureDetailsDTO> getAllJobTypeStructureDetailss() {
		ArrayList<JobTypeStructureDetails> jobList = (ArrayList<JobTypeStructureDetails>) jobTypeStructureDetailsRepo
				.findAll();
		ArrayList<JobTypeStructureDetailsDTO> jobStructureDetailsDTOs = new ArrayList<JobTypeStructureDetailsDTO>();
		jobStructureDetailsDTOs = jobList != null ? this.getJobTypeStructureDetailsDTOs(jobList) : null;
		return jobStructureDetailsDTOs;
	}

	@Override
	public ArrayList<JobTypeStructureDetailsDTO> getSelectJobTypeStructureDetails(
			ArrayList<JobTypeStructureDetailsPK>  jobTypeStructureDetailsPKs) {
		ArrayList<JobTypeStructureDetails> jobTypeStructureDetailss = null;
		ArrayList<JobTypeStructureDetailsDTO> jobTypeStructureDetailsDTOs = null;

		if ( jobTypeStructureDetailsPKs != null) {
			jobTypeStructureDetailss = (ArrayList<JobTypeStructureDetails>) jobTypeStructureDetailsRepo.findAllById(jobTypeStructureDetailsPKs);					
			if (jobTypeStructureDetailss != null) {
				jobTypeStructureDetailsDTOs = this.getJobTypeStructureDetailsDTOs(jobTypeStructureDetailss);
			}
		}
		return jobTypeStructureDetailsDTOs;
	}

	
	@Override
	public ArrayList<JobTypeStructureDetailsDTO> getSelectJobTypeStructureDetailss(
			ArrayList<Long> jobTypeStructureDetailsSeqNos) {
		ArrayList<JobTypeStructureDetails> jobTypeStructureDetailss = null;
		ArrayList<JobTypeStructureDetailsDTO> jobTypeStructureDetailsDTOs = null;

		if (jobTypeStructureDetailsSeqNos != null) {
			jobTypeStructureDetailss = jobTypeStructureDetailsRepo
					.getSelectJobTypeStructureDetails(jobTypeStructureDetailsSeqNos);
			if (jobTypeStructureDetailss != null) {
				jobTypeStructureDetailsDTOs = this.getJobTypeStructureDetailsDTOs(jobTypeStructureDetailss);
			}
		}
		return jobTypeStructureDetailsDTOs;
	}

	@Override
	public JobTypeStructureDetailsDTO getJobTypeStructureDetailsById(Long jobTypeStructureDetailsSeqNo,
			Long parJobTypeStructureDetailsSeqNo) {
		JobTypeStructureDetailsPK jobTypeStructureDetailsPK = new JobTypeStructureDetailsPK();
		jobTypeStructureDetailsPK.setJobTypeSeqNo(jobTypeStructureDetailsSeqNo);
		jobTypeStructureDetailsPK.setParJobTypeSeqNo(parJobTypeStructureDetailsSeqNo);
		Optional<JobTypeStructureDetails> jobTypeStructureDetails = jobTypeStructureDetailsRepo
				.findById(jobTypeStructureDetailsPK);
		JobTypeStructureDetailsDTO jobTypeStructureDetailsDTO = null;

		if (jobTypeStructureDetails.isPresent()) {
			jobTypeStructureDetailsDTO = getJobTypeStructureDetailsDTO(jobTypeStructureDetails.get());
		}
		return jobTypeStructureDetailsDTO;
	}

	@Override
	public void updJobTypeStructureDetails(JobTypeStructureDetailsDTO jobTypeStructureDetailsDTO) {
		JobTypeStructureDetailsPK jobTypeStructureDetailsPK = new JobTypeStructureDetailsPK();
		jobTypeStructureDetailsPK.setJobTypeSeqNo(jobTypeStructureDetailsDTO.getJobTypeSeqNo());
		jobTypeStructureDetailsPK.setParJobTypeSeqNo(jobTypeStructureDetailsDTO.getParJobTypeSeqNo());
		JobTypeStructureDetails jobTypeStructureDetails2 = null;
		Optional<JobTypeStructureDetails> jobTypeStructureDetails = jobTypeStructureDetailsRepo
				.findById(jobTypeStructureDetailsPK);

		if (jobTypeStructureDetails.isPresent()) {
			jobTypeStructureDetails2 = this.setJobTypeStructureDetails(jobTypeStructureDetailsDTO);
			jobTypeStructureDetails2.setId(jobTypeStructureDetailsPK);
			;
			jobTypeStructureDetailsRepo.save(jobTypeStructureDetails2);
		}
	}

	@Override
	public void delJobTypeStructureDetails(Long jobTypeStructureDetailsSeqNo, Long parJobTypeStructureDetailsSeqNo) {
		JobTypeStructureDetailsPK jobTypeStructureDetailsPK = new JobTypeStructureDetailsPK();
		jobTypeStructureDetailsPK.setJobTypeSeqNo(jobTypeStructureDetailsSeqNo);
		jobTypeStructureDetailsPK.setParJobTypeSeqNo(parJobTypeStructureDetailsSeqNo);

		if (jobTypeStructureDetailsRepo.existsById(jobTypeStructureDetailsPK)) {
			jobTypeStructureDetailsRepo.deleteById(jobTypeStructureDetailsPK);
		}
	}

	@Override
	public void delAllJobTypeStructureDetailss() {
		jobTypeStructureDetailsRepo.deleteAll();
	}

	@Override
	public void delSelectJobTypeStructureDetailss(ArrayList<Long> jobTypeStructureDetailsSeqNos) {
		jobTypeStructureDetailsRepo.deleteSelectJobTypeStructureDetailss(jobTypeStructureDetailsSeqNos);
	}

	private ArrayList<JobTypeStructureDetailsDTO> getJobTypeStructureDetailsDTOs(
			ArrayList<JobTypeStructureDetails> jobStructureDetailss) {
		JobTypeStructureDetailsDTO jobStructureDetailsDTO = null;
		ArrayList<JobTypeStructureDetailsDTO> jobStructureDetailsDTOs = new ArrayList<JobTypeStructureDetailsDTO>();

		for (int i = 0; i < jobStructureDetailss.size(); i++) {
			jobStructureDetailsDTO = getJobTypeStructureDetailsDTO(jobStructureDetailss.get(i));
			jobStructureDetailsDTOs.add(jobStructureDetailsDTO);
		}
		return jobStructureDetailsDTOs;
	}

	private JobTypeStructureDetailsDTO getJobTypeStructureDetailsDTO(JobTypeStructureDetails jobTypeStructureDetails) {
		JobTypeStructureDetailsDTO jobTypeStructureDetailsDTO = new JobTypeStructureDetailsDTO();
		jobTypeStructureDetailsDTO.setJobTypeSeqNo(jobTypeStructureDetails.getId().getJobTypeSeqNo());
		jobTypeStructureDetailsDTO.setParJobTypeSeqNo(jobTypeStructureDetails.getId().getParJobTypeSeqNo());
		jobTypeStructureDetailsDTO.setRemarks(jobTypeStructureDetails.getRemarks());
		jobTypeStructureDetailsDTO.setStatus(jobTypeStructureDetails.getStatus());
		jobTypeStructureDetailsDTO.setSeqNo(jobTypeStructureDetails.getSeqNo());
		jobTypeStructureDetailsDTO.setParTargetSeqNo(jobTypeStructureDetails.getId().getParTargetSeqNo());
		return jobTypeStructureDetailsDTO;
	}

	private JobTypeStructureDetails setJobTypeStructureDetails(JobTypeStructureDetailsDTO cDTO) {
		JobTypeStructureDetails jobTypeStructureDetails = new JobTypeStructureDetails();
		JobTypeStructureDetailsPK jobTypeStructureDetailsPK = new JobTypeStructureDetailsPK();
		jobTypeStructureDetailsPK.setJobTypeSeqNo(cDTO.getJobTypeSeqNo());
		jobTypeStructureDetailsPK.setParJobTypeSeqNo(cDTO.getParJobTypeSeqNo());
		jobTypeStructureDetailsPK.setParTargetSeqNo(cDTO.getParTargetSeqNo());
		jobTypeStructureDetails.setRemarks(cDTO.getRemarks());
		jobTypeStructureDetails.setStatus(cDTO.getStatus());
		jobTypeStructureDetails.setSeqNo(cDTO.getSeqNo());		
		return jobTypeStructureDetails;
	}
}