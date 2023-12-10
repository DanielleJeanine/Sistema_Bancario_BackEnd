package com.banco.DTOs;

import java.time.LocalDate;
import java.time.LocalDateTime;

public record DepositoDTO(LocalDate data, float valor, boolean status) {

}
