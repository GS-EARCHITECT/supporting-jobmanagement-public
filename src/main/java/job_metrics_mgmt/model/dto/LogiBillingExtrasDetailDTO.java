package job_metrics_mgmt.model.dto;

import java.io.Serializable;

public class LogiBillingExtrasDetailDTO implements Serializable 
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 2335849020613081676L;
	private Long billSeqNo;
	private String amount;
	private String discPerc;
	private String discount;
	private String tax;
	private String taxPerc;
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
	public LogiBillingExtrasDetailDTO(Long billSeqNo, String amount, String discPerc, String discount, String tax,
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
	public LogiBillingExtrasDetailDTO() {
		super();
	}
		
}