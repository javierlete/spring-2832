package com.ipartek.formacion.ejemplospring.repositorios;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.ipartek.formacion.ejemplospring.entidades.Producto;

@Repository
public class ProductoDaoJdbcTemplate implements ProductoDao {

	@Autowired
	private JdbcTemplate jdbc;
	
	@Override
	public Iterable<Producto> buscarPorDescripcion(String texto) {
		return jdbc.query("SELECT * FROM productos WHERE descripcion LIKE ?",
				new BeanPropertyRowMapper<>(Producto.class), "%" + texto + "%");
	}
	
}
