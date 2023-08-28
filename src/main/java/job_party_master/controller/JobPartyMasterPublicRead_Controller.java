package job_party_master.controller;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CopyOnWriteArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import job_party_master.model.dto.JobPartyMaster_DTO;
import job_party_master.services.I_JobPartyMasterPublicRead_Service;

@RestController
@RequestMapping("/jobPartyMasterPublicReadMgmt")
public class JobPartyMasterPublicRead_Controller {

	@Autowired
	private I_JobPartyMasterPublicRead_Service jobPartyMasterPublicReadService;

	@GetMapping(value = "/getSelectJobPartyMasters", produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<CopyOnWriteArrayList<JobPartyMaster_DTO>> getSelectJobPartyMasters(
			@RequestBody CopyOnWriteArrayList<Long> jobPartyMasterSeqNos) {
		CompletableFuture<CopyOnWriteArrayList<JobPartyMaster_DTO>> completableFuture = jobPartyMasterPublicReadService.getSelectJobPartyMasters(jobPartyMasterSeqNos);
		CopyOnWriteArrayList<JobPartyMaster_DTO> JobPartyMaster_DTOs = completableFuture.join();				
		return new ResponseEntity<>(JobPartyMaster_DTOs, HttpStatus.OK);
	}

	@GetMapping(value = "/getSelectJobPartyMastersByParties", produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<CopyOnWriteArrayList<JobPartyMaster_DTO>> getSelectJobPartyMastersByParties(
			@RequestBody CopyOnWriteArrayList<Long> jobPartyMasterSeqNos) {
		CompletableFuture<CopyOnWriteArrayList<JobPartyMaster_DTO>> completableFuture = jobPartyMasterPublicReadService.getSelectJobPartyMastersByParties(jobPartyMasterSeqNos);
		CopyOnWriteArrayList<JobPartyMaster_DTO> JobPartyMaster_DTOs = completableFuture.join();				
		return new ResponseEntity<>(JobPartyMaster_DTOs, HttpStatus.OK);
	}

	@GetMapping(value = "/getSelectJobPartyMastersByMasterJobs", produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<CopyOnWriteArrayList<JobPartyMaster_DTO>> getSelectJobPartyMastersByMasterJobs(
			@RequestBody CopyOnWriteArrayList<Long> jobPartyMasterSeqNos) {
		CompletableFuture<CopyOnWriteArrayList<JobPartyMaster_DTO>> completableFuture = jobPartyMasterPublicReadService.getSelectJobPartyMastersByMasterJobs(jobPartyMasterSeqNos);
		CopyOnWriteArrayList<JobPartyMaster_DTO> JobPartyMaster_DTOs = completableFuture.join();				
		return new ResponseEntity<>(JobPartyMaster_DTOs, HttpStatus.OK);
	}

	@GetMapping(value = "/getAllJobPartyMasters", produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<CopyOnWriteArrayList<JobPartyMaster_DTO>> getAllJobPartyMasters() {
		CompletableFuture<CopyOnWriteArrayList<JobPartyMaster_DTO>> completableFuture = jobPartyMasterPublicReadService.getAllJobPartyMasters();
		CopyOnWriteArrayList<JobPartyMaster_DTO> JobPartyMaster_DTOs = completableFuture.join();				
		return new ResponseEntity<>(JobPartyMaster_DTOs, HttpStatus.OK);
	}

}