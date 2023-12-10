package com.banco.DTOs;

import java.time.LocalDate;
import java.time.LocalDateTime;

public record TransferenciaDTO(LocalDate data, float valor, boolean status, String contaOrigem, String contaDepostino) {

}
