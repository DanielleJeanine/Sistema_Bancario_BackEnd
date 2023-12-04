package com.banco.entities.conta;


import java.time.LocalDateTime;

import jakarta.persistence.MappedSuperclass;
import lombok.Data;

@Data
@MappedSuperclass
public class Operacao {
    
    private Float valor;
    private LocalDateTime data;
    private Boolean concluidoComSucesso;
}
