package model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the role database table.
 * 
 */
@Entity
@NamedQuery(name="Role.findAll", query="SELECT r FROM Role r")
public class Role implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;

	private String naziv;

	//bi-directional many-to-many association to Profil
	@ManyToMany
	@JoinTable(
		name="role_has_korisnik"
		, joinColumns={
			@JoinColumn(name="role_id")
			}
		, inverseJoinColumns={
			@JoinColumn(name="profil_id")
			}
		)
	private List<Profil> profils;

	public Role() {
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

	public List<Profil> getProfils() {
		return this.profils;
	}

	public void setProfils(List<Profil> profils) {
		this.profils = profils;
	}

}