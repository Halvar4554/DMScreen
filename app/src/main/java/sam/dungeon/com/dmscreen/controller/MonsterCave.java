package sam.dungeon.com.dmscreen.controller;


import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import sam.dungeon.com.dmscreen.comparers.InitiativeComparator;
import sam.dungeon.com.dmscreen.model.Monster;

public class MonsterCave {

    private List<Monster> activeMonsters;
    private List<Monster> reserveMonsters;
    private List<Monster> deadMonsters;

    private InitiativeComparator initiativeComparator;

    private static MonsterCave instance;

    private MonsterCave(List<Monster> reserveMonsters){
        this.activeMonsters=new ArrayList<>();
        this.deadMonsters= new ArrayList<>();
        this.initiativeComparator=new InitiativeComparator();
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

    public void addMonsterToReserve(Monster newMonster){
        this.reserveMonsters.add(newMonster);
    }

    public void addActiveMonster(Monster monster){
        this.activeMonsters.add(monster);
        Collections.sort(this.activeMonsters,this.initiativeComparator);
    }

    public Monster findMonsterById(Integer id){
        Monster result=findMonsterInListById(id,this.activeMonsters);
        if (result==null){
            result=findMonsterInListById(id,this.reserveMonsters);
        }
        if (result==null){
            result=findMonsterInListById(id,deadMonsters);
        }
        return result;
    }

    public void killMonster(Integer id){
        Monster deadMonster=findMonsterInListById(id,this.activeMonsters);
        if (deadMonster!=null){
            this.deadMonsters.add(deadMonster);
            this.activeMonsters.remove(findMonsterIndex(id,this.activeMonsters));
        }
    }

    public Integer getCountOfMonsters(){
        return this.activeMonsters.size();
    }

    private Monster findMonsterInListById(Integer id, List<Monster> listToSearch){
        int index=findMonsterIndex(id,listToSearch);
        return  listToSearch.get(index);
    }

    private int findMonsterIndex(Integer id, List<Monster> listToSearch){
        Monster key= new Monster(id);
        return Collections.binarySearch(listToSearch,key);
    }

}
