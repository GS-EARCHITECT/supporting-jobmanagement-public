package job_type_master_mgmt.controller;

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
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;

import job_type_master_mgmt.model.dto.JobTypeMasterDTO;
import job_type_master_mgmt.services.I_JobTypeMasterService;

@RestController
@RequestMapping("/jobTypeMasterMgmt")
public class JobTypeMasterController 
{

	// private static final Logger logger =
	// LoggerFactory.getLogger(JobTypeMaster_Controller.class);

	@Autowired
	private I_JobTypeMasterService jobTypeMasterService;

	@PostMapping("/new")
	public ResponseEntity<JobTypeMasterDTO> newJobTypeMaster(@RequestBody JobTypeMasterDTO jobDTO) {
		JobTypeMasterDTO JobTypeMasterDTO2 = jobTypeMasterService.newJobTypeMaster(jobDTO);
		HttpHeaders httpHeaders = new HttpHeaders();
		return new ResponseEntity<>(JobTypeMasterDTO2, httpHeaders, HttpStatus.CREATED);
	}

	@GetMapping(value = "/getSelectJobTypeMasters", produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<ArrayList<JobTypeMasterDTO>> getSelectJobTypeMasters(
			@RequestBody ArrayList<Long> jobTypeMasterSeqNos) {
		ArrayList<JobTypeMasterDTO> JobTypeMasterDTOs = jobTypeMasterService
				.getSelectJobTypeMasters(jobTypeMasterSeqNos);
		return new ResponseEntity<>(JobTypeMasterDTOs, HttpStatus.OK);
	}

	@GetMapping(value = "/getJobTypeMaster/{jobTypeMasterSeqNo}", produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<JobTypeMasterDTO> getJobTypeMasterBySeqNo(@PathVariable Long jobTypeMasterSeqNo) {
		JobTypeMasterDTO JobTypeMasterDTO = jobTypeMasterService.getJobTypeMasterById(jobTypeMasterSeqNo);
		return new ResponseEntity<>(JobTypeMasterDTO, HttpStatus.OK);
	}

	@GetMapping(value = "/getAllJobTypeMasters", produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<ArrayList<JobTypeMasterDTO>> getAllJobTypeMasters() {
		ArrayList<JobTypeMasterDTO> JobTypeMasterDTOs = jobTypeMasterService.getAllJobTypeMasters();
		return new ResponseEntity<>(JobTypeMasterDTOs, HttpStatus.OK);
	}

	@PutMapping("/jobType")
	public void updateJobTypeMaster(@RequestBody JobTypeMasterDTO jobDTO) {
		jobTypeMasterService.updJobTypeMaster(jobDTO);
	}

	@DeleteMapping("/delJobTypeMaster/{jobTypeMasterSeqNo}")
	public void deleteJobTypeMaster(@PathVariable Long jobTypeMasterSeqNo) {
		jobTypeMasterService.delJobTypeMaster(jobTypeMasterSeqNo);
	}

	@DeleteMapping("/delAllJobTypeMasters")
	public void deleteAllJobTypeMasters() {
		jobTypeMasterService.delAllJobTypeMasters();
	}

	@DeleteMapping("/delSelectJobTypeMasters")
	public void deleteSelectJobTypeMasters(@RequestBody ArrayList<Long> JobTypeMasterSeqNoList) {
		jobTypeMasterService.delSelectJobTypeMasters(JobTypeMasterSeqNoList);
	}
}