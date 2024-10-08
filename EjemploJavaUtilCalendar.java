package ejercicios;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
public class EjemploJavaUtilCalendar {

	public static void main(String[] args) {
		Date fechaP = new Date();
		System.out.println("Fecha actual = " + fechaP);
		Calendar calendario = Calendar.getInstance();
		calendario.set(1989, 11, 31, 13, 32);
		Date fecha = calendario.getTime();
		System.out.println("calendario = " + fecha);
		calendario.set(1991, Calendar.JULY, 1, 20, 41);
		fecha = calendario.getTime();
		System.out.println("calendario = " + fecha);
		Calendar calendario2 = Calendar.getInstance();
		calendario2.set(Calendar.DAY_OF_MONTH, 12);
		calendario2.set(Calendar.MONTH, Calendar.MARCH);
		calendario2.set(Calendar.YEAR, 1994);
		//calendario2.set(Calendar.HOUR_OF_DAY, 11);
		calendario2.set(Calendar.HOUR, 9);
		calendario2.set(Calendar.AM_PM, Calendar.PM);
		calendario2.set(Calendar.MINUTE, 31);
		calendario2.set(Calendar.SECOND,23);
		calendario2.set(Calendar.MILLISECOND, 110);
		fecha = calendario2.getTime();
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy' hr: 'hh:mm:ss:SSS a");
		System.out.println("calendario = " + sdf.format(fecha));
		
	}

}
