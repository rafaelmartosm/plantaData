package com.plantaData.controllers;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.plantaData.entities.dto.PlantaDTO;
import com.plantaData.repositories.PlantaRepository;
import com.plantaData.services.PlantaService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping(path = "/planta")
@Tag(name = "PlantaDTO", description = "Endpoints para cadastro de planta")
public class PlantaController {

	@Autowired
	private PlantaService plantaService;
	
	@Autowired
	private PlantaRepository plantaRepository;

	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	@Operation(summary = "Cadastrar uma PlantaDTO", description = "Cadastra uma planta",
	tags = {"PlantaDTO"},
	responses = {
			@ApiResponse(description = "Sucesso", responseCode = "200", 
					content = {
							@Content(
									mediaType = "application/json",
									array = @ArraySchema(schema = @Schema(implementation = PlantaDTO.class)))
			}),
			@ApiResponse(description = "Erro", responseCode = "400", content = @Content),
			@ApiResponse(description = "Não Autorizado", responseCode = "401", content = @Content),
			@ApiResponse(description = "Erro do Servidor Interno", responseCode = "500", content = @Content),
	})
	public ResponseEntity<PlantaDTO> save(@Valid @RequestBody PlantaDTO dto) {
		PlantaDTO planta = plantaService.save(dto);
		return new ResponseEntity<>(planta, HttpStatus.CREATED);
	}

	@GetMapping
	@Operation(summary = "Lista de Plantas", description = "Todas as plantas cadastradas",
	tags = {"PlantaDTO"},
	responses = {
			@ApiResponse(description = "Sucesso", responseCode = "200", 
					content = {
							@Content(
									mediaType = "application/json",
									array = @ArraySchema(schema = @Schema(implementation = PlantaDTO.class)))
			}),
			@ApiResponse(description = "Erro", responseCode = "400", content = @Content),
			@ApiResponse(description = "Não Autorizado", responseCode = "401", content = @Content),
			@ApiResponse(description = "Não Encontrado", responseCode = "404", content = @Content),
			@ApiResponse(description = "Erro do Servidor Interno", responseCode = "500", content = @Content),
	})
	public ResponseEntity<List<PlantaDTO>> findAll( ) {
		List<PlantaDTO> plantas = new ArrayList<>();
		plantas = plantaService.findAll( );
		return new ResponseEntity<>(plantas, HttpStatus.OK);
	}

	@GetMapping("/{id}")
	@Operation(summary = "Encontrar uma PlantaDTO", description = "Localizar uma determinada planta cadastrada",
	tags = {"PlantaDTO"},
	responses = {
			@ApiResponse(description = "Sucesso", responseCode = "200", 
					content = {
							@Content(
									mediaType = "application/json",
									array = @ArraySchema(schema = @Schema(implementation = PlantaDTO.class)))
			}),
			@ApiResponse(description = "Sem conteúdo", responseCode = "204", content = @Content),
			@ApiResponse(description = "Erro", responseCode = "400", content = @Content),
			@ApiResponse(description = "Não Autorizado", responseCode = "401", content = @Content),
			@ApiResponse(description = "Não Encontrado", responseCode = "404", content = @Content),
			@ApiResponse(description = "Erro do Servidor Interno", responseCode = "500", content = @Content),
	})
	public PlantaDTO findById(@PathVariable Long id) {
		return plantaService.findById(id);
	}

	@DeleteMapping("/{id}")
	@Operation(summary = "Apagar uma PlantaDTO", description = "Apaga uma planta cadastrada",
	tags = {"PlantaDTO"},
	responses = {
			@ApiResponse(description = "Sem conteúdo", responseCode = "204", content = @Content),
			@ApiResponse(description = "Erro", responseCode = "400", content = @Content),
			@ApiResponse(description = "Não Autorizado", responseCode = "401", content = @Content),
			@ApiResponse(description = "Não Encontrado", responseCode = "404", content = @Content),
			@ApiResponse(description = "Erro do Servidor Interno", responseCode = "500", content = @Content),
	})
	public ResponseEntity<Optional<PlantaDTO>> deleteById(@PathVariable Long id) {
		try {
			plantaService.deleteById(id);
			return new ResponseEntity<Optional<PlantaDTO>>(HttpStatus.OK);
		} catch (NoSuchElementException nsee) {
			return new ResponseEntity<Optional<PlantaDTO>> (HttpStatus.NOT_FOUND);
		}
	}

	@PutMapping("/{id}")
	@Operation(summary = "Atualizar uma PlantaDTO", description = "Atualiza uma planta cadastrada",
	tags = {"PlantaDTO"},
	responses = {
			@ApiResponse(description = "Atualizado", responseCode = "200", 
					content = {
							@Content(
									mediaType = "application/json",
									array = @ArraySchema(schema = @Schema(implementation = PlantaDTO.class)))
			}),
			@ApiResponse(description = "Erro", responseCode = "400", content = @Content),
			@ApiResponse(description = "Não Autorizado", responseCode = "401", content = @Content),
			@ApiResponse(description = "Não Encontrado", responseCode = "404", content = @Content),
			@ApiResponse(description = "Erro do Servidor Interno", responseCode = "500", content = @Content),
	})
	public ResponseEntity<PlantaDTO> update(@PathVariable Long id, @Valid @RequestBody PlantaDTO newPlanta) {
	if(!plantaRepository.existsById(id)) {
		return ResponseEntity.notFound().build();
	}
	newPlanta.setKey(id);
	newPlanta = plantaService.update(newPlanta);
	return ResponseEntity.ok(newPlanta);
	}
}

