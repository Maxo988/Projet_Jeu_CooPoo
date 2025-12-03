package Generators;

import java.util.Random;
import java.util.ArrayList;

public class GeneratorTresor {

    private ArrayList<Integer> Num = new ArrayList<>();
    Random randomGenerator = new Random();

    private int etage;

    public GeneratorTresor()
    {
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
        int choixTresor = randomGenerator.nextInt(100);
        System.out.println("random = "+choixTresor);

        switch(etage)
        {
            case 1: //étage 1
                if(choixTresor < 25)
                    return(0);
                else if(choixTresor < 50)
                    return(1);
                else if(choixTresor < 75)
                    return(2);
                else
                    return(3);
            case 2 : //étage 2
                if(choixTresor < 25)
                    return(0);
                else if(choixTresor < 50)
                    return(1);
                else if(choixTresor < 75)
                    return(2);
                else
                    return(3);

            case 3: //étage 3
                if(choixTresor < 25)
                    return(0);
                else if(choixTresor < 50)
                    return(1);
                else if(choixTresor < 75)
                    return(2);
                else
                    return(3);

            default :
                return(-1);
        }
    }
}
