package com.pl.premier_league.player;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface PlayerRepository extends JpaRepository<Player,String> {

    void deleteByName(String playerName);
    Optional<Player> findByName(String Name);


}
