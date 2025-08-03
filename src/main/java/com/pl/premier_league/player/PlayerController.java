package com.pl.premier_league.player;

import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.data.domain.Pageable;
import java.util.List;

@RestController

@RequestMapping(path = "api/")
public class PlayerController {

    private final PlayerService playerService;

    public PlayerController(PlayerService playerService) {
        this.playerService = playerService;
    }

    @GetMapping
    public List<Player> getPlayers(
            @RequestParam(required = false) String team,
            @RequestParam(required = false) String name,
            @RequestParam(required = false) String pos,
            @RequestParam(required = false) String nation
    ){
        if(team!=null && pos!=null){
            return playerService.getPlayersByTeamAndPos(team,pos);
        }
        else if(team!=null){
            return playerService.getPlayersFromTeam(team);
        }
        else if(name!=null){
            return playerService.getPlayersByName(name);
        }
        else if(pos!=null){
            return playerService.getPlayersByPos(pos);
        }
        else if(nation!=null){
            return playerService.getPlayersByNation(nation);
        }
        else{
            return playerService.getPlayers();
        }
    }

    @PostMapping
    public ResponseEntity<Player> addPlayer(@RequestBody Player player){
        Player newPlayer=playerService.savePlayer(player);
        return new ResponseEntity<>(newPlayer, HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity<Player> updatePlayer(@RequestBody Player player){
        Player resultPlayer=playerService.updatePlayer(player);
        if(resultPlayer==null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(resultPlayer,HttpStatus.OK);
    }

    @DeleteMapping("/{playername}")
    public ResponseEntity<String> deletePlayer(@PathVariable String playername){
        playerService.Delete(playername);
        return new ResponseEntity<>("DELETED SUCCESSFULLY",HttpStatus
                .OK);

    }


    @GetMapping("/players")
    public Page<Player> getPlayersById(@RequestParam int page, @RequestParam int size){
        Pageable pageable= PageRequest.of(page,size);
        return playerService.findAllPlayerByPage(pageable);
    }

    @PostMapping("/upload")
    public List<Player> uploadPlayers(@RequestBody List<Player> players) {
        return playerService.saveAllPlayers(players);
    }

}
