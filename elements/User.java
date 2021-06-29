
//DO_NOT_EDIT_ANYTHING_ABOVE_THIS_LINE


package elements;
import java.util.ArrayList;

import boxes.*;

/**
 * Represents a user in the basic messaging program.
 * @author Aziza
 *
 */
public class User{
	/**
	 * user's ID
	 */
	private int id;
	/**
	 * user's inbox
	 */
	private Inbox inbox;
	/**
	 * user's outbox
	 */
	private Outbox outbox;
	/**
	 * user's list of friends
	 */
	private ArrayList<User> friends;
	/**
	 * Creates a new user with the specified ID
	 * @param id the ID of this user
	 */
	public User(int id) {
		this.id = id;
		setFriends(new ArrayList<User>());
		inbox = new Inbox(this);
		outbox = new Outbox(this);
	}
	/**
	 *  a method for adding a friend to the friends list. It 
	 *  also adds the user to the other user’s friends list. 
	 * @param other another user
	 */
	public void addFriend(User other) {
		friends.add(other);
		other.getFriends().add(this);
	}
	
	
	/**
	 * A method for removing a friend from the friends list. It 
	 * also removes the user from the other user’s friends list
	 * @param other another user
	 */
	public void removeFriend(User other) {
		friends.remove(other);
		other.getFriends().remove(other);
	}
	
	
	/**
	 * Checks if the user and the other user are friends
	 * @param other another user
	 * @return true if the user and the other user are friends, false otherwise.
	 */
	public boolean isFriendsWith(User other) {
		return this.getFriends().contains(other) ;
	}
	

	/**
	 * This user sends message to the receiver. A new message
	 * is created and added to the user’s sent list which is in his/her outbox. 
	 * @param receiver the receiver user
	 * @param body     the body of the message
	 * @param time     the time the message is sent
	 * @param server   the server
	 */
	public void sendMessage(User receiver, String body, int time, Server server) {
		Message newM = new Message(this, receiver, body, server, time);
		this.getOutbox().getSent().add(newM);
	
	}
	
	/**
	 * Gets the ArrayList of friends of this user
	 * @return the friends 
	 */
	public ArrayList<User> getFriends() {
		return friends;
	}
	/**
	 * Sets the friends ArrayList
	 * @param friends the friends to set
	 */
	public void setFriends(ArrayList<User> friends) {
		this.friends = friends;
	}
	/**
	 * Gets the ID of the user
	 * @return the id
	 */
	public int getId() {
		return id;
	}
	/**
	 * Gets the inbox of the user
	 * @return the inbox
	 */
	public Inbox getInbox() {
		return inbox;
	}
	/**
	 * Gets the outbox of the user
	 * @return the outbox
	 */
	public Outbox getOutbox() {
		return outbox;
	}

}


//DO_NOT_EDIT_ANYTHING_BELOW_THIS_LINE

