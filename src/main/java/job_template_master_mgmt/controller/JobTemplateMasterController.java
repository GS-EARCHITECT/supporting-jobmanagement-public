package job_template_master_mgmt.controller;

import java.math.BigDecimal;
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

import job_template_master_mgmt.model.dto.JobTemplateMasterDTO;
import job_template_master_mgmt.services.I_JobTemplateMasterService;

@RestController
@RequestMapping("/jobTemplateMasterMgmt")
public class JobTemplateMasterController 
{

	// private static final Logger logger =
	// LoggerFactory.getLogger(JobTemplateMaster_Controller.class);

	@Autowired
	private I_JobTemplateMasterService jobTemplateMasterService;

	@PostMapping("/new")
	public ResponseEntity<JobTemplateMasterDTO> newJobTemplateMaster(@RequestBody JobTemplateMasterDTO jobDTO) {
		JobTemplateMasterDTO JobTemplateMasterDTO2 = jobTemplateMasterService.newJobTemplateMaster(jobDTO);
		HttpHeaders httpHeaders = new HttpHeaders();
		return new ResponseEntity<>(JobTemplateMasterDTO2, httpHeaders, HttpStatus.CREATED);
	}

	@GetMapping(value = "/getSelectJobTemplateMasters", produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<ArrayList<JobTemplateMasterDTO>> getSelectJobTemplateMasters(
			@RequestBody ArrayList<Long> jobTemplateMasterSeqNos) {
		ArrayList<JobTemplateMasterDTO> JobTemplateMasterDTOs = jobTemplateMasterService
				.getSelectJobTemplateMasters(jobTemplateMasterSeqNos);
		return new ResponseEntity<>(JobTemplateMasterDTOs, HttpStatus.OK);
	}

	@GetMapping(value = "/getJobTemplateMaster/{jobTemplateMasterSeqNo}/{servCatSeqNo}/{servSeqNo}", produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<JobTemplateMasterDTO> getJobTemplateMasterBySeqNo(@PathVariable Long jobTemplateMasterSeqNo, @PathVariable Long servSeqNo, @PathVariable BigDecimal servCatSeqNo) 
	{
		JobTemplateMasterDTO JobTemplateMasterDTO = jobTemplateMasterService.getJobTemplateMasterById(jobTemplateMasterSeqNo,servSeqNo,servCatSeqNo);
		return new ResponseEntity<>(JobTemplateMasterDTO, HttpStatus.OK);
	}

	@GetMapping(value = "/getAllJobTemplateMasters", produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<ArrayList<JobTemplateMasterDTO>> getAllJobTemplateMasters() {
		ArrayList<JobTemplateMasterDTO> JobTemplateMasterDTOs = jobTemplateMasterService.getAllJobTemplateMasters();
		return new ResponseEntity<>(JobTemplateMasterDTOs, HttpStatus.OK);
	}

	@PutMapping("/jobType")
	public void updateJobTemplateMaster(@RequestBody JobTemplateMasterDTO jobDTO) {
		jobTemplateMasterService.updJobTemplateMaster(jobDTO);
	}

	@DeleteMapping("/delJobTemplateMaster/{jobTemplateMasterSeqNo}/{servCatSeqNo}/{servSeqNo}")
	public void deleteJobTemplateMaster(@PathVariable Long jobTemplateMasterSeqNo, @PathVariable Long servSeqNo, @PathVariable BigDecimal servCatSeqNo)
	{
		jobTemplateMasterService.delJobTemplateMaster(jobTemplateMasterSeqNo,servSeqNo,servCatSeqNo);
	}

	@DeleteMapping("/delAllJobTemplateMasters")
	public void deleteAllJobTemplateMasters() {
		jobTemplateMasterService.delAllJobTemplateMasters();
	}

	@DeleteMapping("/delSelectJobTemplateMasters")
	public void deleteSelectJobTemplateMasters(@RequestBody ArrayList<Long> JobTemplateMasterSeqNoList) {
		jobTemplateMasterService.delSelectJobTemplateMasters(JobTemplateMasterSeqNoList);
	}
}