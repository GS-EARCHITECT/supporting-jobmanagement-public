package main;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableEurekaClient
@EnableScheduling
@EntityScan(basePackages = { "job_details_mgmt", "job_master_mgmt", "job_metrics_mgmt", "job_template_details_mgmt",
		"job_template_master_mgmt", "job_type_level_master_mgmt", "job_type_master_mgmt",
		"job_type_structure_details_mgmt" })
@EnableJpaRepositories(basePackages = { "job_details_mgmt", "job_master_mgmt", "job_metrics_mgmt",
		"job_template_details_mgmt", "job_template_master_mgmt", "job_type_level_master_mgmt", "job_type_master_mgmt",
		"job_type_structure_details_mgmt" })
@ComponentScan({ "job_details_mgmt", "job_master_mgmt", "job_metrics_mgmt", "job_template_details_mgmt",
		"job_template_master_mgmt", "job_type_level_master_mgmt", "job_type_master_mgmt",
		"job_type_structure_details_mgmt" })
public class JobManagementMain extends SpringBootServletInitializer {
	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(JobManagementMain.class);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SpringApplication.run(JobManagementMain.class, args);
	}
}