package com.ipartek.formacion.ejemplospring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.ipartek.formacion.ejemplospring.repositorios.CategoriaRepository;
import com.ipartek.formacion.ejemplospring.repositorios.ProductoDao;
import com.ipartek.formacion.ejemplospring.repositorios.ProductoRepository;

@SpringBootApplication
public class EjemplospringApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(EjemplospringApplication.class, args);
	}

	@Autowired
	private ProductoRepository repoProductos;
	
	@Autowired
	private CategoriaRepository repoCategorias;
	
	@Autowired
	private ProductoDao productoDao;
	
	@Override
	public void run(String... args) throws Exception {
//		var informatica = Categoria.builder().nombre("Informática").build();
		
//		repoCategorias.save(informatica);
		
//		var informatica = repoCategorias.findById(1L);
		
//		var informatica = Categoria.builder().id(1L).build();
		
//		var producto = Producto.builder().nombre("Ratón").precio(new BigDecimal("12")).categoria(informatica).build(); 
		
//		repoProductos.save(producto);
		
		for(var p: repoProductos.findAll()) {
			System.out.println(p);
		}
		
		for(var p: repoProductos.obtenerProductosConCategorias()) {
			System.out.print(p);
			System.out.println(p.getCategoria());
		}
		
		for(var p: repoProductos.findByCategoriaId(1L)) {
			System.out.println(p);
		}
		
		for(var c: repoCategorias.findAll()) {
			System.out.println(c);
		}
		
		for(var p: productoDao.buscarPorDescripcion("mejor") ) {
			System.out.println(p);
		}
	}

}
