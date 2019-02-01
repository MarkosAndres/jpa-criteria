package com.markos.jpa.service;

import com.markos.jpa.domain.*;
import com.markos.jpa.repository.MaterialRepository;
import com.markos.jpa.specification.MaterialSpecification;
import com.markos.jpa.specification.MaterialSpecifications;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.*;
import java.util.List;

@Service
public class MaterialServiceCriteria {

	static Logger log = LoggerFactory.getLogger(MaterialServiceCriteria.class);

    @PersistenceContext
    private EntityManager entityManager;

    @Autowired
	private MaterialRepository materialRepository;

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

    public List<Material> specificationSearch() {
		return materialRepository.findAll(new MaterialSpecification());
	}

	public List<Material> specificationSapAndDescrition() {
		Specification<Material> specifications = Specification.where(null);
		specifications = specifications.and(MaterialSpecifications.equalSap("3005038"));
		specifications = specifications.and(MaterialSpecifications.equalDescription("Abrazadera sin fin de 4\" Diam."));
		List<Material> materiales = materialRepository.findAll(specifications);

		log.info(materiales.toString());

		return materiales;
	}

	public void specificationJoin() {
		List<Material> materiales = materialRepository.findAll(MaterialSpecifications.join());

		log.info(materiales.toString()) ;
    }

    public List<Material> specificationContainsOnNumeric(MaterialFilter filter) {
		Specification<Material> specifications = Specification.where(null);

		String contains = filter.getId().getContains();
		specifications = specifications.and(MaterialSpecifications.contains(Material_.id, contains));

		return materialRepository.findAll(specifications);
	}


}
