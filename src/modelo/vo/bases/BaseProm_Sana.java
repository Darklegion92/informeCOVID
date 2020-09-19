package modelo.vo.bases;

import java.util.Date;

public class BaseProm_Sana {

	private String documento;
	private Date fechaConsulta;
	
	public BaseProm_Sana(String documento, Date fechaConsulta) {
		super();
		this.documento = documento;
		this.fechaConsulta = fechaConsulta;
	}

	public String getDocumento() {
		return documento;
	}

	public void setDocumento(String documento) {
		this.documento = documento;
	}

	public Date getFechaConsulta() {
		return fechaConsulta;
	}

	public void setFechaConsulta(Date fechaConsulta) {
		this.fechaConsulta = fechaConsulta;
	}

}
