package br.com.user.utils;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;

public class AESEncryption {

    public static byte[] encryptCredential(String plainText) throws Exception {
	Cipher aesCipher = Cipher.getInstance("AES");
	aesCipher.init(Cipher.ENCRYPT_MODE, getSecretEncryptionKey());
	byte[] byteCipherText = aesCipher.doFinal(plainText.getBytes());
	return byteCipherText;
    }

    public static String decryptCredential(byte[] byteCipherText) throws Exception {
	Cipher aesCipher = Cipher.getInstance("AES");
	aesCipher.init(Cipher.DECRYPT_MODE, getSecretEncryptionKey());
	byte[] bytePlainText = aesCipher.doFinal(byteCipherText);
	return new String(bytePlainText);
    }

    public static SecretKey getSecretEncryptionKey() throws Exception {
	KeyGenerator generator = KeyGenerator.getInstance("AES");
	generator.init(128);
	SecretKey secKey = generator.generateKey();
	return secKey;
    }

}