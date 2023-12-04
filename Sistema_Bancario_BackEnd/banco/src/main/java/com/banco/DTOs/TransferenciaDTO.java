package com.banco.DTOs;

import java.time.LocalDateTime;

public record TransferenciaDTO(LocalDateTime data, float valor,boolean status,String contaOrigem,String contaDepostino) {

}
