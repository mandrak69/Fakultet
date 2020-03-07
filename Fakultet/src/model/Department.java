package model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;

/**
 * The persistent class for the department database table.
 * 
 */
@Entity
@NamedQuery(name = "Department.findAll", query = "SELECT d FROM Department d")
public class Department implements Serializable {
	private static final long serialVersionUID = 1L;
	private int departmentId;
	private String naziv;
	private String opis;
	private List<Profesor> profesors;

	public Department() {
	}

	@Id
	@GeneratedValue(strategy = GenerationType.TABLE)
	@Column(name = "department_id")
	public int getDepartmentId() {
		return this.departmentId;
	}

	// bi-directional many-to-one association to Profesor
	@OneToMany(mappedBy = "department")
	public List<Profesor> getProfesors() {
		return this.profesors;
	}

	public void setDepartmentId(int departmentId) {
		this.departmentId = departmentId;
	}

	public String getNaziv() {
		return this.naziv;
	}

	public void setNaziv(String naziv) {
		this.naziv = naziv;
	}

	public String getOpis() {
		return this.opis;
	}

	public void setOpis(String opis) {
		this.opis = opis;
	}

	public void setProfesors(List<Profesor> profesors) {
		this.profesors = profesors;
	}

	public Profesor addProfesor(Profesor profesor) {
		getProfesors().add(profesor);
		profesor.setDepartment(this);

		return profesor;
	}

	public Profesor removeProfesor(Profesor profesor) {
		getProfesors().remove(profesor);
		profesor.setDepartment(null);

		return profesor;
	}

	@Override
	public String toString() {
		return "Department [departmentId=" + departmentId + ", naziv=" + naziv + ", opis=" + opis + ", profesors="
				+ profesors + "]";
	}

}