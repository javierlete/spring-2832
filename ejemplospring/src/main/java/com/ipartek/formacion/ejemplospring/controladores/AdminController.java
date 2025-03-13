package com.ipartek.formacion.ejemplospring.controladores;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
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

	@GetMapping("/producto")
	public String verFormularioProducto(Producto producto) {
		return "producto";
	}
	
	@PostMapping("/producto")
	public String recibirFormularioProducto(@Valid Producto producto, BindingResult bindingResult) {
		if(bindingResult.hasErrors()) {
			return "producto";
		}
		
		servicio.crearProducto(producto);
		return "redirect:/";
	}
}
