package job_class_structure_read_mgmt.model.master;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The persistent class for the JOB_CLASS_STRUCTURE database table.
 * 
 */
@Entity
@Table(name = "JOB_CLASS_STRUCTURE")
public class JobClassStructure implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private JobClassStructurePK id;

	public JobClassStructure() {
	}

	public JobClassStructurePK getId() {
		return this.id;
	}

	public void setId(JobClassStructurePK id) {
		this.id = id;
	}

	public JobClassStructure(JobClassStructurePK id) {
		super();
		this.id = id;
	}

}