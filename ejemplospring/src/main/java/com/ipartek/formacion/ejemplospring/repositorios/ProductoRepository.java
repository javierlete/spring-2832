package com.ipartek.formacion.ejemplospring.repositorios;

import java.math.BigDecimal;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.ipartek.formacion.ejemplospring.entidades.Producto;

@RepositoryRestResource(collectionResourceRel = "productos", path = "productos")
public interface ProductoRepository extends CrudRepository<Producto, Long>, PagingAndSortingRepository<Producto, Long> {
	@Query("from Producto p join fetch p.categoria")
	Iterable<Producto> obtenerProductosConCategorias();
	
	Iterable<Producto> findByCategoriaId(Long id);
	
	Iterable<Producto> findByNombre(String nombre);

	Iterable<Producto> findByPrecioBetween(BigDecimal minimo, BigDecimal maximo);
}
