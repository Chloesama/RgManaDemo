package rgmana.test6;

import org.apache.commons.codec.DecoderException;
import org.apache.commons.codec.binary.Base64;
import org.apache.commons.codec.binary.Hex;
import org.apache.commons.lang.StringUtils;

import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import java.util.Locale;

/**
 * @ClassName Test1
 * @Description TODO
 * @Author RgMana
 * @Date 2021/9/27 15:25
 * @Version 1.0
 **/
public class Test1 {

    public static void main(String[] args) throws Exception {

        //传给crypto的key、iv要使用base64格式
        //ZGIyMTM5NTYxYzlmZTA2OA==
        byte[] bytes = "db2139561c9fe068".getBytes();
        String base64Str = Base64.encodeBase64String(bytes);
        System.out.println(base64Str);

        String crypto = "34439a96e68b129093105b67de81c0fc";
        byte[] data = Hex.decodeHex(crypto.toCharArray());
        byte[] s = AES_CBC_Decrypt(data, bytes, bytes);
        System.out.println(new String(s));

    }

    public static byte[] AES_CBC_Decrypt(byte[] data, byte[] key, byte[] iv) throws Exception{
        Cipher cipher = getCipher(Cipher.DECRYPT_MODE, key, iv);
        return cipher.doFinal(data);
    }

    private static Cipher getCipher(int mode, byte[] key, byte[] iv) throws Exception{
        Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
        //因为AES的加密块大小是128bit(16byte), 所以key是128、192、256bit无关
        //System.out.println("cipher.getBlockSize()： " + cipher.getBlockSize());
        SecretKeySpec secretKeySpec = new SecretKeySpec(key, "AES");
        cipher.init(mode, secretKeySpec, new IvParameterSpec(iv));

        return cipher;
    }

}
