package job_template_details_mgmt.controller;

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
import job_template_details_mgmt.model.dto.JobTemplateDetails_DTO;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
import job_template_details_mgmt.services.I_JobTemplateDetailsPublicRead_Service;

@RestController
@RequestMapping("/jobTemplateDetailsPublicReadMgmt")
public class JobTemplateDetailsPublicRead_Controller 
{

	// private static final Logger logger =
	// LoggerFactory.getLogger(JobTemplateDetails_Controller.class);

	@Autowired
	private I_JobTemplateDetailsPublicRead_Service jobTemplateDetailsPublicReadService;

	@GetMapping(value = "/getSelectJobTemplateDetails", produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<CopyOnWriteArrayList<JobTemplateDetails_DTO>> getSelectJobTemplateDetails(
			@RequestBody CopyOnWriteArrayList<Long> jobTemplateDetailsSeqNos) 
	{
		CompletableFuture<CopyOnWriteArrayList<JobTemplateDetails_DTO>> jCompletableFuture=null;
		CopyOnWriteArrayList<JobTemplateDetails_DTO> jobTemplateDetails_DTOs=null;
		try {
			
			jCompletableFuture = jobTemplateDetailsPublicReadService.getSelectJobTemplateDetails(jobTemplateDetailsSeqNos);
			jobTemplateDetails_DTOs = jCompletableFuture.get();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ExecutionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return new ResponseEntity<>(jobTemplateDetails_DTOs, HttpStatus.OK);
	}

	@GetMapping(value = "/getAllJobTemplateDetails", produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<CopyOnWriteArrayList<JobTemplateDetails_DTO>> getAllJobTemplateDetails() 
	{
		CompletableFuture<CopyOnWriteArrayList<JobTemplateDetails_DTO>> completableFuture= jobTemplateDetailsPublicReadService.getAllJobTemplateDetails();
		CopyOnWriteArrayList<JobTemplateDetails_DTO> jobTemplateDetails_DTOs=completableFuture.join();
		return new ResponseEntity<>(jobTemplateDetails_DTOs, HttpStatus.OK);
	}
}