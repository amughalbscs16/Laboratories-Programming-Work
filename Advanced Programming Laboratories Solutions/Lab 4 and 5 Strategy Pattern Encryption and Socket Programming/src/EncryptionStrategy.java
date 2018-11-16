
public interface EncryptionStrategy {
	String encryptData(String plainText,String key);
	String decryptData(String encryptedData,String key);
}
