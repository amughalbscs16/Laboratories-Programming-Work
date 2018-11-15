
public class Encryptor {
	  private EncryptionStrategy strategy;
	  //this can be set at runtime by the application preferences
	  public void setStrategy(EncryptionStrategy strategy) {
	    this.strategy = strategy;
	  }
	  public String useStrategy(String plainData,String key) {
		  return strategy.encryptData(plainData,key);
	  }
	  public String unuseStrategy(String encryptedData,String key) {
		  return strategy.decryptData(encryptedData,key);
	  }
}
