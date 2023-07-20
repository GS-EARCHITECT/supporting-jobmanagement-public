package job_structure_details_mgmt.controller;

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

import job_structure_details_mgmt.model.dto.JobStructureDetail_DTO;
import job_structure_details_mgmt.services.I_JobStructureDetails_Service;

@RestController
@RequestMapping("/jobStructureDetailsMgmt")
public class JobStructureDetails_Controller 
{
	@Autowired
	private I_JobStructureDetails_Service jobStructureDetailsService;

	@PostMapping("/new")
	public ResponseEntity<JobStructureDetail_DTO> newJobStructureDetail(@RequestBody JobStructureDetail_DTO jcsDTO) {
		JobStructureDetail_DTO JobStructureDetail_DTO2 = jobStructureDetailsService.newJobStructureDetail(jcsDTO);
		HttpHeaders httpHeaders = new HttpHeaders();
		return new ResponseEntity<>(JobStructureDetail_DTO2, httpHeaders, HttpStatus.CREATED);
	}

	@GetMapping(value = "/getSelectJobStructureDetails", produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<ArrayList<JobStructureDetail_DTO>> getSelectJobStructureDetails(
			@RequestBody ArrayList<Long> ids) {
		ArrayList<JobStructureDetail_DTO> JobStructureDetail_DTOs = jobStructureDetailsService
				.getSelectJobStructureDetails(ids);
		return new ResponseEntity<>(JobStructureDetail_DTOs, HttpStatus.OK);
	}

	@GetMapping(value = "/getSelectJobStructureDetailsByParents", produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<ArrayList<JobStructureDetail_DTO>> getSelectJobStructureDetailsByParents(
			@RequestBody ArrayList<Long> ids) {
		ArrayList<JobStructureDetail_DTO> JobStructureDetail_DTOs = jobStructureDetailsService
				.getSelectJobStructureDetailsByParents(ids);
		return new ResponseEntity<>(JobStructureDetail_DTOs, HttpStatus.OK);
	}

	@GetMapping(value = "/getAllJobStructureDetails", produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<ArrayList<JobStructureDetail_DTO>> getAllJobStructureDetails() {
		ArrayList<JobStructureDetail_DTO> JobStructureDetail_DTOs = jobStructureDetailsService
				.getAllJobStructureDetails();
		return new ResponseEntity<>(JobStructureDetail_DTOs, HttpStatus.OK);
	}

	@PutMapping("/jobStructureDetail")
	public void updateJobStructureDetail(@RequestBody JobStructureDetail_DTO jcsDTO) {
		jobStructureDetailsService.updJobStructureDetail(jcsDTO);
	}

	@DeleteMapping("/delAllJobStructureDetails")
	public void deleteAllJobStructureDetails() {
		jobStructureDetailsService.delAllJobStructureDetails();
	}

	@DeleteMapping("/delSelectJobStructureDetails")
	public void deleteSelectJobStructureDetails(@RequestBody ArrayList<Long> ids) {
		jobStructureDetailsService.delSelectJobStructureDetails(ids);
	}

	@DeleteMapping("/delSelectJobStructureDetailsByParents")
	public void deleteSelectJobStructureDetailsByParents(@RequestBody ArrayList<Long> pids) {
		jobStructureDetailsService.delSelectJobStructureDetailsByParents(pids);
	}

}