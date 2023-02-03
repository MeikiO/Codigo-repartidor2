import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class Principal {

	public static void main(String[] args) {
	
	        Calendar calendar = Calendar.getInstance();
	        calendar.set(2022, 0, 16);
	        System.out.println("Day: " + (calendar.get(Calendar.DATE)));
	        System.out.println("Month: " + (calendar.get(Calendar.MONTH) + 1));
	        System.out.println("Year: " + (calendar.get(Calendar.YEAR)));
	        System.out.println("Current day = " + DiasSemana.cogerDia(calendar.get(Calendar.DAY_OF_WEEK) - 1));
	            
	}

}
