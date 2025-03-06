package ejemplosinspring.entidades;

import java.math.BigDecimal;
import java.time.LocalDate;

import jakarta.validation.Validation;

public class ProductoPrueba {
	public static void main(String[] args) {
		var producto = new Producto();

		producto.setId(1L);
		producto.setNombre("lasdkfjlaskd");

		System.out.println(producto);
		
		var p1 = new Producto(2L, "prueba", BigDecimal.ZERO, LocalDate.now());

		System.out.println(p1);
		
		var p2 = Producto.builder().nombre("  bvg   ").precio(new BigDecimal(5)).build();
		
		System.out.println(p2);
		
		var validationFactory = Validation.buildDefaultValidatorFactory();
		
		var validador = validationFactory.getValidator();
		
		var errores = validador.validate(p2);
		
		System.out.println(errores);
		
		for(var error: errores) {
			System.out.println(error.getPropertyPath());
			System.out.println(error.getMessage());
		}
	}
}
