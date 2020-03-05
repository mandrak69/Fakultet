package model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the zvanja_has_profesor database table.
 * 
 */
@Entity
@Table(name="zvanja_has_profesor")
@NamedQuery(name="ZvanjaHasProfesor.findAll", query="SELECT z FROM ZvanjaHasProfesor z")
public class ZvanjaHasProfesor implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private ZvanjaHasProfesorPK id;

	public ZvanjaHasProfesor() {
	}

	public ZvanjaHasProfesorPK getId() {
		return this.id;
	}

	public void setId(ZvanjaHasProfesorPK id) {
		this.id = id;
	}

}