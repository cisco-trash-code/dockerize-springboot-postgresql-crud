package com.cisco.api;

import com.cisco.model.Player;
import com.cisco.repository.PlayerRepo;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/players")
@RequiredArgsConstructor
public class PlayerAPI {

    private final PlayerRepo repo;
    private static final Logger log = LoggerFactory.getLogger(PlayerAPI.class);

    @GetMapping("/{id}")
    public Player getPlayer(@PathVariable(value = "id") String id) {
        log.info("Get player with id {}", id);
        return repo.findById(id).get();
    }

    @GetMapping
    public List<Player> getAllPlayers() {
        log.info("Get all players");
        return repo.findAll();
    }

    @PostMapping
    public Player createPlayer(@RequestBody Player player) {
        log.info("Create player with name {}", player.getName());
        return repo.save(player);
    }

    @PutMapping
    public Player updatePlayer(@RequestBody Player player) {
        log.info("Update player with name {}", player.getName());
        return repo.save(player);
    }

    @DeleteMapping("/{id}")
    public void deletePlayer(@PathVariable(value = "id") String id) {
        repo.deleteById(id);
    }
}
