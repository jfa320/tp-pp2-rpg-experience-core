package tp.pp2.rpg.experience.core.entidades;


public class Personaje {
    private String nombre;
	
	public Personaje() {}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	@Override
	public String toString() {
		return "Personaje [nombre=" + nombre + "]";
	};
	
}
