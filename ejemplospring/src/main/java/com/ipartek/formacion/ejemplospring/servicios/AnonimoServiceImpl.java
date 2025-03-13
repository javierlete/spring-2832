package com.ipartek.formacion.ejemplospring.servicios;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import com.ipartek.formacion.ejemplospring.entidades.Producto;
import com.ipartek.formacion.ejemplospring.repositorios.ProductoRepository;

import lombok.extern.java.Log;

@Primary
@Log
@Service
public class AnonimoServiceImpl implements AnonimoService {
	
	@Autowired
	private ProductoRepository repo;
	
	@Override
	public Iterable<Producto> obtenerProductos() {
		log.info("Anónimo ha pedido todos los productos");
		return repo.findAll();
	}

	@Override
	public Producto detalleProducto(Long id) {
		log.info("Anónimo ha pedido el producto id " + id);
		return repo.findById(id).orElse(null);
	}
	
}
