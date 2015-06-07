package es.upm.miw.spotify.models.utils;

import java.io.UnsupportedEncodingException;
import java.math.BigInteger;
import java.security.InvalidKeyException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.crypto.Cipher;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;

public class Encript {

	Cipher encryptor;
	Cipher decryptor;

	public Encript(SecretKey key, String algorithm) {
		try {
			this.encryptor = Cipher.getInstance(algorithm);
			this.decryptor = Cipher.getInstance(algorithm);
			this.encryptor.init(Cipher.ENCRYPT_MODE, key);
			this.decryptor.init(Cipher.DECRYPT_MODE, key);
		} catch (NoSuchPaddingException e) {
			System.out.println("EXCEPTION: NoSuchPaddingException");
		} catch (NoSuchAlgorithmException e) {
			System.out.println("EXCEPTION: NoSuchAlgorithmException");
		} catch (InvalidKeyException e) {
			System.out.println("EXCEPTION: InvalidKeyException");
		}
	}

	public Encript() {
	}

	public String encriptacion(String key) throws NoSuchAlgorithmException {
		try {
			key = MD5(key);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return key;
	}

	public String MD5(String key) throws NoSuchAlgorithmException {
		try {

			MessageDigest md = MessageDigest.getInstance("MD5");
			md.update(key.getBytes("UTF-8"), 0, key.length());
			byte[] bt = md.digest();
			BigInteger bi = new BigInteger(1, bt);
			String md5 = bi.toString(16);
			return md5;
		} catch (UnsupportedEncodingException ex) {
			Logger.getLogger(Encript.class.getName()).log(Level.SEVERE, null,
					ex);
		}
		return null;
	}
}
