import org.junit.Test;

public class DailyTest {
    @Test
    public void test1(){
        short s1 = 1;

        String SpringBootMaven = "";
        s1 ++;
    }

    @Test
    public void test(){
        System.out.println(DailyTest.getXML());
    }

    public static String getXML(){
        return "<soapenv:Envelope xmlns:soapenv=\"http://schemas.xmlsoap.org/soap/envelope/\" xmlns:web=\"http://webservice.inf.busi.nsg.ccs.com/\">\n" +
                "   <soapenv:Header/>\n" +
                "   <soapenv:Body>\n" +
                "      <web:qryYXAAAInfoGd>\n" +
                "         <!--Optional:-->\n" +
                "         <arg0>\n" +
                "         <![CDATA[<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n" +
                "<RTS_MSG>\n" +
                "                    <PARAM_IN>\n" +
                "<ITEM VALUE=\"gzcs1587888453331@163.gd\" KEY=\"ACCOUNT\"/>\n" +
                "        <ITEM VALUE=\"47\" KEY=\"PRODUCT_ID\"/>\n" +
                "        <ITEM VALUE=\"01023703\" KEY=\"OPER_ID\"/>\n" +
                "        <ITEM VALUE=\"zhdd\" KEY=\"OPER_NAME\"/>\n" +
                "        <ITEM VALUE=\"GD-GZ\" KEY=\"NATIVE_ID\"/>\n" +
                "                    </PARAM_IN>\n" +
                "                  </RTS_MSG>\n" +
                "]]>\n" +
                "         </arg0>\n" +
                "      </web:qryYXAAAInfoGd>\n" +
                "   </soapenv:Body>\n" +
                "</soapenv:Envelope>";
    }

}
