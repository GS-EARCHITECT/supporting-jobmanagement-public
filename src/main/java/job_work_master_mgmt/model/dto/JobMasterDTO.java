package job_work_master_mgmt.model.dto;

import java.io.Serializable;
import java.math.BigDecimal;

public class JobMasterDTO implements Serializable {
	private static final long serialVersionUID = 1L;
	private long serviceWorkSeqNo;
	private Long companySeqNo;
	private String createdOn;
	private Long jobTemplateSeqNo;
	private Long managerSeqNo;
	private Long serviceSeqNo;
	private String jobRefId;
	private Character schType;
	private Character schFlag;
	private BigDecimal opFlag;

	public String getJobRefId() {
		return jobRefId;
	}

	public void setJobRefId(String jobRefId) {
		this.jobRefId = jobRefId;
	}

	public long getServiceWorkSeqNo() {
		return serviceWorkSeqNo;
	}

	public void setServiceWorkSeqNo(long serviceWorkSeqNo) {
		this.serviceWorkSeqNo = serviceWorkSeqNo;
	}

	public Long getCompanySeqNo() {
		return companySeqNo;
	}

	public void setCompanySeqNo(Long companySeqNo) {
		this.companySeqNo = companySeqNo;
	}

	public String getCreatedOn() {
		return createdOn;
	}

	public void setCreatedOn(String createdOn) {
		this.createdOn = createdOn;
	}

	public Long getJobTemplateSeqNo() {
		return jobTemplateSeqNo;
	}

	public void setJobTemplateSeqNo(Long jobTemplateSeqNo) {
		this.jobTemplateSeqNo = jobTemplateSeqNo;
	}

	public Long getManagerSeqNo() {
		return managerSeqNo;
	}

	public void setManagerSeqNo(Long managerSeqNo) {
		this.managerSeqNo = managerSeqNo;
	}

	public Long getServiceSeqNo() {
		return serviceSeqNo;
	}

	public void setServiceSeqNo(Long serviceSeqNo) {
		this.serviceSeqNo = serviceSeqNo;
	}

	public JobMasterDTO() {
		super();
	}

	public Character getSchType() {
		return schType;
	}

	public void setSchType(Character schType) {
		this.schType = schType;
	}

	public Character getSchFlag() {
		return schFlag;
	}

	public void setSchFlag(Character schFlag) {
		this.schFlag = schFlag;
	}

	public BigDecimal getOpFlag() {
		return opFlag;
	}

	public void setOpFlag(BigDecimal opFlag) {
		this.opFlag = opFlag;
	}

	public JobMasterDTO(long serviceWorkSeqNo, Long companySeqNo, String createdOn, Long jobTemplateSeqNo,
			Long managerSeqNo, Long serviceSeqNo, String jobRefId, Character schType, Character schFlag,
			BigDecimal opFlag) {
		super();
		this.serviceWorkSeqNo = serviceWorkSeqNo;
		this.companySeqNo = companySeqNo;
		this.createdOn = createdOn;
		this.jobTemplateSeqNo = jobTemplateSeqNo;
		this.managerSeqNo = managerSeqNo;
		this.serviceSeqNo = serviceSeqNo;
		this.jobRefId = jobRefId;
		this.schType = schType;
		this.schFlag = schFlag;
		this.opFlag = opFlag;
	}

}