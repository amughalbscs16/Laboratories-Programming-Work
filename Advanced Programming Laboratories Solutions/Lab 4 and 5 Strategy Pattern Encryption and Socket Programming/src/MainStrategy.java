import java.io.IOException;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class MainStrategy {
	public static Encryptor returnEncryptor(String type)
	{
		Encryptor Encrypting = new Encryptor();
		if (type.equals("AES")){
		EncryptionStrategy AES = new AESEncryptionStrategy();
		System.out.println("Using AES");
		Encrypting.setStrategy(AES);


		}
		else if (type.equals("BF")) {
		EncryptionStrategy BF = new BlowfishEncryptionStrategy();
		System.out.println("Using BlowFish");
		Encrypting.setStrategy(BF);
//		decryptedData = Encrypting.unuseStrategy(encryptedData, Key);
		}
		else if (type.equals("TripleDES")) {
		//System.out.println(Encrypting.unuseStrategy(Name));
		System.out.println("Using TripleDES");
		EncryptionStrategy TripleDES  = new TripleDESEncryptionStrategy();
		Encrypting.setStrategy(TripleDES);
//		decryptedData = Encrypting.unuseStrategy(encryptedData, Key);
		
	}
		return Encrypting;
		
	}
}
