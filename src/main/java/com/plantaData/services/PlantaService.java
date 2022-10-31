package com.plantaData.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;
import org.springframework.stereotype.Service;

import com.plantaData.controllers.PlantaController;
import com.plantaData.entities.Planta;
import com.plantaData.entities.dto.PlantaDTO;
import com.plantaData.exceptions.ResourceNotFoundException;
import com.plantaData.mapper.DozerMapper;
import com.plantaData.repositories.PlantaRepository;

@Service
public class PlantaService {
	
	@Autowired
	private PlantaRepository plantaRepository;

	public PlantaDTO save(PlantaDTO planta) {
		var entity = DozerMapper.parseObject(planta, Planta.class);
		var vo = DozerMapper.parseObject(plantaRepository.save(entity), PlantaDTO.class);
		vo.add(linkTo(methodOn(PlantaController.class).findById(vo.getKey())).withSelfRel());
		return vo;
	}

	public List<PlantaDTO> findAll( ) {
 		var plantas = DozerMapper.parseListObjects(plantaRepository.findAll(), PlantaDTO.class);
 		plantas.stream().forEach(p -> p.add(linkTo(methodOn(PlantaController.class).findById(p.getKey())).withSelfRel()));
 		return plantas;
	}

	public PlantaDTO findById (Long id) {
		var entity = plantaRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Não há registros para esse ID"));
		var vo = DozerMapper.parseObject(entity, PlantaDTO.class);
		vo.add(linkTo(methodOn(PlantaController.class).findById(id)).withSelfRel());
		return vo;
	}	

	public void deleteById (Long id) {
		var entity = plantaRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Não há registros para esse ID"));
		plantaRepository.delete(entity);
	}

	public PlantaDTO update(PlantaDTO planta) {
		Planta entity = plantaRepository.findById(planta.getKey()).orElseThrow(() -> new ResourceNotFoundException("Não há registros para esse ID informado!"));
		entity.setEspecie(planta.getEspecie());
		entity.setDataCompra(planta.getDataCompra());
		entity.setIdade(planta.getIdade());
		entity.setVaso(planta.getVaso());
		
		var vo = DozerMapper.parseObject(plantaRepository.save(entity), PlantaDTO.class);
		vo.add(linkTo(methodOn(PlantaController.class).findById(vo.getKey())).withSelfRel());
		return vo;
	}
}

