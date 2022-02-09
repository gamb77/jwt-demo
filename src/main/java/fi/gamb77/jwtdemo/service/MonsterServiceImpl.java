package fi.gamb77.jwtdemo.service;

import fi.gamb77.jwtdemo.dto.MonsterDTO;
import fi.gamb77.jwtdemo.repository.MonsterRepository;
import fi.gamb77.jwtdemo.util.MonsterMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class MonsterServiceImpl implements MonsterService {

    @Autowired
    private MonsterRepository monsterRepository;

    @Override
    public List<MonsterDTO> getAllMonsters() {
        return monsterRepository.findAll().
                stream().map(MonsterMapper::entityToDTO).collect(Collectors.toList());
    }

    @Override
    public MonsterDTO getMonster(Long id) {
        return MonsterMapper.entityToDTO(monsterRepository.getById(id));
    }

    @Override
    public Long saveMonster(MonsterDTO monsterDTO) {
        return monsterRepository.save(MonsterMapper.dtoToEntity(monsterDTO)).getId();
    }

    @Override
    public void deleteMonster(Long id) {
        monsterRepository.delete(monsterRepository.getById(id));
    }
}
