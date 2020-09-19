package modelo.vo.bases;

import java.util.Date;

public class BaseCoosalud {

	private String documento;
	private Date fechaNacimiento;
	private String municipio;
	private String estado;
	private String carnet;
	private String regimen;

	public BaseCoosalud(String documento, Date fechaNacimiento, String municipio, String estado, String carnet,
			String regimen) {
		super();
		this.documento = documento;
		this.fechaNacimiento = fechaNacimiento;
		this.municipio = municipio;
		this.estado = estado;
		this.carnet = carnet;
		this.regimen = regimen;
	}

	public String getDocumento() {
		return documento;
	}

	public void setDocumento(String documento) {
		this.documento = documento;
	}

	public Date getFechaNacimiento() {
		return fechaNacimiento;
	}

	public void setFechaNacimiento(Date fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}

	public String getMunicipio() {
		return municipio;
	}

	public void setMunicipio(String municipio) {
		this.municipio = municipio;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public String getCarnet() {
		return carnet;
	}

	public void setCarnet(String carnet) {
		this.carnet = carnet;
	}

	public String getRegimen() {
		return regimen;
	}

	public void setRegimen(String regimen) {
		this.regimen = regimen;
	}

}
