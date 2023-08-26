package tp.pp2.rpg.generator.core.entidades;

public class DTOHabilidad {
	private int id;
	private String nombre;
	private String tipo;
	private int danio;
	
	public DTOHabilidad() {
	}
	public DTOHabilidad(int id, String nombre, String tipo,int danio) {
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
	public void setDanio(int danio) {
		this.danio = danio;
	}
	@Override
	public String toString() {
		return "DTOHabilidad [id=" + id + ", nombre=" + nombre + ", tipo=" + tipo + ", danio=" + danio + "]";
	}
	
}
