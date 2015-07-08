/**
 * 
 */
package eu.modelwriter.writer.markers.actions;

/**
 * @author Ferhat Erata
 *
 */
public class MarkElement implements java.io.Serializable {

	private static final long serialVersionUID = 1L;

	public MarkElement() {

	}

	private int id;

	private int offset;

	private int length;

	private String message;

	private String location;

	public int getId() {
		return id;
	}

	public int getOffset() {
		return offset;
	}

	public int getLength() {
		return length;
	}

	public String getMessage() {
		return message;
	}

	public String getLocation() {
		return location;
	}
}
