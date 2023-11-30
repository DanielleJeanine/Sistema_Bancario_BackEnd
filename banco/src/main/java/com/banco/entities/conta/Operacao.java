package com.banco.entities.conta;

import java.time.LocalDate;

import jakarta.persistence.MappedSuperclass;
import lombok.Data;

@Data
@MappedSuperclass
public class Operacao {
    
    private Float valor;
    private LocalDate data;
    private Boolean concluidoComSucesso;
}
