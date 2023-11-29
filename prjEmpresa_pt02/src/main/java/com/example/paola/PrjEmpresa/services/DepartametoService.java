package com.example.paola.PrjEmpresa.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.paola.PrjEmpresa.entities.Departamento;

import com.example.paola.PrjEmpresa.repositories.DepartamentoRepository;

@Service
public class DepartametoService {

	
private final DepartamentoRepository departamentoRepository;
	
	@Autowired
	public  DepartametoService( DepartamentoRepository  departamentoRepository) {
		this.departamentoRepository =  departamentoRepository;
	}

	
		public Departamento findDepartamentoById(Long depcodigo) {
			Optional<Departamento> Departamento = departamentoRepository.findById(depcodigo);
			return Departamento.orElse(null);
		}

		
		public List<Departamento> findAllDepartamento() {
			return departamentoRepository.findAll();
		}

		
		public Departamento insertDepartamento(Departamento departamento) {
			return departamentoRepository.save(departamento);
		}

	
		public Departamento updateDepartamento(Long depcodigo, Departamento novoDepartamento) {
			Optional<Departamento> departamentoOptional = departamentoRepository.findById(depcodigo);
			if (departamentoOptional.isPresent()) {
				Departamento departamentoExistente = departamentoOptional.get();
				departamentoExistente.setDepnome(novoDepartamento. getDepnome());
				departamentoExistente.setDepcodigo(novoDepartamento.getDepcodigo());
				return departamentoRepository.save(departamentoExistente);
			} else {
				return null;
			}
		}

		
		public boolean deleteDepartamento(Long depcodigo) {
			Optional<Departamento> departamentoExistente = departamentoRepository.findById(depcodigo);
			if (departamentoExistente.isPresent()) {
				departamentoRepository.deleteById(depcodigo);
				return true;
			} else {
				return false;
			}
		}
	


}
