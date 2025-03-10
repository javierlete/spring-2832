package ejemplosinspring.accesodatos;

import java.math.BigDecimal;

import ejemplosinspring.entidades.Producto;

public class DaoProductoJpaPrueba {
	public static void main(String[] args) {
		var dao = new DaoProductoJpa();
		
		dao.insertar(Producto.builder().nombre("asdfasd").precio(BigDecimal.ZERO).build());
		dao.insertar(Producto.builder().nombre("Otro").precio(BigDecimal.ONE).build());
		
		var productos = dao.obtenerTodos();
		
		for(var p: productos) {
			System.out.println(p);
		}
		
		productos = dao.buscarPorNombre("tro");
		
		for(var p: productos) {
			System.out.println(p);
		}
		
		productos = dao.buscarPorPrecio(BigDecimal.ZERO, BigDecimal.ZERO);
		
		for(var p: productos) {
			System.out.println(p);
		}
	}
}
