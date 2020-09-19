package modelo.vo.bases;

import java.util.Date;

public class BaseTablo {
	private String documento;
	private String grupoRiesgo;
	private String lugarAislamiento;
	private String estadoSalud;
	private Date fechaMuerte;

	public BaseTablo(String documento, String grupoRiesgo, String lugarAislamiento, String estadoSalud,
			Date fechaMuerte, String fuenteMuerte, String lugarMuerte) {
		super();
		this.documento = documento;
		this.grupoRiesgo = grupoRiesgo;
		this.lugarAislamiento = lugarAislamiento;
		this.estadoSalud = estadoSalud;
		this.fechaMuerte = fechaMuerte;
		this.fuenteMuerte = fuenteMuerte;
		this.lugarMuerte = lugarMuerte;
	}

	public String getDocumento() {
		return documento;
	}

	public void setDocumento(String documento) {
		this.documento = documento;
	}

	public String getGrupoRiesgo() {
		return grupoRiesgo;
	}

	public void setGrupoRiesgo(String grupoRiesgo) {
		this.grupoRiesgo = grupoRiesgo;
	}

	public String getLugarAislamiento() {
		return lugarAislamiento;
	}

	public void setLugarAislamiento(String lugarAislamiento) {
		this.lugarAislamiento = lugarAislamiento;
	}

	public String getEstadoSalud() {
		return estadoSalud;
	}

	public void setEstadoSalud(String estadoSalud) {
		this.estadoSalud = estadoSalud;
	}

	public Date getFechaMuerte() {
		return fechaMuerte;
	}

	public void setFechaMuerte(Date fechaMuerte) {
		this.fechaMuerte = fechaMuerte;
	}

	public String getFuenteMuerte() {
		return fuenteMuerte;
	}

	public void setFuenteMuerte(String fuenteMuerte) {
		this.fuenteMuerte = fuenteMuerte;
	}

	public String getLugarMuerte() {
		return lugarMuerte;
	}

	public void setLugarMuerte(String lugarMuerte) {
		this.lugarMuerte = lugarMuerte;
	}

	private String fuenteMuerte;
	private String lugarMuerte;

}
