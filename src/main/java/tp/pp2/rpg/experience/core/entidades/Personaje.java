package tp.pp2.rpg.experience.core.entidades;


public class Personaje {
	private Integer id;
    private String nombre;
	private Integer ataque;
	private Integer defensa;
	
	public Personaje() {};
	public Personaje(Integer id, String nombre, Integer ataque, Integer defensa) {
		this.id = id;
		this.nombre = nombre;
		this.ataque = ataque;
		this.defensa = defensa;
	}
	public Integer getId() {
		return id;
	}
	public String getNombre() {
		return nombre;
	}
	public Integer getAtaque() {
		return ataque;
	}
	public Integer getDefensa() {
		return defensa;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public void setAtaque(Integer ataque) {
		this.ataque = ataque;
	}
	public void setDefensa(Integer defensa) {
		this.defensa = defensa;
	}
	@Override
	public String toString() {
		return "Personaje [id=" + id + ", nombre=" + nombre + ", ataque=" + ataque + ", defensa=" + defensa + "]";
	}
}
