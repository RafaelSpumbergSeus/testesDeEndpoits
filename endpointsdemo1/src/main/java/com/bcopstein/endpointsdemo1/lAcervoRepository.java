package com.bcopstein.endpointsdemo1;

import java.util.List;
import java.util.Set;

public interface lAcervoRepository {
    List<Livro> getAll();
    boolean cadastraLivroNovo(Livro livro);
    boolean removeLivro(int id);
}

