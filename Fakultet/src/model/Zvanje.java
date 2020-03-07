package model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.*;

/**
 * The persistent class for the zvanje database table.
 * 
 */
@Entity
@NamedQuery(name = "Zvanje.findAll", query = "SELECT z FROM Zvanje z")
public class Zvanje implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.TABLE)
	@Column(name = "zvanje_id")
	private int zvanjeId;

	private String naziv;

	// private List<Profesor> profesores;

	public Zvanje() {
	}

	public int getZvanjeId() {
		return this.zvanjeId;
	}

	public void setZvanjeId(int zvanjeId) {
		this.zvanjeId = zvanjeId;
	}

	public String getNaziv() {
		return this.naziv;
	}

	public void setNaziv(String naziv) {
		this.naziv = naziv;
	}

	@Override
	public String toString() {
		return "Zvanje [zvanjeId=" + zvanjeId + ", naziv=" + naziv + "]";
	}

}