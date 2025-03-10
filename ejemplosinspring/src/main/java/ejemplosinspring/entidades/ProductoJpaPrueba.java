package ejemplosinspring.entidades;

import java.math.BigDecimal;

import jakarta.persistence.Persistence;

public class ProductoJpaPrueba {
	public static void main(String[] args) {
		var entityManagerFactory = Persistence
				.createEntityManagerFactory("ejemplosinspring.entidades");
		
		var em = entityManagerFactory.createEntityManager();
		var t = em.getTransaction();
		
		t.begin();
		
		em.persist(Producto.builder().nombre("Prueba1").precio(BigDecimal.ZERO).build());
		em.persist(Producto.builder().nombre("Prueba2").precio(BigDecimal.ONE).build());
		
		t.commit();
		
		em.close();
		
		var em2 = entityManagerFactory.createEntityManager();
		var t2 = em2.getTransaction();
		
		t2.begin();
		
		var productos = em2.createQuery("from Producto", Producto.class).getResultList();
		
		for(var producto: productos) {
			System.out.println(producto);
		}
		
		t2.commit();
		
		em2.close();
	}
}
