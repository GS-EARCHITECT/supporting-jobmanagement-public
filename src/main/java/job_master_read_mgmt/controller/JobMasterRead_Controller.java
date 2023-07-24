package job_master_read_mgmt.controller;

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
import job_master_read_mgmt.model.dto.JobMaster_DTO;
import job_master_read_mgmt.services.I_JobMasterRead_Service;

@RestController
@RequestMapping("/jobMasterReadMgmt")
public class JobMasterRead_Controller {
	@Autowired
	private I_JobMasterRead_Service jobMasterReadService;

	@GetMapping(value = "/getSelectJobMasters", produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<CopyOnWriteArrayList<JobMaster_DTO>> getSelectJobMasters(
			@RequestBody CopyOnWriteArrayList<Long> jobMasterSeqNos) {
		CopyOnWriteArrayList<JobMaster_DTO> JobMaster_DTOs = null;
		try {
			JobMaster_DTOs = jobMasterReadService.getSelectJobMasters(jobMasterSeqNos);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ExecutionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return new ResponseEntity<>(JobMaster_DTOs, HttpStatus.OK);
	}

	@GetMapping(value = "/getSelectJobMastersByParties", produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<CopyOnWriteArrayList<JobMaster_DTO>> getSelectJobMastersByParties(
			@RequestBody CopyOnWriteArrayList<Long> jobMasterSeqNos) {
		CopyOnWriteArrayList<JobMaster_DTO> JobMaster_DTOs = null;
		try {
			JobMaster_DTOs = jobMasterReadService.getSelectJobMastersByParties(jobMasterSeqNos);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ExecutionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return new ResponseEntity<>(JobMaster_DTOs, HttpStatus.OK);
	}

	@GetMapping(value = "/getAllJobMasters", produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<CopyOnWriteArrayList<JobMaster_DTO>> getAllJobMasters() {
		CopyOnWriteArrayList<JobMaster_DTO> JobMaster_DTOs = null;
		try {
			JobMaster_DTOs = jobMasterReadService.getAllJobMasters();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ExecutionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return new ResponseEntity<>(JobMaster_DTOs, HttpStatus.OK);
	}

}