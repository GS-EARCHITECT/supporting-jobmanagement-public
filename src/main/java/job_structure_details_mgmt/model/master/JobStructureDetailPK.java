package job_structure_details_mgmt.model.master;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the JOB_STRUCTURE_DETAILS database table.
 * 
 */
@Embeddable
public class JobStructureDetailPK implements Serializable 
{
	// default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(name = "JOB_CLASS_SEQ_NO")
	private Long jobClassSeqNo;

	@Column(name = "PAR_JOB_SEQ_NO")
	private Long parJobSeqNo;

	@Column(name = "JOB_SEQ_NO")
	private Long jobSeqNo;

	public JobStructureDetailPK() {
	}

	public Long getJobClassSeqNo() {
		return this.jobClassSeqNo;
	}

	public void setJobClassSeqNo(Long jobClassSeqNo) {
		this.jobClassSeqNo = jobClassSeqNo;
	}

	public Long getParJobSeqNo() {
		return this.parJobSeqNo;
	}

	public void setParJobSeqNo(Long parJobSeqNo) {
		this.parJobSeqNo = parJobSeqNo;
	}

	public Long getJobSeqNo() {
		return this.jobSeqNo;
	}

	public void setJobSeqNo(Long jobSeqNo) {
		this.jobSeqNo = jobSeqNo;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof JobStructureDetailPK)) {
			return false;
		}
		JobStructureDetailPK castOther = (JobStructureDetailPK) other;
		return (this.jobClassSeqNo == castOther.jobClassSeqNo) && (this.parJobSeqNo == castOther.parJobSeqNo)
				&& (this.jobSeqNo == castOther.jobSeqNo);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + ((int) (this.jobClassSeqNo ^ (this.jobClassSeqNo >>> 32)));
		hash = hash * prime + ((int) (this.parJobSeqNo ^ (this.parJobSeqNo >>> 32)));
		hash = hash * prime + ((int) (this.jobSeqNo ^ (this.jobSeqNo >>> 32)));

		return hash;
	}

	public JobStructureDetailPK(Long jobClassSeqNo, Long parJobSeqNo, Long jobSeqNo) {
		super();
		this.jobClassSeqNo = jobClassSeqNo;
		this.parJobSeqNo = parJobSeqNo;
		this.jobSeqNo = jobSeqNo;
	}

}