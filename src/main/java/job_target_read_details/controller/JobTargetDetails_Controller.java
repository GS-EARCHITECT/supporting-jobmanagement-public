package job_target_read_details.controller;

import java.util.concurrent.CopyOnWriteArrayList;

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

import job_target_read_details.model.dto.JobTargetDetail_DTO;
import job_target_read_details.services.I_JobTargetDetailsRead_Service;


@RestController
@RequestMapping("/jobTargetDetailsReadMgmt")
public class JobTargetDetails_Controller 
{

	// private static final Logger logger =
	// LoggerFactory.getLogger(JobTargetDetails_Controller.class);

	@Autowired
	private I_JobTargetDetailsRead_Service jobTargetDetailsReadService;

	@GetMapping(value = "/getSelectJobTargetDetails", produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<CopyOnWriteArrayList<JobTargetDetail_DTO>> getSelectJobTargetDetails(
			@RequestBody CopyOnWriteArrayList<JobTargetDetail_DTO> jobTargetDetailsSeqNos) 
	{
		
		CopyOnWriteArrayList<JobTargetDetail_DTO> JobTargetDetail_DTOs = jobTargetDetailsService
				.getSelectJobTargetDetails(jobTargetDetailsSeqNos);
		return new ResponseEntity<>(JobTargetDetail_DTOs, HttpStatus.OK);
	}

	@GetMapping(value = "/getJobTargetDetails", produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<JobTargetDetail_DTO> getJobTargetDetailsBySeqNo(@RequestBody JobTargetDetail_DTO jobTargetDetailsDTO) {
		JobTargetDetail_DTO JobTargetDetail_DTO = jobTargetDetailsService.getJobTargetDetailsById(jobTargetDetailsDTO);
		return new ResponseEntity<>(JobTargetDetail_DTO, HttpStatus.OK);
	}

	@GetMapping(value = "/getAllJobTargetDetails", produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<CopyOnWriteArrayList<JobTargetDetail_DTO>> getAllJobTargetDetails() {
		CopyOnWriteArrayList<JobTargetDetail_DTO> JobTargetDetail_DTOs = jobTargetDetailsService.getAllJobTargetDetails();
		return new ResponseEntity<>(JobTargetDetail_DTOs, HttpStatus.OK);
	}

	@PutMapping("/jobTargetDetails")
	public void updateJobTargetDetails(@RequestBody JobTargetDetail_DTO jobTargetDetails)
	{
		jobTargetDetailsService.updJobTargetDetails(jobTargetDetails);
	}

	@DeleteMapping("/delJobTargetDetails")
	public void deleteJobTargetDetails(@RequestBody JobTargetDetail_DTO jobTargetDetailsDTO)
	{
		jobTargetDetailsService.delJobTargetDetails(jobTargetDetailsDTO);
	}

	@DeleteMapping("/delAllJobTargetDetails")
	public void deleteAllJobTargetDetails() {
		jobTargetDetailsService.delAllJobTargetDetails();
	}

	@DeleteMapping("/delSelectJobTargetDetails")
	public void deleteSelectJobTargetDetails(@RequestBody CopyOnWriteArrayList<JobTargetDetail_DTO> jobTargetDetailsDTOs) 
	{
		jobTargetDetailsService.delSelectJobTargetDetails(jobTargetDetailsDTOs);
	}
}