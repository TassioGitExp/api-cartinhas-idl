package dev.costa.tassio.cartasidl.model.repository;

import dev.costa.tassio.cartasidl.model.entities.Team;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TeamRepository extends JpaRepository<Team, String> {
}
