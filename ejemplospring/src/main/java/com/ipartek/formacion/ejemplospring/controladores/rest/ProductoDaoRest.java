package com.ipartek.formacion.ejemplospring.controladores.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ipartek.formacion.ejemplospring.entidades.Producto;
import com.ipartek.formacion.ejemplospring.repositorios.ProductoDao;

@RestController
@RequestMapping("/api/productos")
public class ProductoDaoRest {
	@Autowired
	private ProductoDao dao;
	
	@GetMapping("/search")
	public Iterable<Producto> buscarPorDescripcion(String descripcion) {
		return dao.buscarPorDescripcion(descripcion);
	}
}
