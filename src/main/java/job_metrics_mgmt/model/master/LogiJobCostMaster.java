package job_metrics_mgmt.model.master;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The persistent class for the LOGI_JOB_COST_MASTER database table.
 * 
 */
@Entity
@Table(name="LOGI_JOB_COST_MASTER")
public class LogiJobCostMaster implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private LogiJobCostMasterPK id;

	@Column(name="DISCOUNT_AMOUNT")
	private float discountAmount;

	@Column(name="DISCOUNT_PERCENT")
	private float discountPercent;

	@Column(name="DURATION_MILLI")
	private float durationMilli;
	
	@Column(name="RATE_SEQ_NO")
	private Integer rateSeqNo;

	@Column(name="TAX")
	private float tax;

	@Column(name="TAX_PERCENT")
	private float taxPercent;

	@Column(name="UNIT_RATE")
	private float unitRate;

	public LogiJobCostMaster() {
	}

	
	public float getDurationMilli() {
		return durationMilli;
	}

	public void setDurationMilli(float durationMilli) {
		this.durationMilli = durationMilli;
	}

	public LogiJobCostMasterPK getId() {
		return id;
	}

	public void setId(LogiJobCostMasterPK id) {
		this.id = id;
	}

	public float getDiscountAmount() {
		return discountAmount;
	}

	public void setDiscountAmount(float discountAmount) {
		this.discountAmount = discountAmount;
	}

	public float getDiscountPercent() {
		return discountPercent;
	}

	public void setDiscountPercent(float discountPercent) {
		this.discountPercent = discountPercent;
	}

	public Integer getRateSeqNo() {
		return rateSeqNo;
	}

	public void setRateSeqNo(Integer rateSeqNo) {
		this.rateSeqNo = rateSeqNo;
	}

	public float getTax() {
		return tax;
	}

	public void setTax(float tax) {
		this.tax = tax;
	}

	public float getTaxPercent() {
		return taxPercent;
	}

	public void setTaxPercent(float taxPercent) {
		this.taxPercent = taxPercent;
	}

	public float getUnitRate() {
		return unitRate;
	}

	public void setUnitRate(float unitRate) {
		this.unitRate = unitRate;
	}


	public LogiJobCostMaster(LogiJobCostMasterPK id, float discountAmount, float discountPercent, float durationMilli,
			Integer rateSeqNo, float tax, float taxPercent, float unitRate) {
		super();
		this.id = id;
		this.discountAmount = discountAmount;
		this.discountPercent = discountPercent;
		this.durationMilli = durationMilli;
		this.rateSeqNo = rateSeqNo;
		this.tax = tax;
		this.taxPercent = taxPercent;
		this.unitRate = unitRate;
	}

}