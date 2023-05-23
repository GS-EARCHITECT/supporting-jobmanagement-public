package job_template_master_mgmt.model.master;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.*;

/**
 * The primary key class for the JOB_TEMPLATE_MASTER database table.
 * 
 */
@Embeddable
public class JobTemplateMasterPK implements Serializable {
	// default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(name = "JOB_TEMPLATE_SEQ_NO")
	private long jobTemplateSeqNo;

	@Column(name = "SERVICE_SEQ_NO")
	private long serviceSeqNo;

	@Column(name = "SERVICE_CATEGORY_SEQ_NO")
	private BigDecimal serviceCategorySeqNo;

	public JobTemplateMasterPK() {
	}

	public long getJobTemplateSeqNo() {
		return this.jobTemplateSeqNo;
	}

	public void setJobTemplateSeqNo(long jobTemplateSeqNo) {
		this.jobTemplateSeqNo = jobTemplateSeqNo;
	}

	public long getServiceSeqNo() {
		return this.serviceSeqNo;
	}

	public void setServiceSeqNo(long serviceSeqNo) {
		this.serviceSeqNo = serviceSeqNo;
	}

	public BigDecimal getServiceCategorySeqNo() {
		return this.serviceCategorySeqNo;
	}

	public void setServiceCategorySeqNo(BigDecimal serviceCategorySeqNo) {
		this.serviceCategorySeqNo = serviceCategorySeqNo;
	}

	public JobTemplateMasterPK(long jobTemplateSeqNo, long serviceSeqNo, BigDecimal serviceCategorySeqNo) {
		super();
		this.jobTemplateSeqNo = jobTemplateSeqNo;
		this.serviceSeqNo = serviceSeqNo;
		this.serviceCategorySeqNo = serviceCategorySeqNo;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (jobTemplateSeqNo ^ (jobTemplateSeqNo >>> 32));
		result = prime * result + ((serviceCategorySeqNo == null) ? 0 : serviceCategorySeqNo.hashCode());
		result = prime * result + (int) (serviceSeqNo ^ (serviceSeqNo >>> 32));
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		JobTemplateMasterPK other = (JobTemplateMasterPK) obj;
		if (jobTemplateSeqNo != other.jobTemplateSeqNo)
			return false;
		if (serviceCategorySeqNo == null) {
			if (other.serviceCategorySeqNo != null)
				return false;
		} else if (!serviceCategorySeqNo.equals(other.serviceCategorySeqNo))
			return false;
		if (serviceSeqNo != other.serviceSeqNo)
			return false;
		return true;
	}

}