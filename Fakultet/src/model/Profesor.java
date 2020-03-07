package model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;

/**
 * The persistent class for the profesor database table.
 * 
 */
@Entity
@NamedQuery(name = "Profesor.findAll", query = "SELECT p FROM Profesor p")
public class Profesor implements Serializable {
	private static final long serialVersionUID = 1L;
	private int profesorId;
	private Date datumRodnosa;
	private String ime;
	private String prezime;
	private String telefon;
	private Department department;
	private List<Predmet> predmets;
	private Profil profil;
	private List<ProfesorHasPredmet> profesorHasPredmets;

	private Zvanje zvanje;

	public Profesor() {
	}

	@Id
	@GeneratedValue(strategy = GenerationType.TABLE)
	@Column(name = "profesor_id")
	public int getProfesorId() {
		return this.profesorId;
	}

	public void setProfesorId(int profesorId) {
		this.profesorId = profesorId;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "datum_rodnosa")
	public Date getDatumRodnosa() {
		return this.datumRodnosa;
	}

// bi-directional many-to-one association to Department
	@ManyToOne
	@JoinColumn(name = "department_id")
	public Department getDepartment() {
		return this.department;
	}

// bi-directional many-to-one association to Zvanje
	@ManyToOne
	@JoinColumn(name = "zvanje_id")
	public Zvanje getZvanje() {
		return this.zvanje;
	}

	// bi-directional many-to-one association to ProfesorHasPredmet
	@OneToMany(mappedBy = "profesor")
	public List<ProfesorHasPredmet> getProfesorHasPredmets() {
		return this.profesorHasPredmets;
	}

	// bi-directional many-to-one association to Profil
	@ManyToOne
	@JoinColumn(name = "profil_id")
	public Profil getProfil() {
		return this.profil;
	}

	// bi-directional many-to-many association to Predmet
	@ManyToMany
	@JoinTable(name = "profesor_has_predmet", joinColumns = {
			@JoinColumn(name = "profesor_predmet_id") }, inverseJoinColumns = {
					@JoinColumn(name = "predmet_profesor_id") })
	public List<Predmet> getPredmets() {
		return this.predmets;
	}

	public void setDatumRodnosa(Date datumRodnosa) {
		this.datumRodnosa = datumRodnosa;
	}

	public String getIme() {
		return this.ime;
	}

	public void setIme(String ime) {
		this.ime = ime;
	}

	public String getPrezime() {
		return this.prezime;
	}

	public void setPrezime(String prezime) {
		this.prezime = prezime;
	}

	public String getTelefon() {
		return this.telefon;
	}

	public void setTelefon(String telefon) {
		this.telefon = telefon;
	}

	public void setPredmets(List<Predmet> predmets) {
		this.predmets = predmets;
	}

	public void setDepartment(Department department) {
		this.department = department;
	}

	public void setProfil(Profil profil) {
		this.profil = profil;
	}

	public void setProfesorHasPredmets(List<ProfesorHasPredmet> profesorHasPredmets) {
		this.profesorHasPredmets = profesorHasPredmets;
	}

	public ProfesorHasPredmet addProfesorHasPredmet(ProfesorHasPredmet profesorHasPredmet) {
		getProfesorHasPredmets().add(profesorHasPredmet);
		profesorHasPredmet.setProfesor(this);

		return profesorHasPredmet;
	}

	public ProfesorHasPredmet removeProfesorHasPredmet(ProfesorHasPredmet profesorHasPredmet) {
		getProfesorHasPredmets().remove(profesorHasPredmet);
		profesorHasPredmet.setProfesor(null);

		return profesorHasPredmet;
	}

	@Override
	public String toString() {
		return "Profesor [profesorId=" + profesorId + ", datumRodnosa=" + datumRodnosa + ", ime=" + ime + ", prezime="
				+ prezime + ", telefon=" + telefon + ", department=" + department + ", predmets=" + predmets
				+ ", profil=" + profil + ", profesorHasPredmets=" + profesorHasPredmets + ", zvanje=" + zvanje + "]";
	}

}