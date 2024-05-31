package codigo;

public class SuscripcionNetflix {

	String email;
	String numTarjeta;
	int numPerfiles;
	
	/**
	 * 
	 * @author alumno
	 * @param recibe como parametros  los string email y numTrarjeta
	 * @version 0.0.1
	 */
	
	public SuscripcionNetflix(String email, String numTarjeta) {
		super();
		this.email = email;
		this.numTarjeta = numTarjeta;
		this.numPerfiles = 3; //por defecto te ofrece 3 perfiles
	} 
	/**
	 * @author Alvaro
	 * @param recibe un entero modoPago y es comparado con varias condiciones donde, cuando este valor 
	 * es igual a la condicion que se tope, entrará, si no, seguira bajando por cada condicion no igual.
	 * si no entra en una condición, automaticamente saltara una excepción
	 * @return como es entero, llama al metodo @see redondearDoubleDosDecimales(cuota); donde al ser un numero 
	 * decimal, float, se redondeará dicha cuota.
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
	 * 
	 * @author Alvaro
	 * @param le llega un modoPago que es entero, para despues, llamando a @see cuotaPagar, apuntará guardando
	 * el resultado en una atributo cuotaPagarTotal que es un double.
	 * @return devuelve el metodo @see redondearDoubleDosDecimales donde se lleva el parametro cuotaPagarTotal dividido
	 * por el numero de perfiles. 
	 */
	
	
	public double cuotaPorPerfil(int modoPago) {
		double cuotaPagarTotal = cuotaPagar(modoPago);
		return redondearDoubleDosDecimales(cuotaPagarTotal / this.numPerfiles);
	}
	/**
	 * 
	 * @param le llega el atributo modoPago modoPago
	 * @return devuelve el metodo @see redondearDoubleDosDecimales donde se divide el precio total de netflix respecto a los numeros 
	 * de perfiles que hay
	 * 
	 * @Deprecated metodo obsoleto, mejor consulten: @see cuotaPorPerfil(int modoPago)
	 */
	
	
	@Deprecated
	public double cuotaPerfiles(int modoPago) {
		return redondearDoubleDosDecimales(Constantes.PRECIO_NETFLIX_TOTAL / this.numPerfiles);
	}
	
	/**
	 * @author Alvaro
	 * @param recibe como paramentro un numero decimal
	 * @return recibe una operacion donde redondea dicho numero
	 */
	
	public static double redondearDoubleDosDecimales(double numero) {
		return (double) Math.round(numero * 100) / 100;
	}
	
}
