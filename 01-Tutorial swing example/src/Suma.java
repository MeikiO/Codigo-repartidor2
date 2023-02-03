
public class Suma {

	Integer numero;
	
	public Suma() {
		// TODO Auto-generated constructor stub
		this.numero=0;
	}

	public Integer getNumero() {
		return numero;
	}

	public void setNumero(Integer numero) {
		this.numero = numero;
	}
	
	public void sumar(int num) {
		this.setNumero(this.getNumero()+num);
	}
	
	public void resta(int num) {
		this.setNumero(this.getNumero()-num);
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return this.getNumero().toString();
	}
	
	
	
}
