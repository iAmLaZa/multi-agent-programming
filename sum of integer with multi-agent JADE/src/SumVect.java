package EXO6;

import jade.core.AID;
import jade.core.behaviours.Behaviour;
import jade.lang.acl.ACLMessage;

import java.io.IOException;
import java.io.Serializable;
import java.util.Arrays;
import java.util.List;

public class SumVect extends Behaviour {
    List<Integer> ints = Arrays.asList(1, 2, 3, 4, 5);
    ACLMessage pairsum =null;
    ACLMessage impairsum =null;
    @Override
    public void action() {
        ACLMessage pair=new ACLMessage(ACLMessage.INFORM);
        ACLMessage impair=new ACLMessage(ACLMessage.INFORM);

        pair.addReceiver(new AID("Pair",AID.ISLOCALNAME));
        impair.addReceiver(new AID("Impair",AID.ISLOCALNAME));

        try {
            pair.setContentObject((Serializable) ints);
            myAgent.send(pair);
            impair.setContentObject((Serializable) ints);
            myAgent.send(impair);
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        pairsum=myAgent.blockingReceive();
        impairsum=myAgent.blockingReceive();
        if (pairsum!=null && impairsum!=null){
            int intpair= Integer.parseInt(pairsum.getContent());
            int intimpair= Integer.parseInt(impairsum.getContent());
            System.out.println("sum of pair numbers in our array is =" + intpair);
            System.out.println("sum of impair numbers in our array is =" + intimpair);
            System.out.println("sum = " + (intimpair + intpair));
        }


    }

    @Override
    public boolean done() {
        return (pairsum!=null && impairsum!=null);
    }
}
