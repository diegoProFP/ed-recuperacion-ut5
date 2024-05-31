package codigo;
/**
 * @author Esteban
 * @version 1.0
 */
public class SuscripcionNetflix {

	String email;
	String numTarjeta;
	int numPerfiles;
	/**
	 * Cuando pides tu suscripcion a netflix te pone el campo email, num tarjeta y te ofrece 3 perfiles
	 * @param email
	 * @param numTarjeta
	 */
	public SuscripcionNetflix(String email, String numTarjeta) {
		super();
		this.email = email;
		this.numTarjeta = numTarjeta;
		this.numPerfiles = 3; //por defecto te ofrece 3 perfiles
	} 
	 /**
	  * Hay dos forvmas de pago la anual qeu se aplica descuento y la mensual que se va pagando a lo larogo de 12 meses
	  * @param modoPago
	  * @return
	  */
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
	/**
	 * Dependiendo del perfil te hace una cosa u otra
	 * @param modoPago
	 * @return
	 */
	public double cuotaPorPerfil(int modoPago) {
		double cuotaPagarTotal = cuotaPagar(modoPago);
		return redondearDoubleDosDecimales(cuotaPagarTotal / this.numPerfiles);
	}
	
	/**
	 * Te dice el precio dependiendo de tu perfil
	 * @param modoPago
	 * @return
	 */
	public double cuotaPerfiles(int modoPago) {
		return redondearDoubleDosDecimales(Constantes.PRECIO_NETFLIX_TOTAL / this.numPerfiles);
	}
	/**
	 * Devuelve el numero  redondeado
	 * @param numero
	 * @return
	 */
	public static double redondearDoubleDosDecimales(double numero) {
		return (double) Math.round(numero * 100) / 100;
	}
	
}
