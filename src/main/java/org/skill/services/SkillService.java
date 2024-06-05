package org.skill.services;

import org.skill.models.Skill;
import org.skill.models.User;
import org.skill.models.UserSkill;
import org.skill.repositories.SkillRepository;
import org.skill.repositories.UserSkillRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SkillService {
    @Autowired
    private SkillRepository skillRepository;

    @Autowired
    private UserSkillRepository userSkillRepository;

    public Skill createSkill(String name) {
        Skill skill = new Skill();
        skill.setName(name);
        return skillRepository.save(skill);
    }

    public List<UserSkill> getUserSkills(Long userId) {
        return userSkillRepository.findByUserId(userId);
    }

    public UserSkill associateSkill(User user, Skill skill, Integer level) {
        UserSkill userSkill = new UserSkill();
        userSkill.setUser(user);
        userSkill.setSkill(skill);
        userSkill.setLevel(level);
        return userSkillRepository.save(userSkill);
    }

    public Skill updateSkill(Long userId, Long skillId, Skill updatedSkill) {

        Skill existingSkill = skillRepository.findByIdAndUserId(skillId, userId);
        if (existingSkill != null) {
            existingSkill.setName(updatedSkill.getName());
            return skillRepository.save(existingSkill);
        }
        return null;
    }

    public SkillService(SkillRepository skillRepository) {
        this.skillRepository = skillRepository;
    }

    public List<Skill> getSkillsByUserId(Long userId) {
        return skillRepository.findByUserId(userId);
    }

    public Skill addSkill(Long userId, Skill skill) {

        skill.setUserId(userId);


        return skillRepository.save(skill);
    }

    public void deleteSkill(Long userId, Long skillId) {

        UserSkill userSkill = userSkillRepository.findByUserIdAndSkillId(userId, skillId);
        if (userSkill != null) {
            userSkillRepository.delete(userSkill);
        } else {

        }
    }
}
