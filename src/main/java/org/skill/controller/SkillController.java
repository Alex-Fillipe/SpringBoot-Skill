package org.skill.controller;

import org.skill.models.Skill;
import org.skill.services.SkillService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/skills")
public class SkillController {

    @Autowired
    private SkillService skillService;

    @GetMapping("/{userId}")
    public ResponseEntity<List<Skill>> getSkillsByUserId(@PathVariable Long userId) {
        List<Skill> skills = skillService.getSkillsByUserId(userId);
        return ResponseEntity.ok(skills);
    }

    @PostMapping("/{userId}")
    public ResponseEntity<Skill> addSkill(@PathVariable Long userId, @RequestBody Skill skill) {
        Skill createdSkill = skillService.addSkill(userId, skill);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdSkill);
    }

    @PutMapping("/{userId}/{skillId}")
    public ResponseEntity<Skill> updateSkill(@PathVariable Long userId, @PathVariable Long skillId, @RequestBody Skill skill) {
        Skill updatedSkill = skillService.updateSkill(userId, skillId, skill);
        return ResponseEntity.ok(updatedSkill);
    }

    @DeleteMapping("/{userId}/{skillId}")
    public ResponseEntity<?> deleteSkill(@PathVariable Long userId, @PathVariable Long skillId) {
        skillService.deleteSkill(userId, skillId);
        return ResponseEntity.noContent().build();
    }
}
