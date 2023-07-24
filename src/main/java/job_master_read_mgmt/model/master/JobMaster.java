package job_master_read_mgmt.model.master;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The persistent class for the JOB_MASTER database table.
 * 
 */
@Entity
@Table(name = "JOB_MASTER")
public class JobMaster implements Serializable 
{
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "JOB_SEQUENCE")
	@SequenceGenerator(name = "JOB_SEQUENCE", sequenceName = "JOB_SEQUENCE", allocationSize = 1)
	@Column(name = "JOB_SEQ_NO")
	private Long jobSeqNo;

	@Column(name = "DESCRIPTION")
	private String description;

	@Column(name = "DISC_PER")
	private Float discPer;

	@Column(name = "DISC_SEQ_NO")
	private Long discSeqNo;

	@Column(name = "DISC_VAL")
	private Float discVal;

	@Column(name = "DURATION")
	private Float duration;

	@Column(name = "DURATION_CODE_SEQ_NO")
	private Long durationCodeSeqNo;

	@Column(name = "JOB")
	private String job;

	@Column(name = "JOB_ID")
	private String jobId;

	@Column(name = "PARTY_SEQ_NO")
	private Long partySeqNo;

	@Column(name = "REMARK")
	private String remark;

	@Column(name = "SPECIFICATION_SEQ_NO")
	private Long specificationSeqNo;

	@Column(name = "STATUS")
	private String status;

	@Column(name = "TAX_PER")
	private Float taxPer;

	@Column(name = "TAX_SEQ_NO")
	private Long taxSeqNo;

	@Column(name = "TAX_VAL")
	private Float taxVal;

	@Column(name = "UNIT_RATE")
	private Float unitRate;

	@Column(name = "UNIT_RATE_SEQ_NO")
	private Long unitRateSeqNo;

	public JobMaster() {
	}

	public Long getJobSeqNo() {
		return this.jobSeqNo;
	}

	public void setJobSeqNo(Long jobSeqNo) {
		this.jobSeqNo = jobSeqNo;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Float getDiscPer() {
		return this.discPer;
	}

	public void setDiscPer(Float discPer) {
		this.discPer = discPer;
	}

	public Long getDiscSeqNo() {
		return this.discSeqNo;
	}

	public void setDiscSeqNo(Long discSeqNo) {
		this.discSeqNo = discSeqNo;
	}

	public Float getDiscVal() {
		return this.discVal;
	}

	public void setDiscVal(Float discVal) {
		this.discVal = discVal;
	}

	public Float getDuration() {
		return this.duration;
	}

	public void setDuration(Float duration) {
		this.duration = duration;
	}

	public Long getDurationCodeSeqNo() {
		return this.durationCodeSeqNo;
	}

	public void setDurationCodeSeqNo(Long durationCodeSeqNo) {
		this.durationCodeSeqNo = durationCodeSeqNo;
	}

	public String getJob() {
		return this.job;
	}

	public void setJob(String job) {
		this.job = job;
	}

	public String getJobId() {
		return this.jobId;
	}

	public void setJobId(String jobId) {
		this.jobId = jobId;
	}

	public Long getPartySeqNo() {
		return this.partySeqNo;
	}

	public void setPartySeqNo(Long partySeqNo) {
		this.partySeqNo = partySeqNo;
	}

	public String getRemark() {
		return this.remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public Long getSpecificationSeqNo() {
		return this.specificationSeqNo;
	}

	public void setSpecificationSeqNo(Long specificationSeqNo) {
		this.specificationSeqNo = specificationSeqNo;
	}

	public String getStatus() {
		return this.status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Float getTaxPer() {
		return this.taxPer;
	}

	public void setTaxPer(Float taxPer) {
		this.taxPer = taxPer;
	}

	public Long getTaxSeqNo() {
		return this.taxSeqNo;
	}

	public void setTaxSeqNo(Long taxSeqNo) {
		this.taxSeqNo = taxSeqNo;
	}

	public Float getTaxVal() {
		return this.taxVal;
	}

	public void setTaxVal(Float taxVal) {
		this.taxVal = taxVal;
	}

	public Float getUnitRate() {
		return this.unitRate;
	}

	public void setUnitRate(Float unitRate) {
		this.unitRate = unitRate;
	}

	public Long getUnitRateSeqNo() {
		return this.unitRateSeqNo;
	}

	public void setUnitRateSeqNo(Long unitRateSeqNo) {
		this.unitRateSeqNo = unitRateSeqNo;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (jobSeqNo ^ (jobSeqNo >>> 32));
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
		JobMaster other = (JobMaster) obj;
		if (jobSeqNo != other.jobSeqNo)
			return false;
		return true;
	}

	public JobMaster(Long jobSeqNo, String description, Float discPer, Long discSeqNo, Float discVal, Float duration,
			Long durationCodeSeqNo, String job, String jobId, Long partySeqNo, String remark, Long specificationSeqNo,
			String status, Float taxPer, Long taxSeqNo, Float taxVal, Float unitRate, Long unitRateSeqNo) {
		super();
		this.jobSeqNo = jobSeqNo;
		this.description = description;
		this.discPer = discPer;
		this.discSeqNo = discSeqNo;
		this.discVal = discVal;
		this.duration = duration;
		this.durationCodeSeqNo = durationCodeSeqNo;
		this.job = job;
		this.jobId = jobId;
		this.partySeqNo = partySeqNo;
		this.remark = remark;
		this.specificationSeqNo = specificationSeqNo;
		this.status = status;
		this.taxPer = taxPer;
		this.taxSeqNo = taxSeqNo;
		this.taxVal = taxVal;
		this.unitRate = unitRate;
		this.unitRateSeqNo = unitRateSeqNo;
	}

}