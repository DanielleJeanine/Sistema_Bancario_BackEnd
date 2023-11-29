package com.banco.banco.entities;

import java.time.LocalDate;

import lombok.Data;

@Data
public class Operacao {
    
    private Float valor;
    private LocalDate data;
    private Boolean concluidoComSucesso;
}
