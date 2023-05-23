package job_details_mgmt.model.dto;

import java.io.Serializable;

public class JobDetailsDTO implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 3431763572172440976L;
	private long jobSeqNo;
	private long seqNo;
	private Long jobTemplateSeqNo;
	private Long targetSeqNo;
	private String actEndDate;
	private String actStartDate;
	private Long jobTypeSeqNo;
	private Long managerSeqNo;
	private Long parentJobSeqNo;
	private String planEndDate;
	private String planStartDate;
	private Long serviceWorkSeqNo;
	private String remarks;
	private String status;

	public long getJobSeqNo() {
		return jobSeqNo;
	}

	public void setJobSeqNo(long jobSeqNo) {
		this.jobSeqNo = jobSeqNo;
	}

	public String getActEndDate() {
		return actEndDate;
	}

	public void setActEndDate(String actEndDate) {
		this.actEndDate = actEndDate;
	}

	public String getActStartDate() {
		return actStartDate;
	}

	public void setActStartDate(String actStartDate) {
		this.actStartDate = actStartDate;
	}

	public Long getJobTypeSeqNo() {
		return jobTypeSeqNo;
	}

	public void setJobTypeSeqNo(Long jobTypeSeqNo) {
		this.jobTypeSeqNo = jobTypeSeqNo;
	}

	public Long getManagerSeqNo() {
		return managerSeqNo;
	}

	public void setManagerSeqNo(Long managerSeqNo) {
		this.managerSeqNo = managerSeqNo;
	}

	public Long getParentJobSeqNo() {
		return parentJobSeqNo;
	}

	public void setParentJobSeqNo(Long parentJobSeqNo) {
		this.parentJobSeqNo = parentJobSeqNo;
	}

	public String getPlanEndDate() {
		return planEndDate;
	}

	public void setPlanEndDate(String planEndDate) {
		this.planEndDate = planEndDate;
	}

	public String getPlanStartDate() {
		return planStartDate;
	}

	public void setPlanStartDate(String planStartDate) {
		this.planStartDate = planStartDate;
	}

	public Long getServiceWorkSeqNo() {
		return serviceWorkSeqNo;
	}

	public void setServiceWorkSeqNo(Long serviceWorkSeqNo) {
		this.serviceWorkSeqNo = serviceWorkSeqNo;
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

	public Long getJobTemplateSeqNo() {
		return jobTemplateSeqNo;
	}

	public void setJobTemplateSeqNo(Long jobTemplateSeqNo) {
		this.jobTemplateSeqNo = jobTemplateSeqNo;
	}

	public JobDetailsDTO() {
		super();
	}

	public Long getTargetSeqNo() {
		return targetSeqNo;
	}

	public void setTargetSeqNo(Long targetSeqNo) {
		this.targetSeqNo = targetSeqNo;
	}

	public long getSeqNo() {
		return seqNo;
	}

	public void setSeqNo(long seqNo) {
		this.seqNo = seqNo;
	}

	public JobDetailsDTO(long jobSeqNo, long seqNo, Long jobTemplateSeqNo, Long targetSeqNo, String actEndDate,
			String actStartDate, Long jobTypeSeqNo, Long managerSeqNo, Long parentJobSeqNo, String planEndDate,
			String planStartDate, Long serviceWorkSeqNo, String remarks, String status) {
		super();
		this.jobSeqNo = jobSeqNo;
		this.seqNo = seqNo;
		this.jobTemplateSeqNo = jobTemplateSeqNo;
		this.targetSeqNo = targetSeqNo;
		this.actEndDate = actEndDate;
		this.actStartDate = actStartDate;
		this.jobTypeSeqNo = jobTypeSeqNo;
		this.managerSeqNo = managerSeqNo;
		this.parentJobSeqNo = parentJobSeqNo;
		this.planEndDate = planEndDate;
		this.planStartDate = planStartDate;
		this.serviceWorkSeqNo = serviceWorkSeqNo;
		this.remarks = remarks;
		this.status = status;
	}

}