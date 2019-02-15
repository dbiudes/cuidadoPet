package br.com.dorival.petcare;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import br.com.dorival.petcare.persistence.entity.Student;
import br.com.dorival.petcare.persistence.repository.StudentJdbcRepository;

@SpringBootApplication
public class PetCare_Application implements CommandLineRunner {

	private Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	StudentJdbcRepository repository;

	public static void main(String[] args) {
		System.out.println("iniciando aplicacoes");

		SpringApplication.run(PetCare_Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		logger.info("Student id 10001 -> {}.", repository.findById(10001L));
		logger.info("All users 1 -> {}", repository.findAll());

		logger.info("Inserting -> {}", repository.insert(new Student(10010L, "John", "A1234657")));
		logger.info("Update 10001 -> {}", repository.update(new Student(10001L, "Name-Updated", "New-Passport")));
		repository.deleteById(10002L);
		logger.info("All users 2 -> {}", repository.findAll());
	
		//Environment environment = null;
		//System.out.println("environment: " + environment.getRequiredProperty(""));
		
	}

	// MySQL ou Portgree Configuration
	/*
	 * @Bean public DataSource dataSource(){ DriverManagerDataSource dataSource =
	 * new DriverManagerDataSource();
	 * dataSource.setDriverClassName("com.mysql.jdbc.Driver");
	 * dataSource.setUrl("jdbc:mysql://localhost:3306/listavip");
	 * 
	 * //dataSource.setDriverClassName("org.postgresql.Driver");
	 * //dataSource.setUrl("jdbc:postgresql://localhost:5432/listavip");
	 * 
	 * dataSource.setUsername("root"); dataSource.setPassword("root");
	 * 
	 * return dataSource; }
	 */

}
