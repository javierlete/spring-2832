package com.ipartek.formacion.ejemplospring.controladores;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ipartek.formacion.ejemplospring.entidades.Producto;

@Controller
@RequestMapping("/admin")
public class AdminController {
	@GetMapping("/producto")
	public String verFormularioProducto() {
		return "producto";
	}
	
	@PostMapping("/producto")
	@ResponseBody
	public String recibirFormularioProducto(Producto producto) {
		return producto.toString();
	}
}
