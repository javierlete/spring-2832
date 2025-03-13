package com.ipartek.formacion.ejemplospring.controladores;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ipartek.formacion.ejemplospring.entidades.Producto;
import com.ipartek.formacion.ejemplospring.servicios.AdminService;

import jakarta.validation.Valid;

@Controller
@RequestMapping("/admin")
public class AdminController {
	@Autowired
	private AdminService servicio;
	
	@GetMapping("/productos")
	public String verListado(Model modelo) {
		var productos = servicio.obtenerProductos(); 
		
		modelo.addAttribute("productos", productos);
		
		return "productos";
	}

	@GetMapping("/productos/nuevo")
	public String verFormularioProducto(Producto producto) {
		return "producto";
	}

	@GetMapping("/productos/{id}")
	public String verFormularioProductoPorId(@PathVariable Long id, Model modelo) {
		var producto = servicio.detalleProducto(id);

		modelo.addAttribute("producto", producto);

		return "producto";
	}

	@PostMapping("/productos")
	public String recibirFormularioProducto(@Valid Producto producto, BindingResult bindingResult) {
		if (bindingResult.hasErrors()) {
			return "producto";
		}

		if (producto.getId() == null) {
			servicio.crearProducto(producto);
		} else {
			servicio.modificarProducto(producto);
		}
		return "redirect:/";
	}
}
