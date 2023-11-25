package br.edu.iftm.contact.contatos.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import br.edu.iftm.contact.contatos.domain.Contato;

@Component
public class ContatoDao {

    @Autowired
    JdbcTemplate db;

    public List<Contato> getContatos() {
        String sql = "select email, nome, cpf_cnpj from tb_contato"; // Inclui a coluna "cpf_cnpj" na consulta SQL

        return db.query(sql, (res, rowNum) -> {
            return new Contato(
                res.getString("nome"),
                res.getString("email"),
                res.getString("cpf_cnpj")
            );
        }); 
    }

    public List<Contato> getContatos(String nome) {
        String sql = "select email, nome, cpf_cnpj from tb_contato where lower(nome) like ?"; // Inclui a coluna "cpf_cnpj" na consulta SQL

        return db.query(sql,
                        new BeanPropertyRowMapper<>(Contato.class),
                        new Object[]{"%" + nome + "%"});
    }

    public Contato getContato(String email) {
        String sql = "select email, nome, cpf_cnpj from tb_contato where email = ?"; // Inclui a coluna "cpf_cnpj" na consulta SQL

        List<Contato> contatos = db.query(sql,
                        new BeanPropertyRowMapper<>(Contato.class),
                        new Object[]{email});
        if (contatos != null && contatos.size() > 0) {
            return contatos.get(0);
        } else {
            return null;
        }
    }

    public void inserirContato(Contato contato) {
        String sql = "insert into tb_contato(email, nome, cpf_cnpj) values(?,?,?)"; // Inclui a coluna "cpf_cnpj" na instrução SQL

        db.update(sql, new Object[]{contato.getEmail(), contato.getNome(), contato.getCpf_cnpj()});
    }

    public void updateContato(Contato contato) {
        String sql = "update tb_contato set nome = ?, cpf_cnpj = ? where email = ?"; // Inclui a coluna "cpf_cnpj" na instrução SQL

        db.update(sql, new Object[]{contato.getNome(), contato.getCpf_cnpj(), contato.getEmail()});
    }

    public void deleteContato(String email) {
        String sql = "delete from tb_contato where email = ?";

        db.update(sql, new Object[]{email});
    }
}
