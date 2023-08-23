package tp.pp2.rpg.generator.core.entidades;

public class DTOHabilidad {
	private Integer id;
	private String nombre;
	private String tipo;
	
	public DTOHabilidad() {
	}
	public DTOHabilidad(Integer id, String nombre, String tipo) {
		this.id = id;
		this.nombre = nombre;
		this.tipo = tipo;
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
}
