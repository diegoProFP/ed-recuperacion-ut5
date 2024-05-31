package codigo;
/**@author MATIAS PENCEF*/
public class SuscripcionNetflix {

	
	
	String email;
	String numTarjeta;
	int numPerfiles;
	
	/**{@value} metodo que recoge un String y un int para crear una suscripcion a netflix*/
	public SuscripcionNetflix(String email, String numTarjeta) {
		super();
		this.email = email;
		this.numTarjeta = numTarjeta;
		this.numPerfiles = 3; //por defecto te ofrece 3 perfiles
	} 
	 
	/**@param recibe un int llamado modoPago con el que elige entre el pago de 1 año y o por meses
	 * @return retorna un double con el importe de la cuota*/
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
	
	/**@param recoge un int para cobrar la cuota segun el numero de perfiles
	 * @return devuelve un double con el importe de la cuota por perfil*/
	public double cuotaPorPerfil(int modoPago) {
		double cuotaPagarTotal = cuotaPagar(modoPago);
		return redondearDoubleDosDecimales(cuotaPagarTotal / this.numPerfiles);
	}
	
	/**@Deprecated metodo obsoleto, se referencia a el nuevo metodo que se encarga de esta funcionalidad
	 * @see cuotaPorPerfil*/
	public double cuotaPerfiles(int modoPago) {
		return redondearDoubleDosDecimales(Constantes.PRECIO_NETFLIX_TOTAL / this.numPerfiles);
	}
	
	/**@param recoge un double con muchos decimales y lo redondea
	 * @return devuelve un double redondeado a dos decimales*/
	public static double redondearDoubleDosDecimales(double numero) {
		return (double) Math.round(numero * 100) / 100;
	}
	
}
