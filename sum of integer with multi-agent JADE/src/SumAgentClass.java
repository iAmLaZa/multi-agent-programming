import jade.core.*;
public class SumAgentClass extends Agent {
    public void setup(){
        Object [] T = getArguments();
        String a = (String) T[0];
        String b = (String) T[1];
        int c = Integer.parseInt(a)+ Integer.parseInt(b);
        System.out.println("La somme est : "+c);
    }
}

