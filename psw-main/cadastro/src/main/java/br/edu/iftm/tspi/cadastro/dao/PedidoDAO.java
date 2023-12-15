package br.edu.iftm.tspi.cadastro.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.ModelAttribute;

import br.edu.iftm.tspi.cadastro.domain.Pedido;

@Component
public class PedidoDAO {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    // Consulta todos os Pedidos
    public List<Pedido> listarPedidos(String email) {
        String sql = "SELECT idPedido, valorPedido, dataPedido, email_contato FROM tb_pedido WHERE email_contato = ?";
        return jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(Pedido.class), email);
    }

    // Insere um novo Pedido
    public void inserirPedido(Pedido Pedido) throws DataAccessException {
        String sql = "INSERT INTO tb_pedido (idPedido, valorPedido, dataPedido, email_contato) VALUES (?, ?, ?, ?)";
        jdbcTemplate.update(sql, Pedido.getIdPedido(), Pedido.getValorPedido(), Pedido.getDataPedido(), Pedido.getEmail_contato());
    }

    // Busca Pedidos pelo nome
    public List<Pedido> buscarPedidosPorId(int idPedido) {
        String sql = "SELECT idPedido, valorPedido, dataPedido WHERE idPedido LIKE ?";
        return jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(Pedido.class), "%" + idPedido + "%");
    }

    public void atualizarpedido(Pedido pedido) throws DataAccessException {
        String sql = "UPDATE tb_pedido SET valorPedido = ?, dataPedido = ? WHERE idPedido = ?";
        jdbcTemplate.update(sql, pedido.getValorPedido(), pedido.getDataPedido(), pedido.getIdPedido());
    }

    // Exclui um pedido pelo email
    public void excluirpedido(String email) throws DataAccessException {
        String sql = "DELETE FROM tb_pedido WHERE idPedido = ?";
        jdbcTemplate.update(sql, email);
    }

    // Busca um pedido pelo email
    public Pedido buscarPedidoPorId(int idPedido) {
        String sql = "SELECT  idPedido, valorPedido, dataPedido FROM tb_pedido WHERE idPedido = ?";
        return jdbcTemplate.queryForObject(sql, new BeanPropertyRowMapper<>(Pedido.class), idPedido);
    }

}
