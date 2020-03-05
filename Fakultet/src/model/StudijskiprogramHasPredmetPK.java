package model;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the studijskiprogram_has_predmet database table.
 * 
 */
@Embeddable
public class StudijskiprogramHasPredmetPK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	private int id;

	@Column(name="studijskiprogram_id", insertable=false, updatable=false)
	private int studijskiprogramId;

	@Column(name="predmet_id", insertable=false, updatable=false)
	private int predmetId;

	public StudijskiprogramHasPredmetPK() {
	}
	public int getId() {
		return this.id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getStudijskiprogramId() {
		return this.studijskiprogramId;
	}
	public void setStudijskiprogramId(int studijskiprogramId) {
		this.studijskiprogramId = studijskiprogramId;
	}
	public int getPredmetId() {
		return this.predmetId;
	}
	public void setPredmetId(int predmetId) {
		this.predmetId = predmetId;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof StudijskiprogramHasPredmetPK)) {
			return false;
		}
		StudijskiprogramHasPredmetPK castOther = (StudijskiprogramHasPredmetPK)other;
		return 
			(this.id == castOther.id)
			&& (this.studijskiprogramId == castOther.studijskiprogramId)
			&& (this.predmetId == castOther.predmetId);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.id;
		hash = hash * prime + this.studijskiprogramId;
		hash = hash * prime + this.predmetId;
		
		return hash;
	}
}