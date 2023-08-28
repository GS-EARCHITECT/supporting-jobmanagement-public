package job_resource_master_mgmt.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import job_resource_master_mgmt.model.dto.JobResourceMaster_DTO;
import job_resource_master_mgmt.service.I_JobResourceMasterPublicRead_Service;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CopyOnWriteArrayList;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@RestController
@RequestMapping("/jobResourceMasterPublicReadMgmt")
public class JobResourceMasterPublicRead_Controller {

	// private static final Logger logger =
	// LoggerFactory.getLogger(JobResourceMasterPublicReadMaster_Controller.class);

	@Autowired
	private I_JobResourceMasterPublicRead_Service jobResourceMasterPublicReadServ;

	@GetMapping(value = "/getAllJobResources", produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<CopyOnWriteArrayList<JobResourceMaster_DTO>> getAllJobResources() {
		
		CompletableFuture<CopyOnWriteArrayList<JobResourceMaster_DTO>> completableFuture = jobResourceMasterPublicReadServ.getAllJobResources();
		CopyOnWriteArrayList<JobResourceMaster_DTO> resourceDTOs = completableFuture.join();
		return new ResponseEntity<>(resourceDTOs, HttpStatus.OK);
	}

	@GetMapping(value = "/getSelectJobResourcesByJobs", produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<CopyOnWriteArrayList<JobResourceMaster_DTO>> getSelectJobResourcesByJobs(
			@RequestBody CopyOnWriteArrayList<Long> jobSeqNos) {
		CompletableFuture<CopyOnWriteArrayList<JobResourceMaster_DTO>> completableFuture = jobResourceMasterPublicReadServ.getSelectJobResourcesByJobs(jobSeqNos);
		CopyOnWriteArrayList<JobResourceMaster_DTO> resourceDTOs = completableFuture.join();
		return new ResponseEntity<>(resourceDTOs, HttpStatus.OK);
	}

	@GetMapping(value = "/getSelectJobResourcesByTargets", produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<CopyOnWriteArrayList<JobResourceMaster_DTO>> getSelectJobResourcesByTargets(
			@RequestBody CopyOnWriteArrayList<Long> targetSeqNos) {
		CompletableFuture<CopyOnWriteArrayList<JobResourceMaster_DTO>> completableFuture = jobResourceMasterPublicReadServ.getSelectJobResourcesByTargets(targetSeqNos);
		CopyOnWriteArrayList<JobResourceMaster_DTO> resourceDTOs = completableFuture.join();
		return new ResponseEntity<>(resourceDTOs, HttpStatus.OK);
	}

	@GetMapping(value = "/getSelectJobResourcesByResources", produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<CopyOnWriteArrayList<JobResourceMaster_DTO>> getSelectJobResourcesByResources(
			@RequestBody CopyOnWriteArrayList<Long> rSeqNos) {
		CompletableFuture<CopyOnWriteArrayList<JobResourceMaster_DTO>> completableFuture = jobResourceMasterPublicReadServ.getSelectJobResourcesByResources(rSeqNos);
		CopyOnWriteArrayList<JobResourceMaster_DTO> resourceDTOs = completableFuture.join();
		return new ResponseEntity<>(resourceDTOs, HttpStatus.OK);
	}

}