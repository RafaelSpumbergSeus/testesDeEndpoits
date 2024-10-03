package com.bcopstein.endpointsdemo1;

import java.util.*;
import java.util.stream.Collectors;
import org.springframework.stereotype.Repository;

@Repository
@Primary
public class AcervoJDBCImpl implements IAcervoRepository {
    private JdbcTemplate jdbcTemplate;
    
    @Autowired
    public AcervoJDBCImpl(JdbcTemplate jdbcTem){
        this.JdbcTemplate = jdbcTem;
    }

    @Override
    public List<Livro> getAll() {
        List<Livro> resp = this.jdbcTemplate.query("SELECT * from livro",
        (rs, rowNum)->
            new Livro(rs.getInt("codigo"),rs.getString("título"),rs.getString("autor"),rs.getInt("ano")));
    return resp;
    }

    @Override
    public boolean cadastraLivroNovo(Livro livro) {
        this.jdbcTemplate.update(
            "INSERT INTO livros(codigo,titulo,autor,ano) VALUES (?,?,?,?)",
            livro.codigo(),livro.titulo(),livro.autor(),livro.ano());
        return true;
    }

    @Override
    public boolean removeLivro(long codigo) {
        this.jdbcTemplate.update("DELETE FROM livros WHERE codigo = ?", codigo);
        return true;
    }

}
