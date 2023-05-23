package job_template_details_mgmt.model.details;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.*;

/**
 * The primary key class for the JOB_TEMPLATE_DETAILS database table.
 * 
 */
@Embeddable
public class JobTemplateDetailsPK implements Serializable {
	private static final long serialVersionUID = 1L;

	@Column(name = "JOB_TEMPLATE_SEQ_NO")
	private long jobTemplateSeqNo;

	@Column(name = "JOB_LEVEL_NO")
	private long jobLevelNo;

	@Column(name = "SEQ_NO")
	private Long seqNo;

	@Column(name = "JOB_TYPE_SEQ_NO")
	private Long jobTypeSeqNo;

	@Column(name = "TARGET_SEQ_NO")
	private long targetSeqNo;

	@Column(name = "TARGET_TYPE_SEQ_NO")
	private BigDecimal targetTypeSeqNo;

	public JobTemplateDetailsPK() {
	}

	public long getJobTemplateSeqNo() {
		return jobTemplateSeqNo;
	}

	public void setJobTemplateSeqNo(long jobTemplateSeqNo) {
		this.jobTemplateSeqNo = jobTemplateSeqNo;
	}

	public long getJobLevelNo() {
		return jobLevelNo;
	}

	public void setJobLevelNo(long jobLevelNo) {
		this.jobLevelNo = jobLevelNo;
	}

	public Long getSeqNo() {
		return seqNo;
	}

	public void setSeqNo(Long seqNo) {
		this.seqNo = seqNo;
	}

	public Long getJobTypeSeqNo() {
		return jobTypeSeqNo;
	}

	public void setJobTypeSeqNo(Long jobTypeSeqNo) {
		this.jobTypeSeqNo = jobTypeSeqNo;
	}

	public long getTargetSeqNo() {
		return targetSeqNo;
	}

	public void setTargetSeqNo(long targetSeqNo) {
		this.targetSeqNo = targetSeqNo;
	}

	public BigDecimal getTargetTypeSeqNo() {
		return targetTypeSeqNo;
	}

	public void setTargetTypeSeqNo(BigDecimal targetTypeSeqNo) {
		this.targetTypeSeqNo = targetTypeSeqNo;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (jobLevelNo ^ (jobLevelNo >>> 32));
		result = prime * result + (int) (jobTemplateSeqNo ^ (jobTemplateSeqNo >>> 32));
		result = prime * result + ((jobTypeSeqNo == null) ? 0 : jobTypeSeqNo.hashCode());
		result = prime * result + ((seqNo == null) ? 0 : seqNo.hashCode());
		result = prime * result + (int) (targetSeqNo ^ (targetSeqNo >>> 32));
		result = prime * result + ((targetTypeSeqNo == null) ? 0 : targetTypeSeqNo.hashCode());
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
		JobTemplateDetailsPK other = (JobTemplateDetailsPK) obj;
		if (jobLevelNo != other.jobLevelNo)
			return false;
		if (jobTemplateSeqNo != other.jobTemplateSeqNo)
			return false;
		if (jobTypeSeqNo == null) {
			if (other.jobTypeSeqNo != null)
				return false;
		} else if (!jobTypeSeqNo.equals(other.jobTypeSeqNo))
			return false;
		if (seqNo == null) {
			if (other.seqNo != null)
				return false;
		} else if (!seqNo.equals(other.seqNo))
			return false;
		if (targetSeqNo != other.targetSeqNo)
			return false;
		if (targetTypeSeqNo == null) {
			if (other.targetTypeSeqNo != null)
				return false;
		} else if (!targetTypeSeqNo.equals(other.targetTypeSeqNo))
			return false;
		return true;
	}

	public JobTemplateDetailsPK(long jobTemplateSeqNo, long jobLevelNo, Long seqNo, Long jobTypeSeqNo,
			long targetSeqNo, BigDecimal targetTypeSeqNo) {
		super();
		this.jobTemplateSeqNo = jobTemplateSeqNo;
		this.jobLevelNo = jobLevelNo;
		this.seqNo = seqNo;
		this.jobTypeSeqNo = jobTypeSeqNo;
		this.targetSeqNo = targetSeqNo;
		this.targetTypeSeqNo = targetTypeSeqNo;
	}

}