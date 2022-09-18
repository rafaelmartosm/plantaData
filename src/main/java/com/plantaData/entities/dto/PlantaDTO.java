package com.plantaData.entities.dto;

import java.time.LocalDate;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.plantaData.entities.Planta;

import jakarta.persistence.Column;
import jakarta.validation.constraints.NotNull;

public class PlantaDTO {
	
	
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
