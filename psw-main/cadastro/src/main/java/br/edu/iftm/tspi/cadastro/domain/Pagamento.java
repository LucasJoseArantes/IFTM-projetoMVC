    package br.edu.iftm.tspi.cadastro.domain;

    import lombok.AllArgsConstructor;
    import lombok.Data;
    import lombok.NoArgsConstructor;


    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    public class Pagamento {
        private int idPagamento;
        private String formaPagamento;
        private int id_pedido;
    }
