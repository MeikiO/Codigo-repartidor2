import java.util.Calendar;

public enum DiasSemana {
	
	Domingo("do",0),
	Lunes("lu",1),
	Martes("mar",2),
	Miercoles("mie",3),
	Jueves("ju",4),
	Viernes("vi",5),
	Sabado("sa",6);
	

	private String abreviacion;
	private int diaSemana;

	DiasSemana(String string,int dayOfTheWeek) {
		this.abreviacion=string;
		this.diaSemana=dayOfTheWeek;
	}

	public static String cogerDia(int dia) {
		String abreviacionDia="";
		
		for(DiasSemana actual:DiasSemana.values()) {
			if(actual.getDiaSemana()==dia) {
				abreviacionDia=actual.getAbreviacion();
			}
			
		}
		return abreviacionDia;
	}
	
	public static String diaActual() {
	      Calendar calendar = Calendar.getInstance();
	      
	      return DiasSemana.cogerDia(calendar.get(Calendar.DAY_OF_WEEK) - 1);
	}
	
	public String getAbreviacion() {
		return abreviacion;
	}

	public int getDiaSemana() {
		return diaSemana;
	}

	
}
