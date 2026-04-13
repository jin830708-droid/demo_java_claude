import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import java.util.Base64;

public class AESUtils {

    private static final String ALGORITHM = "AES/CBC/PKCS5Padding";

    public static String encrypt(String data, String key, String iv) throws Exception {
        Cipher cipher = Cipher.getInstance(ALGORITHM);
        SecretKey secretKey = new SecretKeySpec(key.getBytes(), "AES");
        IvParameterSpec ivParameterSpec = new IvParameterSpec(iv.getBytes());

        cipher.init(Cipher.ENCRYPT_MODE, secretKey, ivParameterSpec);
        byte[] encrypted = cipher.doFinal(data.getBytes());

        return Base64.getEncoder().encodeToString(encrypted);
    }

    public static String decrypt(String encryptedData, String key, String iv) throws Exception {
        Cipher cipher = Cipher.getInstance(ALGORITHM);
        SecretKey secretKey = new SecretKeySpec(key.getBytes(), "AES");
        IvParameterSpec ivParameterSpec = new IvParameterSpec(iv.getBytes());

        cipher.init(Cipher.DECRYPT_MODE, secretKey, ivParameterSpec);
        byte[] decrypted = cipher.doFinal(Base64.getDecoder().decode(encryptedData));

        return new String(decrypted);
    }
}
