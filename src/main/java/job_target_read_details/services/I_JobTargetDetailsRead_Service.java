package job_target_read_details.services;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.ExecutionException;

import job_target_read_details.model.dto.JobTargetDetail_DTO;
import job_target_read_details.model.master.JobTargetDetailPK;

public interface I_JobTargetDetailsRead_Service 
{
	public CompletableFuture<CopyOnWriteArrayList<JobTargetDetail_DTO>> getAllJobTargetDetails() throws InterruptedException, ExecutionException;
	public CompletableFuture<CopyOnWriteArrayList<JobTargetDetail_DTO>> getAllJobTargetDetailsByIds(CopyOnWriteArrayList<JobTargetDetailPK> jobTargetDetailsPks) throws InterruptedException, ExecutionException;
	public CompletableFuture<CopyOnWriteArrayList<JobTargetDetail_DTO>> getSelectJobTargetDetails(CopyOnWriteArrayList<Long> jobTargetDetailsSeqNos) throws InterruptedException, ExecutionException;
	public CompletableFuture<Integer> getJobDurDays(Long jobSeqNo) throws InterruptedException, ExecutionException;
	public CompletableFuture<Integer> getJobDurHours(Long jobSeqNo) throws InterruptedException, ExecutionException;
	public CompletableFuture<Integer> getJobDurSeconds(Long jobSeqNo) throws InterruptedException, ExecutionException;
	public CompletableFuture<Integer> getJobDurMinutes(Long jobSeqNo) throws InterruptedException, ExecutionException;
	public CompletableFuture<Integer> getJobDurWeeks(Long jobSeqNo) throws InterruptedException, ExecutionException;
	public CompletableFuture<Integer> getJobDurMonths(Long jobSeqNo) throws InterruptedException, ExecutionException;
}