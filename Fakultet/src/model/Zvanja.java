package model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the zvanja database table.
 * 
 */
@Entity
@NamedQuery(name="Zvanja.findAll", query="SELECT z FROM Zvanja z")
public class Zvanja implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;

	private String ime;

	private String nivo;

	public Zvanja() {
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

	public String getNivo() {
		return this.nivo;
	}

	public void setNivo(String nivo) {
		this.nivo = nivo;
	}

}