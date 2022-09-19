package com.plantaData.controllers;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

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

import com.plantaData.entities.Planta;
import com.plantaData.entities.dto.PlantaDTO;
import com.plantaData.repositories.PlantaRepository;
import com.plantaData.services.PlantaService;

import jakarta.validation.Valid;

@RestController
@RequestMapping(path = "/planta")
public class PlantaController {

	@Autowired
	private PlantaService plantaService;
	@Autowired
	private PlantaRepository plantaRepository;

	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public ResponseEntity<Planta> save(@Valid @RequestBody PlantaDTO dto) {
		Planta planta = plantaService.save(dto.DtoToPlanta());
		return new ResponseEntity<>(planta, HttpStatus.CREATED);
	}

	@GetMapping
	public ResponseEntity<List<Planta>> findAll( ) {
		List<Planta> plantas = new ArrayList<>();
		plantas = plantaService.findAll( );
		return new ResponseEntity<>(plantas, HttpStatus.OK);
	}

	@GetMapping("/{id}")
	public Planta findById(@PathVariable Long id) {
		return plantaService.findById(id);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Optional<Planta>> deleteById(@PathVariable Long id) {
		try {
			plantaService.deleteById(id);
			return new ResponseEntity<Optional<Planta>>(HttpStatus.OK);
		} catch (NoSuchElementException nsee) {
			return new ResponseEntity<Optional<Planta>> (HttpStatus.NOT_FOUND);
		}
	}

	@PutMapping("/{id}")
	public ResponseEntity<Planta> update(@PathVariable Long id, @Valid @RequestBody Planta newPlanta) {
	if(!plantaRepository.existsById(id)) {
		return ResponseEntity.notFound().build();
	}
	newPlanta.setId(id);
	newPlanta = plantaRepository.save(newPlanta);
	return ResponseEntity.ok(newPlanta);
	}
}

