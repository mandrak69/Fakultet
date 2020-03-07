package model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;

/**
 * The persistent class for the predmet database table.
 * 
 */
@Entity
@NamedQuery(name = "Predmet.findAll", query = "SELECT p FROM Predmet p")
public class Predmet implements Serializable {
	private static final long serialVersionUID = 1L;
	private int predmetId;
	private String espb;
	private String naziv;
	private List<Profesor> profesors;
	private List<ProfesorHasPredmet> profesorHasPredmets;
	private List<Smer> smers;
	private List<SmerHasPredmet> smerHasPredmets;

	public Predmet() {
	}

	@Id
	@GeneratedValue(strategy = GenerationType.TABLE)
	@Column(name = "predmet_id")
	public int getPredmetId() {
		return this.predmetId;
	}

	// bi-directional many-to-many association to Profesor
	@ManyToMany(mappedBy = "predmets")
	public List<Profesor> getProfesors() {
		return this.profesors;
	}

//bi-directional many-to-one association to SmerHasPredmet
	@OneToMany(mappedBy = "predmet")
	public List<SmerHasPredmet> getSmerHasPredmets() {
		return this.smerHasPredmets;
	}

	// bi-directional many-to-many association to Smer
	@ManyToMany(mappedBy = "predmets")
	public List<Smer> getSmers() {
		return this.smers;
	}

	// bi-directional many-to-one association to ProfesorHasPredmet
	@OneToMany(mappedBy = "predmet")
	public List<ProfesorHasPredmet> getProfesorHasPredmets() {
		return this.profesorHasPredmets;
	}

	public void setProfesors(List<Profesor> profesors) {
		this.profesors = profesors;
	}

	public void setProfesorHasPredmets(List<ProfesorHasPredmet> profesorHasPredmets) {
		this.profesorHasPredmets = profesorHasPredmets;
	}

	public ProfesorHasPredmet addProfesorHasPredmet(ProfesorHasPredmet profesorHasPredmet) {
		getProfesorHasPredmets().add(profesorHasPredmet);
		profesorHasPredmet.setPredmet(this);

		return profesorHasPredmet;
	}

	public ProfesorHasPredmet removeProfesorHasPredmet(ProfesorHasPredmet profesorHasPredmet) {
		getProfesorHasPredmets().remove(profesorHasPredmet);
		profesorHasPredmet.setPredmet(null);

		return profesorHasPredmet;
	}

	public void setPredmetId(int predmetId) {
		this.predmetId = predmetId;
	}

	public String getEspb() {
		return this.espb;
	}

	public void setEspb(String espb) {
		this.espb = espb;
	}

	public String getNaziv() {
		return this.naziv;
	}

	public void setNaziv(String naziv) {
		this.naziv = naziv;
	}

	public void setSmers(List<Smer> smers) {
		this.smers = smers;
	}

	public void setSmerHasPredmets(List<SmerHasPredmet> smerHasPredmets) {
		this.smerHasPredmets = smerHasPredmets;
	}

	public SmerHasPredmet addSmerHasPredmet(SmerHasPredmet smerHasPredmet) {
		getSmerHasPredmets().add(smerHasPredmet);
		smerHasPredmet.setPredmet(this);

		return smerHasPredmet;
	}

	public SmerHasPredmet removeSmerHasPredmet(SmerHasPredmet smerHasPredmet) {
		getSmerHasPredmets().remove(smerHasPredmet);
		smerHasPredmet.setPredmet(null);

		return smerHasPredmet;
	}

	@Override
	public String toString() {
		return "Predmet [predmetId=" + predmetId + ", espb=" + espb + ", naziv=" + naziv + ", profesors=" + profesors
				+ ", profesorHasPredmets=" + profesorHasPredmets + ", smers=" + smers + ", smerHasPredmets="
				+ smerHasPredmets + "]";
	}

}