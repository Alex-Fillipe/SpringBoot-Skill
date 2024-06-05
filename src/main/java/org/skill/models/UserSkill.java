package org.skill.models;
import jakarta.persistence.*;
@Entity
public class UserSkill {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "user_skill_sequence")
    @SequenceGenerator(name = "user_skill_sequence", sequenceName = "user_skill_sequence", allocationSize = 1)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne
    @JoinColumn(name = "skill_id")
    private Skill skill;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public Skill getSkill() {
        return skill;
    }

    public void setSkill(Skill skill) {
        this.skill = skill;
    }

    public Integer getLevel() {
        return level;
    }

    public void setLevel(Integer level) {
        this.level = level;
    }

    private Integer level;

    public void setUser(User user) {
    }
}
