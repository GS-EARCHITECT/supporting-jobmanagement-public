package job_asset_master_mgmt.controller;

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
import job_asset_master_mgmt.model.dto.JobAssetMaster_DTO;
import job_asset_master_mgmt.model.master.JobAssetMasterPK;
import job_asset_master_mgmt.service.I_JobAssetMasterPublicRead_Service;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@RestController
@RequestMapping("/jobAssetMasterPublicReadMgmt")
public class JobAssetMasterPublicRead_Controller {

	// private static final Logger logger =
	// LoggerFactory.getLogger(JobAssetMasterPublicReadMaster_Controller.class);

	@Autowired
	private I_JobAssetMasterPublicRead_Service jobAssetMasterPublicReadServ;

	@GetMapping(value = "/getAllJobAssets", produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<CopyOnWriteArrayList<JobAssetMaster_DTO>> getAllJobAssets() {
		CompletableFuture<CopyOnWriteArrayList<JobAssetMaster_DTO>> completableFuture = jobAssetMasterPublicReadServ
				.getAllJobAssets();
		CopyOnWriteArrayList<JobAssetMaster_DTO> assetDTOs = completableFuture.join();
		return new ResponseEntity<>(assetDTOs, HttpStatus.OK);
	}

	@GetMapping(value = "/getSelectJobAssets", produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<CopyOnWriteArrayList<JobAssetMaster_DTO>> getSelectJobAssets(
			@RequestBody CopyOnWriteArrayList<JobAssetMasterPK> jobAssetMasterPKs) {
		CompletableFuture<CopyOnWriteArrayList<JobAssetMaster_DTO>> completableFuture = jobAssetMasterPublicReadServ
				.getSelectJobAssets(jobAssetMasterPKs);
		CopyOnWriteArrayList<JobAssetMaster_DTO> assetDTOs = completableFuture.join();
		return new ResponseEntity<>(assetDTOs, HttpStatus.OK);
	}

	@GetMapping(value = "/getSelectJobAssetsByJobs", produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<CopyOnWriteArrayList<JobAssetMaster_DTO>> getSelectJobAssetsByJobs(
			@RequestBody CopyOnWriteArrayList<Long> ids) {
		CompletableFuture<CopyOnWriteArrayList<JobAssetMaster_DTO>> completableFuture = jobAssetMasterPublicReadServ
				.getSelectJobAssetsByJobs(ids);
		CopyOnWriteArrayList<JobAssetMaster_DTO> assetDTOs = completableFuture.join();
		return new ResponseEntity<>(assetDTOs, HttpStatus.OK);
	}

	@GetMapping(value = "/getSelectJobAssetsByTargets", produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<CopyOnWriteArrayList<JobAssetMaster_DTO>> getSelectJobAssetsByTargets(
			@RequestBody CopyOnWriteArrayList<Long> ids) {
		CompletableFuture<CopyOnWriteArrayList<JobAssetMaster_DTO>> completableFuture = jobAssetMasterPublicReadServ
				.getSelectJobAssetsByTargets(ids);
		CopyOnWriteArrayList<JobAssetMaster_DTO> assetDTOs = completableFuture.join();
		return new ResponseEntity<>(assetDTOs, HttpStatus.OK);
	}

	@GetMapping(value = "/getSelectJobAssetsByAssets", produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<CopyOnWriteArrayList<JobAssetMaster_DTO>> getSelectJobAssetsByAssets(
			@RequestBody CopyOnWriteArrayList<Long> ids) {
		CompletableFuture<CopyOnWriteArrayList<JobAssetMaster_DTO>> completableFuture = jobAssetMasterPublicReadServ
				.getSelectJobAssetsByAssets(ids);
		CopyOnWriteArrayList<JobAssetMaster_DTO> assetDTOs = completableFuture.join();
		return new ResponseEntity<>(assetDTOs, HttpStatus.OK);
	}

}