package job_class_structure_mgmt.controller;

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

import job_class_structure_mgmt.model.dto.JobClassStructure_DTO;
import job_class_structure_mgmt.services.I_JobClassStructure_Service;

@RestController
@RequestMapping("/jobClassStructureMgmt")
public class JobClassStructure_Controller 
{
	@Autowired
	private I_JobClassStructure_Service jobClassStructureService;

	@PostMapping("/new")
	public ResponseEntity<JobClassStructure_DTO> newJobClassStructure(@RequestBody JobClassStructure_DTO jcsDTO) {
		JobClassStructure_DTO JobClassStructure_DTO2 = jobClassStructureService.newJobClassStructure(jcsDTO);
		HttpHeaders httpHeaders = new HttpHeaders();
		return new ResponseEntity<>(JobClassStructure_DTO2, httpHeaders, HttpStatus.CREATED);
	}

	@GetMapping(value = "/getSelectJobClassStructures", produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<ArrayList<JobClassStructure_DTO>> getSelectJobClassStructures(
			@RequestBody ArrayList<Long> ids, @RequestBody ArrayList<Long> pids)
	{
		ArrayList<JobClassStructure_DTO> JobClassStructure_DTOs = jobClassStructureService.getSelectJobClassStructures(ids, pids);
		return new ResponseEntity<>(JobClassStructure_DTOs, HttpStatus.OK);
	}

	@GetMapping(value = "/getSelectJobClassesByParents", produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<ArrayList<JobClassStructure_DTO>> getSelectJobClassesByParents(
			@RequestBody ArrayList<Long> ids)
	{
		ArrayList<JobClassStructure_DTO> JobClassStructure_DTOs = jobClassStructureService.getSelectJobClassesByParents(ids);
		return new ResponseEntity<>(JobClassStructure_DTOs, HttpStatus.OK);
	}
	
	@GetMapping(value = "/getSelectJobClassesByParties", produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<ArrayList<JobClassStructure_DTO>> getSelectJobClassesByParties(
			@RequestBody ArrayList<Long> ids)
	{
		ArrayList<JobClassStructure_DTO> JobClassStructure_DTOs = jobClassStructureService.getSelectJobClassesByParties(ids);
		return new ResponseEntity<>(JobClassStructure_DTOs, HttpStatus.OK);
	}
	
	@GetMapping(value = "/getAllJobClassStructures", produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<ArrayList<JobClassStructure_DTO>> getAllJobClassStructures() 
	{
		ArrayList<JobClassStructure_DTO> JobClassStructure_DTOs = jobClassStructureService.getAllJobClassStructures();
		return new ResponseEntity<>(JobClassStructure_DTOs, HttpStatus.OK);
	}

	@PutMapping("/jobClassStructure")
	public void updateJobClassStructure(@RequestBody JobClassStructure_DTO jcsDTO) {
		jobClassStructureService.updJobClassStructure(jcsDTO);
	}

	@DeleteMapping("/delAllJobClassStructures")
	public void deleteAllJobClassStructures() {
		jobClassStructureService.delAllJobClassStructures();
	}

	@DeleteMapping("/delSelectJobClassStructures")
	public void deleteSelectJobClassStructures(@RequestBody ArrayList<Long> ids, @RequestBody ArrayList<Long> pids) 
	{
		jobClassStructureService.delSelectJobClassStructures(ids, pids);
	}
	
	@DeleteMapping("/delSelectJobClassStructuresByParents")
	public void deleteSelectJobClassStructuresByParents(@RequestBody ArrayList<Long> pids) 
	{
		jobClassStructureService.delSelectJobClassesByParents(pids);
	}
	
	@DeleteMapping("/delSelectJobClassStructuresByParties")
	public void deleteSelectJobClassStructuresByParties(@RequestBody ArrayList<Long> pids) 
	{
		jobClassStructureService.delSelectJobClassesByParties(pids);
	}
}