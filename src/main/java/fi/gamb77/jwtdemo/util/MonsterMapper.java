package fi.gamb77.jwtdemo.util;

import fi.gamb77.jwtdemo.dto.MonsterDTO;
import fi.gamb77.jwtdemo.model.Monster;

public class MonsterMapper {
    public static MonsterDTO entityToDTO(Monster monster) {
        MonsterDTO monsterDTO = new MonsterDTO();
        monsterDTO.setId(monster.getId());
        monsterDTO.setName(monster.getName());
        monsterDTO.setDescription(monster.getDescription());
        return monsterDTO;
    }

    public static Monster dtoToEntity(MonsterDTO monsterDTO) {
        Monster monster = new Monster();
        monster.setName(monster.getName());
        monster.setDescription(monster.getDescription());
        return monster;
    }
}
