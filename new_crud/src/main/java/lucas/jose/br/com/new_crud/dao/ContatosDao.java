package lucas.jose.br.com.new_crud.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

@Component
public class ContatosDao {
    @Autowired
    JdbcTemplate db;
    
    public List<Contato> getContato(){
        String sql = "select email, nome from tb_contato";
    }
}
