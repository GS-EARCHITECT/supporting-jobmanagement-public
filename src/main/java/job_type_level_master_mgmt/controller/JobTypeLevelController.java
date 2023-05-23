package job_type_level_master_mgmt.controller;

import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import job_type_level_master_mgmt.model.dto.JobTypeLevelMasterDTO;
import job_type_level_master_mgmt.services.I_JobTypeLevelService;

@RestController
@RequestMapping("/jobTypeLevelMgmt")
public class JobTypeLevelController {

	// private static final Logger logger =
	// LoggerFactory.getLogger(JobTypeLevel_Controller.class);

	@Autowired
	private I_JobTypeLevelService jobTypeLevelService;

	@PostMapping("/new")
	public ResponseEntity<JobTypeLevelMasterDTO> newJobTypeLevel(@RequestBody JobTypeLevelMasterDTO jobDTO) {
		JobTypeLevelMasterDTO JobTypeLevelMasterDTO2 = jobTypeLevelService.newJobTypeLevel(jobDTO);
		HttpHeaders httpHeaders = new HttpHeaders();
		return new ResponseEntity<>(JobTypeLevelMasterDTO2, httpHeaders, HttpStatus.CREATED);
	}

	@GetMapping(value = "/getSelectJobTypeLevels", produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<ArrayList<JobTypeLevelMasterDTO>> getSelectJobTypeLevels(
			@RequestBody ArrayList<Long> jobTypeLevelSeqNos) {
		ArrayList<JobTypeLevelMasterDTO> JobTypeLevelMasterDTOs = jobTypeLevelService
				.getSelectJobTypeLevels(jobTypeLevelSeqNos);
		return new ResponseEntity<>(JobTypeLevelMasterDTOs, HttpStatus.OK);
	}

	@GetMapping(value = "/getJobTypeLevel/{jobTypeLevelSeqNo}", produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<JobTypeLevelMasterDTO> getJobTypeLevelBySeqNo(@PathVariable Long jobTypeLevelSeqNo) {
		JobTypeLevelMasterDTO JobTypeLevelMasterDTO = jobTypeLevelService.getJobTypeLevelById(jobTypeLevelSeqNo);
		return new ResponseEntity<>(JobTypeLevelMasterDTO, HttpStatus.OK);
	}

	@GetMapping(value = "/getAllJobTypeLevels", produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<ArrayList<JobTypeLevelMasterDTO>> getAllJobTypeLevels() {
		ArrayList<JobTypeLevelMasterDTO> JobTypeLevelMasterDTOs = jobTypeLevelService.getAllJobTypeLevels();
		return new ResponseEntity<>(JobTypeLevelMasterDTOs, HttpStatus.OK);
	}

	@PutMapping("/jobType")
	public void updateJobTypeLevel(@RequestBody JobTypeLevelMasterDTO jobDTO) {
		jobTypeLevelService.updJobTypeLevel(jobDTO);
	}

	@DeleteMapping("/delJobTypeLevel/{jobTypeLevelSeqNo}")
	public void deleteJobTypeLevel(@PathVariable Long jobTypeLevelSeqNo) {
		jobTypeLevelService.delJobTypeLevel(jobTypeLevelSeqNo);
	}

	@DeleteMapping("/delAllJobTypeLevels")
	public void deleteAllJobTypeLevels() {
		jobTypeLevelService.delAllJobTypeLevels();
	}

	@DeleteMapping("/delSelectJobTypeLevels")
	public void deleteSelectJobTypeLevels(@RequestBody ArrayList<Long> JobTypeLevelSeqNoList) {
		jobTypeLevelService.delSelectJobTypeLevels(JobTypeLevelSeqNoList);
	}
}