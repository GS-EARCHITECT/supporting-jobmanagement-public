package job_template_details_mgmt.controller;

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
import job_template_details_mgmt.services.I_JobTemplateDetailsService;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;

@RestController
@RequestMapping("/jobTemplateDetailsMgmt")
public class JobTemplateDetailsController {

	// private static final Logger logger =
	// LoggerFactory.getLogger(JobTemplateDetails_Controller.class);

	@Autowired
	private I_JobTemplateDetailsService jobTemplateDetailsService;

	@GetMapping(value = "/getSelectJobTemplateDetails", produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<CopyOnWriteArrayList<JobTemplateDetails_DTO>> getSelectJobTemplateDetails(
			@RequestBody CopyOnWriteArrayList<Long> jobTemplateDetailsSeqNos) {
		CopyOnWriteArrayList<JobTemplateDetails_DTO> JobTemplateDetails_DTOs=null;
		try {
			JobTemplateDetails_DTOs = jobTemplateDetailsService
					.getSelectJobTemplateDetails(jobTemplateDetailsSeqNos);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ExecutionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return new ResponseEntity<>(JobTemplateDetails_DTOs, HttpStatus.OK);
	}

	@GetMapping(value = "/getAllJobTemplateDetails", produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<CopyOnWriteArrayList<JobTemplateDetails_DTO>> getAllJobTemplateDetails() {
		CopyOnWriteArrayList<JobTemplateDetails_DTO> JobTemplateDetails_DTOs=null;
		try {
			JobTemplateDetails_DTOs = jobTemplateDetailsService.getAllJobTemplateDetails();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ExecutionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return new ResponseEntity<>(JobTemplateDetails_DTOs, HttpStatus.OK);
	}
}