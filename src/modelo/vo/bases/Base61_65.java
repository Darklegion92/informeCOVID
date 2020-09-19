package modelo.vo.bases;

import java.util.Date;

public class Base61_65 {

	private String documento;
	private String idVisita;
	private String observacion;
	private Date fechaVisita;

	public Base61_65(String documento, String idVisita, String observacion, Date fechaVisita) {
		super();
		this.documento = documento;
		this.idVisita = idVisita;
		this.observacion = observacion;
		this.fechaVisita = fechaVisita;
	}

	public String getDocumento() {
		return documento;
	}

	public void setDocumento(String documento) {
		this.documento = documento;
	}

	public String getIdVisita() {
		return idVisita;
	}

	public void setIdVisita(String idVisita) {
		this.idVisita = idVisita;
	}

	public String getObservacion() {
		return observacion;
	}

	public void setObservacion(String observacion) {
		this.observacion = observacion;
	}

	public Date getFechaVisita() {
		return fechaVisita;
	}

	public void setFechaVisita(Date fechaVisita) {
		this.fechaVisita = fechaVisita;
	}

}
