package fi.gamb77.jwtdemo.repository;

import fi.gamb77.jwtdemo.model.Monster;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MonsterRepository extends JpaRepository<Monster, Long> {
}
