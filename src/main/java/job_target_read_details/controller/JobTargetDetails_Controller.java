package job_target_read_details.controller;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.ExecutionException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
import job_target_read_details.model.dto.JobTargetDetail_DTO;
import job_target_read_details.model.master.JobTargetDetailPK;
import job_target_read_details.services.I_JobTargetDetailsRead_Service;


@RestController
@RequestMapping("/jobTargetDetailsReadMgmt")
public class JobTargetDetails_Controller 
{

	// private static final Logger logger =
	// LoggerFactory.getLogger(JobTargetDetails_Controller.class);

	@Autowired
	private I_JobTargetDetailsRead_Service jobTargetDetailsReadService;

	@GetMapping(value = "/getSelectJobTargetDetails", produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<CopyOnWriteArrayList<JobTargetDetail_DTO>> getSelectJobTargetDetails(
			@RequestBody CopyOnWriteArrayList<Long> jobTargetDetailsSeqNos) 
	{
		CompletableFuture<CopyOnWriteArrayList<JobTargetDetail_DTO>> jobTargetDetail_DTOs = null;
		CopyOnWriteArrayList<JobTargetDetail_DTO> jobTargetDetailList = null;
		try {
			jobTargetDetail_DTOs = jobTargetDetailsReadService.getSelectJobTargetDetails(jobTargetDetailsSeqNos);
			jobTargetDetailList = jobTargetDetail_DTOs.get();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ExecutionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return new ResponseEntity<>(jobTargetDetailList, HttpStatus.OK);
	}

	@GetMapping(value = "/getAllJobTargetDetailsByIds", produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<CopyOnWriteArrayList<JobTargetDetail_DTO>> getAllJobTargetDetailsByIds(@RequestBody CopyOnWriteArrayList<JobTargetDetailPK> jobTargetDetailsPks) 
	{
		CompletableFuture<CopyOnWriteArrayList<JobTargetDetail_DTO>> jobTargetDetail_DTOs = null;
		CopyOnWriteArrayList<JobTargetDetail_DTO> jobTargetDetailList = null;
		try {
			jobTargetDetail_DTOs = jobTargetDetailsReadService.getAllJobTargetDetailsByIds(jobTargetDetailsPks);
			jobTargetDetailList = jobTargetDetail_DTOs.get();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ExecutionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return new ResponseEntity<>(jobTargetDetailList, HttpStatus.OK);
	}

	@GetMapping(value = "/getJobDurDays/{jobSeqNo}", produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<Integer> getJobDurDays(@PathVariable Long jobSeqNo) 
	{
		CompletableFuture<Integer> completableFuture = null;
		Integer jobDur = 0;
		try {
			completableFuture = jobTargetDetailsReadService.getJobDurDays(jobSeqNo);
			jobDur = completableFuture.get();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ExecutionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return new ResponseEntity<>(jobDur, HttpStatus.OK);
	}
	
	@GetMapping(value = "/getJobDurHours/{jobSeqNo}", produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<Integer> getJobDurHours(@PathVariable Long jobSeqNo) 
	{
		CompletableFuture<Integer> completableFuture = null;
		Integer jobDur = 0;
		try {
			completableFuture = jobTargetDetailsReadService.getJobDurHours(jobSeqNo);
			jobDur = completableFuture.get();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ExecutionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return new ResponseEntity<>(jobDur, HttpStatus.OK);
	}
	
	@GetMapping(value = "/getJobDurSeconds/{jobSeqNo}", produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<Integer> getJobDurSeconds(@PathVariable Long jobSeqNo) 
	{
		CompletableFuture<Integer> completableFuture = null;
		Integer jobDur = 0;
		try {
			completableFuture = jobTargetDetailsReadService.getJobDurSeconds(jobSeqNo);
			jobDur = completableFuture.get();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ExecutionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return new ResponseEntity<>(jobDur, HttpStatus.OK);
	}
	
	@GetMapping(value = "/getJobDurMinutes/{jobSeqNo}", produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<Integer> getJobDurMinutes(@PathVariable Long jobSeqNo) 
	{
		CompletableFuture<Integer> completableFuture = null;
		Integer jobDur = 0;
		try {
			completableFuture = jobTargetDetailsReadService.getJobDurMinutes(jobSeqNo);
			jobDur = completableFuture.get();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ExecutionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return new ResponseEntity<>(jobDur, HttpStatus.OK);
	}
	
	@GetMapping(value = "/getJobDurWeeks/{jobSeqNo}", produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<Integer> getJobDurWeeks(@PathVariable Long jobSeqNo) 
	{
		CompletableFuture<Integer> completableFuture = null;
		Integer jobDur = 0;
		try {
			completableFuture = jobTargetDetailsReadService.getJobDurWeeks(jobSeqNo);
			jobDur = completableFuture.get();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ExecutionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return new ResponseEntity<>(jobDur, HttpStatus.OK);
	}

	@GetMapping(value = "/getJobDurMonths/{jobSeqNo}", produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<Integer> getJobDurMonths(@PathVariable Long jobSeqNo) 
	{
		CompletableFuture<Integer> completableFuture = null;
		Integer jobDur = 0;
		try {
			completableFuture = jobTargetDetailsReadService.getJobDurMonths(jobSeqNo);
			jobDur = completableFuture.get();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ExecutionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return new ResponseEntity<>(jobDur, HttpStatus.OK);
	}

	@GetMapping(value = "/getAllJobTargetDetails", produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<CopyOnWriteArrayList<JobTargetDetail_DTO>> getAllJobTargetDetails() 
	{
		CompletableFuture<CopyOnWriteArrayList<JobTargetDetail_DTO>> jobTargetDetail_DTOs = null;
		CopyOnWriteArrayList<JobTargetDetail_DTO> jobTargetDetailList = null;
		try {
			jobTargetDetail_DTOs = jobTargetDetailsReadService.getAllJobTargetDetails();
			jobTargetDetailList = jobTargetDetail_DTOs.get();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ExecutionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return new ResponseEntity<>(jobTargetDetailList, HttpStatus.OK);
	}

}