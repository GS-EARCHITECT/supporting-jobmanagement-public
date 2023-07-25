package job_class_master_read_mgmt.controller;

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

import job_class_master_read_mgmt.model.dto.JobClassMaster_DTO;
import job_class_master_read_mgmt.services.I_JobClassMasterRead_Service;

@RestController
@RequestMapping("/jobClassMasterReadMgmt")
public class JobClassMasterRead_Controller 
{
	@Autowired
	private I_JobClassMasterRead_Service jobClassMasterReadService;

	@GetMapping(value = "/getSelectJobClasses", produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<CopyOnWriteArrayList<JobClassMaster_DTO>> getSelectJobClassMasters(
			@RequestBody CopyOnWriteArrayList<Long> jobClassMasterSeqNos) {
		CompletableFuture<CopyOnWriteArrayList<JobClassMaster_DTO>> jobClassMaster_DTOs=null;
		CopyOnWriteArrayList<JobClassMaster_DTO> jobClassMasterList=null;
		try {
			jobClassMaster_DTOs = jobClassMasterReadService.getSelectJobClasses(jobClassMasterSeqNos);
			jobClassMasterList=jobClassMaster_DTOs.get();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ExecutionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return new ResponseEntity<>(jobClassMasterList, HttpStatus.OK);
	}

	@GetMapping(value = "/getAllJobClasses", produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<CopyOnWriteArrayList<JobClassMaster_DTO>> getAllJobClassMasters() 
	{
		CompletableFuture<CopyOnWriteArrayList<JobClassMaster_DTO>> jobClassMaster_DTOs=null;
		CopyOnWriteArrayList<JobClassMaster_DTO> jobClassMasterList=null;
		try {
			jobClassMaster_DTOs = jobClassMasterReadService.getAllJobClasses();
			jobClassMasterList=jobClassMaster_DTOs.get();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ExecutionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return new ResponseEntity<>(jobClassMasterList, HttpStatus.OK);
	}

	}