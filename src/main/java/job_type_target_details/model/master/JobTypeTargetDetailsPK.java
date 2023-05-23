package job_type_target_details.model.master;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the JOB_TYPE_TARGET_DETAILS database table.
 * 
 */
@Embeddable
public class JobTypeTargetDetailsPK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(name="JOB_TYPE_SEQ_NO")
	private long jobTypeSeqNo;

	@Column(name="TARGET_SEQ_NO")
	private long targetSeqNo;

	public JobTypeTargetDetailsPK() {
	}
	public long getJobTypeSeqNo() {
		return this.jobTypeSeqNo;
	}
	public void setJobTypeSeqNo(long jobTypeSeqNo) {
		this.jobTypeSeqNo = jobTypeSeqNo;
	}
	public long getTargetSeqNo() {
		return this.targetSeqNo;
	}
	public void setTargetSeqNo(long targetSeqNo) {
		this.targetSeqNo = targetSeqNo;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof JobTypeTargetDetailsPK)) {
			return false;
		}
		JobTypeTargetDetailsPK castOther = (JobTypeTargetDetailsPK)other;
		return 
			(this.jobTypeSeqNo == castOther.jobTypeSeqNo)
			&& (this.targetSeqNo == castOther.targetSeqNo);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + ((int) (this.jobTypeSeqNo ^ (this.jobTypeSeqNo >>> 32)));
		hash = hash * prime + ((int) (this.targetSeqNo ^ (this.targetSeqNo >>> 32)));
		
		return hash;
	}
}