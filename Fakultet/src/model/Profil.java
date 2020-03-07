package model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;

/**
 * The persistent class for the profil database table.
 * 
 */
@Entity
@NamedQuery(name = "Profil.findAll", query = "SELECT p FROM Profil p")
public class Profil implements Serializable {
	private static final long serialVersionUID = 1L;
	private int profilId;
	private String password;
	private String phone;
	private String tipKorisnika;
	private String username;
	private List<Profesor> profesors;
	private Rola rola;
	private List<Sluzbenik> sluzbeniks;
	private List<Student> students;

	public Profil() {
	}

	@Id
	@GeneratedValue(strategy = GenerationType.TABLE)
	@Column(name = "profil_id")
	public int getProfilId() {
		return this.profilId;
	}


	// bi-directional many-to-one association to Profesor
	@OneToMany(mappedBy = "profil")
	public List<Profesor> getProfesors() {
		return this.profesors;
	}

	// bi-directional many-to-one association to Rola
	@ManyToOne
	@JoinColumn(name = "rola_id")
	public Rola getRola() {
		return this.rola;
	}

   //bi-directional many-to-one association to Student
	@OneToMany(mappedBy = "profil")
	public List<Student> getStudents() {
		return this.students;
	}

	@Column(name = "tip_korisnika")
	public String getTipKorisnika() {
		return this.tipKorisnika;
	}
	// bi-directional many-to-one association to Sluzbenik
	@OneToMany(mappedBy = "profil")
	public List<Sluzbenik> getSluzbeniks() {
		return this.sluzbeniks;
	}

	public void setRola(Rola rola) {
		this.rola = rola;
	}

	public void setProfesors(List<Profesor> profesors) {
		this.profesors = profesors;
	}

	public Profesor addProfesor(Profesor profesor) {
		getProfesors().add(profesor);
		profesor.setProfil(this);

		return profesor;
	}

	public Profesor removeProfesor(Profesor profesor) {
		getProfesors().remove(profesor);
		profesor.setProfil(null);

		return profesor;
	}

	public void setSluzbeniks(List<Sluzbenik> sluzbeniks) {
		this.sluzbeniks = sluzbeniks;
	}

	public void setTipKorisnika(String tipKorisnika) {
		this.tipKorisnika = tipKorisnika;
	}

	public void setProfilId(int profilId) {
		this.profilId = profilId;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPhone() {
		return this.phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getUsername() {
		return this.username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public Sluzbenik addSluzbenik(Sluzbenik sluzbenik) {
		getSluzbeniks().add(sluzbenik);
		sluzbenik.setProfil(this);

		return sluzbenik;
	}

	public Sluzbenik removeSluzbenik(Sluzbenik sluzbenik) {
		getSluzbeniks().remove(sluzbenik);
		sluzbenik.setProfil(null);

		return sluzbenik;
	}

	public void setStudents(List<Student> students) {
		this.students = students;
	}

	public Student addStudent(Student student) {
		getStudents().add(student);
		student.setProfil(this);

		return student;
	}

	public Student removeStudent(Student student) {
		getStudents().remove(student);
		student.setProfil(null);

		return student;
	}

	@Override
	public String toString() {
		return "Profil [profilId=" + profilId + ", password=" + password + ", phone=" + phone + ", tipKorisnika="
				+ tipKorisnika + ", username=" + username + ", profesors=" + profesors + ", rola=" + rola
				+ ", sluzbeniks=" + sluzbeniks + ", students=" + students + "]";
	}

}