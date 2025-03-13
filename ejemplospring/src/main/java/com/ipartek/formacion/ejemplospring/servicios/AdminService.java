package com.ipartek.formacion.ejemplospring.servicios;

import com.ipartek.formacion.ejemplospring.entidades.Producto;

public interface AdminService extends AnonimoService {
	void crearProducto(Producto producto);
	void modificarProducto(Producto producto);
}
