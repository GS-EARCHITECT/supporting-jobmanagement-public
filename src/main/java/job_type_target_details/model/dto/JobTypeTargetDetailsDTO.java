package job_type_target_details.model.dto;

import java.io.Serializable;

public class JobTypeTargetDetailsDTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3155705397624659763L;
	private long jobTypeSeqNo;
	private long targetSeqNo;
	private Integer durDays;
	private Integer durHours;
	private Integer durMinutes;
	private Integer durMonths;
	private Integer durSeconds;
	private Integer durWeeks;
	private Float duration;
	private Integer durationSeqNo;
	private Integer rateSeqNo;
	private String remarks;
	private String status;
	private Float unitRate;

	public long getJobTypeSeqNo() {
		return jobTypeSeqNo;
	}

	public void setJobTypeSeqNo(long jobTypeSeqNo) {
		this.jobTypeSeqNo = jobTypeSeqNo;
	}

	public long getTargetSeqNo() {
		return targetSeqNo;
	}

	public void setTargetSeqNo(long targetSeqNo) {
		this.targetSeqNo = targetSeqNo;
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

	public JobTypeTargetDetailsDTO(long jobTypeSeqNo, long targetSeqNo, Integer durDays, Integer durHours,
			Integer durMinutes, Integer durMonths, Integer durSeconds, Integer durWeeks, Float duration,
			Integer durationSeqNo, Integer rateSeqNo, String remarks, String status, Float unitRate) {
		super();
		this.jobTypeSeqNo = jobTypeSeqNo;
		this.targetSeqNo = targetSeqNo;
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

	public JobTypeTargetDetailsDTO() {
		super();
	}

}