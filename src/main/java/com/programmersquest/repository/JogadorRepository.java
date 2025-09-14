package com.programmersquest.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.programmersquest.model.Jogador;

@Repository
public interface JogadorRepository extends JpaRepository<Jogador, Long> {
    List<Jogador> findByNome(String nome);
    List<Jogador> findByNomeContaining(String parteDoNome);
}