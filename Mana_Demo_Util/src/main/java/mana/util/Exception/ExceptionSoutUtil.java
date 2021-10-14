package mana.util.Exception;

import org.apache.commons.lang.exception.ExceptionUtils;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.io.StringWriter;

//最好用2,3
public class ExceptionSoutUtil {
    //1、
    /**
     * java.lang.ArrayIndexOutOfBoundsException: 0
     * 	at com.ccs.test.test2.main(test2.java:99)
     */
    public static String getTrace(Throwable t) {
        StringWriter stringWriter= new StringWriter();
        PrintWriter writer= new PrintWriter(stringWriter);
        t.printStackTrace(writer);
        StringBuffer buffer= stringWriter.getBuffer();
        return buffer.toString();
    }

    //2、
    /**
     * java.lang.ArrayIndexOutOfBoundsException: 0
     * 	at com.ccs.test.test2.main(test2.java:99)
     */
    public static String getExceptionAllinformation(Exception ex) {
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        PrintStream pout = new PrintStream(out);
        ex.printStackTrace(pout);
        String ret = new String(out.toByteArray());
        pout.close();
        try {
            out.close();
        } catch (Exception e) {
        }
        return ret;
    }

    //3、
    /**
     * java.lang.ArrayIndexOutOfBoundsException: 0
     * 	at com.ccs.test.test2.main(test2.java:99)
     */
    public static String getTraString(Throwable e){
        StringWriter sw = new StringWriter();
        PrintWriter pw = new PrintWriter(sw, true);
        e.printStackTrace(pw);
        pw.flush();
        sw.flush();
        return sw.toString();
    }

    public static void main(String[] args) {
        try{
            int a = 1 / 0;
        }catch (Exception e){
            System.out.println(ExceptionUtils.getFullStackTrace(e));
        }
    }
}
