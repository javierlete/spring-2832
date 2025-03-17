package com.ipartek.formacion.ejemplospring.repositorios;

import com.ipartek.formacion.ejemplospring.entidades.Producto;

public interface ProductoDao {
	Iterable<Producto> buscarPorDescripcion(String texto);
}
