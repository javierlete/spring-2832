package com.ipartek.formacion.ejemplospring.servicios;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ipartek.formacion.ejemplospring.entidades.Producto;
import com.ipartek.formacion.ejemplospring.repositorios.ProductoRepository;

import lombok.extern.java.Log;

@Log
@Service
public class AdminServiceImpl implements AdminService {
	@Autowired
	private ProductoRepository repo;
	
	@Override
	public void crearProducto(Producto producto) {
		log.info("Guardando producto " + producto);
		repo.save(producto);
	}

}
