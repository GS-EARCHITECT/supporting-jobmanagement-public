package job_structure_target_details_mgmt.controller;

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
import job_structure_target_details_mgmt.services.I_JobStructureTargetDetails_Service;

@RestController
@RequestMapping("/jobStructureTargetDetailsMgmt")
public class JobStructureTargetDetails_Controller 
{

	// private static final Logger logger =
	// LoggerFactory.getLogger(JobStructureTargetDetails_Controller.class);

	@Autowired
	private I_JobStructureTargetDetails_Service jobStructureTargetDetailsService;

	@GetMapping(value = "/getAllJobStructureTargetDetails", produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<CopyOnWriteArrayList<JobStructureTargetDetail_DTO>> getAllJobStructureTargetDetails() 
	{
		CopyOnWriteArrayList<JobStructureTargetDetail_DTO> JobStructureTargetDetail_DTOs=null;
		try {
			JobStructureTargetDetail_DTOs = jobStructureTargetDetailsService.getAllJobStructureTargetDetails();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ExecutionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return new ResponseEntity<>(JobStructureTargetDetail_DTOs, HttpStatus.OK);
	}
	
	@GetMapping(value = "/getSelectJobStructureTargetDetails", produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<CopyOnWriteArrayList<JobStructureTargetDetail_DTO>> getSelectJobStructureTargetDetails(
			@RequestBody CopyOnWriteArrayList<JobStructureTargetDetailPK> jobStructureTargetDetailsPKs) 
	{
		CopyOnWriteArrayList<JobStructureTargetDetail_DTO> JobStructureTargetDetail_DTOs=null;
		try {
			JobStructureTargetDetail_DTOs = jobStructureTargetDetailsService.getSelectJobStructureTargetDetails(jobStructureTargetDetailsPKs);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ExecutionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return new ResponseEntity<>(JobStructureTargetDetail_DTOs, HttpStatus.OK);
	}

	@GetMapping(value = "/getSelectJobStructureTargetDetailsForJobs", produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<CopyOnWriteArrayList<JobStructureTargetDetail_DTO>> getSelectJobStructureTargetDetailsForJobs(@RequestBody CopyOnWriteArrayList<Long> ids) 
	{
		CopyOnWriteArrayList<JobStructureTargetDetail_DTO> JobStructureTargetDetail_DTO=null;
		try {
			JobStructureTargetDetail_DTO = jobStructureTargetDetailsService.getSelectJobStructureTargetDetailsForJobs(ids);
		} catch (InterruptedException | ExecutionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return new ResponseEntity<>(JobStructureTargetDetail_DTO, HttpStatus.OK);
	}
}