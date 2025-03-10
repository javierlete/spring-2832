package ejemplosinspring.accesodatos;

import java.math.BigDecimal;

import ejemplosinspring.entidades.Producto;

public interface DaoProducto extends Dao<Producto> {
	Iterable<Producto> buscarPorNombre(String nombre);
	
	Iterable<Producto> buscarPorPrecio(BigDecimal minimo, BigDecimal maximo);
}
