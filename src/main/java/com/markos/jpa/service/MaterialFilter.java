package com.markos.jpa.service;

import com.markos.jpa.service.filter.LongFilter;
import com.markos.jpa.service.filter.StringFilter;

import java.io.Serializable;

public class MaterialFilter implements Serializable {

	private LongFilter id;

	private StringFilter sap;

	private StringFilter descripcion;

	private LongFilter unidadMedidaId;

	private LongFilter tipoId;

	public MaterialFilter() {
	}

	public LongFilter getId() {
		return id;
	}

	public void setId(LongFilter id) {
		this.id = id;
	}

	public StringFilter getSap() {
		return sap;
	}

	public void setSap(StringFilter sap) {
		this.sap = sap;
	}

	public StringFilter getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(StringFilter descripcion) {
		this.descripcion = descripcion;
	}

	public LongFilter getUnidadMedidaId() {
		return unidadMedidaId;
	}

	public void setUnidadMedidaId(LongFilter unidadMedidaId) {
		this.unidadMedidaId = unidadMedidaId;
	}

	public LongFilter getTipoId() {
		return tipoId;
	}

	public void setTipoId(LongFilter tipoId) {
		this.tipoId = tipoId;
	}

	@Override
	public String toString() {
		return "SapCriteria{" +
				(id != null ? "id=" + id + ", " : "") +
				(sap != null ? "sap=" + sap + ", " : "") +
				(descripcion != null ? "descripcion=" + descripcion + ", " : "") +
				(unidadMedidaId != null ? "unidadMedidaId=" + unidadMedidaId + ", " : "") +
				(tipoId != null ? "tipoId=" + tipoId + ", " : "") +
				"}";
	}
}
