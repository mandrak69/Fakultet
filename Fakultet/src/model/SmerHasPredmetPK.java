package model;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the smer_has_predmet database table.
 * 
 */
@Embeddable
public class SmerHasPredmetPK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;
	private int predmetId;
	private int smerId;

	public SmerHasPredmetPK() {
	}

	@Column(name="predmet_id", insertable=false, updatable=false)
	public int getPredmetId() {
		return this.predmetId;
	}
	public void setPredmetId(int predmetId) {
		this.predmetId = predmetId;
	}

	@Column(name="smer_id", insertable=false, updatable=false)
	public int getSmerId() {
		return this.smerId;
	}
	public void setSmerId(int smerId) {
		this.smerId = smerId;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof SmerHasPredmetPK)) {
			return false;
		}
		SmerHasPredmetPK castOther = (SmerHasPredmetPK)other;
		return 
			(this.predmetId == castOther.predmetId)
			&& (this.smerId == castOther.smerId);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.predmetId;
		hash = hash * prime + this.smerId;
		
		return hash;
	}

	@Override
	public String toString() {
		return "SmerHasPredmetPK [predmetId=" + predmetId + ", smerId=" + smerId + "]";
	}
	
	
}