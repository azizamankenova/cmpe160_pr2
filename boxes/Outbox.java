
//DO_NOT_EDIT_ANYTHING_ABOVE_THIS_LINE


package boxes;

import java.util.*;
import elements.*;

/**
 * Represents an Outbox, the child of the Box, in the basic messaging program.
 * @author Aziza
 *
 */
public class Outbox extends Box{
	
	/**
	 * collection of messages sent by the user in the outbox
	 */
	private Queue<Message> sent;
	
	/**
	 * Constructs an outbox of the user, given in the parameter.
	 * Instantiates the sent queue.
	 * @param owner the owner of the outbox
	 */
	public Outbox(User owner) {
		super(owner);
		sent = new LinkedList<Message>();
		
	}

	
	/**
	 * Gets the messages sent by the user
	 * @return the sent the sent messages
	 */
	public Queue<Message> getSent() {
		return sent;
	}
	
}




//DO_NOT_EDIT_ANYTHING_BELOW_THIS_LINE

