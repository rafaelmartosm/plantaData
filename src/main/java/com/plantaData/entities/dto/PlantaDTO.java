package com.plantaData.entities.dto;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.hateoas.RepresentationModel;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.github.dozermapper.core.Mapping;

@JsonPropertyOrder({"id", "especie", "dataCompra", "idade", "vaso"})
public class PlantaDTO extends RepresentationModel<PlantaDTO> implements Serializable {
	
	private static final long serialVersionUID = 1L;

	@Mapping("id")
	@JsonProperty("id")
	private Long key;
	
	private String especie;
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	@JsonFormat(shape=JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy")
	private LocalDate dataCompra;
	
	private String idade;
	
	private String vaso;

	public PlantaDTO() { }

	public PlantaDTO(String especie, LocalDate dataCompra, String idade, String vaso) {
		super();
		this.especie = especie;
		this.dataCompra = dataCompra;
		this.idade = idade;
		this.vaso = vaso;
	}

	public Long getKey() {
		return key;
	}

	public void setKey(Long key) {
		this.key = key;
	}

	public String getEspecie() {
		return especie;
	}

	public void setEspecie(String especie) {
		this.especie = especie;
	}

	public LocalDate getDataCompra() {
		return dataCompra;
	}

	public void setDataCompra(LocalDate dataCompra) {
		this.dataCompra = dataCompra;
	}

	public String getIdade() {
		return idade;
	}

	public void setIdade(String idade) {
		this.idade = idade;
	}

	public String getVaso() {
		return vaso;
	}

	public void setVaso(String vaso) {
		this.vaso = vaso;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + Objects.hash(dataCompra, especie, idade, key, vaso);
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		PlantaDTO other = (PlantaDTO) obj;
		return Objects.equals(dataCompra, other.dataCompra) && Objects.equals(especie, other.especie)
				&& Objects.equals(idade, other.idade) && Objects.equals(key, other.key)
				&& Objects.equals(vaso, other.vaso);
	}

}
