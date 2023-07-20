package job_structure_details_mgmt.model.master;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The persistent class for the JOB_STRUCTURE_DETAILS database table.
 * 
 */
@Entity
@Table(name = "JOB_STRUCTURE_DETAILS")
public class JobStructureDetail implements Serializable 
{
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private JobStructureDetailPK id;

	public JobStructureDetail() {
	}

	public JobStructureDetailPK getId() {
		return this.id;
	}

	public void setId(JobStructureDetailPK id) {
		this.id = id;
	}

	public JobStructureDetail(JobStructureDetailPK id) {
		super();
		this.id = id;
	}

}