package Generators;

import java.util.Random;
import java.util.ArrayList;

public class GeneratorTresor {

    private ArrayList<Integer> Num;
    private int etage;
    public GeneratorTresor()
    {
        Num = new ArrayList<Integer>();
        for(int i=0; i<4; i++)
        {
            Num.add(i);
        }
    }

    public void printList()
    {
        for(int i : Num)
        {
            System.out.println(i);
        }
    }

    public int tirage(int etage)
    {
        Random randomGenerator = new Random();
        int choixTresor = randomGenerator.nextInt(4);
        return(choixTresor);
    }

}
