package ejercicios;

import java.util.Date;
import java.text.SimpleDateFormat;

public class EjemploJavaUtilDate {
	public static void main(String args[]) {
		Date fecha = new Date();
		System.out.println("Fecha = " + fecha);
		
		SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy");
		SimpleDateFormat sim = new SimpleDateFormat("'Ciudad de México a 'dd' de 'MMMM' del año 'yyyy");
		SimpleDateFormat dfDia = new SimpleDateFormat("d");
		SimpleDateFormat dfMes = new SimpleDateFormat("MMMM");
		SimpleDateFormat dfAnio = new SimpleDateFormat("yyyy");
		String fechaStr = df.format(fecha);
		String dia = dfDia.format(fecha);
		String mes = dfMes.format(fecha);
		String anio = dfAnio.format(fecha);
		String simpleFecha = sim.format(fecha);
		System.out.println("fechaStr = " + fechaStr);
		System.out.println("Ciudad de México a " + dia + " de " + mes + " del año " + anio);
		System.out.println("Ciudad de México a " + dfDia.format(fecha) + " de " + dfMes.format(fecha) + " del año " + dfAnio.format(fecha));
		System.out.println("Lugar y fecha: "+simpleFecha);
		
		//----------------------------------------------
		
		Date primTiempo = new Date();
		
		long sum = 0;
		for(int c = 0;c < 10000000;c++){
			sum+=c;
		}
		Date segTiempo = new Date();
		System.out.println("Resultado de la suma: " + sum + " y se demoró aprox " + (segTiempo.getTime() - primTiempo.getTime()) + " milisegundos");
		//----------------------------------------------
	}

}
