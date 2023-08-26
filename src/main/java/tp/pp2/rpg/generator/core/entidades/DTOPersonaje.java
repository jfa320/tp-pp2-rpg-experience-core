package tp.pp2.rpg.generator.core.entidades;

import java.util.List;

public class DTOPersonaje {
    private String nombrePersonaje;
    private String tipo;
	private Integer vida;
    private List<DTOHabilidad> habilidades;
    
    public DTOPersonaje() {};
	public DTOPersonaje(String nombrePersonaje, String tipo, Integer vida, List<DTOHabilidad> habilidades) {
		super();
		this.nombrePersonaje = nombrePersonaje;
		this.tipo = tipo;
		this.vida = vida;
		this.habilidades = habilidades;
	}
	public String getNombrePersonaje() {
		return nombrePersonaje;
	}
	public String getTipo() {
		return tipo;
	}
	public int getVida() {
		return vida;
	}
	public List<DTOHabilidad> getHabilidades() {
		return habilidades;
	}
	public void setNombrePersonaje(String nombrePersonaje) {
		this.nombrePersonaje = nombrePersonaje;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	public void setVida(Integer i) {
		this.vida = i;
	}
	public void setHabilidades(List<DTOHabilidad> habilidades) {
		this.habilidades = habilidades;
	}
	@Override
	public String toString() {
		return "DTOPersonaje [nombrePersonaje=" + nombrePersonaje + ", tipo=" + tipo + ", vida=" + vida + ", habilidades="
				+ habilidades + "]";
	}
}
