
//DO_NOT_EDIT_ANYTHING_ABOVE_THIS_LINE

package elements;

/**
 * Represents a message in the basic messaging program
 * @author Aziza 
 *
 */
public class Message implements Comparable<Message>{

	/**
	 * the number of total messages in the program that is used for assigning the IDs
	 */
	private static int numOfMessages = 0;
	/**
	 * the ID of the message
	 */
	private int id;
	/**
	 * the text of the message
	 */
	private String body;
	/**
	 * the sender of the message
	 */
	private User sender;
	/**
	 * the receiver of the message
	 */
	private User receiver;
	/**
	 * the time when the message is sent 
	 */
	private int timeStampSent;
	/**
	 * the time when the message is read
	 */
	private int timeStampRead;
	/**
	 * the time when the message is received
	 */
	private int timeStampReceived;
	
	
	/**
	 * Constructs a new Message. Assigns the ID equal to the numOfMessages and increments 
	 * the numOfMessages by one. Adds this message to the server, changing the previous
	 * size and incrementing the current size by the length of this message
	 * @param sender   the user who sends the message
	 * @param receiver the user who will receive the message
	 * @param body	   the text of the message
	 * @param server   the server
	 * @param time     the time when the message is sent
	 */
	public Message(User sender, User receiver, String body, Server server, int time){
		this.id = numOfMessages;
		numOfMessages++;
		this.sender = sender;
		this.receiver = receiver;
		this.body = body;
		this.timeStampSent = time;
		server.getMsgs().add(this);
		server.setPrevSize(server.getCurrentSize());
		server.setCurrentSize(server.getCurrentSize() + body.length());
		
	}
	/**
	 * Sets the time when the message is sent
	 * @param timeStampSent the timeStampSent to set
	 */
	public void setTimeStampSent(int timeStampSent) {
		this.timeStampSent = timeStampSent;
	}
	/**
	 * Sets the time when the message is read
	 * @param timeStampRead the timeStampRead to set
	 */
	public void setTimeStampRead(int timeStampRead) {
		this.timeStampRead = timeStampRead;
	}
	/**
	 * Sets the time when the message is received
	 * @param timeStampReceived the timeStampReceived to set
	 */
	public void setTimeStampReceived(int timeStampReceived) {
		this.timeStampReceived = timeStampReceived;
	}
	/**
	 * Gets the ID
	 * @return the id
	 */
	public int getId() {
		return id;
	}
	/**
	 * Gets the body of the message
	 * @return the body
	 */
	public String getBody() {
		return body;
	}
	
	/**
	 * Compares this message with the other message.
	 * 
	 * @param o another message
	 * @return if this message is longer than the other message, returns 1. Else if
	 * the other message is longer, returns -1. Returns 0 if both messages have 
	 * the same number of characters.
	 */
	public int compareTo(Message o) {
		if(this.getBody().length() > o.getBody().length()) {
			return 1;
		}
		else if(this.getBody().length() < o.getBody().length()) {
			return -1;
		}
		else {
			return 0;
		}	
	}
	
	
	/**
	 * Checks if two messages are equal
	 * @param o an object
	 * @return true if this message equals the other, and false otherwise
	 */
	
	public boolean equals(Object o) {
		if(o instanceof Message) {
			return ((Message) o).getId() == this.getId();
		}
		else {
			return false;
		}
	}
	
	public String toString() {
		 
		String output = "\tFrom: " + getSender().getId() + " To: " + getReceiver().getId() + "\n";
		output += "\tReceived: ";
		if(this.timeStampReceived != 0 ) {
			output += this.timeStampReceived;
		}
		else {
			output += "   ";
		}
		output += " Read: ";
		if(this.timeStampRead != 0) {
			output += this.timeStampRead;
		}
		else {
			output += "   ";
		}
		output += "\n\t" + this.body;
		 
		return output;
		 
		 
	}
	/**
	 * Gets the sender of the message 
	 * @return the sender
	 */
	public User getSender() {
		return sender;
	}
	/**
	 * Gets the receiver of the message 
	 * @return the receiver
	 */
	public User getReceiver() {
		return receiver;
	}
	
}



//DO_NOT_EDIT_ANYTHING_BELOW_THIS_LINE

