package com.ipartek.formacion.ejemplospring.servicios;

import com.ipartek.formacion.ejemplospring.entidades.Producto;

public interface AnonimoService {
	Iterable<Producto> obtenerProductos();
	Producto detalleProducto(Long id);
}
