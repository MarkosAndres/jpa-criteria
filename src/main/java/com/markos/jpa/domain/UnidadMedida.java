package com.markos.jpa.domain;

import javax.persistence.*;
import javax.validation.constraints.*;

import java.io.Serializable;
import java.util.Objects;

/**
 * A UnidadMedida.
 */
@Entity
@Table(name = "unidad_medida")
public class UnidadMedida implements Serializable {

	private static final long serialVersionUID = 1L;

	public UnidadMedida() {
	}

	public UnidadMedida(Long id) {
		this.id = id;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "sequenceGenerator")
	@SequenceGenerator(name = "sequenceGenerator")
	private Long id;

	@NotNull
	@Size(min = 2, max = 50)
	@Column(name = "medida", length = 50, nullable = false)
	private String medida;

	// jhipster-needle-entity-add-field - JHipster will add fields here, do not remove
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getMedida() {
		return medida;
	}

	public UnidadMedida medida(String medida) {
		this.medida = medida;
		return this;
	}

	public void setMedida(String medida) {
		this.medida = medida;
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
		UnidadMedida unidadMedida = (UnidadMedida) o;
		if (unidadMedida.getId() == null || getId() == null) {
			return false;
		}
		return Objects.equals(getId(), unidadMedida.getId());
	}

	@Override
	public int hashCode() {
		return Objects.hashCode(getId());
	}

	@Override
	public String toString() {
		return "UnidadMedida{" +
				"id=" + getId() +
				", medida='" + getMedida() + "'" +
				"}";
	}
}

