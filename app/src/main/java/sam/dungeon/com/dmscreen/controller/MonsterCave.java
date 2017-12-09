package sam.dungeon.com.dmscreen.controller;


import java.util.ArrayList;
import java.util.List;

import sam.dungeon.com.dmscreen.model.Monster;

public class MonsterCave {

    private List<Monster> activeMonsters;
    private List<Monster> reserveMonsters;
    private List<Monster> deadMonsters;

    private static MonsterCave instance;

    private MonsterCave(List<Monster> reserveMonsters){
        this.activeMonsters=new ArrayList<>();
        this.deadMonsters= new ArrayList<>();
        if (reserveMonsters!=null || !reserveMonsters.isEmpty()){
            this.reserveMonsters=reserveMonsters;
        }else {
            this.reserveMonsters= new ArrayList<>();
        }
    }

    public static MonsterCave getInstance(List<Monster> reserveMonsters){
        if (instance == null) {
            instance=new MonsterCave(reserveMonsters);
        }
        return instance;
    }


}
