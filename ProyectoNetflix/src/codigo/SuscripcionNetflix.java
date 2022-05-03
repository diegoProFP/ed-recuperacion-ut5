package codigo;

public class SuscripcionNetflix {

	String email;
	String numTarjeta;
	int numPerfiles;
	
	public SuscripcionNetflix(String email, String numTarjeta) {
		super();
		this.email = email;
		this.numTarjeta = numTarjeta;
		this.numPerfiles = 3; //por defecto te ofrece 3 perfiles
	} 
	 
	public double cuotaPagar(int modoPago) {
		double cuota = 0;
		//Si pago es Anual, se hace un descuento al total
		if(modoPago == Constantes.PAGO_ANUAL) {
			cuota = (Constantes.PRECIO_NETFLIX_TOTAL - (Constantes.PRECIO_NETFLIX_TOTAL * Constantes.DESCUENTO_PAGO_ANUAL));
		}else if(modoPago == Constantes.PAGO_MENSUAL) {
			//si el pago es mensual, se divide el precio entre 12 meses
			cuota = (Constantes.PRECIO_NETFLIX_TOTAL / 12);
		}else {
			throw new IllegalArgumentException("El modo de pago es incorrecto.");
		}
		
		return redondearDoubleDosDecimales(cuota);
	}
	
	public double cuotaPorPerfil(int modoPago) {
		double cuotaPagarTotal = cuotaPagar(modoPago);
		return redondearDoubleDosDecimales(cuotaPagarTotal / this.numPerfiles);
	}
	
	@Deprecated
	public double cuotaPerfiles(int modoPago) {
		return redondearDoubleDosDecimales(Constantes.PRECIO_NETFLIX_TOTAL / this.numPerfiles);
	}
	
	public static double redondearDoubleDosDecimales(double numero) {
		return (double) Math.round(numero * 100) / 100;
	}
	
}
