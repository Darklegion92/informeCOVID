package modelo.vo.bases;

import java.util.Date;

public class BaseCiade_Duarte {

	private String documento;
	private Date fechaConsulta;
	private String resultado;

	public BaseCiade_Duarte(String documento, Date fechaConsulta, String resultado) {
		super();
		this.documento = documento;
		this.fechaConsulta = fechaConsulta;
		this.resultado = resultado;
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

	public String getResultado() {
		return resultado;
	}

	public void setResultado(String resultado) {
		this.resultado = resultado;
	}

}
