package job_structure_target_details_mgmt.controller;

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

import job_structure_target_details_mgmt.model.details.JobStructureTargetDetailPK;
import job_structure_target_details_mgmt.model.dto.JobStructureTargetDetail_DTO;
import job_structure_target_details_mgmt.services.I_JobStructureTargetDetailsRead_Service;
import job_target_details.model.dto.IdsList_DTO;

@RestController
@RequestMapping("/jobStructureTargetDetailsReadMgmt")
public class JobStructureTargetDetailsRead_Controller {

	// private static final Logger logger =
	// LoggerFactory.getLogger(JobStructureTargetDetails_Controller.class);

	@Autowired
	private I_JobStructureTargetDetailsRead_Service jobStructureTargetDetailsReadService;

	@GetMapping(value = "/getAllJobStructureTargetDetails", produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<CopyOnWriteArrayList<JobStructureTargetDetail_DTO>> getAllJobStructureTargetDetails() {
		CompletableFuture<CopyOnWriteArrayList<JobStructureTargetDetail_DTO>> jCompletableFuture = null;
		CopyOnWriteArrayList<JobStructureTargetDetail_DTO> jobStructureTargetDetail_DTOs = null;
		try {
			jCompletableFuture = jobStructureTargetDetailsReadService.getAllJobStructureTargetDetails();
			jobStructureTargetDetail_DTOs = jCompletableFuture.get();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ExecutionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return new ResponseEntity<>(jobStructureTargetDetail_DTOs, HttpStatus.OK);
	}

	@GetMapping(value = "/getSelectJobStructureTargetDetails", produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<CopyOnWriteArrayList<JobStructureTargetDetail_DTO>> getSelectJobStructureTargetDetails(
			@RequestBody CopyOnWriteArrayList<JobStructureTargetDetailPK> jobStructureTargetDetailsPKs) {
		CompletableFuture<CopyOnWriteArrayList<JobStructureTargetDetail_DTO>> jCompletableFuture = null;
		CopyOnWriteArrayList<JobStructureTargetDetail_DTO> jobStructureTargetDetail_DTOs = null;
		try {
			jCompletableFuture = jobStructureTargetDetailsReadService
					.getSelectJobStructureTargetDetails(jobStructureTargetDetailsPKs);
			jobStructureTargetDetail_DTOs = jCompletableFuture.get();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ExecutionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return new ResponseEntity<>(jobStructureTargetDetail_DTOs, HttpStatus.OK);
	}

	@GetMapping(value = "/getSelectJobStructureTargetDetailsForJobs", produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<CopyOnWriteArrayList<JobStructureTargetDetail_DTO>> getSelectJobStructureTargetDetailsForJobs(
			@RequestBody CopyOnWriteArrayList<Long> ids) {
		CompletableFuture<CopyOnWriteArrayList<JobStructureTargetDetail_DTO>> jCompletableFuture = null;
		CopyOnWriteArrayList<JobStructureTargetDetail_DTO> jobStructureTargetDetail_DTOs = null;
		try {
			jCompletableFuture = jobStructureTargetDetailsReadService.getSelectJobStructureTargetDetailsForJobs(ids);
			jobStructureTargetDetail_DTOs = jCompletableFuture.get();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ExecutionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return new ResponseEntity<>(jobStructureTargetDetail_DTOs, HttpStatus.OK);
	}

	
	@GetMapping(value = "/getSelectJobStructureTargetDetailsForParents", produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<CopyOnWriteArrayList<JobStructureTargetDetail_DTO>> getSelectJobStructureTargetDetailsForParents(
			@RequestBody IdsList_DTO idsList_DTO)
	{
		CopyOnWriteArrayList<Long> ids = idsList_DTO.getIds();
		CopyOnWriteArrayList<Long> tids = idsList_DTO.getTids();
		CompletableFuture<CopyOnWriteArrayList<JobStructureTargetDetail_DTO>> jCompletableFuture = null;
		CopyOnWriteArrayList<JobStructureTargetDetail_DTO> jobStructureTargetDetail_DTOs = null;
		try {
			jCompletableFuture = jobStructureTargetDetailsReadService.getSelectJobStructureTargetDetailsForParents(ids, tids);
			jobStructureTargetDetail_DTOs = jCompletableFuture.get();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ExecutionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return new ResponseEntity<>(jobStructureTargetDetail_DTOs, HttpStatus.OK);
	}

}