package tp.pp2.rpg.generator.core.entidades;

public class Habilidad {
	private Integer id;
	private String nombre;
	private Integer danio;
	private String tipo;
	
	public Habilidad(int id, String nombre, Integer danio, String tipo) {
		this.id = id;
		this.nombre = nombre;
		this.tipo = tipo;
		this.danio=danio;
	}
	public Integer getId() {
		return id;
	}
	public String getNombre() {
		return nombre;
	}
	public String getTipo() {
		return tipo;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	public int getDanio() {
		return danio;
	}
	public void setDanio(Integer danio) {
		this.danio = danio;
	}
	@Override
	public String toString() {
		return "Habilidad [id=" + id + ", nombre=" + nombre + ", tipo=" + tipo + ", danio=" + danio + "]";
	}
	
}
