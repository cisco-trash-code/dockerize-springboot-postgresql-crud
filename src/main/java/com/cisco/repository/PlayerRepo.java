package com.cisco.repository;

import com.cisco.model.Player;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PlayerRepo extends JpaRepository<Player, String> {
}
