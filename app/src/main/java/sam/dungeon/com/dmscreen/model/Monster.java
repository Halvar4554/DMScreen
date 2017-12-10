package sam.dungeon.com.dmscreen.model;

import android.support.annotation.NonNull;

public class Monster implements Comparable<Monster> {

    private Integer id;
    private Integer initiative;
    private String name;
    private Integer lives;
    private Integer defense;
    private String attack;
    private String  skills;

    public Monster(Integer id){
        this.id=id;
    }

    public Monster(Integer id, Integer initiative, String name){
        this.id=id;
        this.initiative=initiative;
        this.name=name;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getInitiative() {
        return initiative;
    }

    public void setInitiative(Integer initiative) {
        this.initiative = initiative;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getLives() {
        return lives;
    }

    public void setLives(Integer lives) {
        this.lives = lives;
    }

    public Integer getDefense() {
        return defense;
    }

    public void setDefense(Integer defense) {
        this.defense = defense;
    }

    public String getAttack() {
        return attack;
    }

    public void setAttack(String attack) {
        this.attack = attack;
    }

    public String getSkills() {
        return skills;
    }

    public void setSkills(String skills) {
        this.skills = skills;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Monster monster = (Monster) o;

        return getId().equals(monster.getId());
    }

    @Override
    public int hashCode() {
        return getId().hashCode();
    }

    @Override
    public int compareTo(Monster other) {
        if (this.initiative<other.getInitiative()){
            return -1;
        }else if (this.initiative==other.getInitiative()){
            return 0;
        }else{
            return 1;
        }
    }
}
