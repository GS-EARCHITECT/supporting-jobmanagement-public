package job_asset_master_mgmt.model.master;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the JOB_ASSET_MASTER database table.
 * 
 */
@Entity
@Table(name="JOB_ASSET_MASTER")
public class JobAssetMaster implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private JobAssetMasterPK id;

	@Column(name="RATE_SEQ_NO")
	private Long rateSeqNo;

	@Column(name="RETURNFLAG")
	private Character returnflag;

	@Column(name="UNIT_RATE")
	private Float unitRate;
	
	@Column(name="DIRECTIONFLAG")
	private Character directionflag;

	public JobAssetMaster() {
	}

	public JobAssetMasterPK getId() {
		return this.id;
	}

	public void setId(JobAssetMasterPK id) {
		this.id = id;
	}

	public Long getRateSeqNo() {
		return this.rateSeqNo;
	}

	public void setRateSeqNo(Long rateSeqNo) {
		this.rateSeqNo = rateSeqNo;
	}

	public Character getReturnflag() {
		return this.returnflag;
	}

	public void setReturnflag(Character returnflag) {
		this.returnflag = returnflag;
	}

	public Float getUnitRate() {
		return this.unitRate;
	}

	public void setUnitRate(Float unitRate) {
		this.unitRate = unitRate;
	}

	public Character getDirectionflag() {
		return directionflag;
	}

	public void setDirectionflag(Character directionflag) {
		this.directionflag = directionflag;
	}

	public JobAssetMaster(JobAssetMasterPK id, Long rateSeqNo, Character returnflag, Float unitRate,
			Character directionflag) {
		super();
		this.id = id;
		this.rateSeqNo = rateSeqNo;
		this.returnflag = returnflag;
		this.unitRate = unitRate;
		this.directionflag = directionflag;
	}
	
	

}