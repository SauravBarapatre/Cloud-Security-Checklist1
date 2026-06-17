import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import java.util.Base64;

public class EncryptionUtil {

    private static final String KEY =
            "1234567890123456";

    public static String encrypt(String data)
            throws Exception {

        SecretKeySpec key =
                new SecretKeySpec(KEY.getBytes(),"AES");

        Cipher cipher =
                Cipher.getInstance("AES");

        cipher.init(Cipher.ENCRYPT_MODE,key);

        byte[] encrypted =
                cipher.doFinal(data.getBytes());

        return Base64.getEncoder()
                .encodeToString(encrypted);
    }
}
