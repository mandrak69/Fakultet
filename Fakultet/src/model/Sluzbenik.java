package model;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The persistent class for the sluzbenik database table.
 * 
 */
@Entity
@NamedQuery(name = "Sluzbenik.findAll", query = "SELECT s FROM Sluzbenik s")
public class Sluzbenik implements Serializable {
	private static final long serialVersionUID = 1L;
	private int sluzbenikId;
	private String ime;
	private String prezime;
	private String telefon;
	private Profil profil;

	public Sluzbenik() {
	}

	@Id
	@GeneratedValue(strategy = GenerationType.TABLE)
	@Column(name = "sluzbenik_id")
	public int getSluzbenikId() {
		return this.sluzbenikId;
	}

	// bi-directional many-to-one association to Profil
	@ManyToOne
	@JoinColumn(name = "profil_id")
	public Profil getProfil() {
		return this.profil;
	}

	public void setSluzbenikId(int sluzbenikId) {
		this.sluzbenikId = sluzbenikId;
	}

	public String getIme() {
		return this.ime;
	}

	public void setIme(String ime) {
		this.ime = ime;
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

	public void setProfil(Profil profil) {
		this.profil = profil;
	}

	@Override
	public String toString() {
		return "Sluzbenik [sluzbenikId=" + sluzbenikId + ", ime=" + ime + ", prezime=" + prezime + ", telefon="
				+ telefon + ", profil=" + profil + "]";
	}

}