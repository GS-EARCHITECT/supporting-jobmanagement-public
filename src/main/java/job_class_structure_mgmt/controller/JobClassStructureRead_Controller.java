package job_class_structure_mgmt.controller;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.ExecutionException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import job_class_structure_mgmt.model.dto.JobClassStructure_DTO;
import job_class_structure_mgmt.services.I_JobClassStructureRead_Service;

@RestController
@RequestMapping("/jobClassStructureReadMgmt")
public class JobClassStructureRead_Controller 
{
	@Autowired
	private I_JobClassStructureRead_Service jobClassStructureReadService;

	@GetMapping(value = "/getSelectJobClassStructures", produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<CopyOnWriteArrayList<JobClassStructure_DTO>> getSelectJobClassStructures(
			@RequestBody CopyOnWriteArrayList<Long> ids, @RequestBody CopyOnWriteArrayList<Long> pids) {
		CompletableFuture<CopyOnWriteArrayList<JobClassStructure_DTO>> jobClassStructure_DTOs = null;
		CopyOnWriteArrayList<JobClassStructure_DTO> jobClassStructureList = null;
		
		try {
			jobClassStructure_DTOs = jobClassStructureReadService.getSelectJobClassStructures(ids, pids);
			jobClassStructureList = jobClassStructure_DTOs.get();
			
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ExecutionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return new ResponseEntity<>(jobClassStructureList, HttpStatus.OK);
	}

	@GetMapping(value = "/getSelectJobClassesByParents", produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<CopyOnWriteArrayList<JobClassStructure_DTO>> getSelectJobClassesByParents(
			@RequestBody CopyOnWriteArrayList<Long> ids) {
		CompletableFuture<CopyOnWriteArrayList<JobClassStructure_DTO>> jobClassStructure_DTOs = null;
		CopyOnWriteArrayList<JobClassStructure_DTO> jobClassStructureList = null;
		
		try {
			jobClassStructure_DTOs = jobClassStructureReadService.getSelectJobClassesByParents(ids);
			jobClassStructureList = jobClassStructure_DTOs.get();
			
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ExecutionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return new ResponseEntity<>(jobClassStructureList, HttpStatus.OK);	}

	@GetMapping(value = "/getSelectJobClassesByParties", produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<CopyOnWriteArrayList<JobClassStructure_DTO>> getSelectJobClassesByParties(
			@RequestBody CopyOnWriteArrayList<Long> ids) {
		CompletableFuture<CopyOnWriteArrayList<JobClassStructure_DTO>> jobClassStructure_DTOs = null;
		CopyOnWriteArrayList<JobClassStructure_DTO> jobClassStructureList = null;
		
		try {
			jobClassStructure_DTOs = jobClassStructureReadService.getSelectJobClassesByParties(ids);
			jobClassStructureList = jobClassStructure_DTOs.get();
			
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ExecutionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return new ResponseEntity<>(jobClassStructureList, HttpStatus.OK);
		}

	@GetMapping(value = "/getAllJobClassStructures", produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<CopyOnWriteArrayList<JobClassStructure_DTO>> getAllJobClassStructures() {
		CompletableFuture<CopyOnWriteArrayList<JobClassStructure_DTO>> jobClassStructure_DTOs = null;
		CopyOnWriteArrayList<JobClassStructure_DTO> jobClassStructureList = null;
		
		try {
			jobClassStructure_DTOs = jobClassStructureReadService.getAllJobClassStructures();
			jobClassStructureList = jobClassStructure_DTOs.get();
			
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ExecutionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return new ResponseEntity<>(jobClassStructureList, HttpStatus.OK);	}

}