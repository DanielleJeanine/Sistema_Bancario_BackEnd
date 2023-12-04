package com.banco.DTOs;

import java.time.LocalDateTime;

public record SaqueDTO(LocalDateTime data, float valor,boolean status) {
//valor, data,status e conta

}
