package mana.util.zip;

import org.apache.commons.lang.StringUtils;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.Base64;
import java.util.zip.GZIPInputStream;
import java.util.zip.GZIPOutputStream;

/**
 * <p>系统名称： <b>ANIAM-接入网综告告警系统V1.0</b></p>
 * <p>公司：  中通服软件科技有限公司</p>
 * <p>功能描述：字符串压缩工具类</p>
 */
public class ZipUtil {
	  /**
	   *  压缩
	   */
	  public static String compress(String str) throws IOException {
	    if (StringUtils.isBlank(str)) {
	      return str;
	    }
	    ByteArrayOutputStream out = new ByteArrayOutputStream();
	    GZIPOutputStream gzip = new GZIPOutputStream(out);
	    gzip.write(str.getBytes());			//"UTF-8"
	    gzip.close();
	    return out.toString("ISO-8859-1"); 
	  }

	  /**
	   * 解压缩
	   */
	  public static String unCompress(String str) throws IOException {
	    if (StringUtils.isBlank(str)) {
	      return str;
	    }
	    ByteArrayOutputStream out = new ByteArrayOutputStream();
	    ByteArrayInputStream in = new ByteArrayInputStream(str.getBytes("ISO-8859-1"));
	    GZIPInputStream gunzip = new GZIPInputStream(in);
	    byte[] buffer = new byte[1024];
	    int n;
	    while ((n = gunzip.read(buffer)) >= 0) {
	      out.write(buffer, 0, n);
	    }
	    return out.toString();  // toString()使用平台默认编码，也可以显式的指定如toString("GBK") "UTF-8"
	  }

	  
	// 测试方法
	@SuppressWarnings("restriction")
	public static void main(String[] args) throws IOException {
		String compressed = ZipUtil.compress("字符串的拼接China");
		String base64data1 = Base64.getEncoder().encodeToString(compressed.getBytes("UTF-8"));//"ISO-8859-1"
		String str2 = new String(Base64.getDecoder().decode(base64data1),"UTF-8");  //"ISO-8859-1"
		System.out.println(ZipUtil.unCompress(str2));
	  }

}
