package com.plantaData.entities;

import java.io.Serializable;
import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "plantaData")
public class Planta implements Serializable{
	
	private static final long serialVersionUID = 1L;

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
