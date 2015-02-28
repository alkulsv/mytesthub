package HttpServer3;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import org.apache.commons.codec.binary.Hex;

/**
 *  Make MD5 code for the file.
 */
public class MessageDigestForFile {

	/**
	 *  This method make MD5 code for the file.
	 *  @param file Input file.
	 *  @return MD5 code.
	 *  @throws NoSuchAlgorithmException If MD5 code can't be calculated.
	 *  @throws FileNotFoundException If file not found.
	 *  @throws IOException IO-error exception. 
	 */
	public String getDigestForFile(String file) throws NoSuchAlgorithmException, FileNotFoundException, IOException {
		return getDigest(new FileInputStream(file), MessageDigest.getInstance("MD5"), 2048);
	}
	
	/**
	 *  This method make MD5 code for the stream.
	 *  @param is Input stream.
	 *  @param md MessageDigest.
	 *  @param byteArraySize Size of buffer.
	 *  @return MD5 code.
	 *  @throws NoSuchAlgorithmException If MD5 code can't be calculated.
	 *  @throws IOException IO-error exception. 
	 */
		public String getDigest(InputStream is, MessageDigest md, int byteArraySize)
			throws NoSuchAlgorithmException, IOException {
		md.reset();
		byte[] bytes = new byte[byteArraySize];
		int numBytes;
		while ((numBytes = is.read(bytes)) != -1) {
			md.update(bytes, 0, numBytes);
		}
		byte[] digest = md.digest();
		String result = new String(Hex.encodeHex(digest));
		return result;
	}
}