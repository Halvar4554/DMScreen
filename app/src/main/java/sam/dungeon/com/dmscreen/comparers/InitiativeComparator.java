package sam.dungeon.com.dmscreen.comparers;

import java.util.Comparator;

import sam.dungeon.com.dmscreen.model.Monster;

public class InitiativeComparator implements Comparator<Monster> {
    @Override
    public int compare(Monster monster, Monster t1) {
        if (monster.getInitiative()<t1.getInitiative()){
            return -1;
        }else if (monster.getInitiative()==t1.getInitiative()){
            return 0;
        }else{
            return 1;
        }
    }
}
