package job_class_structure_read_mgmt.controller;

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
import job_class_structure_read_mgmt.model.dto.JobClassStructure_DTO;
import job_class_structure_read_mgmt.services.I_JobClassStructureRead_Service;

@RestController
@RequestMapping("/jobClassStructureReadMgmt")
public class JobClassStructureRead_Controller 
{
	@Autowired
	private I_JobClassStructureRead_Service jobClassStructureReadService;

	@GetMapping(value = "/getSelectJobClassStructures", produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<CopyOnWriteArrayList<JobClassStructure_DTO>> getSelectJobClassStructures(
			@RequestBody CopyOnWriteArrayList<Long> ids, @RequestBody CopyOnWriteArrayList<Long> pids) {
		CopyOnWriteArrayList<JobClassStructure_DTO> JobClassStructure_DTOs = null;
		try {
			JobClassStructure_DTOs = jobClassStructureReadService.getSelectJobClassStructures(ids, pids);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ExecutionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return new ResponseEntity<>(JobClassStructure_DTOs, HttpStatus.OK);
	}

	@GetMapping(value = "/getSelectJobClassesByParents", produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<CopyOnWriteArrayList<JobClassStructure_DTO>> getSelectJobClassesByParents(
			@RequestBody CopyOnWriteArrayList<Long> ids) {
		CopyOnWriteArrayList<JobClassStructure_DTO> JobClassStructure_DTOs = null;
		try {
			JobClassStructure_DTOs = jobClassStructureReadService.getSelectJobClassesByParents(ids);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ExecutionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return new ResponseEntity<>(JobClassStructure_DTOs, HttpStatus.OK);
	}

	@GetMapping(value = "/getSelectJobClassesByParties", produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<CopyOnWriteArrayList<JobClassStructure_DTO>> getSelectJobClassesByParties(
			@RequestBody CopyOnWriteArrayList<Long> ids) {
		CopyOnWriteArrayList<JobClassStructure_DTO> JobClassStructure_DTOs = null;
		try {
			JobClassStructure_DTOs = jobClassStructureReadService.getSelectJobClassesByParties(ids);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ExecutionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return new ResponseEntity<>(JobClassStructure_DTOs, HttpStatus.OK);
	}

	@GetMapping(value = "/getAllJobClassStructures", produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<CopyOnWriteArrayList<JobClassStructure_DTO>> getAllJobClassStructures() {
		CopyOnWriteArrayList<JobClassStructure_DTO> JobClassStructure_DTOs = null;
		try {
			JobClassStructure_DTOs = jobClassStructureReadService.getAllJobClassStructures();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ExecutionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return new ResponseEntity<>(JobClassStructure_DTOs, HttpStatus.OK);
	}

}