package job_type_level_master_mgmt.model.master;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The persistent class for the JOB_LEVEL_MASTER database table.
 * 
 */
@Entity
@Table(name = "JOB_TYPE_LEVEL_MASTER")
public class JobTypeLevelMaster implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "JOB_TYPE_LEVEL_SEQUENCE")
	@SequenceGenerator(name = "JOB_TYPE_LEVEL_SEQUENCE", sequenceName = "JOB_TYPE_LEVEL_SEQUENCE", allocationSize = 1)
	@Column(name = "JOB_TYPE_LEVEL_SEQ_NO")
	private Long jobTypeLevelSeqNo;

	@Column(name = "JOB_TYPE_LEVEL")
	private Long jobLevel;

	@Column(name = "REMARKS")
	private String remarks;

	@Column(name = "STATUS")
	private String status;

	public Long getJobTypeLevelSeqNo() {
		return jobTypeLevelSeqNo;
	}

	public void setJobTypeLevelSeqNo(Long jobTypeLevelSeqNo) {
		this.jobTypeLevelSeqNo = jobTypeLevelSeqNo;
	}

	public Long getJobLevel() {
		return jobLevel;
	}

	public void setJobLevel(Long jobLevel) {
		this.jobLevel = jobLevel;
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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((jobLevel == null) ? 0 : jobLevel.hashCode());
		result = prime * result + ((jobTypeLevelSeqNo == null) ? 0 : jobTypeLevelSeqNo.hashCode());
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
		JobTypeLevelMaster other = (JobTypeLevelMaster) obj;
		if (jobLevel == null) {
			if (other.jobLevel != null)
				return false;
		} else if (!jobLevel.equals(other.jobLevel))
			return false;
		if (jobTypeLevelSeqNo == null) {
			if (other.jobTypeLevelSeqNo != null)
				return false;
		} else if (!jobTypeLevelSeqNo.equals(other.jobTypeLevelSeqNo))
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

	public JobTypeLevelMaster(Long jobTypeLevelSeqNo, Long jobLevel, String remarks, String status) {
		super();
		this.jobTypeLevelSeqNo = jobTypeLevelSeqNo;
		this.jobLevel = jobLevel;
		this.remarks = remarks;
		this.status = status;
	}

	public JobTypeLevelMaster() {
		super();
	}

}