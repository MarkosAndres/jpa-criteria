package com.markos.jpa.service;

import com.markos.jpa.domain.*;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.*;
import java.util.List;

@Service
public class MaterialService {

    @PersistenceContext
    private EntityManager entityManager;

    public Material searchMaterialBySap(String sap, Long id) {
		CriteriaBuilder cb = entityManager.getCriteriaBuilder();
		CriteriaQuery<Material> query = cb.createQuery(Material.class);

		Root<Material> root = query.from(Material.class);
		Path<String> sapPath = root.get(Material_.sap);
		Path<Long> idPath = root.get(Material_.ID);

		Predicate sapEqualTo = cb.equal(sapPath, sap);
		Predicate idEqualTo = cb.equal(idPath, id);
		Predicate sapAndId = cb.and(sapEqualTo, idEqualTo);

		query.where(sapAndId);

		return entityManager.createQuery(query).getSingleResult();
	}

	public List<Material> joinTipoMaterial() {
    	CriteriaBuilder cb = entityManager.getCriteriaBuilder();
    	CriteriaQuery<Material> query = cb.createQuery(Material.class);

    	Root<Material> root = query.from(Material.class);

    	Join<Material, TiposMaterial> joinTiposMaterial = root.join(Material_.tipo);
    	Path<String> tipoMaterialTipoPath = joinTiposMaterial.get(TiposMaterial_.TIPO);

    	Predicate materialTipoEqual = cb.equal(tipoMaterialTipoPath, "Herramienta");

    	query.where(materialTipoEqual);

    	return entityManager.createQuery(query).getResultList();
	}

	public List<Material> joinTipoMaterialAndUnidadMedida() {
		CriteriaBuilder cb = entityManager.getCriteriaBuilder();
		CriteriaQuery<Material> query = cb.createQuery(Material.class);

		Root<Material> root = query.from(Material.class);

		Join<Material, TiposMaterial> joinTipoMaterial = root.join(Material_.tipo);
		Path<String> tipoMaterialNamePath = joinTipoMaterial.get(TiposMaterial_.TIPO);

		Join<Material, UnidadMedida> joinUnidadMedida = root.join(Material_.unidadMedida);
		Path<String> unidadMedidaPath = joinUnidadMedida.get(UnidadMedida_.MEDIDA);

		Predicate materialTipoEqual = cb.equal(tipoMaterialNamePath, "Herramienta");
		Predicate unidadMedidaEqual  = cb.equal(unidadMedidaPath, "serv");
		Predicate andJoins = cb.and(materialTipoEqual, unidadMedidaEqual);

		query.where(andJoins);

		return entityManager.createQuery(query).getResultList();
	}


	public List<String> selectSaps() {
    	CriteriaBuilder cb = entityManager.getCriteriaBuilder();
    	CriteriaQuery<String> query = cb.createQuery(String.class);

    	Root<Material> root = query.from(Material.class);
		query.select(root.get(Material_.SAP));

    	Path<Long> idPath = root.get(Material_.id);

    	Predicate idGtThan = cb.gt(idPath, 338L);

    	query.where(idGtThan);

    	return entityManager.createQuery(query).getResultList();
	}



	public List<Material> searchAll() {
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<Material> query = cb.createQuery(Material.class);

        Root<Material> root = query.from(Material.class);

        query.select(root);

        return entityManager.createQuery(query).getResultList();
    }
}
