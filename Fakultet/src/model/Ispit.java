package model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;

/**
 * The persistent class for the ispit database table.
 * 
 */
@Entity
@NamedQuery(name = "Ispit.findAll", query = "SELECT i FROM Ispit i")
public class Ispit implements Serializable {
	private static final long serialVersionUID = 1L;
	private int id;
	private Date datum;
	private int ocena;
	private ProfesorHasPredmet profesorHasPredmet;
	private Student student;

	public Ispit() {
	}

	@Id
	@GeneratedValue(strategy = GenerationType.TABLE)
	public int getId() {
		return this.id;
	}

	@Temporal(TemporalType.DATE)
	public Date getDatum() {
		return this.datum;
	}

	// bi-directional many-to-one association to Student
	@ManyToOne
	@JoinColumn(name = "student_id")
	public Student getStudent() {
		return this.student;
	}

	// bi-directional many-to-one association to ProfesorHasPredmet
	@ManyToOne
	@JoinColumn(name = "prof_predmet_id")
	public ProfesorHasPredmet getProfesorHasPredmet() {
		return this.profesorHasPredmet;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setDatum(Date datum) {
		this.datum = datum;
	}

	public int getOcena() {
		return this.ocena;
	}

	public void setOcena(int ocena) {
		this.ocena = ocena;
	}

	public void setProfesorHasPredmet(ProfesorHasPredmet profesorHasPredmet) {
		this.profesorHasPredmet = profesorHasPredmet;
	}

	public void setStudent(Student student) {
		this.student = student;
	}

	@Override
	public String toString() {
		return "Ispit [id=" + id + ", datum=" + datum + ", ocena=" + ocena + ", profesorHasPredmet="
				+ profesorHasPredmet + ", student=" + student + "]";
	}

}