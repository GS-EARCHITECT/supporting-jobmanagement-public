package job_class_structure_read_mgmt.services;

import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.ExecutionException;

import job_class_structure_read_mgmt.model.dto.JobClassStructure_DTO;

public interface I_JobClassStructureRead_Service 
{
	public CopyOnWriteArrayList<JobClassStructure_DTO> getSelectJobClassStructures(CopyOnWriteArrayList<Long> ids, CopyOnWriteArrayList<Long> pids) throws InterruptedException, ExecutionException;

	public CopyOnWriteArrayList<JobClassStructure_DTO> getSelectJobClassesByParents(CopyOnWriteArrayList<Long> ids) throws InterruptedException, ExecutionException;

	public CopyOnWriteArrayList<JobClassStructure_DTO> getSelectJobClassesByParties(CopyOnWriteArrayList<Long> pids) throws InterruptedException, ExecutionException;

	public CopyOnWriteArrayList<JobClassStructure_DTO> getAllJobClassStructures() throws InterruptedException, ExecutionException;

}