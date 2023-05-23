package job_type_level_master_mgmt.model.dto;

import java.io.Serializable;

public class JobTypeLevelMasterDTO implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 4932347621808917936L;
	private Long jobTypeLevelSeqNo;
	private Long jobLevel;
	private String remarks;
	private String status;

	public Long getJobTypeLevelSeqNo() {
		return jobTypeLevelSeqNo;
	}

	public void setJobTypeLevelSeqNo(Long jobTypeLevelSeqNo) {
		this.jobTypeLevelSeqNo = jobTypeLevelSeqNo;
	}

	public Long getJobLevel() {
		return jobLevel;
	}

	public void setJobLevel(Long jobLevel) {
		this.jobLevel = jobLevel;
	}

	public String getRemarks() {
		return remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public JobTypeLevelMasterDTO(Long jobTypeLevelSeqNo, Long jobLevel, String remarks, String status) {
		super();
		this.jobTypeLevelSeqNo = jobTypeLevelSeqNo;
		this.jobLevel = jobLevel;
		this.remarks = remarks;
		this.status = status;
	}

	public JobTypeLevelMasterDTO() {
		super();
	}

}