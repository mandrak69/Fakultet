package model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the semestar database table.
 * 
 */
@Entity
@NamedQuery(name="Semestar.findAll", query="SELECT s FROM Semestar s")
public class Semestar implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;

	private String naziv;

	//bi-directional many-to-one association to Predmet
	@OneToMany(mappedBy="semestar")
	private List<Predmet> predmets;

	public Semestar() {
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

	public List<Predmet> getPredmets() {
		return this.predmets;
	}

	public void setPredmets(List<Predmet> predmets) {
		this.predmets = predmets;
	}

	public Predmet addPredmet(Predmet predmet) {
		getPredmets().add(predmet);
		predmet.setSemestar(this);

		return predmet;
	}

	public Predmet removePredmet(Predmet predmet) {
		getPredmets().remove(predmet);
		predmet.setSemestar(null);

		return predmet;
	}

}