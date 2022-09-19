package com.plantaData.entities;

import java.time.LocalDate;

import org.springframework.format.annotation.DateTimeFormat;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name = "plantaData")
public class Planta{
	
	
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id
	private Long id;

	@Column(name = "especie_planta")
	@NotNull(message = "A espécie é obrigatório")
	private String especie;

	@Column(name = "data_compra")
	@NotNull(message = "Data da compra é obrigatório") 
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	private LocalDate dataCompra;
	
	@Column(name = "idade_planta")
	@NotNull(message = "Idade da planta é obrigatório") 
	private String idade;

	@Column(name = "tamanho_vaso")	
	@NotNull(message = "Tamanho do vaso é obrigatório")
	private String vaso;

	public Planta() { }
	
	public Planta(@NotNull(message = "A espécie é obrigatório") String especie,
			@NotNull(message = "Data da compra é obrigatório") LocalDate dataCompra,
			@NotNull(message = "Idade da planta é obrigatório") String idade,
			@NotNull(message = "Tamanho do vaso é obrigatório") String vaso) {
		super();
		this.especie = especie;
		this.dataCompra = dataCompra;
		this.idade = idade;
		this.vaso = vaso;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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
