package com.ipartek.formacion.ejemplospring.servicios;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ipartek.formacion.ejemplospring.entidades.Producto;
import com.ipartek.formacion.ejemplospring.repositorios.ProductoRepository;

import lombok.extern.java.Log;

@Log
@Service
public class AdminServiceImpl extends AnonimoServiceImpl implements AdminService {
	@Autowired
	private ProductoRepository repo;

	@Override
	public void crearProducto(Producto producto) {
		if (producto.getId() != null) {
			throw new ServiciosException("No se puede pasar un id para un producto nuevo");
		}

		log.info("Creando producto " + producto);

		repo.save(producto);
	}

	@Override
	public void modificarProducto(Producto producto) {
		if (producto.getId() == null) {
			throw new ServiciosException("Es obligatorio proporcionar un id para modificar un producto");
		}

		log.info("Modificando producto " + producto);

		repo.save(producto);
	}

	@Override
	public void borrarProducto(Long id) {
		if(!repo.existsById(id)) {
			throw new ServiciosException("No existe un producto con el id " + id); 
		}
		
		log.info("Borrar producto " + id);
		
		repo.deleteById(id);
	}

}
