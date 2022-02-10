package fi.gamb77.jwtdemo.controller;

import fi.gamb77.jwtdemo.dto.MonsterDTO;
import fi.gamb77.jwtdemo.service.MonsterService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;

@RestController
@Api(tags = "monsters")
@RequestMapping(value = "/api")
@Validated
public class MonsterController {

    @Autowired
    private MonsterService monsterService;


    @GetMapping(value = "/monsters")
    List getAll() {
        return monsterService.getAllMonsters();
    }

    @PreAuthorize("hasAnyRole('ADMIN','MANAGER')")
    @GetMapping(value = "/monster/{id}")
    ResponseEntity<MonsterDTO> getOne(@PathVariable("id") Long id) {
        return ResponseEntity.ok().body(monsterService.getMonster(id));
    }

    @PreAuthorize("hasAnyRole('ADMIN','MANAGER')")
    @PostMapping(value = "/monster")
    ResponseEntity<?> createMonster(@Valid @RequestBody MonsterDTO monsterDTO) {
        URI monsterUri = ServletUriComponentsBuilder.
                fromCurrentRequest().
                path("/{id}").
                buildAndExpand(monsterService.saveMonster(monsterDTO))
                .toUri();
        return ResponseEntity.created(monsterUri).build();
    }

    @PreAuthorize("hasAuthority('ROLE_MANAGER')")
    @DeleteMapping(value = "/monster/{id}")
    ResponseEntity<String> removeMonster(@PathVariable("id") Long id) {
        monsterService.deleteMonster(id);
        return ResponseEntity.ok().body("Monster removed successfully!");
    }

}
