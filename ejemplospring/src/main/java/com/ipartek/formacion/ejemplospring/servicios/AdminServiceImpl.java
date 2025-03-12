package com.ipartek.formacion.ejemplospring.servicios;

import org.springframework.stereotype.Service;

import com.ipartek.formacion.ejemplospring.entidades.Producto;

import lombok.extern.java.Log;

@Log
@Service
public class AdminServiceImpl implements AdminService {

	@Override
	public void crearProducto(Producto producto) {
		log.info("Guardando producto " + producto);
	}

}
