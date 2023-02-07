package EXO6;

import jade.core.AID;
import jade.core.behaviours.Behaviour;
import jade.lang.acl.ACLMessage;
import jade.lang.acl.UnreadableException;


import java.util.List;

public class Pair extends Behaviour {
    ACLMessage msg =null;
    List<Integer> ints;
    int sumpair=0;
    @Override
    public void action() {
        msg=myAgent.blockingReceive();
        if(msg!=null) {
            try {
                ints=(List<Integer>) msg.getContentObject();

                for (int i =0;i<ints.size();i++){
                    if(ints.get(i)%2==0)
                        sumpair += ints.get(i);
                }
            }
            catch (UnreadableException e1) {
                e1.printStackTrace();

            }
        }
        ACLMessage pair = new ACLMessage(ACLMessage.INFORM);
        pair.addReceiver(new AID("SumVect",AID.ISLOCALNAME));
        String r =Integer.toString(sumpair);
        pair.setContent(r);
        myAgent.send(pair);
    }

    @Override
    public boolean done() {
        return msg!=null;
    }
}
