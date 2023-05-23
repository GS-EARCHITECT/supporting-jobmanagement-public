package job_metrics_mgmt.model.dto;

import java.io.Serializable;
import java.sql.Timestamp;

public class LogiServiceCostDTO implements Serializable 
{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -7631978247200275556L;
	private Long job_seq_no;
	private Long frSeqNo;
	private Long toSeqNo;
	private Integer jobTypeSeqNo;
	private Integer modeSeqNo;
	private Integer targetTypeSeqNo;
	private Integer unitTripSeqNo;
	private Float tripRate;
	private Integer unitJobSeqNo;
	private Float unitJobRate;
	private Timestamp frDtTm;
	private Timestamp toDtTm;
	private Float jobSeqDuration;
	private Float jobMasterDuration;
	private double cost;
	private Integer billingUnitSeqNo;	
	
	
	
	public Integer getBillingUnitSeqNo() {
		return billingUnitSeqNo;
	}

	public void setBillingUnitSeqNo(Integer billingUnitSeqNo) {
		this.billingUnitSeqNo = billingUnitSeqNo;
	}

	public Long getJob_seq_no() {
		return job_seq_no;
	}
	
	public Float getJobMasterDuration() {
		return jobMasterDuration;
	}



	public void setJobMasterDuration(Float jobMasterDuration) {
		this.jobMasterDuration = jobMasterDuration;
	}



	public void setJob_seq_no(Long job_seq_no) {
		this.job_seq_no = job_seq_no;
	}
	public Long getFrSeqNo() {
		return frSeqNo;
	}
	public void setFrSeqNo(Long frSeqNo) {
		this.frSeqNo = frSeqNo;
	}
	public Long getToSeqNo() {
		return toSeqNo;
	}
	public void setToSeqNo(Long toSeqNo) {
		this.toSeqNo = toSeqNo;
	}
	public Integer getJobTypeSeqNo() {
		return jobTypeSeqNo;
	}
	public void setJobTypeSeqNo(Integer jobTypeSeqNo) {
		this.jobTypeSeqNo = jobTypeSeqNo;
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
	public Integer getUnitTripSeqNo() {
		return unitTripSeqNo;
	}
	public void setUnitTripSeqNo(Integer unitTripSeqNo) {
		this.unitTripSeqNo = unitTripSeqNo;
	}
	public Float getTripRate() {
		return tripRate;
	}
	public void setTripRate(Float tripRate) {
		this.tripRate = tripRate;
	}
	public Integer getUnitJobSeqNo() {
		return unitJobSeqNo;
	}
	public void setUnitJobSeqNo(Integer unitJobSeqNo) {
		this.unitJobSeqNo = unitJobSeqNo;
	}
	public Float getUnitJobRate() {
		return unitJobRate;
	}
	public void setUnitJobRate(Float unitJobRate) {
		this.unitJobRate = unitJobRate;
	}
	public Timestamp getFrDtTm() {
		return frDtTm;
	}
	public void setFrDtTm(Timestamp frDtTm) {
		this.frDtTm = frDtTm;
	}
	public Timestamp getToDtTm() {
		return toDtTm;
	}
	public void setToDtTm(Timestamp toDtTm) {
		this.toDtTm = toDtTm;
	}
	public Float getJobSeqDuration() {
		return jobSeqDuration;
	}
	public void setJobSeqDuration(Float jobSeqDuration) {
		this.jobSeqDuration = jobSeqDuration;
	}
	public double getCost() {
		return cost;
	}
	public void setCost(double cost) {
		this.cost = cost;
	}
	
	public LogiServiceCostDTO() {
		super();
	}

	public LogiServiceCostDTO(Long job_seq_no, Long frSeqNo, Long toSeqNo, Integer jobTypeSeqNo, Integer modeSeqNo,
			Integer targetTypeSeqNo, Integer unitTripSeqNo, Float tripRate, Integer unitJobSeqNo, Float unitJobRate,
			Timestamp frDtTm, Timestamp toDtTm, Float jobSeqDuration, Float jobMasterDuration, double cost,
			Integer billingUnitSeqNo) {
		super();
		this.job_seq_no = job_seq_no;
		this.frSeqNo = frSeqNo;
		this.toSeqNo = toSeqNo;
		this.jobTypeSeqNo = jobTypeSeqNo;
		this.modeSeqNo = modeSeqNo;
		this.targetTypeSeqNo = targetTypeSeqNo;
		this.unitTripSeqNo = unitTripSeqNo;
		this.tripRate = tripRate;
		this.unitJobSeqNo = unitJobSeqNo;
		this.unitJobRate = unitJobRate;
		this.frDtTm = frDtTm;
		this.toDtTm = toDtTm;
		this.jobSeqDuration = jobSeqDuration;
		this.jobMasterDuration = jobMasterDuration;
		this.cost = cost;
		this.billingUnitSeqNo = billingUnitSeqNo;
	}
	
	
}