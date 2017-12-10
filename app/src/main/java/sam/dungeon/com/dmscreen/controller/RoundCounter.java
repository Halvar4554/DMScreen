package sam.dungeon.com.dmscreen.controller;

public class RoundCounter {

    private Integer round;
    private Integer actualCombatant;

    private RoundCounter(Integer firstRound,Integer actualCombatant){
        this.round=firstRound;
        this.actualCombatant=actualCombatant;
    }


}
