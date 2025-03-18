package com.ipartek.formacion.ejemplospring.controladores;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.ipartek.formacion.ejemplospring.servicios.AnonimoService;

@Controller
public class AnonimoController {
	
	@Autowired
	private AnonimoService servicio;
	
	@GetMapping("/")
	public String principal(Model modelo) {
		var productos = servicio.obtenerProductos(); 
		modelo.addAttribute("productos", productos);
		return "principal";
	}
	
	@GetMapping("/detalle")
	public String detalle(Long id, Model modelo) {
		var producto = servicio.detalleProducto(id);
		
		modelo.addAttribute("producto", producto);
		
		return "detalle";
	}
	
	@GetMapping("/login")
	public String login() {
		return "login";
	}
}
