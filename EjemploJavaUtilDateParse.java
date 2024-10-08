package ejercicios;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;
public class EjemploJavaUtilDateParse {

	public static void main(String[] args) {
		SimpleDateFormat formato = new SimpleDateFormat("dd-MM-yyyy");
		Scanner s = new Scanner(System.in);
		try {
			//Date fecha = formato.parse("2020-01-05");
			System.out.println("Introduzca una fecha en formato dd-MM-yyyy");
			Date fecha = formato.parse(s.nextLine());
			System.out.println("fecha = " + fecha);
			System.out.println("fecha con formato = " + formato.format(fecha));
			Date fecha2 = Calendar.getInstance().getTime();
			if(fecha.after(fecha2)) {
				System.out.println("La fecha introducida es despues de la fecha actual");
			}else if(fecha.before(fecha2)) {
				System.out.println("La fecha introducida es antes que la fecha actual");
			}else {
				System.out.println("Las fechas son la misma");
			}
			
			if(fecha.compareTo(fecha2) > 0) {
				System.out.println("La fecha introducida es despues de la fecha actual");
			}
			else if(fecha.compareTo(fecha2) < 0) {
				System.out.println("La fecha introducida es antes que la fecha actual");
				long edadMili = fecha2.getTime()-fecha.getTime();
				edadMili /= 1000;
				edadMili /= 3600;
				edadMili /= 24;
				edadMili /= 365;
				System.out.println("La edad estimada del usuario es: " +  edadMili);
			}
			
			
		} catch (ParseException e) {
			//e.printStackTrace();
			System.out.println("Formato de fecha incorrecto");
		}
		s.close();
		System.out.println("\nTermina la ejecución del programa");
	}

}
