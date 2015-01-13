package eis.examples.acconnector2009;

import java.util.LinkedList;

import eis.AgentListener;
import eis.EnvironmentListener;

import eis.EnvironmentInterfaceStandard;
import eis.exceptions.ActException;
import eis.exceptions.AgentException;
import eis.exceptions.NoEnvironmentException;
import eis.exceptions.RelationException;
import eis.iilang.Action;
import eis.iilang.Percept;
import eis.iilang.Identifier;
import eis.iilang.Numeral;
import eis.iilang.EnvironmentEvent;

public class Main implements AgentListener,EnvironmentListener {

	/**
	 * @param args not used
	 */
	public static void main(String[] args) {
		
		new Main();
		
	}

	
	/**
	 * Instantiates the class.
	 */
	public Main() {

		EnvironmentInterfaceStandard ei = new EnvironmentInterface();

		ei.attachEnvironmentListener(this);
		
		// constants
		String server = "agentcontest1.in.tu-clausthal.de";
		int port = 12300;
		
		// registering and associating agents
		try {

			ei.registerAgent("agent1");
			ei.associateEntity("agent1", "connector1");
			ei.registerAgent("agent2");
			ei.associateEntity("agent2", "connector2");
			ei.registerAgent("agent3");
			ei.associateEntity("agent3", "connector3");
			ei.registerAgent("agent4");
			ei.associateEntity("agent4", "connector4");
			ei.registerAgent("agent5");
			ei.associateEntity("agent5", "connector5");
			ei.registerAgent("agent6");
			ei.associateEntity("agent6", "connector6");
			ei.registerAgent("agent7");
			ei.associateEntity("agent7", "connector7");
			ei.registerAgent("agent8");
			ei.associateEntity("agent8", "connector8");
			ei.registerAgent("agent9");
			ei.associateEntity("agent9", "connector9");
			ei.registerAgent("agent10");
			ei.associateEntity("agent10", "connector10");

		} catch (AgentException e) {

			e.printStackTrace();
			System.exit(0);
		
		} catch (RelationException e) {

			e.printStackTrace();
			System.exit(0);
		
		}
	
		LinkedList<Percept> ar = null;
		try {

			Action action = new Action(
					"connect", 
					new Identifier(server), 
					new Numeral(port),
					new Identifier("team0TUCBotagent1"),
					new Identifier("13ER21CH")
			);
			
			System.out.println("Action " + action);
			
			ar = (LinkedList) ei.performAction("agent1", action);
			
			System.out.println("Action-result:\n" + ar.toString());
		
			while( true ) {

				System.out.println("Action " + action);

				action = new Action(
						"move",
						new Identifier("north")
						);
				
				ar = (LinkedList) ei.performAction("agent1", action);

				System.out.println("Action-result:\n" + ar.toString());

			}
			
		} catch (ActException e) {

			e.printStackTrace();
			System.exit(0);
		
		} catch (NoEnvironmentException e) {

			e.printStackTrace();
			System.exit(0);

		}
	
	}

	@Override
	public void handlePercept(String agent, Percept event) {

		System.out.println("Event for agent " + agent + " " + event.toXML() );
		
	}

	@Override
	public void handleDeletedEntity(String entity) {
		
	}

	@Override
	public void handleEnvironmentEvent(EnvironmentEvent event) {
		
	}

	@Override
	public void handleFreeEntity(String entity) {
		
	}

	@Override
	public void handleNewEntity(String entity) {
		
	}

}
