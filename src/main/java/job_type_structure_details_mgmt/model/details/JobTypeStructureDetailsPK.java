package job_type_structure_details_mgmt.model.details;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the JOB_TYPE_STRUCTURE_DETAILS database table.
 * 
 */
@Embeddable
public class JobTypeStructureDetailsPK implements Serializable {
	private static final long serialVersionUID = 1L;

	@Column(name = "JOB_TYPE_SEQ_NO")
	private long jobTypeSeqNo;

	@Column(name = "PAR_TARGET_SEQ_NO")
	private long parTargetSeqNo;

	@Column(name = "PAR_JOB_TYPE_SEQ_NO")
	private long parJobTypeSeqNo;

	public JobTypeStructureDetailsPK() {
	}

	public long getJobTypeSeqNo() {
		return this.jobTypeSeqNo;
	}

	public void setJobTypeSeqNo(long jobTypeSeqNo) {
		this.jobTypeSeqNo = jobTypeSeqNo;
	}

	public long getParJobTypeSeqNo() {
		return this.parJobTypeSeqNo;
	}

	public void setParJobTypeSeqNo(long parJobTypeSeqNo) {
		this.parJobTypeSeqNo = parJobTypeSeqNo;
	}

	public long getParTargetSeqNo() {
		return parTargetSeqNo;
	}

	public void setParTargetSeqNo(long parTargetSeqNo) {
		this.parTargetSeqNo = parTargetSeqNo;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (jobTypeSeqNo ^ (jobTypeSeqNo >>> 32));
		result = prime * result + (int) (parJobTypeSeqNo ^ (parJobTypeSeqNo >>> 32));
		result = prime * result + (int) (parTargetSeqNo ^ (parTargetSeqNo >>> 32));
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
		JobTypeStructureDetailsPK other = (JobTypeStructureDetailsPK) obj;
		if (jobTypeSeqNo != other.jobTypeSeqNo)
			return false;
		if (parJobTypeSeqNo != other.parJobTypeSeqNo)
			return false;
		if (parTargetSeqNo != other.parTargetSeqNo)
			return false;
		return true;
	}

	public JobTypeStructureDetailsPK(long jobTypeSeqNo, long parTargetSeqNo, long parJobTypeSeqNo) {
		super();
		this.jobTypeSeqNo = jobTypeSeqNo;
		this.parTargetSeqNo = parTargetSeqNo;
		this.parJobTypeSeqNo = parJobTypeSeqNo;
	}

}