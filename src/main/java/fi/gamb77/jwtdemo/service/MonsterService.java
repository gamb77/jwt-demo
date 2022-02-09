package fi.gamb77.jwtdemo.service;

import fi.gamb77.jwtdemo.dto.MonsterDTO;

import java.util.List;

public interface MonsterService {
    List<MonsterDTO> getAllMonsters();
    MonsterDTO getMonster(Long id);
    Long saveMonster(MonsterDTO monsterDTO);
    void deleteMonster(Long id);
}
