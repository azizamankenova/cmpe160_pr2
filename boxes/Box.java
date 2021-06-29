
//DO_NOT_EDIT_ANYTHING_ABOVE_THIS_LINE

package boxes;
import elements.*;


/**
 * Represents the Box class in the basic messaging program.
 * @author Aziza
 *
 */
public abstract class Box{
	/**
	 * owner of the Box
	 */
	protected User owner;
	
	/**
	 * Constructs the box object for this owner
	 * @param owner the owner of the box
	 */
	public Box(User owner) {
		this.owner = owner;
	}
	
}



//DO_NOT_EDIT_ANYTHING_BELOW_THIS_LINE

