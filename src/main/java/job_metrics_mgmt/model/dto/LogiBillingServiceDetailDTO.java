package job_metrics_mgmt.model.dto;

import java.io.Serializable;


public class LogiBillingServiceDetailDTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6136451785351438060L;
	private Long billSeqNo;
	private String amount;
	private String disc;
	private String discPerc;
	private String qty;
	private Long jobSeqNo;
	private String tax;
	private String taxPerc;
	private String unitRate;
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
	public Long getJobSeqNo() {
		return jobSeqNo;
	}
	public void setJobSeqNo(Long jobSeqNo) {
		this.jobSeqNo = jobSeqNo;
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
	public LogiBillingServiceDetailDTO(Long billSeqNo, String amount, String disc, String discPerc, String qty,
			Long jobSeqNo, String tax, String taxPerc, String unitRate) {
		super();
		this.billSeqNo = billSeqNo;
		this.amount = amount;
		this.disc = disc;
		this.discPerc = discPerc;
		this.qty = qty;
		this.jobSeqNo = jobSeqNo;
		this.tax = tax;
		this.taxPerc = taxPerc;
		this.unitRate = unitRate;
	}
	public LogiBillingServiceDetailDTO() {
		super();
	}
		
}