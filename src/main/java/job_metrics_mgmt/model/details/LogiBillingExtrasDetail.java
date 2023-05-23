package job_metrics_mgmt.model.details;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The persistent class for the LOGI_BILLING_EXTRAS_DETAILS database table.
 * 
 */
@Entity
@Table(name="LOGI_BILLING_EXTRAS_DETAILS")
public class LogiBillingExtrasDetail implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 8333366824651736948L;

	@Id
	@Column(name="BILL_SEQ_NO")
	private Long billSeqNo;
	
	@Column(name="AMOUNT")
	private String amount;

	@Column(name="DISC_PERC")
	private String discPerc;

	@Column(name="DISC")
	private String discount;

	@Column(name="TAX")
	private String tax;
	
	@Column(name="TAX_PERC")
	private String taxPerc;

	@Column(name="EXTRA_TYPE")
	private String extraType;

	public Long getBillSeqNo() {
		return billSeqNo;
	}

	public void setBillSeqNo(Long billSeqNo) {
		this.billSeqNo = billSeqNo;
	}

	public String getAmount() {
		return amount;
	}

	public void setAmount(String amount) {
		this.amount = amount;
	}

	public String getDiscPerc() {
		return discPerc;
	}

	public void setDiscPerc(String discPerc) {
		this.discPerc = discPerc;
	}

	public String getDiscount() {
		return discount;
	}

	public void setDiscount(String discount) {
		this.discount = discount;
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

	public String getExtraType() {
		return extraType;
	}

	public void setExtraType(String extraType) {
		this.extraType = extraType;
	}

	public LogiBillingExtrasDetail(Long billSeqNo, String amount, String discPerc, String discount, String tax,
			String taxPerc, String extraType) {
		super();
		this.billSeqNo = billSeqNo;
		this.amount = amount;
		this.discPerc = discPerc;
		this.discount = discount;
		this.tax = tax;
		this.taxPerc = taxPerc;
		this.extraType = extraType;
	}

	public LogiBillingExtrasDetail() {
		super();
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((amount == null) ? 0 : amount.hashCode());
		result = prime * result + ((billSeqNo == null) ? 0 : billSeqNo.hashCode());
		result = prime * result + ((discPerc == null) ? 0 : discPerc.hashCode());
		result = prime * result + ((discount == null) ? 0 : discount.hashCode());
		result = prime * result + ((extraType == null) ? 0 : extraType.hashCode());
		result = prime * result + ((tax == null) ? 0 : tax.hashCode());
		result = prime * result + ((taxPerc == null) ? 0 : taxPerc.hashCode());
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
		LogiBillingExtrasDetail other = (LogiBillingExtrasDetail) obj;
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
		if (discPerc == null) {
			if (other.discPerc != null)
				return false;
		} else if (!discPerc.equals(other.discPerc))
			return false;
		if (discount == null) {
			if (other.discount != null)
				return false;
		} else if (!discount.equals(other.discount))
			return false;
		if (extraType == null) {
			if (other.extraType != null)
				return false;
		} else if (!extraType.equals(other.extraType))
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
		return true;
	}

	
}