package EXO6;

import jade.wrapper.*;
import jade.core.*;
import jade.core.Runtime;
import jade.util.ExtendedProperties;
import jade.util.leap.Properties;


public class AgentMain extends Agent {

    @Override
    protected void setup() {

        super.setup();

        if(this.getLocalName().equals("Pair"))
            addBehaviour(new Pair());
        if(this.getLocalName().equals("Impair"))
            addBehaviour(new Impair());
        if(this.getLocalName().equals("SumVect"))
            addBehaviour(new SumVect());

    }

    public static void main(String[] args) {
        // préparer les arguments pout le conteneur JADE
        Properties prop = new ExtendedProperties();

        // demander la fenêtre de contrôle
        prop.setProperty(Profile.GUI, "true");

        // nommer les agents
        prop.setProperty(Profile.AGENTS,"Pair:EXO6.AgentMain;Impair:EXO6.AgentMain;SumVect:EXO6.AgentMain");

        // créer le profile pour le conteneur principal
        ProfileImpl profMain = new ProfileImpl((jade.util.leap.Properties)prop);

        // lancer le conteneur principal
        jade.core.Runtime rt = jade.core.Runtime.instance();

        rt.createMainContainer(profMain);


    }

}

