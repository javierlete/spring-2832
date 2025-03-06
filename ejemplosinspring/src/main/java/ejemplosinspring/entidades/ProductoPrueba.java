package ejemplosinspring.entidades;

import java.math.BigDecimal;
import java.time.LocalDate;

public class ProductoPrueba {
	public static void main(String[] args) {
		var producto = new Producto();

		producto.setId(1L);
		producto.setNombre("lasdkfjlaskd");

		System.out.println(producto);
		
		var p1 = new Producto(2L, "prueba", BigDecimal.ZERO, LocalDate.now());

		System.out.println(p1);
		
		var p2 = Producto.builder().nombre("Producto2").precio(BigDecimal.ONE).build();
		
		System.out.println(p2);
	}
}
