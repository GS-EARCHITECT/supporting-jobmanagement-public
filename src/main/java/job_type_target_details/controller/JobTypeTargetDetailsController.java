package job_type_target_details.controller;

import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;

import job_type_target_details.model.dto.JobTypeTargetDetailsDTO;
import job_type_target_details.services.I_JobTypeTargetDetailsService;

@RestController
@RequestMapping("/jobTypeTargetDetailsMgmt")
public class JobTypeTargetDetailsController 
{

	// private static final Logger logger =
	// LoggerFactory.getLogger(JobTypeTargetDetails_Controller.class);

	@Autowired
	private I_JobTypeTargetDetailsService jobTypeTargetDetailsService;

	@PostMapping("/new")
	public ResponseEntity<JobTypeTargetDetailsDTO> newJobTypeTargetDetails(@RequestBody JobTypeTargetDetailsDTO jobTypeTargetDetails) {
		JobTypeTargetDetailsDTO JobTypeTargetDetailsDTO2 = jobTypeTargetDetailsService.newJobTypeTargetDetails(jobTypeTargetDetails);
		HttpHeaders httpHeaders = new HttpHeaders();
		return new ResponseEntity<>(JobTypeTargetDetailsDTO2, httpHeaders, HttpStatus.CREATED);
	}

	@GetMapping(value = "/getSelectJobTypeTargetDetails", produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<ArrayList<JobTypeTargetDetailsDTO>> getSelectJobTypeTargetDetails(
			@RequestBody ArrayList<JobTypeTargetDetailsDTO> jobTypeTargetDetailsSeqNos) 
	{
		ArrayList<JobTypeTargetDetailsDTO> JobTypeTargetDetailsDTOs = jobTypeTargetDetailsService
				.getSelectJobTypeTargetDetails(jobTypeTargetDetailsSeqNos);
		return new ResponseEntity<>(JobTypeTargetDetailsDTOs, HttpStatus.OK);
	}

	@GetMapping(value = "/getJobTypeTargetDetails", produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<JobTypeTargetDetailsDTO> getJobTypeTargetDetailsBySeqNo(@RequestBody JobTypeTargetDetailsDTO jobTypeTargetDetailsDTO) {
		JobTypeTargetDetailsDTO JobTypeTargetDetailsDTO = jobTypeTargetDetailsService.getJobTypeTargetDetailsById(jobTypeTargetDetailsDTO);
		return new ResponseEntity<>(JobTypeTargetDetailsDTO, HttpStatus.OK);
	}

	@GetMapping(value = "/getAllJobTypeTargetDetails", produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<ArrayList<JobTypeTargetDetailsDTO>> getAllJobTypeTargetDetails() {
		ArrayList<JobTypeTargetDetailsDTO> JobTypeTargetDetailsDTOs = jobTypeTargetDetailsService.getAllJobTypeTargetDetails();
		return new ResponseEntity<>(JobTypeTargetDetailsDTOs, HttpStatus.OK);
	}

	@PutMapping("/jobTypeTargetDetails")
	public void updateJobTypeTargetDetails(@RequestBody JobTypeTargetDetailsDTO jobTypeTargetDetails)
	{
		jobTypeTargetDetailsService.updJobTypeTargetDetails(jobTypeTargetDetails);
	}

	@DeleteMapping("/delJobTypeTargetDetails")
	public void deleteJobTypeTargetDetails(@RequestBody JobTypeTargetDetailsDTO jobTypeTargetDetailsDTO)
	{
		jobTypeTargetDetailsService.delJobTypeTargetDetails(jobTypeTargetDetailsDTO);
	}

	@DeleteMapping("/delAllJobTypeTargetDetails")
	public void deleteAllJobTypeTargetDetails() {
		jobTypeTargetDetailsService.delAllJobTypeTargetDetails();
	}

	@DeleteMapping("/delSelectJobTypeTargetDetails")
	public void deleteSelectJobTypeTargetDetails(@RequestBody ArrayList<JobTypeTargetDetailsDTO> jobTypeTargetDetailsDTOs) 
	{
		jobTypeTargetDetailsService.delSelectJobTypeTargetDetails(jobTypeTargetDetailsDTOs);
	}
}