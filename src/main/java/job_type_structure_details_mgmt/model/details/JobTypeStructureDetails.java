package job_type_structure_details_mgmt.model.details;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The persistent class for the JOB_TYPE_STRUCTURE_DETAILS database table.
 * 
 */
@Entity
@Table(name = "JOB_TYPE_STRUCTURE_DETAILS")
public class JobTypeStructureDetails implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private JobTypeStructureDetailsPK id;

	@Column(name = "REMARKS")
	private String remarks;

	@Column(name = "STATUS")
	private String status;

	@Column(name = "SEQ_NO")
	private Integer seqNo;

	@Column(name = "CHILD_TARGET_SEQ_NO")
	private long targetSeqNo;

	public JobTypeStructureDetailsPK getId() {
		return id;
	}

	public void setId(JobTypeStructureDetailsPK id) {
		this.id = id;
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

	public Integer getSeqNo() {
		return seqNo;
	}

	public void setSeqNo(Integer seqNo) {
		this.seqNo = seqNo;
	}

	public long getTargetSeqNo() {
		return targetSeqNo;
	}

	public void setTargetSeqNo(long targetSeqNo) {
		this.targetSeqNo = targetSeqNo;
	}

	public JobTypeStructureDetails() {
		super();
	}

	public JobTypeStructureDetails(JobTypeStructureDetailsPK id, String remarks, String status, Integer seqNo,
			long targetSeqNo) {
		super();
		this.id = id;
		this.remarks = remarks;
		this.status = status;
		this.seqNo = seqNo;
		this.targetSeqNo = targetSeqNo;
	}

}