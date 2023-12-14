    package br.edu.iftm.tspi.cadastro.domain;

    import lombok.AllArgsConstructor;
    import lombok.Data;
    import lombok.NoArgsConstructor;

    import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    public class Pedido {
        private int idPedido;
        private String valorPedido;
        
        @DateTimeFormat(pattern = "yyyy-MM-dd")
        private Date dataPedido;
    }
