package com.markos.jpa;

import com.markos.jpa.service.MaterialService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories
public class CriteriaDemoApplication {

	private static ApplicationContext ctx;
	private static MaterialService materialService;

	public static void main(String[] args) {
		ctx = SpringApplication.run(CriteriaDemoApplication.class, args);
		materialService = ctx.getBean("materialService", MaterialService.class);

		//criteria();

		specification();
	}

	static void specification() {
		//materialService.specificationSearch()

		//materialService.specificationSapAndDescrition();

		materialService.specificationJoin();
	}

	static void criteria() {
		materialService.searchMaterialBySap("3005097", 20L);

		materialService.joinTipoMaterial();

		materialService.joinTipoMaterialAndUnidadMedida();

		materialService.selectSaps();
	}

}

