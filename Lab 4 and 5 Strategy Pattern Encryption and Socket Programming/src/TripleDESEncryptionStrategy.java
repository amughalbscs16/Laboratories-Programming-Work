
import java.security.MessageDigest;
import java.util.Arrays;
import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import java.util.Base64;
public class TripleDESEncryptionStrategy implements EncryptionStrategy {
	TripleDES Algorithm = new TripleDES();
	@Override
	public String encryptData(String plainText, String key) {
		try{
			return Algorithm.encrypt(plainText, key);
		}
		catch(Exception e) {
			//System.out.println(e.getMessage());
		}
		return "null";
		}

//	@Override
	public String decryptData(String encryptedData, String key) {
//		try{
//			//return Algorithm.encrypt(encryptedData);
//		}
//		catch(Exception e) {
//			return null;
//		}
		return null;
	}

}


class TripleDES {

    public String encrypt(String plainText,String keys) throws Exception {
    	byte[] key = keys.getBytes();
        String IV = "12345678";
        SecretKeySpec spec = new SecretKeySpec(key, "DESede");
        Cipher cipher = Cipher.getInstance("DESede/CBC/PKCS5Padding");
        cipher.init(Cipher.ENCRYPT_MODE, spec, new javax.crypto.spec.IvParameterSpec(IV.getBytes()));
        return Base64.getEncoder().encodeToString(cipher.doFinal(plainText.getBytes("UTF-8"))); 

  	  }

    public String decrypt(String encryptedData,String keys) throws Exception {
    	byte[] key = keys.getBytes();
        String IV = "12345678";
        SecretKeySpec spec = new SecretKeySpec(key, "DESede");
        Cipher cipher = Cipher.getInstance("DESede/CBC/PKCS5Padding");
        cipher.init(Cipher.DECRYPT_MODE, spec, new javax.crypto.spec.IvParameterSpec(IV.getBytes()));
        System.out.println("Shit");
        return new String(cipher.doFinal(Base64.getDecoder().decode(encryptedData)));   
    }
}