package job_structure_details_mgmt.model.dto;

import java.io.Serializable;

public class JobStructureDetail_DTO implements Serializable 
{

	/**
	 * 
	 */
	private static final long serialVersionUID = 3291443518283566129L;
	private Long jobClassSeqNo;
	private Long parJobSeqNo;
	private Long jobSeqNo;

	public Long getJobClassSeqNo() {
		return jobClassSeqNo;
	}

	public void setJobClassSeqNo(Long jobClassSeqNo) {
		this.jobClassSeqNo = jobClassSeqNo;
	}

	public Long getParJobSeqNo() {
		return parJobSeqNo;
	}

	public void setParJobSeqNo(Long parJobSeqNo) {
		this.parJobSeqNo = parJobSeqNo;
	}

	public Long getJobSeqNo() {
		return jobSeqNo;
	}

	public void setJobSeqNo(Long jobSeqNo) {
		this.jobSeqNo = jobSeqNo;
	}

	public JobStructureDetail_DTO(Long jobClassSeqNo, Long parJobSeqNo, Long jobSeqNo) {
		super();
		this.jobClassSeqNo = jobClassSeqNo;
		this.parJobSeqNo = parJobSeqNo;
		this.jobSeqNo = jobSeqNo;
	}

	public JobStructureDetail_DTO() {
		super();
	}

}