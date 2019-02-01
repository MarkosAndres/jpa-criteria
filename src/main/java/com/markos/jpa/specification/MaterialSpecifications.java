package com.markos.jpa.specification;

import com.markos.jpa.domain.Material;
import com.markos.jpa.domain.Material_;
import com.markos.jpa.domain.TiposMaterial;
import com.markos.jpa.domain.TiposMaterial_;
import org.springframework.data.jpa.domain.Specification;

import javax.persistence.criteria.*;

public class MaterialSpecifications {

	public static Specification<Material> equalSap(String sap) {
		return (root, query, cb) ->
				cb.equal(root.get(Material_.sap), sap);
	}

	public static Specification<Material> equalDescription(String description) {
		return ((root, criteriaQuery, cb) -> cb.equal(root.get(Material_.descripcion), description));
	}

	public static Specification<Material> join() {
		return ((root, criteriaQuery, criteriaBuilder) -> {
			Join<Material, TiposMaterial> joinTipoMaterial = root.join(Material_.tipo);
			Path<String> tipoMaterialTipoPath = joinTipoMaterial.get(TiposMaterial_.TIPO);

			return criteriaBuilder.equal(tipoMaterialTipoPath, "Herramienta");
		});
	}
}
