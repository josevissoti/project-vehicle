package com.project.service;

import com.project.domains.Veiculo;
import com.project.repositories.VeiculoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDate;

@Service
public class DBService {

    @Autowired
    private VeiculoRepository veiculoRepo;

    public void initDB() {
        Veiculo veiculo01 = new Veiculo(0, "Ferrari", LocalDate.of(2024, 11, 11), new BigDecimal("80000.00"), "Jorginho", "214.534.563-28");
        Veiculo veiculo02 = new Veiculo(0, "Corsa", LocalDate.of(2023, 07, 23), new BigDecimal("30000.00"), "Renata", "578.196.384-89");
        Veiculo veiculo03 = new Veiculo(0, "Duster", LocalDate.of(2025, 02, 19), new BigDecimal("70000.00"), "Fábio", "671.643.284-81");

        veiculoRepo.save(veiculo01);
        veiculoRepo.save(veiculo02);
        veiculoRepo.save(veiculo03);
    }

}
