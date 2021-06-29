
//DO_NOT_EDIT_ANYTHING_ABOVE_THIS_LINE

package executable;


import java.io.*;
import java.util.*;
import elements.*;

/**
 * The main objective is to implement a basic messaging program. 
 * Program carries out the necessary actions by
 * parsing the input file composed of the sequential operations.
 * @author Aziza
 *
 */
public class Main {
	
	/**
	 * Reads an input file that is composed of sequential
	 * commands related to the messaging operations and prints the necessary 
	 * output in the separate file.
	 * @param args the names of the input and output files
	 * @throws FileNotFoundException if such file was not found
	 */
	public static void main(String[] args) throws FileNotFoundException {

		Scanner input = new Scanner(new File(args[0]));
		PrintStream output = new PrintStream(new File(args[1]));
		
		ArrayList<User> users = new ArrayList<>();
		int noOfUsers = input.nextInt();
		for(int i = 0; i < noOfUsers; i++) {
			users.add(new User(i));
		}
		
		int noOfQueries = input.nextInt();
		int capacityServer = input.nextInt();
		
		Server server = new Server(capacityServer);
		input.nextLine();
		int time = 0;
		for(int i = 0; i < noOfQueries; i++) {
			int action = input.nextInt();
			if(action == 0) {// sending a message
				int senderId = input.nextInt();
				int receiverId = input.nextInt();
				if(senderId < users.size() && receiverId < users.size()) {
					String body = input.nextLine();
					body = body.substring(1);
					User sender = users.get(senderId);
				
					sender.sendMessage(users.get(receiverId), body, time, server);
					server.checkServerLoad(output);
				}
				
				time++;
			}
			else if(action == 1) {// receiving messages
				int receiverId = input.nextInt();
				if(receiverId < users.size()) {
					User receiver = users.get(receiverId);
					receiver.getInbox().receiveMessages(server, time);
					server.checkServerLoad(output);
				}
				time++;
			}
			else if(action == 2) {// reading a certain amount of messages
				int receiverId = input.nextInt();
				if(receiverId < users.size()) {
					int numMessages = input.nextInt();
					User receiver = users.get(receiverId);
					time += receiver.getInbox().readMessages(numMessages, time);
				}
				else {
					time++;
				}
			}
			else if(action == 21) {// reading all the messages from a sender
				int receiverId = input.nextInt();
				int senderId = input.nextInt();
				if(senderId < users.size() && receiverId < users.size()) {
					User receiver = users.get(receiverId);
					time += receiver.getInbox().readMessages(users.get(senderId), time);
				}
				else {
					time++;
				}
			}
			else if(action == 22) {//22: reading a specific message of some ID
				int receiverId = input.nextInt();
				if(receiverId < users.size()) {
					int msgId = input.nextInt();
					User receiver = users.get(receiverId);
					receiver.getInbox().readMessage(msgId, time);
				}
				time++;
			}
			else if(action == 3) { // adds a friend to the friends list, also adding the user to the other user’s friends list. 
				int id1 = input.nextInt();
				int id2 = input.nextInt();
				if(id1 < users.size() && id2 < users.size()) {
					User user1 = users.get(id1);
					User user2 = users.get(id2);
					if(!user1.isFriendsWith(user2) && !user2.isFriendsWith(user1)) {
						user1.getFriends().add(user2);
						user2.getFriends().add(user1);
					}
				}
				time++;
			}
			else if(action == 4) {// Removes a friend from the friends lists. 
				int id1 = input.nextInt();
				int id2 = input.nextInt();
				if(id1 < users.size() && id2 < users.size()) {
					User user1 = users.get(id1);
					User user2 = users.get(id2);
					if(user1.getFriends().contains(user2) && user2.getFriends().contains(user1)) {
						user1.getFriends().remove(user2);            
						user2.getFriends().remove(user1);
					}
				}
				time++;
			}
			
			else if(action == 5) {// Deletes all messages from the server 
				server.flush();
				time++;
			}
			
			else if(action == 6) {//Prints the current load of the server
				output.println("Current load of the server is " + server.getCurrentSize() + " characters.");
				time++;
			}
			
			else if(action == 61) {// prints the last message a user has read 
				int id = input.nextInt();
				if(id < users.size()){
					User user = users.get(id);
					Iterator<Message> itr = user.getInbox().getRead().iterator();
					Message m = null;
					while(itr.hasNext()) {
						m = itr.next();
					}
					if(m != null) {
						output.println(m.toString());
					}
				}
				time++;
			}
		}
		
		input.close();

	}
	
}




//DO_NOT_EDIT_ANYTHING_BELOW_THIS_LINE

