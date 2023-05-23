package job_metrics_mgmt.model.master;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the LOGI_JOB_COST_MASTER database table.
 * 
 */
@Embeddable
public class LogiJobCostMasterPK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(name="JOB_TYPE_SEQ_NO")
	private long jobTypeSeqNo;

	@Column(name="TARGET_TYPE_SEQ_NO")
	private long targetTypeSeqNo;

	public LogiJobCostMasterPK() {
	}
	public long getJobTypeSeqNo() {
		return this.jobTypeSeqNo;
	}
	public void setJobTypeSeqNo(long jobTypeSeqNo) {
		this.jobTypeSeqNo = jobTypeSeqNo;
	}
	public long getTargetTypeSeqNo() {
		return this.targetTypeSeqNo;
	}
	public void setTargetTypeSeqNo(long targetTypeSeqNo) {
		this.targetTypeSeqNo = targetTypeSeqNo;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof LogiJobCostMasterPK)) {
			return false;
		}
		LogiJobCostMasterPK castOther = (LogiJobCostMasterPK)other;
		return 
			(this.jobTypeSeqNo == castOther.jobTypeSeqNo)
			&& (this.targetTypeSeqNo == castOther.targetTypeSeqNo);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + ((int) (this.jobTypeSeqNo ^ (this.jobTypeSeqNo >>> 32)));
		hash = hash * prime + ((int) (this.targetTypeSeqNo ^ (this.targetTypeSeqNo >>> 32)));
		
		return hash;
	}
}