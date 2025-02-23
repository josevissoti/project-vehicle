package com.project.resources;

import com.project.domains.Veiculo;
import com.project.domains.dtos.VeiculoDTO;
import com.project.service.VeiculoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/veiculo")
public class VeiculoResource {

    @Autowired
    private VeiculoService veiculoService;

    @GetMapping
    public ResponseEntity<List<VeiculoDTO>> findAll() {
        return ResponseEntity.ok().body(veiculoService.findAll());
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<VeiculoDTO> findById(@PathVariable Long id) {
        Veiculo obj = this.veiculoService.findById(id);
        return ResponseEntity.ok().body(new VeiculoDTO(obj));
    }

    @GetMapping(value = "/cpfProprietario/{cpfProprietario}")
    public ResponseEntity<VeiculoDTO> findByCpfProprietario(@PathVariable String cpfProprietario) {
        Veiculo obj = this.veiculoService.findByCpfProprietario(cpfProprietario);
        return ResponseEntity.ok().body(new VeiculoDTO(obj));
    }
}
