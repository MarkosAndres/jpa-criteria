package com.markos.jpa.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Objects;

/**
 * A Sap.
 */
@Entity
@Table(name = "sap")
public class Material implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotNull
    @Column(name = "sap", nullable = false)
    private String sap;

    @NotNull
    @Column(name = "descripcion", nullable = false)
    private String descripcion;

    @NotNull
    @Column(name = "precio", precision = 10, scale = 2, nullable = false)
    private BigDecimal precio;

    @ManyToOne(optional = false)
    @NotNull
    @JsonIgnoreProperties("")
    private UnidadMedida unidadMedida;

    @ManyToOne(optional = false)
    @NotNull
    @JsonIgnoreProperties("")
    private TiposMaterial tipo;

    // jhipster-needle-entity-add-field - JHipster will add fields here, do not remove
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSap() {
        return sap;
    }

    public Material material(String sap) {
        this.sap = sap;
        return this;
    }

    public void setSap(String sap) {
        this.sap = sap;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public Material descripcion(String descripcion) {
        this.descripcion = descripcion;
        return this;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public BigDecimal getPrecio() {
        return precio;
    }

    public Material precio(BigDecimal precio) {
        this.precio = precio;
        return this;
    }

    public void setPrecio(BigDecimal precio) {
        this.precio = precio;
    }

    public UnidadMedida getUnidadMedida() {
        return unidadMedida;
    }

    public Material unidadMedida(UnidadMedida unidadMedida) {
        this.unidadMedida = unidadMedida;
        return this;
    }

    public void setUnidadMedida(UnidadMedida unidadMedida) {
        this.unidadMedida = unidadMedida;
    }

    public TiposMaterial getTipo() {
        return tipo;
    }

    public Material tipo(TiposMaterial tiposSap) {
        this.tipo = tiposSap;
        return this;
    }

    public void setTipo(TiposMaterial tiposSap) {
        this.tipo = tiposSap;
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
        Material sap = (Material) o;
        if (sap.getId() == null || getId() == null) {
            return false;
        }
        return Objects.equals(getId(), sap.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }

    @Override
    public String toString() {
        return "Material{\n" +
                " id=" + getId() +
                ",\n sap='" + getSap() + "'" +
                ",\n descripcion='" + getDescripcion() + "'" +
                ",\n precio=" + getPrecio() +
                "\n}";
    }
}
