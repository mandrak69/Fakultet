package model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the smer_has_predmet database table.
 * 
 */
@Entity
@Table(name="smer_has_predmet")
@NamedQuery(name="SmerHasPredmet.findAll", query="SELECT s FROM SmerHasPredmet s")
public class SmerHasPredmet implements Serializable {
	private static final long serialVersionUID = 1L;
	private SmerHasPredmetPK id;
	private Date datum;
	private Predmet predmet;
	private Smer smer;

	public SmerHasPredmet() {
	}


	@EmbeddedId
	public SmerHasPredmetPK getId() {
		return this.id;
	}

	public void setId(SmerHasPredmetPK id) {
		this.id = id;
	}


	@Temporal(TemporalType.DATE)
	public Date getDatum() {
		return this.datum;
	}


	//bi-directional many-to-one association to Predmet
	@ManyToOne
	@JoinColumn(name="predmet_id")
	public Predmet getPredmet() {
		return this.predmet;
	}

	


	//bi-directional many-to-one association to Smer
	@ManyToOne
	@JoinColumn(name="smer_id")
	public Smer getSmer() {
		return this.smer;
	}

	public void setSmer(Smer smer) {
		this.smer = smer;
	}
public void setPredmet(Predmet predmet) {
		this.predmet = predmet;
	}

	public void setDatum(Date datum) {
		this.datum = datum;
	}

	@Override
	public String toString() {
		return "SmerHasPredmet [id=" + id + ", datum=" + datum + ", predmet=" + predmet + ", smer=" + smer + "]";
	}

}