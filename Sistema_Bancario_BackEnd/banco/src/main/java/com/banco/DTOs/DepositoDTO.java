package com.banco.DTOs;

import java.time.LocalDateTime;

public record DepositoDTO(LocalDateTime data, float valor,boolean status) {

}
