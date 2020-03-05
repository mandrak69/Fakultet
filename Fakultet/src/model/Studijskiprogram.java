package model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the studijskiprogram database table.
 * 
 */
@Entity
@NamedQuery(name="Studijskiprogram.findAll", query="SELECT s FROM Studijskiprogram s")
public class Studijskiprogram implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;

	private String ime;

	//bi-directional many-to-one association to Student
	@OneToMany(mappedBy="studijskiprogram")
	private List<Student> students;

	//bi-directional many-to-one association to StudijskiprogramHasPredmet
	@OneToMany(mappedBy="studijskiprogram")
	private List<StudijskiprogramHasPredmet> studijskiprogramHasPredmets;

	public Studijskiprogram() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getIme() {
		return this.ime;
	}

	public void setIme(String ime) {
		this.ime = ime;
	}

	public List<Student> getStudents() {
		return this.students;
	}

	public void setStudents(List<Student> students) {
		this.students = students;
	}

	public Student addStudent(Student student) {
		getStudents().add(student);
		student.setStudijskiprogram(this);

		return student;
	}

	public Student removeStudent(Student student) {
		getStudents().remove(student);
		student.setStudijskiprogram(null);

		return student;
	}

	public List<StudijskiprogramHasPredmet> getStudijskiprogramHasPredmets() {
		return this.studijskiprogramHasPredmets;
	}

	public void setStudijskiprogramHasPredmets(List<StudijskiprogramHasPredmet> studijskiprogramHasPredmets) {
		this.studijskiprogramHasPredmets = studijskiprogramHasPredmets;
	}

	public StudijskiprogramHasPredmet addStudijskiprogramHasPredmet(StudijskiprogramHasPredmet studijskiprogramHasPredmet) {
		getStudijskiprogramHasPredmets().add(studijskiprogramHasPredmet);
		studijskiprogramHasPredmet.setStudijskiprogram(this);

		return studijskiprogramHasPredmet;
	}

	public StudijskiprogramHasPredmet removeStudijskiprogramHasPredmet(StudijskiprogramHasPredmet studijskiprogramHasPredmet) {
		getStudijskiprogramHasPredmets().remove(studijskiprogramHasPredmet);
		studijskiprogramHasPredmet.setStudijskiprogram(null);

		return studijskiprogramHasPredmet;
	}

}