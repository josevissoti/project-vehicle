package com.project.service;

import com.project.domains.dtos.VeiculoDTO;
import com.project.repositories.VeiculoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
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
}
