package job_metrics_mgmt.model.dto;

import java.io.Serializable;

public class LogiBillingMasterDTO implements Serializable 
{
	/**
	 * 
	 */
	private static final long serialVersionUID = -6360944006046860982L;
	private Long bill_seq_no;
	private String status;
	private String remark;
	private String billDate;
	private Long serviceWorkSeqNo;
	private String totalAmt;
	private Long customerSeqNo;
	private String billNo;
	private String closureDate;
	private Long preparedBy;
	public Long getBill_seq_no() {
		return bill_seq_no;
	}
	public void setBill_seq_no(Long bill_seq_no) {
		this.bill_seq_no = bill_seq_no;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	public String getBillDate() {
		return billDate;
	}
	public void setBillDate(String billDate) {
		this.billDate = billDate;
	}
	public Long getServiceWorkSeqNo() {
		return serviceWorkSeqNo;
	}
	public void setServiceWorkSeqNo(Long serviceWorkSeqNo) {
		this.serviceWorkSeqNo = serviceWorkSeqNo;
	}
	public String getTotalAmt() {
		return totalAmt;
	}
	public void setTotalAmt(String totalAmt) {
		this.totalAmt = totalAmt;
	}
	public Long getCustomerSeqNo() {
		return customerSeqNo;
	}
	public void setCustomerSeqNo(Long customerSeqNo) {
		this.customerSeqNo = customerSeqNo;
	}
	public String getBillNo() {
		return billNo;
	}
	public void setBillNo(String billNo) {
		this.billNo = billNo;
	}
	public String getClosureDate() {
		return closureDate;
	}
	public void setClosureDate(String closureDate) {
		this.closureDate = closureDate;
	}
	public Long getPreparedBy() {
		return preparedBy;
	}
	public void setPreparedBy(Long preparedBy) {
		this.preparedBy = preparedBy;
	}
	public LogiBillingMasterDTO(Long bill_seq_no, String status, String remark, String billDate, Long serviceWorkSeqNo,
			String totalAmt, Long customerSeqNo, String billNo, String closureDate, Long preparedBy) {
		super();
		this.bill_seq_no = bill_seq_no;
		this.status = status;
		this.remark = remark;
		this.billDate = billDate;
		this.serviceWorkSeqNo = serviceWorkSeqNo;
		this.totalAmt = totalAmt;
		this.customerSeqNo = customerSeqNo;
		this.billNo = billNo;
		this.closureDate = closureDate;
		this.preparedBy = preparedBy;
	}
	public LogiBillingMasterDTO() {
		super();
	}
	
}