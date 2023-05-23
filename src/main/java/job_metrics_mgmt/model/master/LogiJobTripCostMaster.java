package job_metrics_mgmt.model.master;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The persistent class for the LOGI_JOB_TRIP_COST_MASTER database table.
 * 
 */
@Entity
@Table(name="LOGI_JOB_TRIP_COST_MASTER")
public class LogiJobTripCostMaster implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private LogiJobTripCostMasterPK id;

	@Column(name="DISCOUNT_AMOUNT")
	private float discountAmount;

	@Column(name="DISCOUNT_PERCENT")
	private float discountPercent;

	@Column(name="RATE")
	private float rate;

	@Column(name="RATE_SEQ_NO")
	private Integer rateSeqNo;

	@Column(name="TAX")
	private float tax;

	@Column(name="TAX_PERCENT")
	private float taxPercent;

	public LogiJobTripCostMasterPK getId() {
		return id;
	}

	public void setId(LogiJobTripCostMasterPK id) {
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

	public float getRate() {
		return rate;
	}

	public void setRate(float rate) {
		this.rate = rate;
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

	public LogiJobTripCostMaster(LogiJobTripCostMasterPK id, float discountAmount, float discountPercent, float rate,
			Integer rateSeqNo, float tax, float taxPercent) {
		super();
		this.id = id;
		this.discountAmount = discountAmount;
		this.discountPercent = discountPercent;
		this.rate = rate;
		this.rateSeqNo = rateSeqNo;
		this.tax = tax;
		this.taxPercent = taxPercent;
	}

	public LogiJobTripCostMaster() {
		super();
	}
}