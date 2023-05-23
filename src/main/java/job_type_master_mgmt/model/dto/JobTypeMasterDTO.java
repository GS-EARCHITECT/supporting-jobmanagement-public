package job_type_master_mgmt.model.dto;

import java.io.Serializable;

public class JobTypeMasterDTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7686655576219413071L;
	private long jobTypeSeqNo;
	private Integer jobLevelSeqNo;
	private String jobType;
	private Long masterJobTypeSeqNo;
	private String remarks;
	private String status;

	public long getJobTypeSeqNo() {
		return jobTypeSeqNo;
	}

	public void setJobTypeSeqNo(long jobTypeSeqNo) {
		this.jobTypeSeqNo = jobTypeSeqNo;
	}

	public Integer getJobLevelSeqNo() {
		return jobLevelSeqNo;
	}

	public void setJobLevelSeqNo(Integer jobLevelSeqNo) {
		this.jobLevelSeqNo = jobLevelSeqNo;
	}

	public String getJobType() {
		return jobType;
	}

	public void setJobType(String jobType) {
		this.jobType = jobType;
	}

	public Long getMasterJobTypeSeqNo() {
		return masterJobTypeSeqNo;
	}

	public void setMasterJobTypeSeqNo(Long masterJobTypeSeqNo) {
		this.masterJobTypeSeqNo = masterJobTypeSeqNo;
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

	public JobTypeMasterDTO(long jobTypeSeqNo, Integer jobLevelSeqNo, String jobType, Long masterJobTypeSeqNo,
			String remarks, String status) {
		super();
		this.jobTypeSeqNo = jobTypeSeqNo;
		this.jobLevelSeqNo = jobLevelSeqNo;
		this.jobType = jobType;
		this.masterJobTypeSeqNo = masterJobTypeSeqNo;
		this.remarks = remarks;
		this.status = status;
	}

	public JobTypeMasterDTO() {
		super();
	}

}