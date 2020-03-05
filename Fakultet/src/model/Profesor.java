package model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the profesor database table.
 * 
 */
@Entity
@NamedQuery(name="Profesor.findAll", query="SELECT p FROM Profesor p")
public class Profesor implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private ProfesorPK id;

	@Temporal(TemporalType.DATE)
	private Date datum;

	private String ime;

	private String prezime;

	private String profesorcol;

	private String zvanje;

	//bi-directional many-to-one association to Department
	@ManyToOne(fetch=FetchType.LAZY)
	private Department department;

	//bi-directional many-to-one association to Korisnik
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="tip_id")
	private Korisnik korisnik;

	public Profesor() {
	}

	public ProfesorPK getId() {
		return this.id;
	}

	public void setId(ProfesorPK id) {
		this.id = id;
	}

	public Date getDatum() {
		return this.datum;
	}

	public void setDatum(Date datum) {
		this.datum = datum;
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

	public String getProfesorcol() {
		return this.profesorcol;
	}

	public void setProfesorcol(String profesorcol) {
		this.profesorcol = profesorcol;
	}

	public String getZvanje() {
		return this.zvanje;
	}

	public void setZvanje(String zvanje) {
		this.zvanje = zvanje;
	}

	public Department getDepartment() {
		return this.department;
	}

	public void setDepartment(Department department) {
		this.department = department;
	}

	public Korisnik getKorisnik() {
		return this.korisnik;
	}

	public void setKorisnik(Korisnik korisnik) {
		this.korisnik = korisnik;
	}

}