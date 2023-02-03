
public class NestedObject{
	private Integer id;
	private String inicio_mandato;
	private String fin_mandato;
	private String vicepresidente;
	public NestedObject(int i, String string, String string2, String string3) {
		// TODO Auto-generated constructor stub
		this.id=i;
		this.inicio_mandato=string;
		this.fin_mandato=string2;
		this.vicepresidente=string3;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getInicio_mandato() {
		return inicio_mandato;
	}
	public void setInicio_mandato(String inicio_mandato) {
		this.inicio_mandato = inicio_mandato;
	}
	public String getFin_mandato() {
		return fin_mandato;
	}
	public void setFin_mandato(String fin_mandato) {
		this.fin_mandato = fin_mandato;
	}
	public String getVicepresidente() {
		return vicepresidente;
	}
	public void setVicepresidente(String vicepresidente) {
		this.vicepresidente = vicepresidente;
	}
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "id: "+this.getId()+
				"\n inicio mandato: "+this.getInicio_mandato()+
				"\n fint mandato: "+this.getFin_mandato()+
				"\n vicepresidente: "+this.getVicepresidente();
	}

	


}