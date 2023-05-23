package job_type_master_mgmt.model.master;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The persistent class for the JOB_TYPE_MASTER database table.
 * 
 */
@Entity
@Table(name = "JOB_TYPE_MASTER")
public class JobTypeMaster implements Serializable 
{
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "JOB_TYPE_SEQUENCE")
	@SequenceGenerator(name = "JOB_TYPE_SEQUENCE", sequenceName = "JOB_TYPE_SEQUENCE", allocationSize = 1)
	@Column(name = "JOB_TYPE_SEQ_NO")
	private long jobTypeSeqNo;

	@Column(name = "JOB_LEVEL_SEQ_NO")
	private Integer jobLevelSeqNo;

	@Column(name = "JOB_TYPE")
	private String jobType;

	@Column(name = "MASTER_JOB_TYPE_SEQ_NO")
	private Long masterJobTypeSeqNo;

	@Column(name = "REMARKS")
	private String remarks;

	@Column(name = "STATUS")
	private String status;

	public JobTypeMaster() {
	}

	public long getJobTypeSeqNo() {
		return this.jobTypeSeqNo;
	}

	public void setJobTypeSeqNo(long jobTypeSeqNo) {
		this.jobTypeSeqNo = jobTypeSeqNo;
	}

	public Integer getJobLevelSeqNo() {
		return this.jobLevelSeqNo;
	}

	public void setJobLevelSeqNo(Integer jobLevelSeqNo) {
		this.jobLevelSeqNo = jobLevelSeqNo;
	}

	public String getJobType() {
		return this.jobType;
	}

	public void setJobType(String jobType) {
		this.jobType = jobType;
	}

	public Long getMasterJobTypeSeqNo() {
		return this.masterJobTypeSeqNo;
	}

	public void setMasterJobTypeSeqNo(Long masterJobTypeSeqNo) {
		this.masterJobTypeSeqNo = masterJobTypeSeqNo;
	}

	public String getRemarks() {
		return this.remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

	public String getStatus() {
		return this.status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((jobLevelSeqNo == null) ? 0 : jobLevelSeqNo.hashCode());
		result = prime * result + ((jobType == null) ? 0 : jobType.hashCode());
		result = prime * result + (int) (jobTypeSeqNo ^ (jobTypeSeqNo >>> 32));
		result = prime * result + ((masterJobTypeSeqNo == null) ? 0 : masterJobTypeSeqNo.hashCode());
		result = prime * result + ((remarks == null) ? 0 : remarks.hashCode());
		result = prime * result + ((status == null) ? 0 : status.hashCode());
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
		JobTypeMaster other = (JobTypeMaster) obj;
		if (jobLevelSeqNo == null) {
			if (other.jobLevelSeqNo != null)
				return false;
		} else if (!jobLevelSeqNo.equals(other.jobLevelSeqNo))
			return false;
		if (jobType == null) {
			if (other.jobType != null)
				return false;
		} else if (!jobType.equals(other.jobType))
			return false;
		if (jobTypeSeqNo != other.jobTypeSeqNo)
			return false;
		if (masterJobTypeSeqNo == null) {
			if (other.masterJobTypeSeqNo != null)
				return false;
		} else if (!masterJobTypeSeqNo.equals(other.masterJobTypeSeqNo))
			return false;
		if (remarks == null) {
			if (other.remarks != null)
				return false;
		} else if (!remarks.equals(other.remarks))
			return false;
		if (status == null) {
			if (other.status != null)
				return false;
		} else if (!status.equals(other.status))
			return false;
		return true;
	}

	public JobTypeMaster(long jobTypeSeqNo, Integer jobLevelSeqNo, String jobType, Long masterJobTypeSeqNo,
			String remarks, String status) {
		super();
		this.jobTypeSeqNo = jobTypeSeqNo;
		this.jobLevelSeqNo = jobLevelSeqNo;
		this.jobType = jobType;
		this.masterJobTypeSeqNo = masterJobTypeSeqNo;
		this.remarks = remarks;
		this.status = status;
	}

}