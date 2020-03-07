package model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;

/**
 * The persistent class for the student database table.
 * 
 */
@Entity
@NamedQuery(name = "Student.findAll", query = "SELECT s FROM Student s")
public class Student implements Serializable {
	private static final long serialVersionUID = 1L;
	private int studentId;
	private Date datumRodjenja;
	private String ime;
	private String indeks;
	private String prezime;
	private String telefon;
	private List<Ispit> ispits;
	private Profil profil;
	private Smer smer;

	public Student() {
	}

	@Id
	@GeneratedValue(strategy = GenerationType.TABLE)
	@Column(name = "student_id")

	public int getStudentId() {
		return this.studentId;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "datum_rodjenja")
	public Date getDatumRodjenja() {
		return this.datumRodjenja;
	}

	// bi-directional many-to-one association to Ispit
	@OneToMany(mappedBy = "student")
	public List<Ispit> getIspits() {
		return this.ispits;
	}

	// bi-directional many-to-one association to Smer
	@ManyToOne
	@JoinColumn(name = "smer_id")
	public Smer getSmer() {
		return this.smer;
	}

	// bi-directional many-to-one association to Profil
	@ManyToOne
	@JoinColumn(name = "profil_id")
	public Profil getProfil() {
		return this.profil;
	}

	public void setIspits(List<Ispit> ispits) {
		this.ispits = ispits;
	}

	public void setDatumRodjenja(Date datumRodjenja) {
		this.datumRodjenja = datumRodjenja;
	}

	public String getIme() {
		return this.ime;
	}

	public void setStudentId(int studentId) {
		this.studentId = studentId;
	}

	public void setIme(String ime) {
		this.ime = ime;
	}

	public String getIndeks() {
		return this.indeks;
	}

	public void setIndeks(String indeks) {
		this.indeks = indeks;
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

	public Ispit addIspit(Ispit ispit) {
		getIspits().add(ispit);
		ispit.setStudent(this);

		return ispit;
	}

	public Ispit removeIspit(Ispit ispit) {
		getIspits().remove(ispit);
		ispit.setStudent(null);

		return ispit;
	}

	public void setProfil(Profil profil) {
		this.profil = profil;
	}

	public void setSmer(Smer smer) {
		this.smer = smer;
	}

	@Override
	public String toString() {
		return "Student [studentId=" + studentId + ", datumRodjenja=" + datumRodjenja + ", ime=" + ime + ", indeks="
				+ indeks + ", prezime=" + prezime + ", telefon=" + telefon + ", ispits=" + ispits + ", profil=" + profil
				+ ", smer=" + smer + "]";
	}

}