package com.project.service;

import com.project.domains.Veiculo;
import com.project.domains.dtos.VeiculoDTO;
import com.project.repositories.VeiculoRepository;
import com.project.service.exceptions.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class VeiculoService {

    @Autowired
    public VeiculoRepository veiculoRepository;

    public List<VeiculoDTO> findAll() {
        return veiculoRepository.findAll().stream()
                .map(obj -> new VeiculoDTO(obj))
                .collect(Collectors.toList());
    }

    public Veiculo findById(Long id) {
        Optional<Veiculo> obj = veiculoRepository.findById(id);
        return obj.orElseThrow(() -> new ObjectNotFoundException("Veículo não encontrado. ID: " + id));
    }

    public Veiculo findByCpfProprietario(String cpfProprietario) {
        Optional<Veiculo> obj = veiculoRepository.findByCpfProprietario(cpfProprietario);
        return obj.orElseThrow(() -> new ObjectNotFoundException("Veículo não encontrado. CPF do proprietário: " + cpfProprietario));
    }
}
