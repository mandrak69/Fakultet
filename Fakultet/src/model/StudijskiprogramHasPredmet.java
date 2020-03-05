package model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the studijskiprogram_has_predmet database table.
 * 
 */
@Entity
@Table(name="studijskiprogram_has_predmet")
@NamedQuery(name="StudijskiprogramHasPredmet.findAll", query="SELECT s FROM StudijskiprogramHasPredmet s")
public class StudijskiprogramHasPredmet implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private StudijskiprogramHasPredmetPK id;

	//bi-directional many-to-one association to Predmet
	@ManyToOne(fetch=FetchType.LAZY)
	private Predmet predmet;

	//bi-directional many-to-one association to Studijskiprogram
	@ManyToOne(fetch=FetchType.LAZY)
	private Studijskiprogram studijskiprogram;

	public StudijskiprogramHasPredmet() {
	}

	public StudijskiprogramHasPredmetPK getId() {
		return this.id;
	}

	public void setId(StudijskiprogramHasPredmetPK id) {
		this.id = id;
	}

	public Predmet getPredmet() {
		return this.predmet;
	}

	public void setPredmet(Predmet predmet) {
		this.predmet = predmet;
	}

	public Studijskiprogram getStudijskiprogram() {
		return this.studijskiprogram;
	}

	public void setStudijskiprogram(Studijskiprogram studijskiprogram) {
		this.studijskiprogram = studijskiprogram;
	}

}