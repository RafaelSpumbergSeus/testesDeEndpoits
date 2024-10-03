package com.bcopstein.endpointsdemo1;

import org.springframework.web.bind.annotation.*;
import java.util.*;

@RestController
@RequestMapping("/biblioteca")
public class DemoController {

    private Acervo acervo;

    public DemoController() {
        this.acervo = new Acervo();
    }

    @GetMapping("/")
    @CrossOrigin(origins = "*")
    public String mensagemInicial() {
        return "Bem vindo a biblioteca central!";
    }

    @GetMapping("/livros")
    @CrossOrigin(origins = "*")
    public List<Livro> getLivros() {
        return acervo.getAll();
    }
    
    @GetMapping("/titulos")
    @CrossOrigin(origins = "*")
    public List<String> getTitulos() {
        return acervo.getTitulos();
    }

    @GetMapping("/autores")
    @CrossOrigin(origins = "*")
    public Set<String> getAutores() {
        return acervo.getAutores();
    }

    @PostMapping("/novoLivro")
    @CrossOrigin(origins = "*")
    public boolean cadastraLivroNovo(@RequestBody final Livro livro) {
        return acervo.cadastraLivroNovo(livro);
    }

    @GetMapping("/LivrosPorAno")
    @CrossOrigin(origins = "*")
    public List<Livro> getLivrosPorAno(@RequestParam(value = "ano") int ano) {
        return acervo.getLivrosPorAno(ano);
    }

    @GetMapping("/Desatualizados/{ano}")
    @CrossOrigin(origins = "*")
    public List<Livro> getLivrosDesatualizados(@PathVariable(value = "ano") int ano) {
        return acervo.getLivrosDesatualizados(ano);
    }

    @GetMapping("/LivrosPorAutorEAno")
    @CrossOrigin(origins = "*")
    public List<Livro> getLivrosPorAutorEAno(@RequestParam(value = "autor") String autor,
                                             @RequestParam(value = "ano") int ano) {
        return acervo.getLivrosPorAutorEAno(autor, ano);
    }

    @PostMapping("/atualizarLivro")
    @CrossOrigin(origins = "*")
    public boolean atualizarLivro(@RequestBody final Livro livroAtualizado) {
        return acervo.atualizarLivro(livroAtualizado);
    }
}
