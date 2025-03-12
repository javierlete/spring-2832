package com.ipartek.formacion.ejemplospring.controladores;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ipartek.formacion.ejemplospring.servicios.AnonimoService;

@Controller
public class AnonimoController {
	
	@Autowired
	private AnonimoService servicio;
	
	@GetMapping("/")
	@ResponseBody
	public String principal(Model modelo) {
		var productos = servicio.obtenerProductos(); 
		modelo.addAttribute("productos", productos);
		return modelo.toString();
	}
}
