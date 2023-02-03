package contrasenas;


import java.security.SecureRandom;


public class GestorContrasenas
{
	
	
	public int longitud;

	public GestorContrasenas() {
		// TODO Auto-generated constructor stub
		
		this.longitud=8;
	}
	
	public GestorContrasenas(int lenght) {
		// TODO Auto-generated constructor stub
		this.longitud=lenght;
	}
	
    // Method to generate a random alphanumeric password of a specific length
    public String generateRandomPassword()
    {
        // ASCII range – alphanumeric (0-9, a-z, A-Z)
        final String chars = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
 
        SecureRandom random = new SecureRandom();
        StringBuilder sb = new StringBuilder();
 
        // each iteration of the loop randomly chooses a character from the given
        // ASCII range and appends it to the `StringBuilder` instance
 
        for (int i = 0; i < this.getLongitud(); i++)
        {
            int randomIndex = random.nextInt(chars.length());
            sb.append(chars.charAt(randomIndex));
        }
 
        return sb.toString();
    }
 
    
    
    public int getLongitud() {
		return longitud;
	}

	public void setLongitud(int longitud) {
		this.longitud = longitud;
	}

	public static void main(String[] args)
    {
        int len = 10;
        GestorContrasenas contrasena=new GestorContrasenas();
        System.out.println(contrasena.generateRandomPassword());
    }
}