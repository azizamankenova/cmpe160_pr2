
//DO_NOT_EDIT_ANYTHING_ABOVE_THIS_LINE


package boxes;

import java.util.*;

import elements.*;

/**
 * Represents an Inbox, the child of the Box, in the basic messaging program.
 * @author Aziza
 *
 */
public class Inbox extends Box{
	/**
	 * unread messages
	 */
	private Stack<Message> unread;
	/**
	 * read messages
	 */
	private Queue<Message> read;	
	/**
	 * Constructs an Inbox of a user and instantiates unread stack and read queue.
	 * @param user the owner of the inbox
	 */
	public Inbox(User user) {
		super(user);
		unread = new Stack<Message>();
		read = new LinkedList<Message>();
	}
	/**
	 * Receives messages from the server from the users that are friends with this user. Adds 
	 * these messages to the ​unread​ stack. Changes ​timeStampReceived​ with the parameter ​time​.
	 * Changes the the previous capacity and current capacity of the server.
	 * @param server the server 
	 * @param time the time of receiving the message
	 */
	public void receiveMessages(Server server, int time) {
		Queue<Message> msgs = server.getMsgs();
		Iterator<Message> itr = msgs.iterator();
		server.setPrevSize(server.getCurrentSize());
		while(itr.hasNext()){
			Message m = itr.next();
			if(m.getReceiver().getId() == this.owner.getId() && this.owner.isFriendsWith(m.getSender())) {
				unread.push(m);
				m.setTimeStampReceived(time);
				itr.remove();;
				server.setCurrentSize(server.getCurrentSize() - m.getBody().length());
			}	
		}
	}
	/**
	 * Reads a certain amount of messages from the ​unread stack. If the ​num parameter is 0,
	 * then all messages in​ unread should be read. If the number of messages in ​unread​ is
	 * less than num, still all messages should be read. After receiving messages from
	 * the unread stack adds them to the read queue and changes the timeStampRead of these 
	 * messages.
	 * @param num number of messages to be read
	 * @param time the current time
	 * @return by how much the time has increased after this operation
	 */
	public int readMessages(int num, int time) {
		int toRead;
		if(unread.size() < num || num == 0) {
			toRead = unread.size();
		}
		else {
			toRead = num;
		}
		int numRead = 0;
		
		for(int i = 0; i < toRead; i++) {
			Message m = unread.pop(); 
			m.setTimeStampRead(time + numRead);
			numRead++;
			getRead().add(m);
		}
		
		if(numRead == 0) {
			return 1;
		}
		else {
			return numRead;
		}
		
	}
	

	/**
	 * Reads message(s) from the specified sender. Removes that message(s) from
	 * the unread stack and adds to the read queue and changes the timeStampRead
	 * @param sender the sender, from which the messages should be read
	 * @param time the current time
	 * @return by how much the time has increased after this operation
	 */
	public int readMessages(User sender, int time) {
		int numRead = 0;
		for(int i = unread.size() - 1; i >= 0; i--) {
			Message m = unread.get(i);
			if(m.getSender().getId() == sender.getId()) {
				unread.remove(i);
				m.setTimeStampRead(time + numRead);
				numRead++;
				getRead().add(m);
				

			}
		}
		if(numRead == 0) {
			return 1;
		}
		else {
			return numRead;
		}
		
	}
	
	/**
	 * Reads the message with the ID number ​msgId​, if it exists.
	 * Removes the message from the stack unread and adds to read queue
	 * and changes timeStampRead
	 * @param msgId the ID number of the message that should be read
	 * @param time the current time
	 */
	public void readMessage(int msgId, int time) {
		
		
		Iterator<Message> itr = unread.listIterator();
		while(itr.hasNext()) {
			Message m = itr.next();
			if(m.getId() == msgId) {
				itr.remove();
				m.setTimeStampRead(time);
				getRead().add(m);
				break;
			}
		}
		
		
		
	}
	/**
	 * Gets the read queue
	 * @return the read queue
	 */
	public Queue<Message> getRead() {
		return read;
	}
	
}



//DO_NOT_EDIT_ANYTHING_BELOW_THIS_LINE

