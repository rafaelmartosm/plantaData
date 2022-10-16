package com.plantaData.entities.dto;

import java.io.Serializable;
import java.time.LocalDate;

import javax.persistence.Column;
import javax.validation.constraints.NotNull;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.plantaData.entities.Planta;

public class PlantaDTO implements Serializable {
	
	private static final long serialVersionUID = 1L;

	@Column(name = "especie_planta")
	@NotNull(message = "A espécie é obrigatório")
	private String especie;

	@Column(name = "data_compra")
	@NotNull(message = "Data da compra é obrigatório") 
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	@JsonFormat(shape=JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy")
	private LocalDate dataCompra;
	
	@Column(name = "idade_planta")
	@NotNull(message = "Idade da planta é obrigatório") 
	private String idade;

	@Column(name = "tamanho_vaso")	
	@NotNull(message = "Tamanho do vaso é obrigatório")
	private String vaso;

	public PlantaDTO() { }

	public Planta DtoToPlanta() {
		return new Planta(especie, dataCompra, idade, vaso);
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

}
