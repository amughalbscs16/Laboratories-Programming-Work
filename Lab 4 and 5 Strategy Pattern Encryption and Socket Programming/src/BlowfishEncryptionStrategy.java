
import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import java.util.Base64;
public class BlowfishEncryptionStrategy implements EncryptionStrategy {
	Blowfish BF = new Blowfish();
	@Override
	public String encryptData(String plainText,String key) {
		try {
		return BF.encrypt(plainText, key);
		}catch(Exception e) {
			
		}
		return null;
		}

	@Override
	public String decryptData(String encryptedData, String key) {
		try {
		return BF.decrypt(encryptedData, key);
		}catch(Exception e) {
			
		}
		return null;
		}
	}




class Blowfish { 
	 
	 private static final String BLOWFISH = "Blowfish"; 
	 
	 Blowfish() {} 
	 
	 /**
	  * Encrypts a file with a given key. The maximum key length is 16 byte. 
	  * @param plainFileName File name of the file you want to encrypt. 
	  * @param encryptedFileName File name of the encrypted file. 
	  * @param key Key (maximum 16 byte) 
	 * @return 
	  * @throws Exception 
	  */ 
	 public String encrypt(String plainData,String key) throws Exception { 
	  SecretKeySpec skey = new SecretKeySpec(key.getBytes("UTF-8"), BLOWFISH);
	  try
      {
	  Cipher cipher = Cipher.getInstance(BLOWFISH); 
	  cipher.init(Cipher.ENCRYPT_MODE, skey); 
	  return Base64.getEncoder().encodeToString(cipher.doFinal(plainData.getBytes("UTF-8"))); 
      }
	  catch (Exception e)
      {
          System.out.println("Error while encrypting: " + e.toString());
      }
      return null;
	 } 
	 
	 /**
	  * Decrypts an encrypted file. 
	  * @param encryptedFileName File name of the encrypted file 
	  * @param plainFileName File name of the decrypted file 
	  * @param key Key 
	 * @return 
	  * @throws Exception 
	  */ 
	 public String decrypt(String encryptedData,String key) throws Exception { 
		 SecretKeySpec skey = new SecretKeySpec(key.getBytes(), BLOWFISH); 
	  Cipher cipher = Cipher.getInstance(BLOWFISH); 
	  try 
	  {
	  cipher.init(Cipher.DECRYPT_MODE, skey);
	  return new String(cipher.doFinal(Base64.getDecoder().decode(encryptedData)));      }
	  catch (Exception e)
     {
         System.out.println("Error while encrypting: " + e.toString());
     }
     return null;
	  } 
	}