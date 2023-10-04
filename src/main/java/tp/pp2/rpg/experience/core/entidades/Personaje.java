package tp.pp2.rpg.experience.core.entidades;


public class Personaje {
	private int id;
    private String nombre;
	
	public Personaje() {}

	public Personaje(int id, String nombre) {
		super();
		this.id = id;
		this.nombre = nombre;
	}

	public int getId() {
		return id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	@Override
	public String toString() {
		return "Personaje [id=" + id + ", nombre=" + nombre + "]";
	}
	@Override
	public boolean equals(Object per) {
	    return(((Personaje) per).getId()==this.getId());
	}
}
