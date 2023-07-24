package job_class_structure_read_mgmt.model.master;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the JOB_CLASS_STRUCTURE database table.
 * 
 */
@Embeddable
public class JobClassStructurePK implements Serializable 
{
	// default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(name = "JOB_CLASS_SEQ_NO")
	private Long jobClassSeqNo;

	@Column(name = "PAR_JOB_CLASS_SEQ_NO")
	private Long parJobClassSeqNo;

	@Column(name = "PARTY_SEQ_NO")
	private Long partySeqNo;

	public JobClassStructurePK() {
	}

	public Long getJobClassSeqNo() {
		return this.jobClassSeqNo;
	}

	public void setJobClassSeqNo(Long jobClassSeqNo) {
		this.jobClassSeqNo = jobClassSeqNo;
	}

	public Long getParJobClassSeqNo() {
		return this.parJobClassSeqNo;
	}

	public void setParJobClassSeqNo(Long parJobClassSeqNo) {
		this.parJobClassSeqNo = parJobClassSeqNo;
	}

	public Long getPartySeqNo() {
		return this.partySeqNo;
	}

	public void setPartySeqNo(Long partySeqNo) {
		this.partySeqNo = partySeqNo;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof JobClassStructurePK)) {
			return false;
		}
		JobClassStructurePK castOther = (JobClassStructurePK) other;
		return (this.jobClassSeqNo == castOther.jobClassSeqNo) && (this.parJobClassSeqNo == castOther.parJobClassSeqNo)
				&& (this.partySeqNo == castOther.partySeqNo);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + ((int) (this.jobClassSeqNo ^ (this.jobClassSeqNo >>> 32)));
		hash = hash * prime + ((int) (this.parJobClassSeqNo ^ (this.parJobClassSeqNo >>> 32)));
		hash = hash * prime + ((int) (this.partySeqNo ^ (this.partySeqNo >>> 32)));

		return hash;
	}

	public JobClassStructurePK(Long jobClassSeqNo, Long parJobClassSeqNo, Long partySeqNo) {
		super();
		this.jobClassSeqNo = jobClassSeqNo;
		this.parJobClassSeqNo = parJobClassSeqNo;
		this.partySeqNo = partySeqNo;
	}

}