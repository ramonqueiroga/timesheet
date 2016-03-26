package br.com.timesheet.modelos.generico;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;

@MappedSuperclass
public class TabelaModel {

	@Column
	private LocalDateTime atualizado;
	@Column
	private String atualizadoPor;
	@Column
	private LocalDateTime criado;
	@Column
	private String criadoPor;
	
	public LocalDateTime getAtualizado() {
		return atualizado;
	}
	public void setAtualizado(LocalDateTime atualizado) {
		this.atualizado = atualizado;
	}
	public String getAtualizadoPor() {
		return atualizadoPor;
	}
	public void setAtualizadoPor(String atualizadoPor) {
		this.atualizadoPor = atualizadoPor;
	}
	public LocalDateTime getCriado() {
		return criado;
	}
	public void setCriado(LocalDateTime criado) {
		this.criado = criado;
	}
	public String getCriadoPor() {
		return criadoPor;
	}
	public void setCriadoPor(String criadoPor) {
		this.criadoPor = criadoPor;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((atualizado == null) ? 0 : atualizado.hashCode());
		result = prime * result
				+ ((atualizadoPor == null) ? 0 : atualizadoPor.hashCode());
		result = prime * result + ((criado == null) ? 0 : criado.hashCode());
		result = prime * result
				+ ((criadoPor == null) ? 0 : criadoPor.hashCode());
		return result;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		TabelaModel other = (TabelaModel) obj;
		if (atualizado == null) {
			if (other.atualizado != null)
				return false;
		} else if (!atualizado.equals(other.atualizado))
			return false;
		if (atualizadoPor == null) {
			if (other.atualizadoPor != null)
				return false;
		} else if (!atualizadoPor.equals(other.atualizadoPor))
			return false;
		if (criado == null) {
			if (other.criado != null)
				return false;
		} else if (!criado.equals(other.criado))
			return false;
		if (criadoPor == null) {
			if (other.criadoPor != null)
				return false;
		} else if (!criadoPor.equals(other.criadoPor))
			return false;
		return true;
	}
	
	@Override
	public String toString() {
		return "TabelaModel [atualizado=" + atualizado + ", atualizadoPor="
				+ atualizadoPor + ", criado=" + criado + ", criadoPor="
				+ criadoPor + "]";
	}
	
}
