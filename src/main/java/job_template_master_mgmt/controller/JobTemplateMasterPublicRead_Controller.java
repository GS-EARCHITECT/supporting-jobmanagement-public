package job_template_master_mgmt.controller;

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
import job_template_master_mgmt.model.dto.JobTemplateMaster_DTO;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
import job_template_master_mgmt.services.I_JobTemplateMasterPublicRead_Service;

@RestController
@RequestMapping("/jobTemplateMasterPublicReadMgmt")
public class JobTemplateMasterPublicRead_Controller 
{

	// private static final Logger logger =
	// LoggerFactory.getLogger(JobTemplateMaster_Controller.class);

	@Autowired
	private I_JobTemplateMasterPublicRead_Service jobTemplateMasterPublicReadService;

	@GetMapping(value = "/getSelectJobTemplateMasters", produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<CopyOnWriteArrayList<JobTemplateMaster_DTO>> getSelectJobTemplateMasters(
			@RequestBody CopyOnWriteArrayList<Long> jobTemplateMasterSeqNos) 
	{
		CompletableFuture<CopyOnWriteArrayList<JobTemplateMaster_DTO>> completableFuture = jobTemplateMasterPublicReadService.getSelectJobTemplateMasters(jobTemplateMasterSeqNos);
		CopyOnWriteArrayList<JobTemplateMaster_DTO> jobTemplateMaster_DTOs=completableFuture.join();
		return new ResponseEntity<>(jobTemplateMaster_DTOs, HttpStatus.OK);
	}

	@GetMapping(value = "/getAllJobTemplateMasters", produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<CopyOnWriteArrayList<JobTemplateMaster_DTO>> getAllJobTemplateMasters() 
	{
		CompletableFuture<CopyOnWriteArrayList<JobTemplateMaster_DTO>> completableFuture = jobTemplateMasterPublicReadService.getAllJobTemplateMasters();
		CopyOnWriteArrayList<JobTemplateMaster_DTO> jobTemplateMaster_DTOs=completableFuture.join();
		return new ResponseEntity<>(jobTemplateMaster_DTOs, HttpStatus.OK);
		}
	
}