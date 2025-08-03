package com.pl.premier_league.player;

import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service

public class PlayerService
{
    private final PlayerRepository playerRepository;

    public PlayerService(PlayerRepository playerRepository) {
        this.playerRepository = playerRepository;
    }


    public List<Player> getPlayers(){
        return playerRepository.findAll();
    }

    public List<Player> getPlayersFromTeam(String teamName){
        return  playerRepository.findAll().stream().filter(player->teamName.equals(player.getTeam()))
                .collect(Collectors.toList());
    }
    public List<Player> getPlayersByName(String search){
        return playerRepository.findAll().stream().filter(player -> player.getName().toLowerCase().contains(search.toLowerCase()))
                .collect(Collectors.toList());
    }
    public List<Player> getPlayersByPos(String search){
        return playerRepository.findAll().stream().filter(player -> player.getPosition().toLowerCase().contains(search.toLowerCase()))
                .collect(Collectors.toList());
    }

    public List<Player> getPlayersByNation(String search){
        return playerRepository.findAll().stream().filter(player -> player.getNation().toLowerCase()
                .contains(search.toLowerCase())).collect(Collectors.toList());
    }

    public List<Player> getPlayersByTeamAndPos(String team,String pos){
        return playerRepository.findAll().stream().filter(player->player.getTeam().toLowerCase().contains(team) &&
                player.getPosition().toLowerCase().contains(pos.toLowerCase())).collect(Collectors.toList());
    }

    public Player savePlayer(Player player){
        return playerRepository.save(player);
    }

    public Player updatePlayer(Player player){
        Optional<Player> existingPlayer=playerRepository.findByName(player.getName());
        if(existingPlayer.isPresent()){
            Player playerToUpdate=existingPlayer.get();
            playerToUpdate.setName(player.getName());
            playerToUpdate.setTeam(player.getTeam());
            playerToUpdate.setPosition(player.getPosition());
            playerToUpdate.setPosition(player.getPosition());
            playerRepository.save(playerToUpdate);
            return playerToUpdate;
        }
        return null;
    }

    @Transactional
    public void Delete(String name){
        playerRepository.deleteByName(name);
    }


    public Page<Player> findAllPlayerByPage(Pageable pageable) {
        return playerRepository.findAll(pageable);
    }

    public List<Player> saveAllPlayers(List<Player> players) {
        return playerRepository.saveAll(players);
    }
}
