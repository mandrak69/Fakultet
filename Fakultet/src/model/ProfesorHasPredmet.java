package model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;

/**
 * The persistent class for the profesor_has_predmet database table.
 * 
 */
@Entity
@Table(name = "profesor_has_predmet")
@NamedQuery(name = "ProfesorHasPredmet.findAll", query = "SELECT p FROM ProfesorHasPredmet p")
public class ProfesorHasPredmet implements Serializable {
	private static final long serialVersionUID = 1L;
	private int profPredmetId;
	private Date datum;
	private int semestar;
	private List<Ispit> ispits;
	private Predmet predmet;
	private Profesor profesor;

	public ProfesorHasPredmet() {
	}

	@Id
	@GeneratedValue(strategy = GenerationType.TABLE)
	@Column(name = "prof_predmet_id")
	public int getProfPredmetId() {
		return this.profPredmetId;
	}

	@Temporal(TemporalType.DATE)
	public Date getDatum() {
		return this.datum;
	}

	// bi-directional many-to-one association to Profesor
	@ManyToOne
	@JoinColumn(name = "profesor_predmet_id")
	public Profesor getProfesor() {
		return this.profesor;
	}

	// bi-directional many-to-one association to Predmet
	@ManyToOne
	@JoinColumn(name = "predmet_profesor_id")
	public Predmet getPredmet() {
		return this.predmet;
	}

	// bi-directional many-to-one association to Ispit
	@OneToMany(mappedBy = "profesorHasPredmet")
	public List<Ispit> getIspits() {
		return this.ispits;
	}

	public void setDatum(Date datum) {
		this.datum = datum;
	}

	public void setProfPredmetId(int profPredmetId) {
		this.profPredmetId = profPredmetId;
	}

	public void setSemestar(int semestar) {
		this.semestar = semestar;
	}

	public int getSemestar() {
		return this.semestar;
	}

	public void setIspits(List<Ispit> ispits) {
		this.ispits = ispits;
	}

	public Ispit addIspit(Ispit ispit) {
		getIspits().add(ispit);
		ispit.setProfesorHasPredmet(this);

		return ispit;
	}

	public Ispit removeIspit(Ispit ispit) {
		getIspits().remove(ispit);
		ispit.setProfesorHasPredmet(null);

		return ispit;
	}

	public void setPredmet(Predmet predmet) {
		this.predmet = predmet;
	}

	public void setProfesor(Profesor profesor) {
		this.profesor = profesor;
	}

	@Override
	public String toString() {
		return "ProfesorHasPredmet [profPredmetId=" + profPredmetId + ", datum=" + datum + ", sem.=" + semestar
				+ ", ispits=" + ispits + ", predmet=" + predmet + ", profesor=" + profesor + "]";
	}

}