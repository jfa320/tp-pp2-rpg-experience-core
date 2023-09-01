package tp.pp2.rpg.generator.core.entidades;

import java.util.List;

public class Personaje {
    private String nombre;
    private String tipo;
	private Integer vidaInicial;
	private Integer vidaActual;
	private Integer ataqueFisico;
	private Integer ataqueEspecial;
	private Integer defensaFisica;
	private Integer defensaEspecial;
    private List<Habilidad> habilidades;
    
	public Personaje(String nombre, String tipo, Integer vidaInicial, Integer vidaActual, Integer ataqueFisico,
			Integer ataqueEspecial, Integer defensaFisica, Integer defensaEspecial, List<Habilidad> habilidades) {
		this.nombre = nombre;
		this.tipo = tipo;
		this.vidaInicial = vidaInicial;
		this.vidaActual = vidaActual;
		this.ataqueFisico = ataqueFisico;
		this.ataqueEspecial = ataqueEspecial;
		this.defensaFisica = defensaFisica;
		this.defensaEspecial = defensaEspecial;
		this.habilidades = habilidades;
	}

	public String getNombre() {
		return nombre;
	}
	public String getTipo() {
		return tipo;
	}
	public int getVidaActual() {
		return vidaActual;
	}
	public List<Habilidad> getHabilidades() {
		return habilidades;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	public void setVidaActual(Integer vidaActual) {
		this.vidaActual = vidaActual;
	}
	public void setHabilidades(List<Habilidad> habilidades) {
		this.habilidades = habilidades;
	}

	public Integer getVidaInicial() {
		return vidaInicial;
	}

	public Integer getAtaqueFisico() {
		return ataqueFisico;
	}

	public Integer getAtaqueEspecial() {
		return ataqueEspecial;
	}

	public Integer getDefensaFisica() {
		return defensaFisica;
	}

	public Integer getDefensaEspecial() {
		return defensaEspecial;
	}

	public void setVidaInicial(Integer vidaInicial) {
		this.vidaInicial = vidaInicial;
	}

	public void setAtaqueFisico(Integer ataqueFisico) {
		this.ataqueFisico = ataqueFisico;
	}

	public void setAtaqueEspecial(Integer ataqueEspecial) {
		this.ataqueEspecial = ataqueEspecial;
	}

	public void setDefensaFisica(Integer defensaFisica) {
		this.defensaFisica = defensaFisica;
	}

	public void setDefensaEspecial(Integer defensaEspecial) {
		this.defensaEspecial = defensaEspecial;
	}
}
