/**
 * @author Edson Cezar
 *
 * Jul 4, 2019
 */
package br.com.user.utils;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;


/**
 * The Class AESEncryption.
 */
public class AESEncryption {

    /** The sec key. */
    private static SecretKey secKey;

    /**
     * Instantiates a new AES encryption.
     */
    public AESEncryption() {
	super();
	try {
	    this.secKey = getSecretEncryptionKey();
	} catch (Exception e) {
	    e.printStackTrace();
	}
    }

    /**
     * Encrypt credential.
     *
     * @param plainText the plain text
     * @return the byte[]
     * @throws Exception the exception
     */
    public byte[] encryptCredential(String plainText) throws Exception {
	Cipher aesCipher = Cipher.getInstance("AES");
	aesCipher.init(Cipher.ENCRYPT_MODE, this.secKey);
	byte[] byteCipherText = aesCipher.doFinal(plainText.getBytes());
	return byteCipherText;
    }

    /**
     * Decrypt credential.
     *
     * @param byteCipherText the byte cipher text
     * @return the string
     * @throws Exception the exception
     */
    public String decryptCredential(byte[] byteCipherText) throws Exception {
	Cipher aesCipher = Cipher.getInstance("AES");
	aesCipher.init(Cipher.DECRYPT_MODE, this.secKey);
	byte[] bytePlainText = aesCipher.doFinal(byteCipherText);
	return new String(bytePlainText);
    }

    /**
     * Gets the secret encryption key.
     *
     * @return the secret encryption key
     * @throws Exception the exception
     */
    public static SecretKey getSecretEncryptionKey() throws Exception {
	KeyGenerator generator = KeyGenerator.getInstance("AES");
	generator.init(128);
	SecretKey secKey = generator.generateKey();
	return secKey;
    }

}