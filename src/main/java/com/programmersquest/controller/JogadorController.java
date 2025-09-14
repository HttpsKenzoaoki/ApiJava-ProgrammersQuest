package com.programmersquest.controller;
import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.programmersquest.model.Jogador;
import com.programmersquest.repository.JogadorRepository;

@RestController
@RequestMapping("/jogador")
public class JogadorController { 
    private final JogadorRepository repository;

    public JogadorController(JogadorRepository repository) {
        this.repository = repository;
    }

    @PostMapping
    public Jogador criar(@RequestBody Jogador jogador) {
        return repository.save(jogador);
    }

    @GetMapping
    public List<Jogador> Listar() {
        return repository.findAll();
    }

    @GetMapping("/{id}")
    public Jogador buscar(@PathVariable Long id) {
        return repository.findById(id).orElse(null);
    }

    @PutMapping("/{id}")
    public Jogador atualizar(@PathVariable Long id, @RequestBody Jogador novoJogador) {
        return repository.findById(id).map(jogador -> {
            jogador.setNome(novoJogador.getNome());
            jogador.setEmail(novoJogador.getEmail());
            jogador.setSenha(novoJogador.getSenha());
            return repository.save(jogador);
        }).orElse(null);
    }

    @DeleteMapping("/{id}")
    public void excluir(@PathVariable Long id) {
        repository.deleteById(id);
    }
}

