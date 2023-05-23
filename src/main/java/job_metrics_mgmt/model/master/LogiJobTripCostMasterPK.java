package job_metrics_mgmt.model.master;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the LOGI_JOB_TRIP_COST_MASTER database table.
 * 
 */
@Embeddable
public class LogiJobTripCostMasterPK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(name="JOB_TYPE_SEQ_NO")
	private long jobTypeSeqNo;

	@Column(name="FR_LOC_SEQ_NO")
	private long frLocSeqNo;

	@Column(name="TO_LOC_SEQ_NO")
	private long toLocSeqNo;

	@Column(name="MODE_SEQ_NO")
	private Integer modeSeqNo;

	@Column(name="TARGET_TYPE_SEQ_NO")
	private Integer targetTypeSeqNo;

	public long getJobTypeSeqNo() {
		return jobTypeSeqNo;
	}

	public void setJobTypeSeqNo(long jobTypeSeqNo) {
		this.jobTypeSeqNo = jobTypeSeqNo;
	}

	public long getFrLocSeqNo() {
		return frLocSeqNo;
	}

	public void setFrLocSeqNo(long frLocSeqNo) {
		this.frLocSeqNo = frLocSeqNo;
	}

	public long getToLocSeqNo() {
		return toLocSeqNo;
	}

	public void setToLocSeqNo(long toLocSeqNo) {
		this.toLocSeqNo = toLocSeqNo;
	}

	public Integer getModeSeqNo() {
		return modeSeqNo;
	}

	public void setModeSeqNo(Integer modeSeqNo) {
		this.modeSeqNo = modeSeqNo;
	}

	public Integer getTargetTypeSeqNo() {
		return targetTypeSeqNo;
	}

	public void setTargetTypeSeqNo(Integer targetTypeSeqNo) {
		this.targetTypeSeqNo = targetTypeSeqNo;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (frLocSeqNo ^ (frLocSeqNo >>> 32));
		result = prime * result + (int) (jobTypeSeqNo ^ (jobTypeSeqNo >>> 32));
		result = prime * result + ((modeSeqNo == null) ? 0 : modeSeqNo.hashCode());
		result = prime * result + ((targetTypeSeqNo == null) ? 0 : targetTypeSeqNo.hashCode());
		result = prime * result + (int) (toLocSeqNo ^ (toLocSeqNo >>> 32));
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
		LogiJobTripCostMasterPK other = (LogiJobTripCostMasterPK) obj;
		if (frLocSeqNo != other.frLocSeqNo)
			return false;
		if (jobTypeSeqNo != other.jobTypeSeqNo)
			return false;
		if (modeSeqNo == null) {
			if (other.modeSeqNo != null)
				return false;
		} else if (!modeSeqNo.equals(other.modeSeqNo))
			return false;
		if (targetTypeSeqNo == null) {
			if (other.targetTypeSeqNo != null)
				return false;
		} else if (!targetTypeSeqNo.equals(other.targetTypeSeqNo))
			return false;
		if (toLocSeqNo != other.toLocSeqNo)
			return false;
		return true;
	}

	public LogiJobTripCostMasterPK(long jobTypeSeqNo, long frLocSeqNo, long toLocSeqNo, Integer modeSeqNo,
			Integer targetTypeSeqNo) {
		super();
		this.jobTypeSeqNo = jobTypeSeqNo;
		this.frLocSeqNo = frLocSeqNo;
		this.toLocSeqNo = toLocSeqNo;
		this.modeSeqNo = modeSeqNo;
		this.targetTypeSeqNo = targetTypeSeqNo;
	}

	public LogiJobTripCostMasterPK() {
		super();
	}

}