package job_metrics_mgmt.model.details;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The persistent class for the LOGI_BILLING_RESOURCE_DETAILS database table.
 * 
 */
@Entity
@Table(name="LOGI_BILLING_RESOURCE_DETAILS")
public class LogiBillingResourceDetail implements Serializable {
	private static final long serialVersionUID = 1L;

	@Column(name="AMOUNT")
	private String amount;

	@Id
	@Column(name="BILL_SEQ_NO")
	private Long billSeqNo;

	@Column(name="DISC")
	private String disc;

	@Column(name="DISC_PERC")
	private String discPerc;

	@Column(name="QTY")
	private String qty;

	@Column(name="RESOURCE_SEQ_NO")
	private Long resourceSeqNo;

	@Column(name="TAXC")
	private String tax;

	@Column(name="TAX_PERC")
	private String taxPerc;

	@Column(name="UNIT_RATE")
	private String unitRate;

	public String getAmount() {
		return amount;
	}

	public void setAmount(String amount) {
		this.amount = amount;
	}

	public Long getBillSeqNo() {
		return billSeqNo;
	}

	public void setBillSeqNo(Long billSeqNo) {
		this.billSeqNo = billSeqNo;
	}

	public String getDisc() {
		return disc;
	}

	public void setDisc(String disc) {
		this.disc = disc;
	}

	public String getDiscPerc() {
		return discPerc;
	}

	public void setDiscPerc(String discPerc) {
		this.discPerc = discPerc;
	}

	public String getQty() {
		return qty;
	}

	public void setQty(String qty) {
		this.qty = qty;
	}

	public Long getResourceSeqNo() {
		return resourceSeqNo;
	}

	public void setResourceSeqNo(Long resourceSeqNo) {
		this.resourceSeqNo = resourceSeqNo;
	}

	public String getTax() {
		return tax;
	}

	public void setTax(String tax) {
		this.tax = tax;
	}

	public String getTaxPerc() {
		return taxPerc;
	}

	public void setTaxPerc(String taxPerc) {
		this.taxPerc = taxPerc;
	}

	public String getUnitRate() {
		return unitRate;
	}

	public void setUnitRate(String unitRate) {
		this.unitRate = unitRate;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((amount == null) ? 0 : amount.hashCode());
		result = prime * result + ((billSeqNo == null) ? 0 : billSeqNo.hashCode());
		result = prime * result + ((disc == null) ? 0 : disc.hashCode());
		result = prime * result + ((discPerc == null) ? 0 : discPerc.hashCode());
		result = prime * result + ((qty == null) ? 0 : qty.hashCode());
		result = prime * result + ((resourceSeqNo == null) ? 0 : resourceSeqNo.hashCode());
		result = prime * result + ((tax == null) ? 0 : tax.hashCode());
		result = prime * result + ((taxPerc == null) ? 0 : taxPerc.hashCode());
		result = prime * result + ((unitRate == null) ? 0 : unitRate.hashCode());
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
		LogiBillingResourceDetail other = (LogiBillingResourceDetail) obj;
		if (amount == null) {
			if (other.amount != null)
				return false;
		} else if (!amount.equals(other.amount))
			return false;
		if (billSeqNo == null) {
			if (other.billSeqNo != null)
				return false;
		} else if (!billSeqNo.equals(other.billSeqNo))
			return false;
		if (disc == null) {
			if (other.disc != null)
				return false;
		} else if (!disc.equals(other.disc))
			return false;
		if (discPerc == null) {
			if (other.discPerc != null)
				return false;
		} else if (!discPerc.equals(other.discPerc))
			return false;
		if (qty == null) {
			if (other.qty != null)
				return false;
		} else if (!qty.equals(other.qty))
			return false;
		if (resourceSeqNo == null) {
			if (other.resourceSeqNo != null)
				return false;
		} else if (!resourceSeqNo.equals(other.resourceSeqNo))
			return false;
		if (tax == null) {
			if (other.tax != null)
				return false;
		} else if (!tax.equals(other.tax))
			return false;
		if (taxPerc == null) {
			if (other.taxPerc != null)
				return false;
		} else if (!taxPerc.equals(other.taxPerc))
			return false;
		if (unitRate == null) {
			if (other.unitRate != null)
				return false;
		} else if (!unitRate.equals(other.unitRate))
			return false;
		return true;
	}

	public LogiBillingResourceDetail(String amount, Long billSeqNo, String disc, String discPerc, String qty,
			Long resourceSeqNo, String tax, String taxPerc, String unitRate) {
		super();
		this.amount = amount;
		this.billSeqNo = billSeqNo;
		this.disc = disc;
		this.discPerc = discPerc;
		this.qty = qty;
		this.resourceSeqNo = resourceSeqNo;
		this.tax = tax;
		this.taxPerc = taxPerc;
		this.unitRate = unitRate;
	}

	public LogiBillingResourceDetail() {
		super();
	}
	
}