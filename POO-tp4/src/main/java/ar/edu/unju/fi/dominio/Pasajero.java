package ar.edu.unju.fi.dominio;

public class Pasajero {
	
	private String nombre;
	private String apellido;
	private String dni;
	private String correo;
	private String password;
	
		
	public Pasajero() {
		super();
	}
	
	public Pasajero(String nombreString, String apellido, String dni, String correo, String password) {
		super();
		this.nombre = nombreString;
		this.apellido = apellido;
		this.dni = dni;
		this.correo = correo;
		this.password = password;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getApellido() {
		return apellido;
	}
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	public String getDni() {
		return dni;
	}
	public void setDni(String dni) {
		this.dni = dni;
	}
	public String getCorreo() {
		return correo;
	}
	public void setCorreo(String correo) {
		this.correo = correo;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	
	/**
	 * metodo para validar una contraseña.
	 * debe cumplir con que no debe ser menos a 8 caracteres ni mayor a 12, ademas
	 * no debe permitirse ingresar dos numeros consecutivos. Debe Ingresarse una mayuscula
	 * y al menos un caracter especial 
	 * @return true o false
	 */
	public boolean validarPassword() {
	    if (password == null || password.length() < 8 || password.length() > 12) return false;

	    if (!password.matches(".*[A-Z].*")) return false;

	    
	 // Verificar que la contraseña contenga al menos dos números no consecutivos
	    int contadorDigitos = 0;
	    for (int i = 0; i < password.length(); i++) {
	        if (Character.isDigit(password.charAt(i))) {
	            contadorDigitos++;
	            if (i > 0 && Character.isDigit(password.charAt(i - 1))) {
	                return false; // Si hay dos números consecutivos, falla
	            }
	        }
	    }
	    if (contadorDigitos < 2) {
	        return false; // Si no tiene al menos dos números, falla
	    }
	    
	    
	    if (!password.matches(".*[!@#$%^&*().].*")) return false;

	    return true;
	}
	

}
