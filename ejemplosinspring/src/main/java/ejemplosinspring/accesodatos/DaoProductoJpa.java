package ejemplosinspring.accesodatos;

import java.math.BigDecimal;

import ejemplosinspring.entidades.Producto;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class DaoProductoJpa implements DaoProducto {
	private static EntityManagerFactory emf = Persistence.createEntityManagerFactory("ejemplosinspring.entidades");

	@Override
	public Iterable<Producto> buscarPorNombre(String nombre) {
		var em = emf.createEntityManager();
		var t = em.getTransaction();

		t.begin();

		var productos = em.createQuery("from Producto p where p.nombre like :nombre", Producto.class)
				.setParameter("nombre", "%" + nombre + "%").getResultList();

		t.commit();

		em.close();

		return productos;
	}

	@Override
	public Iterable<Producto> buscarPorPrecio(BigDecimal minimo, BigDecimal maximo) {
		var em = emf.createEntityManager();
		var t = em.getTransaction();

		t.begin();

		var productos = em.createQuery("from Producto p where p.precio between :minimo and :maximo", Producto.class)
				.setParameter("minimo", minimo).setParameter("maximo", maximo).getResultList();

		t.commit();

		em.close();

		return productos;
	}

	@Override
	public Iterable<Producto> obtenerTodos() {
		var em = emf.createEntityManager();
		var t = em.getTransaction();

		t.begin();

		var productos = em.createQuery("from Producto", Producto.class).getResultList();

		t.commit();

		em.close();
		
		return productos;
	}

	@Override
	public Producto insertar(Producto producto) {
		var em = emf.createEntityManager();
		var t = em.getTransaction();

		t.begin();

		em.persist(producto);
		
		t.commit();

		em.close();
		
		return producto;
	}

	
}
