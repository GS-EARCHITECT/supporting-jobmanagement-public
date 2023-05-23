package job_type_target_details.model.master;

import java.io.Serializable;
import javax.persistence.*;

@Entity
@Table(name = "JOB_TYPE_TARGET_DETAILS")
public class JobTypeTargetDetails implements Serializable 
{
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private JobTypeTargetDetailsPK id;

	@Column(name = "DUR_DAYS")
	private Integer durDays;

	@Column(name = "DUR_HOURS")
	private Integer durHours;

	@Column(name = "DUR_MINUTES")
	private Integer durMinutes;

	@Column(name = "DUR_MONTHS")
	private Integer durMonths;

	@Column(name = "DUR_SECONDS")
	private Integer durSeconds;

	@Column(name = "DUR_WEEKS")
	private Integer durWeeks;

	@Column(name = "DURATION")
	private Float duration;

	@Column(name = "DURATION_SEQ_NO")
	private Integer durationSeqNo;

	@Column(name = "RATE_SEQ_NO")
	private Integer rateSeqNo;

	@Column(name = "REMARKS")
	private String remarks;

	@Column(name = "STATUS")
	private String status;

	@Column(name = "UNIT_RATE")
	private Float unitRate;

	public JobTypeTargetDetails() {
	}

	public JobTypeTargetDetailsPK getId() {
		return id;
	}

	public void setId(JobTypeTargetDetailsPK id) {
		this.id = id;
	}

	public Integer getDurDays() {
		return durDays;
	}

	public void setDurDays(Integer durDays) {
		this.durDays = durDays;
	}

	public Integer getDurHours() {
		return durHours;
	}

	public void setDurHours(Integer durHours) {
		this.durHours = durHours;
	}

	public Integer getDurMinutes() {
		return durMinutes;
	}

	public void setDurMinutes(Integer durMinutes) {
		this.durMinutes = durMinutes;
	}

	public Integer getDurMonths() {
		return durMonths;
	}

	public void setDurMonths(Integer durMonths) {
		this.durMonths = durMonths;
	}

	public Integer getDurSeconds() {
		return durSeconds;
	}

	public void setDurSeconds(Integer durSeconds) {
		this.durSeconds = durSeconds;
	}

	public Integer getDurWeeks() {
		return durWeeks;
	}

	public void setDurWeeks(Integer durWeeks) {
		this.durWeeks = durWeeks;
	}

	public Float getDuration() {
		return duration;
	}

	public void setDuration(Float duration) {
		this.duration = duration;
	}

	public Integer getDurationSeqNo() {
		return durationSeqNo;
	}

	public void setDurationSeqNo(Integer durationSeqNo) {
		this.durationSeqNo = durationSeqNo;
	}

	public Integer getRateSeqNo() {
		return rateSeqNo;
	}

	public void setRateSeqNo(Integer rateSeqNo) {
		this.rateSeqNo = rateSeqNo;
	}

	public String getRemarks() {
		return remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Float getUnitRate() {
		return unitRate;
	}

	public void setUnitRate(Float unitRate) {
		this.unitRate = unitRate;
	}

	public JobTypeTargetDetails(JobTypeTargetDetailsPK id, Integer durDays, Integer durHours, Integer durMinutes,
			Integer durMonths, Integer durSeconds, Integer durWeeks, Float duration, Integer durationSeqNo,
			Integer rateSeqNo, String remarks, String status, Float unitRate) {
		super();
		this.id = id;
		this.durDays = durDays;
		this.durHours = durHours;
		this.durMinutes = durMinutes;
		this.durMonths = durMonths;
		this.durSeconds = durSeconds;
		this.durWeeks = durWeeks;
		this.duration = duration;
		this.durationSeqNo = durationSeqNo;
		this.rateSeqNo = rateSeqNo;
		this.remarks = remarks;
		this.status = status;
		this.unitRate = unitRate;
	}

}