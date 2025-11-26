import Generators.GeneratorTresor;

public class Main_generator {

    public static void main(String[] args){
        GeneratorTresor gen;
        gen = new GeneratorTresor();
        //gen.printList();

        System.out.println(gen.tirage(1));
    }
}
