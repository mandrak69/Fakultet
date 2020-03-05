package model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the korisnik database table.
 * 
 */
@Entity
@NamedQuery(name="Korisnik.findAll", query="SELECT k FROM Korisnik k")
public class Korisnik implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;

	private String naziv;

	private int nivo;

	//bi-directional many-to-one association to Profil
	@ManyToOne(fetch=FetchType.LAZY)
	private Profil profil;

	//bi-directional many-to-one association to Profesor
	@OneToMany(mappedBy="korisnik")
	private List<Profesor> profesors;

	//bi-directional many-to-one association to Student
	@OneToMany(mappedBy="korisnik")
	private List<Student> students;

	public Korisnik() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNaziv() {
		return this.naziv;
	}

	public void setNaziv(String naziv) {
		this.naziv = naziv;
	}

	public int getNivo() {
		return this.nivo;
	}

	public void setNivo(int nivo) {
		this.nivo = nivo;
	}

	public Profil getProfil() {
		return this.profil;
	}

	public void setProfil(Profil profil) {
		this.profil = profil;
	}

	public List<Profesor> getProfesors() {
		return this.profesors;
	}

	public void setProfesors(List<Profesor> profesors) {
		this.profesors = profesors;
	}

	public Profesor addProfesor(Profesor profesor) {
		getProfesors().add(profesor);
		profesor.setKorisnik(this);

		return profesor;
	}

	public Profesor removeProfesor(Profesor profesor) {
		getProfesors().remove(profesor);
		profesor.setKorisnik(null);

		return profesor;
	}

	public List<Student> getStudents() {
		return this.students;
	}

	public void setStudents(List<Student> students) {
		this.students = students;
	}

	public Student addStudent(Student student) {
		getStudents().add(student);
		student.setKorisnik(this);

		return student;
	}

	public Student removeStudent(Student student) {
		getStudents().remove(student);
		student.setKorisnik(null);

		return student;
	}

}