package job_type_structure_details_mgmt.controller;

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

import job_type_structure_details_mgmt.model.dto.JobTypeStructureDetailsDTO;
import job_type_structure_details_mgmt.services.I_JobTypeStructureDetailsService;

@RestController
@RequestMapping("/jobTypeStructureDetailsMgmt")
public class JobTypeStructureDetailsController 
{

	// private static final Logger logger =
	// LoggerFactory.getLogger(JobTypeStructureDetails_Controller.class);

	@Autowired
	private I_JobTypeStructureDetailsService jobTypeStructureDetailsService;

	@PostMapping("/new")
	public ResponseEntity<JobTypeStructureDetailsDTO> newJobTypeStructureDetails(@RequestBody JobTypeStructureDetailsDTO jobDTO) {
		JobTypeStructureDetailsDTO JobTypeStructureDetailsDTO2 = jobTypeStructureDetailsService.newJobTypeStructureDetails(jobDTO);
		HttpHeaders httpHeaders = new HttpHeaders();
		return new ResponseEntity<>(JobTypeStructureDetailsDTO2, httpHeaders, HttpStatus.CREATED);
	}

	@GetMapping(value = "/getSelectJobTypeStructureDetailss", produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<ArrayList<JobTypeStructureDetailsDTO>> getSelectJobTypeStructureDetailss(
			@RequestBody ArrayList<Long> jobTypeStructureDetailsSeqNos) {
		ArrayList<JobTypeStructureDetailsDTO> JobTypeStructureDetailsDTOs = jobTypeStructureDetailsService
				.getSelectJobTypeStructureDetailss(jobTypeStructureDetailsSeqNos);
		return new ResponseEntity<>(JobTypeStructureDetailsDTOs, HttpStatus.OK);
	}

	@GetMapping(value = "/getJobTypeStructureDetails/{jobTypeStructureDetailsSeqNo}/{parjobTypeStructureDetailsSeqNo}", produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<JobTypeStructureDetailsDTO> getJobTypeStructureDetailsBySeqNo(@PathVariable Long jobTypeStructureDetailsSeqNo, @PathVariable Long parjobTypeStructureDetailsSeqNo) 
	{
			JobTypeStructureDetailsDTO JobTypeStructureDetailsDTO = jobTypeStructureDetailsService.getJobTypeStructureDetailsById(jobTypeStructureDetailsSeqNo, parjobTypeStructureDetailsSeqNo);
		return new ResponseEntity<>(JobTypeStructureDetailsDTO, HttpStatus.OK);
	}

	@GetMapping(value = "/getAllJobTypeStructureDetailss", produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<ArrayList<JobTypeStructureDetailsDTO>> getAllJobTypeStructureDetailss() {
		ArrayList<JobTypeStructureDetailsDTO> JobTypeStructureDetailsDTOs = jobTypeStructureDetailsService.getAllJobTypeStructureDetailss();
		return new ResponseEntity<>(JobTypeStructureDetailsDTOs, HttpStatus.OK);
	}

	@PutMapping("/jobType")
	public void updateJobTypeStructureDetails(@RequestBody JobTypeStructureDetailsDTO jobDTO) {
		jobTypeStructureDetailsService.updJobTypeStructureDetails(jobDTO);
	}

	@DeleteMapping("/delJobTypeStructureDetails/{jobTypeStructureDetailsSeqNo}/{parjobTypeStructureDetailsSeqNo}")
	public void deleteJobTypeStructureDetails(@PathVariable Long jobTypeStructureDetailsSeqNo, @PathVariable Long parjobTypeStructureDetailsSeqNo)
	{
		jobTypeStructureDetailsService.delJobTypeStructureDetails(jobTypeStructureDetailsSeqNo, parjobTypeStructureDetailsSeqNo);
	}

	@DeleteMapping("/delAllJobTypeStructureDetailss")
	public void deleteAllJobTypeStructureDetailss() {
		jobTypeStructureDetailsService.delAllJobTypeStructureDetailss();
	}

	@DeleteMapping("/delSelectJobTypeStructureDetailss")
	public void deleteSelectJobTypeStructureDetailss(@RequestBody ArrayList<Long> JobTypeStructureDetailsSeqNoList) {
		jobTypeStructureDetailsService.delSelectJobTypeStructureDetailss(JobTypeStructureDetailsSeqNoList);
	}
}