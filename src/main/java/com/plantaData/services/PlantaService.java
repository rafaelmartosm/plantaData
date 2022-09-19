package com.plantaData.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.plantaData.entities.Planta;
import com.plantaData.exceptions.ResourceNotFoundException;
import com.plantaData.repositories.PlantaRepository;

@Service
public class PlantaService {
	
	@Autowired
	private PlantaRepository plantaRepository;

	public Planta save(Planta planta) {
		return plantaRepository.save(planta);
	}

	public List<Planta> findAll( ) {
 		return plantaRepository.findAll( );
	}

	public Planta findById (Long id) {
		return plantaRepository.findById(id).get();
	}

	public void deleteById (Long id) {
		plantaRepository.deleteById(id);
	}

	public Planta update(Planta planta) {
		Planta plantas = plantaRepository.findById(planta.getId()).orElseThrow(() -> new ResourceNotFoundException("Não há registros para esse ID informado!"));

		plantas.setEspecie(planta.getEspecie());
		plantas.setDataCompra(planta.getDataCompra());
		plantas.setIdade(planta.getIdade());
		plantas.setVaso(planta.getVaso());
		
		var plantaUpdated = plantaRepository.save(plantas);
		return plantaUpdated;
	}
}

