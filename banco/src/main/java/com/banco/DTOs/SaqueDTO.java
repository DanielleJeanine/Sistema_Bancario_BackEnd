package com.banco.DTOs;

import java.time.LocalDate;


public record SaqueDTO(LocalDate data, float valor, boolean status) {
//valor, data,status e conta

}
