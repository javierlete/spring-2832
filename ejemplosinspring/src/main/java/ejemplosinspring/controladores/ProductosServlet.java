package ejemplosinspring.controladores;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

import ejemplosinspring.accesodatos.DaoProductoJpa;

@WebServlet("/productos")
public class ProductosServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// Recoger la información de la petición
		// Convertir si es necesario
		// Empaquetar en un objeto

		// Ejecutar la lógica de negocio
		var dao = new DaoProductoJpa();
		var productos = dao.obtenerTodos();
		
		// Rellenar la información para la siguiente pantalla
		request.setAttribute("productos", productos);
		
		// Ir a la siguiente pantalla
		request.getRequestDispatcher("productos.jsp").forward(request, response);
	}
}
