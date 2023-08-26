package job_class_structure_mgmt.model.dto;

import java.io.Serializable;

public class JobClassStructure_DTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8859762622510698877L;
	private Long jobClassSeqNo;
	private Long parJobClassSeqNo;
	private Long partySeqNo;

	public Long getJobClassSeqNo() {
		return jobClassSeqNo;
	}

	public void setJobClassSeqNo(Long jobClassSeqNo) {
		this.jobClassSeqNo = jobClassSeqNo;
	}

	public Long getParJobClassSeqNo() {
		return parJobClassSeqNo;
	}

	public void setParJobClassSeqNo(Long parJobClassSeqNo) {
		this.parJobClassSeqNo = parJobClassSeqNo;
	}

	public Long getPartySeqNo() {
		return partySeqNo;
	}

	public void setPartySeqNo(Long partySeqNo) {
		this.partySeqNo = partySeqNo;
	}

	public JobClassStructure_DTO(Long jobClassSeqNo, Long parJobClassSeqNo, Long partySeqNo) {
		super();
		this.jobClassSeqNo = jobClassSeqNo;
		this.parJobClassSeqNo = parJobClassSeqNo;
		this.partySeqNo = partySeqNo;
	}

	public JobClassStructure_DTO() {
		super();
	}

}