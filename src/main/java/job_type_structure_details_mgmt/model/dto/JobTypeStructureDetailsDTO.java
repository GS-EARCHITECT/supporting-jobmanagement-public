package job_type_structure_details_mgmt.model.dto;

import java.io.Serializable;

public class JobTypeStructureDetailsDTO implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -6605676229812565980L;
	private long jobTypeSeqNo;
	private long parJobTypeSeqNo;
	private String remarks;
	private String status;
	private Integer seqNo;
	private long parTargetSeqNo;
	private long targetSeqNo;

	public long getJobTypeSeqNo() {
		return jobTypeSeqNo;
	}

	public void setJobTypeSeqNo(long jobTypeSeqNo) {
		this.jobTypeSeqNo = jobTypeSeqNo;
	}

	public long getParJobTypeSeqNo() {
		return parJobTypeSeqNo;
	}

	public void setParJobTypeSeqNo(long parJobTypeSeqNo) {
		this.parJobTypeSeqNo = parJobTypeSeqNo;
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

	public Integer getSeqNo() {
		return seqNo;
	}

	public void setSeqNo(Integer seqNo) {
		this.seqNo = seqNo;
	}

	public long getParTargetSeqNo() {
		return parTargetSeqNo;
	}

	public void setParTargetSeqNo(long parTargetSeqNo) {
		this.parTargetSeqNo = parTargetSeqNo;
	}

	public long getTargetSeqNo() {
		return targetSeqNo;
	}

	public void setTargetSeqNo(long targetSeqNo) {
		this.targetSeqNo = targetSeqNo;
	}

	public JobTypeStructureDetailsDTO(long jobTypeSeqNo, long parJobTypeSeqNo, String remarks, String status,
			Integer seqNo, long parTargetSeqNo, long targetSeqNo) {
		super();
		this.jobTypeSeqNo = jobTypeSeqNo;
		this.parJobTypeSeqNo = parJobTypeSeqNo;
		this.remarks = remarks;
		this.status = status;
		this.seqNo = seqNo;
		this.parTargetSeqNo = parTargetSeqNo;
		this.targetSeqNo = targetSeqNo;
	}

	public JobTypeStructureDetailsDTO() {
		super();
	}

}