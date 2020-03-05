package model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the predmet database table.
 * 
 */
@Entity
@NamedQuery(name="Predmet.findAll", query="SELECT p FROM Predmet p")
public class Predmet implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;

	private int esp;

	private String ime;

	//bi-directional many-to-one association to Semestar
	@ManyToOne(fetch=FetchType.LAZY)
	private Semestar semestar;

	//bi-directional many-to-one association to StudijskiprogramHasPredmet
	@OneToMany(mappedBy="predmet")
	private List<StudijskiprogramHasPredmet> studijskiprogramHasPredmets;

	public Predmet() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getEsp() {
		return this.esp;
	}

	public void setEsp(int esp) {
		this.esp = esp;
	}

	public String getIme() {
		return this.ime;
	}

	public void setIme(String ime) {
		this.ime = ime;
	}

	public Semestar getSemestar() {
		return this.semestar;
	}

	public void setSemestar(Semestar semestar) {
		this.semestar = semestar;
	}

	public List<StudijskiprogramHasPredmet> getStudijskiprogramHasPredmets() {
		return this.studijskiprogramHasPredmets;
	}

	public void setStudijskiprogramHasPredmets(List<StudijskiprogramHasPredmet> studijskiprogramHasPredmets) {
		this.studijskiprogramHasPredmets = studijskiprogramHasPredmets;
	}

	public StudijskiprogramHasPredmet addStudijskiprogramHasPredmet(StudijskiprogramHasPredmet studijskiprogramHasPredmet) {
		getStudijskiprogramHasPredmets().add(studijskiprogramHasPredmet);
		studijskiprogramHasPredmet.setPredmet(this);

		return studijskiprogramHasPredmet;
	}

	public StudijskiprogramHasPredmet removeStudijskiprogramHasPredmet(StudijskiprogramHasPredmet studijskiprogramHasPredmet) {
		getStudijskiprogramHasPredmets().remove(studijskiprogramHasPredmet);
		studijskiprogramHasPredmet.setPredmet(null);

		return studijskiprogramHasPredmet;
	}

}