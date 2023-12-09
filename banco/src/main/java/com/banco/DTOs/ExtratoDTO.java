package com.banco.DTOs;

import java.util.List;



public record ExtratoDTO(List<SaqueDTO> saques, List<DepositoDTO> depositos, List<TransferenciaDTO> transferencias) {

}
