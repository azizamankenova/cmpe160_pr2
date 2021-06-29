
//DO_NOT_EDIT_ANYTHING_ABOVE_THIS_LINE


package elements;

import java.io.PrintStream;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Represents the server in the basic messaging program.
 * @author Aziza
 *
 */
public class Server {

	/**
	 * the capacity of the server 
	 */
	private long capacity;
	/**
	 * the current size of the server 
	 */
	private long currentSize;
	/**
	 * the Queue of the message in the server
	 */
	private Queue<Message> msgs;
	/**
	 * the previous capacity of the sever
	 */
	private long prevSize;

	/**
	 * Constructs a server with the given capacity
	 * @param capacity the capacity of the server
	 */
	public Server(long capacity) {
		this.capacity = capacity;
		msgs = new LinkedList<Message>();

	}

	
	/**Checks the load of the server. And prints the warning when 
	 * the server is 50, 80 percent full and deletes all the messages when 
	 * the server is 100 percent full.
	 * @param printer the place where the warning should be printed out
	 */
	public void checkServerLoad(PrintStream printer) {
		long prevPercent = (long)((1.0 * prevSize / capacity) * 100);
		long currentPercent = (long)((1.0 * currentSize / capacity) * 100);
		if(prevPercent >= 50 && prevPercent < 80 && currentPercent >= 50 && currentPercent < 80) {
			return;
		}
		else if(prevPercent >= 80 && prevPercent < 100 && currentPercent >= 80 && currentPercent < 100) { 
			return; 
		}
		else if(currentPercent < 50 ){
			return;
		}
		else if(prevPercent >= 50 && prevPercent < 80 && currentPercent >= 80 && currentPercent < 100 ) {
			printer.println("Warning! Server is 80% full.");
		}
		 else if(prevPercent >= 80 && prevPercent < 100 && currentPercent >= 50 && currentPercent < 80) {
			printer.println("Warning! Server is 50% full.");
		}
		else {	
			if(currentPercent >= 100) {
				printer.println("Server is full. Deleting all messages...");
				flush();
			}
			else if(currentPercent >= 50 && currentPercent >= 80) {
				printer.println("Warning! Server is 80% full.");
			}
			else if(currentPercent >= 50) {
				printer.println("Warning! Server is 50% full.");
			}
		} 
	}		

	/**
	 * Deletes all the messages in the server.
	 * Changes the current and previous sizes of the server
	 */
	public void flush() {
		getMsgs().clear();
		this.currentSize = 0;
		this.prevSize = 0;
	}

	/**
	 * Gets the current size of the server
	 * @return the currentSize
	 */
	public long getCurrentSize() {
		return currentSize;
	}

	/**
	 * Sets the current size of the server to the
	 * given parameter
	 * @param currentSize the currentSize to set
	 */
	public void setCurrentSize(long currentSize) {
		this.currentSize = currentSize;
	}

	/**
	 * Gets the messages of the server
	 * @return the queue of messages
	 */
	public Queue<Message> getMsgs() { 
		return msgs;
	}

	/**
	 * Sets the previous size of the server
	 * @param prevSize the prevSize to set
	 */
	public void setPrevSize(long prevSize) {
		this.prevSize = prevSize;
	}

}

//DO_NOT_EDIT_ANYTHING_BELOW_THIS_LINE

