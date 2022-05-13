package codigo;

/**
 * Esta clase sirve para suscribirse a Netflix.
 * 
 * Tenemos un metodo cuotaPagar que calcula el precio a pagar dependiendo del tipo de pago
 * que elijas, si elegimos el pago anual se realizara un descuento del 15% al total que se 
 * tiene que pagar y si elegimos el pago mensual el pago total se dividira entre 12 para 
 * que nos de el resultado.
 * 
 * Tenemos otro metodo cuotaPorPerfil donde te calcula la cuota a pagar por perfil dividiendo 
 * la cuota total entre el numero de perfiles (maximo 3 perfiles descrito en el constructor.
 * 
 * Tenemos un metodo cuotaPerfiles que la hemos descartado.
 * 
 * Y por ultimo tenemos un metodo redondearDoubleDosDecimales que sirve para que nos redondee
 * la cuota a maximo 2 decimales.
 * 
 * @author les96 (les96@hotmail.es)
 *
 */

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
	
	/**
	 * Tenemos un metodo cuotaPagar que calcula el precio a pagar dependiendo del tipo de pago
	 * que elijas, si elegimos el pago anual se realizara un descuento del 15% al total que se 
	 * tiene que pagar y si elegimos el pago mensual el pago total se dividira entre 12 para 
	 * que nos de el resultado.
	 * 
	 * @param modoPago es un parametro donde indicaremos la couta que pagaremos.
	 * 
	 * @return redondearDoubleDosDecimales nos devuelve el metodo redondearDoubleDosDecimales
	 * que sirve para redondear la couta a pagar con un maximo de 2 decimales.
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
