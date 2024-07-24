package dev.costa.tassio.cartasidl.model.repository;

import dev.costa.tassio.cartasidl.model.entities.Week;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WeekRepository extends JpaRepository<Week, Long> {
}
