package com.markos.jpa.domain;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.io.Serializable;
import java.util.Objects;

/**
 * A TiposMaterial.
 */
@Entity
@Table(name = "tipos_sap")
public class TiposMaterial implements Serializable {

	private static final long serialVersionUID = 1L;

	public TiposMaterial() {
	}

	public TiposMaterial(Long id) {
		this.id = id;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@NotNull
	@Size(min = 2, max = 50)
	@Column(name = "tipo", length = 50, nullable = false)
	private String tipo;

	// jhipster-needle-entity-add-field - JHipster will add fields here, do not remove
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTipo() {
		return tipo;
	}

	public TiposMaterial tipo(String tipo) {
		this.tipo = tipo;
		return this;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	// jhipster-needle-entity-add-getters-setters - JHipster will add getters and setters here, do not remove

	@Override
	public boolean equals(Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}
		TiposMaterial tiposSap = (TiposMaterial) o;
		if (tiposSap.getId() == null || getId() == null) {
			return false;
		}
		return Objects.equals(getId(), tiposSap.getId());
	}

	@Override
	public int hashCode() {
		return Objects.hashCode(getId());
	}

	@Override
	public String toString() {
		return "TiposMaterial{" +
				"id=" + getId() +
				", tipo='" + getTipo() + "'" +
				"}";
	}
}

