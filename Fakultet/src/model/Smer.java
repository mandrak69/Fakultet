package model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;

/**
 * The persistent class for the smer database table.
 * 
 */
@Entity
@NamedQuery(name = "Smer.findAll", query = "SELECT s FROM Smer s")
public class Smer implements Serializable {
	private static final long serialVersionUID = 1L;
	private int smerId;
	private String naziv;
	private List<Predmet> predmets;
	private List<SmerHasPredmet> smerHasPredmets;
	private List<Student> students;

	public Smer() {
	}

	@Id
	@GeneratedValue(strategy = GenerationType.TABLE)
	@Column(name = "smer_id")
	public int getSmerId() {
		return this.smerId;
	}

	// bi-directional many-to-many association to Predmet
	@ManyToMany
	@JoinTable(name = "smer_has_predmet", joinColumns = { @JoinColumn(name = "smer_id") }, inverseJoinColumns = {
			@JoinColumn(name = "predmet_id") })
	public List<Predmet> getPredmets() {
		return this.predmets;
	}

//bi-directional many-to-one association to Student
	@OneToMany(mappedBy = "smer")
	public List<Student> getStudents() {
		return this.students;
	}

	// bi-directional many-to-one association to SmerHasPredmet
	@OneToMany(mappedBy = "smer")
	public List<SmerHasPredmet> getSmerHasPredmets() {
		return this.smerHasPredmets;
	}

	public void setPredmets(List<Predmet> predmets) {
		this.predmets = predmets;
	}

	public void setSmerHasPredmets(List<SmerHasPredmet> smerHasPredmets) {
		this.smerHasPredmets = smerHasPredmets;
	}

	public SmerHasPredmet addSmerHasPredmet(SmerHasPredmet smerHasPredmet) {
		getSmerHasPredmets().add(smerHasPredmet);
		smerHasPredmet.setSmer(this);

		return smerHasPredmet;
	}

	public void setSmerId(int smerId) {
		this.smerId = smerId;
	}

	public String getNaziv() {
		return this.naziv;
	}

	public void setNaziv(String naziv) {
		this.naziv = naziv;
	}

	public SmerHasPredmet removeSmerHasPredmet(SmerHasPredmet smerHasPredmet) {
		getSmerHasPredmets().remove(smerHasPredmet);
		smerHasPredmet.setSmer(null);

		return smerHasPredmet;
	}

	public void setStudents(List<Student> students) {
		this.students = students;
	}

	public Student addStudent(Student student) {
		getStudents().add(student);
		student.setSmer(this);

		return student;
	}

	public Student removeStudent(Student student) {
		getStudents().remove(student);
		student.setSmer(null);

		return student;
	}

	@Override
	public String toString() {
		return "Smer [smerId=" + smerId + ", naziv=" + naziv + ", predmets=" + predmets + ", smerHasPredmets="
				+ smerHasPredmets + ", students=" + students + "]";
	}

}