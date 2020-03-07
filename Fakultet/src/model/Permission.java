package model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;

/**
 * The persistent class for the permission database table.
 * 
 */
@Entity
@NamedQuery(name = "Permission.findAll", query = "SELECT p FROM Permission p")
public class Permission implements Serializable {
	private static final long serialVersionUID = 1L;
	private int permissionId;
	private String name;
	private List<Rola> rolas;

	public Permission() {
	}

	@Id
	@GeneratedValue(strategy = GenerationType.TABLE)
	@Column(name = "permission_id")
	public int getPermissionId() {
		return this.permissionId;
	}

//bi-directional many-to-many association to Rola
	@ManyToMany(mappedBy = "permissions")
	public List<Rola> getRolas() {
		return this.rolas;
	}

	public void setPermissionId(int permissionId) {
		this.permissionId = permissionId;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setRolas(List<Rola> rolas) {
		this.rolas = rolas;
	}

	@Override
	public String toString() {
		return "Permission [permissionId=" + permissionId + ", name=" + name + ", rolas=" + rolas + "]";
	}

}