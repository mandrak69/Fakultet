package model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;

/**
 * The persistent class for the rola database table.
 * 
 */
@Entity
@NamedQuery(name = "Rola.findAll", query = "SELECT r FROM Rola r")
public class Rola implements Serializable {
	private static final long serialVersionUID = 1L;
	private int rolaId;
	private String name;
	private List<Profil> profils;
	private List<Permission> permissions;

	public Rola() {
	}

	@Id
	@GeneratedValue(strategy = GenerationType.TABLE)
	@Column(name = "rola_id")
	public int getRolaId() {
		return this.rolaId;
	}

	// bi-directional many-to-many association to Permission
	@ManyToMany
	@JoinTable(name = "permission_has_rola", joinColumns = { @JoinColumn(name = "rola_id") }, inverseJoinColumns = {
			@JoinColumn(name = "permission_id") })
	public List<Permission> getPermissions() {
		return this.permissions;
	}

	// bi-directional many-to-one association to Profil
	@OneToMany(mappedBy = "rola")
	public List<Profil> getProfils() {
		return this.profils;
	}

	public void setProfils(List<Profil> profils) {
		this.profils = profils;
	}

	public Profil addProfil(Profil profil) {
		getProfils().add(profil);
		profil.setRola(this);

		return profil;
	}

	public Profil removeProfil(Profil profil) {
		getProfils().remove(profil);
		profil.setRola(null);

		return profil;
	}

	public void setPermissions(List<Permission> permissions) {
		this.permissions = permissions;
	}

	public void setRolaId(int rolaId) {
		this.rolaId = rolaId;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "Rola [rolaId=" + rolaId + ", name=" + name + ", profils=" + profils + ", permissions=" + permissions
				+ "]";
	}

}