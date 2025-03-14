package com.ipartek.formacion.ejemplospring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.ipartek.formacion.ejemplospring.repositorios.ProductoRepository;

@SpringBootApplication
public class EjemplospringApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(EjemplospringApplication.class, args);
	}

	@Autowired
	private ProductoRepository repo;
	
	@Override
	public void run(String... args) throws Exception {
//		repo.save(Producto.builder().nombre("Prueba").precio(new BigDecimal("1234")).build());
		
		for(var p: repo.findAll()) {
			System.out.println(p);
		}
	}

}
