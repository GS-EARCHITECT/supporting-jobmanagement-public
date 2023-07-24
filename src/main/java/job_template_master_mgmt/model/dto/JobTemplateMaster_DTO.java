package job_template_master_mgmt.model.dto;

import java.io.Serializable;
import java.math.BigDecimal;

public class JobTemplateMaster_DTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1695546094307840011L;
	private long jobTemplateSeqNo;
	private long serviceSeqNo;
	private BigDecimal serviceCategorySeqNo;
	private String remarks;
	private String status;

	public long getJobTemplateSeqNo() {
		return jobTemplateSeqNo;
	}

	public void setJobTemplateSeqNo(long jobTemplateSeqNo) {
		this.jobTemplateSeqNo = jobTemplateSeqNo;
	}

	public long getServiceSeqNo() {
		return serviceSeqNo;
	}

	public void setServiceSeqNo(long serviceSeqNo) {
		this.serviceSeqNo = serviceSeqNo;
	}

	public BigDecimal getServiceCategorySeqNo() {
		return serviceCategorySeqNo;
	}

	public void setServiceCategorySeqNo(BigDecimal serviceCategorySeqNo) {
		this.serviceCategorySeqNo = serviceCategorySeqNo;
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

	public JobTemplateMaster_DTO(long jobTemplateSeqNo, long serviceSeqNo, BigDecimal serviceCategorySeqNo,
			String remarks, String status) {
		super();
		this.jobTemplateSeqNo = jobTemplateSeqNo;
		this.serviceSeqNo = serviceSeqNo;
		this.serviceCategorySeqNo = serviceCategorySeqNo;
		this.remarks = remarks;
		this.status = status;
	}

	public JobTemplateMaster_DTO() {
		super();
	}

}