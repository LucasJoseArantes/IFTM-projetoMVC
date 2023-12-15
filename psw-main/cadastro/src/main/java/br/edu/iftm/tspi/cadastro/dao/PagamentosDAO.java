package br.edu.iftm.tspi.cadastro.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import br.edu.iftm.tspi.cadastro.domain.Pagamento;

@Component
public class PagamentosDAO {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    // Consulta todos os Pagamentos
    public List<Pagamento> listarPagamento(int idPedido) {
        String sql = "SELECT idPagamento, formaPagamento, id_pedido FROM tb_pagamentos WHERE id_pedido = ?";
        return jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(Pagamento.class), idPedido); 
    }

    // Insere um novo Pagamentos
    public void inserirPagamento(Pagamento pagamento) throws DataAccessException {
        String sql = "INSERT INTO tb_pagamentos (idPagamento, formaPagamento, id_pedido) VALUES (?, ?, ?)";
        jdbcTemplate.update(sql, pagamento.getIdPagamento(), pagamento.getFormaPagamento(), pagamento.getId_pedido());
    }

}