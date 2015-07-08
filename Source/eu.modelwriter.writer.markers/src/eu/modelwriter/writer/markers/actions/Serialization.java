package eu.modelwriter.writer.markers.actions;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Base64;

public final class Serialization<T> {

	/** Read the object from Base64 string. */
	@SuppressWarnings({ "unchecked", "unused" })
	private static <T> T fromString(String string) throws IOException,
			ClassNotFoundException {
		byte[] data = Base64.getDecoder().decode(string);
		ObjectInputStream ois = new ObjectInputStream(new ByteArrayInputStream(
				data));
		T object = (T) ois.readObject();
		ois.close();
		return object;
	}

	/** Write the object to a Base64 string. */
	@SuppressWarnings("unused")
	private static <T extends Serializable> String toString(T object)
			throws IOException {
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		ObjectOutputStream oos = new ObjectOutputStream(baos);
		oos.writeObject(object);
		oos.close();
		return Base64.getEncoder().encodeToString(baos.toByteArray());
	}
}
