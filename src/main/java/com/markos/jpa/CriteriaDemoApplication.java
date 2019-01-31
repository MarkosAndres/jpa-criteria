package com.markos.jpa;

import com.markos.jpa.domain.Material;
import com.markos.jpa.domain.TiposMaterial;
import com.markos.jpa.domain.UnidadMedida;
import com.markos.jpa.repository.MaterialRepository;
import com.markos.jpa.repository.TipoMaterialRepository;
import com.markos.jpa.repository.UnidadMedidaRepository;
import com.markos.jpa.service.MaterialService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import java.math.BigDecimal;

@SpringBootApplication
@EnableJpaRepositories
public class CriteriaDemoApplication {

	private static ApplicationContext ctx;

	public static void main(String[] args) {
		ctx = SpringApplication.run(CriteriaDemoApplication.class, args);
		MaterialService materialService = ctx.getBean("materialService", MaterialService.class);

		//System.out.println(materialService.searchMaterialBySap("3005097", 20L));

		//System.out.println(materialService.joinTipoMaterial());

		//System.out.println(materialService.joinTipoMaterialAndUnidadMedida());

		System.out.println(materialService.selectSaps());

	}

}

