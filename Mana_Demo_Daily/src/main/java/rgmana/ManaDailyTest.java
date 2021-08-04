package rgmana;


import mana.util.zip.ZipUtil;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.InputStreamReader;
import java.util.Base64;

public class ManaDailyTest {


    public static void main(String[] args) throws Exception {
        String xml = "H4sIAAAAAAAAAIVU7W6bMBT9vUl7B89SpTYqYAi0TQVUBNwUFQLCpF1WVSgidELjowJS7fFnG0qJ\n" +
                "VmnkB7k+Hz7Xvol+86cswFvWtHldGVAWEQRZldb7vPplwE18K1xBcGN++6o3dd3R9xc9xn7oWTFO\n" +
                "/MDBpqJLxwucYpH7JN6G2CSPCdkSL1glQYgjyh0RxgujIA7swDPJ2g91aSwBA4m7Xnk4cfCDudWl\n" +
                "ScXApRXbd8k6MOUL+lFkVdXQ5VyXxnVG8skqcR1T//5kO1ZsPSlIkQU0F+QFkNH1/PJa0Z6fTV0a\n" +
                "eEziuCTkFrHr4/8rj+nMIIgcHLEAo/YoIVeNHL4jfkjc9S0vhmoSWVVlGb0/2qVCnZCqzIfde/Io\n" +
                "ZOd6pP6gvUMjl2yWn/CRjBRlFE05XOiGk7YUURNleSEqmsoVFOQkK8LWkevKEVY/OeUdYn1L08b1\n" +
                "CMebaJ3YbIKQLk1LBuMoCiJ6+cQ220OaZm2rS5O13oFsvJj0GVjyfgHQWc4MSOeQDeAwjBA0WXdo\n" +
                "KptjbOSbpm6crE0NOPhDbvRFvw9dcGizxt0bcDaDIC3yrOrc177qsqbMq11hwPSlpGBJWXtq0+Sv\n" +
                "Hf1BgaoWqJgCdVFkaZd0eUk3/GSaIKB7vOUpi3qHPY97RVl7KDoD+rsGUC6TAaRwgQr4qQrL7Q8i\n" +
                "OORRkMU1jpciWczRBTg5QTK3kTTJ9p0I23TkTouzp7mGFtrF1fN1lKV1s6e5ynJX7UFevdRNuWOZ\n" +
                "RXAa79rfhn3rnwPa52x2DjY0HP9i93zj3x7PwZCW9Od3BqX+KqSPu+jv/eOidGn4U/kLg9PpEYYE\n" +
                "AAA=\n";

        xml = xml.replaceAll("\n","");
        System.out.println(ManaDailyTest.getInputStreamDataExt(xml));
    }

    public static String getInputStreamDataExt(String xml) throws Exception {
        StringBuffer  sb = new StringBuffer();
        BufferedReader rd = new BufferedReader(new InputStreamReader(new ByteArrayInputStream(xml.getBytes())));
        while (true) {
            int ch;
            ch = rd.read();
            if (ch > -1) {
                sb.append((char)ch);
            } else {
                break;
            }
        }
        rd.close();
        String orginal_base64_compressed_Str = sb.toString();

        /*使用JDK方法替换SUN方法
         */
        /*sun.misc.BASE64Decoder decoder = new sun.misc.BASE64Decoder();
        String retStr = new String(decoder.decodeBuffer(orginal_base64_compressed_Str),"ISO-8859-1");*/   //"UTF-8"

        String retStr = new String(Base64.getDecoder().decode(orginal_base64_compressed_Str),"ISO-8859-1");   //"UTF-8"

        String finalStr = ZipUtil.unCompress(retStr);

        return finalStr;
    }
}
