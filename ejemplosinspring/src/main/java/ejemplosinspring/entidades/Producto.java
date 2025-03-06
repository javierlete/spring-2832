package ejemplosinspring.entidades;

import java.math.BigDecimal;
import java.time.LocalDate;

import jakarta.validation.constraints.FutureOrPresent;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Producto {
	private Long id;
	
	@NotBlank
	private String nombre;
	
	@NotNull
	@Min(0)
	private BigDecimal precio;
	
	@FutureOrPresent
	private LocalDate fechaCaducidad;
}
