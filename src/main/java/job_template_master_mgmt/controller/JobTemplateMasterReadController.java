package job_template_master_mgmt.controller;

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

import job_template_master_mgmt.model.dto.JobTemplateMaster_DTO;
import job_template_master_mgmt.services.I_JobTemplateMasterReadService;

//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;

@RestController
@RequestMapping("/jobTemplateMasterReadMgmt")
public class JobTemplateMasterReadController 
{

	// private static final Logger logger =
	// LoggerFactory.getLogger(JobTemplateMaster_Controller.class);

	@Autowired
	private I_JobTemplateMasterReadService jobTemplateMasterReadService;

	@GetMapping(value = "/getSelectJobTemplateMasters", produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<CopyOnWriteArrayList<JobTemplateMaster_DTO>> getSelectJobTemplateMasters(
			@RequestBody CopyOnWriteArrayList<Long> jobTemplateMasterSeqNos) 
	{
		CompletableFuture<CopyOnWriteArrayList<JobTemplateMaster_DTO>> jCompletableFuture = null;
		CopyOnWriteArrayList<JobTemplateMaster_DTO> jobTemplateMaster_DTOs=null;
		try {
			jCompletableFuture = jobTemplateMasterReadService.getSelectJobTemplateMasters(jobTemplateMasterSeqNos);
			jobTemplateMaster_DTOs = jCompletableFuture.get();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ExecutionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return new ResponseEntity<>(jobTemplateMaster_DTOs, HttpStatus.OK);
	}

	@GetMapping(value = "/getAllJobTemplateMasters", produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<CopyOnWriteArrayList<JobTemplateMaster_DTO>> getAllJobTemplateMasters() {
		CompletableFuture<CopyOnWriteArrayList<JobTemplateMaster_DTO>> jCompletableFuture = null;
		CopyOnWriteArrayList<JobTemplateMaster_DTO> jobTemplateMaster_DTOs=null;
		try {
			jCompletableFuture = jobTemplateMasterReadService.getAllJobTemplateMasters();
			jobTemplateMaster_DTOs = jCompletableFuture.get();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ExecutionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return new ResponseEntity<>(jobTemplateMaster_DTOs, HttpStatus.OK);
		}
	
}