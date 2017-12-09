package sam.dungeon.com.dmscreen.singleton;


public final class IdGenerator {

    private static IdGenerator generator;
    private static Integer lastGeneratedId=1;

    public static IdGenerator getIdGeneratorInstance(){
        if (generator==null){
            generator= new IdGenerator();
        }
        return generator;
    }

    public static Integer getNewId(){
        return getIdGeneratorInstance().generateNewId();
    }

    private Integer generateNewId(){
        return lastGeneratedId++;
    }

}
