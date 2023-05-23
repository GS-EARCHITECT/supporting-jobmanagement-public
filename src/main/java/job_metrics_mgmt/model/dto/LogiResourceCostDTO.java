package job_metrics_mgmt.model.dto;

import java.io.Serializable;

public class LogiResourceCostDTO implements Serializable 
{
	/**
	 * 
	 */
	private static final long serialVersionUID = -7631978247200275556L;
	private Long job_seq_no;
	private Long resource_seq_no;
	private Long asse_seq_no;
	private Long frSeqNo;
	private Long toSeqNo;
	private Integer jobTypeSeqNo;
	private Integer modeSeqNo;
	private Integer targetTypeSeqNo;
	private Integer unitSeqNoBasis;
	private Float unitRateBasis;	
	private Integer unitQtySeqNoBasis;		
	private Float qtyBasis;
	private Float qtyUsed;	
	private double cost;
	private Integer billingUnitSeqNo;
	
	public Long getJob_seq_no() {
		return job_seq_no;
	}
	public void setJob_seq_no(Long job_seq_no) {
		this.job_seq_no = job_seq_no;
	}
	public Long getResource_seq_no() {
		return resource_seq_no;
	}
	public void setResource_seq_no(Long resource_seq_no) {
		this.resource_seq_no = resource_seq_no;
	}
	public Long getAsse_seq_no() {
		return asse_seq_no;
	}
	public void setAsse_seq_no(Long asse_seq_no) {
		this.asse_seq_no = asse_seq_no;
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
	public Integer getUnitSeqNoBasis() {
		return unitSeqNoBasis;
	}
	public void setUnitSeqNoBasis(Integer unitSeqNoBasis) {
		this.unitSeqNoBasis = unitSeqNoBasis;
	}
	public Float getUnitRateBasis() {
		return unitRateBasis;
	}
	public void setUnitRateBasis(Float unitRateBasis) {
		this.unitRateBasis = unitRateBasis;
	}
	public Integer getUnitQtySeqNoBasis() {
		return unitQtySeqNoBasis;
	}
	public void setUnitQtySeqNoBasis(Integer unitQtySeqNoBasis) {
		this.unitQtySeqNoBasis = unitQtySeqNoBasis;
	}
	public Float getQtyBasis() {
		return qtyBasis;
	}
	public void setQtyBasis(Float qtyBasis) {
		this.qtyBasis = qtyBasis;
	}
	public Float getQtyUsed() {
		return qtyUsed;
	}
	public void setQtyUsed(Float qtyUsed) {
		this.qtyUsed = qtyUsed;
	}
	public double getCost() {
		return cost;
	}
	public void setCost(double cost) {
		this.cost = cost;
	}
	public Integer getBillingUnitSeqNo() {
		return billingUnitSeqNo;
	}
	public void setBillingUnitSeqNo(Integer billingUnitSeqNo) {
		this.billingUnitSeqNo = billingUnitSeqNo;
	}
	public LogiResourceCostDTO(Long job_seq_no, Long resource_seq_no, Long asse_seq_no, Long frSeqNo, Long toSeqNo,
			Integer jobTypeSeqNo, Integer modeSeqNo, Integer targetTypeSeqNo, Integer unitSeqNoBasis,
			Float unitRateBasis, Integer unitQtySeqNoBasis, Float qtyBasis, Float qtyUsed, double cost,
			Integer billingUnitSeqNo) {
		super();
		this.job_seq_no = job_seq_no;
		this.resource_seq_no = resource_seq_no;
		this.asse_seq_no = asse_seq_no;
		this.frSeqNo = frSeqNo;
		this.toSeqNo = toSeqNo;
		this.jobTypeSeqNo = jobTypeSeqNo;
		this.modeSeqNo = modeSeqNo;
		this.targetTypeSeqNo = targetTypeSeqNo;
		this.unitSeqNoBasis = unitSeqNoBasis;
		this.unitRateBasis = unitRateBasis;
		this.unitQtySeqNoBasis = unitQtySeqNoBasis;
		this.qtyBasis = qtyBasis;
		this.qtyUsed = qtyUsed;
		this.cost = cost;
		this.billingUnitSeqNo = billingUnitSeqNo;
	}
	public LogiResourceCostDTO() {
		super();
	}	
}