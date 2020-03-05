package model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the student database table.
 * 
 */
@Entity
@NamedQuery(name="Student.findAll", query="SELECT s FROM Student s")
public class Student implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;

	private String datumrodjenja;

	private String ime;

	private String prezime;

	//bi-directional many-to-one association to Studijskiprogram
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="studijski_id")
	private Studijskiprogram studijskiprogram;

	//bi-directional many-to-one association to Korisnik
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="tip_id")
	private Korisnik korisnik;

	public Student() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDatumrodjenja() {
		return this.datumrodjenja;
	}

	public void setDatumrodjenja(String datumrodjenja) {
		this.datumrodjenja = datumrodjenja;
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

	public Studijskiprogram getStudijskiprogram() {
		return this.studijskiprogram;
	}

	public void setStudijskiprogram(Studijskiprogram studijskiprogram) {
		this.studijskiprogram = studijskiprogram;
	}

	public Korisnik getKorisnik() {
		return this.korisnik;
	}

	public void setKorisnik(Korisnik korisnik) {
		this.korisnik = korisnik;
	}

}