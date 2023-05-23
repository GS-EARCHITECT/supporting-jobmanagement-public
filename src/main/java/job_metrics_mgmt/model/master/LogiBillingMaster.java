package job_metrics_mgmt.model.master;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The persistent class for the LOGI_BILLING_MASTER database table.
 * 
 */
@Entity
@Table(name="LOGI_BILLING_MASTER")
public class LogiBillingMaster implements Serializable 
{

	/**
	 * 
	 */
	private static final long serialVersionUID = -3712530195600795376L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "bill_no_sequence")
	@SequenceGenerator(name = "bill_no_sequence", sequenceName="bill_no_sequence", allocationSize = 1)
	private Long bill_seq_no;

	@Column(name="STATUS")
	private String status;

	@Column(name="REMARK")	
	private String remark;
	
	@Column(name="BILL_DATE")
	private String billDate;

	@Column(name="SERVICE_WORK_SEQ_NO")
	private Long serviceWorkSeqNo;

	@Column(name="TOTAL_AMT")
	private String totalAmt;

	@Column(name="CUSTOMER_SEQ_NO")
	private Long customerSeqNo;
	
	@Column(name="BILL_NO")
	private String billNo;
	
	@Column(name="CLOSURE_DATE")
	private String closureDate;

	@Column(name="PREPARED_BY")
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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((billDate == null) ? 0 : billDate.hashCode());
		result = prime * result + ((billNo == null) ? 0 : billNo.hashCode());
		result = prime * result + ((bill_seq_no == null) ? 0 : bill_seq_no.hashCode());
		result = prime * result + ((closureDate == null) ? 0 : closureDate.hashCode());
		result = prime * result + ((customerSeqNo == null) ? 0 : customerSeqNo.hashCode());
		result = prime * result + ((preparedBy == null) ? 0 : preparedBy.hashCode());
		result = prime * result + ((remark == null) ? 0 : remark.hashCode());
		result = prime * result + ((serviceWorkSeqNo == null) ? 0 : serviceWorkSeqNo.hashCode());
		result = prime * result + ((status == null) ? 0 : status.hashCode());
		result = prime * result + ((totalAmt == null) ? 0 : totalAmt.hashCode());
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
		LogiBillingMaster other = (LogiBillingMaster) obj;
		if (billDate == null) {
			if (other.billDate != null)
				return false;
		} else if (!billDate.equals(other.billDate))
			return false;
		if (billNo == null) {
			if (other.billNo != null)
				return false;
		} else if (!billNo.equals(other.billNo))
			return false;
		if (bill_seq_no == null) {
			if (other.bill_seq_no != null)
				return false;
		} else if (!bill_seq_no.equals(other.bill_seq_no))
			return false;
		if (closureDate == null) {
			if (other.closureDate != null)
				return false;
		} else if (!closureDate.equals(other.closureDate))
			return false;
		if (customerSeqNo == null) {
			if (other.customerSeqNo != null)
				return false;
		} else if (!customerSeqNo.equals(other.customerSeqNo))
			return false;
		if (preparedBy == null) {
			if (other.preparedBy != null)
				return false;
		} else if (!preparedBy.equals(other.preparedBy))
			return false;
		if (remark == null) {
			if (other.remark != null)
				return false;
		} else if (!remark.equals(other.remark))
			return false;
		if (serviceWorkSeqNo == null) {
			if (other.serviceWorkSeqNo != null)
				return false;
		} else if (!serviceWorkSeqNo.equals(other.serviceWorkSeqNo))
			return false;
		if (status == null) {
			if (other.status != null)
				return false;
		} else if (!status.equals(other.status))
			return false;
		if (totalAmt == null) {
			if (other.totalAmt != null)
				return false;
		} else if (!totalAmt.equals(other.totalAmt))
			return false;
		return true;
	}

	public LogiBillingMaster(Long bill_seq_no, String status, String remark, String billDate,
			Long serviceWorkSeqNo, String totalAmt, Long customerSeqNo, String billNo, String closureDate,
			Long preparedBy) {
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

	public LogiBillingMaster() {
		super();
	}
	
}