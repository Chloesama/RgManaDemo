package com.http;

import org.apache.http.HttpEntity;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;

import java.io.IOException;
import java.nio.charset.Charset;

/**
 * @ClassName HttpSoap
 * @Description TODO
 * @Author RgMana
 * @Date 2021/7/21 18:56
 * @Version 1.0
 **/
public class HttpSoap {


    static int socketTimeout = 180000;
    static int connectTimeout = 180000;

    static final String soap = "text/xml;charset=UTF-8";

    static final String soap11 = "application/soap+xml;charset=UTF-8";

    public static String doPostSoap(String webServiceURL, String soapXml, String soapAction, String soapType) {

        org.apache.commons.logging.LogFactory a ;
        HttpClientBuilder httpClientBuilder = HttpClientBuilder.create();
        CloseableHttpClient closeableHttpClient = httpClientBuilder.build();

        HttpPost httpPost = new HttpPost(webServiceURL);

        RequestConfig requestConfig = RequestConfig.custom().setSocketTimeout(socketTimeout).setConnectTimeout(connectTimeout).build();
        httpPost.setConfig(requestConfig);

        httpPost.setHeader("Content-Type", soapType);
        httpPost.setHeader("SOAPAction", soapAction);

        StringEntity data = new StringEntity(soapXml, Charset.forName("UTF-8"));
        httpPost.setEntity(data);
        try {
            CloseableHttpResponse response = closeableHttpClient.execute(httpPost);
            HttpEntity httpEntity = response.getEntity();
            if (httpEntity != null) {
                return EntityUtils.toString(httpEntity, "UTF-8");
            }
            closeableHttpClient.close();
        } catch (ClientProtocolException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static void main(String[] args) {
        //String soapUrl = "http://172.51.234.79:18256/NetSharkServerTest/services/AniamOuterInterfaceService?wsdl";
        String soapUrl = "http://172.51.234.79:18256/NetSharkServer/services/AniamOuterInterfaceService?wsdl";
        System.out.println("soapUrl:" + soapUrl);
        String result = HttpSoap.doPostSoap(soapUrl, HttpSoap.getXML(), "", "text/xml;charset=UTF-8");
        System.out.println(result);
    }

    public static String getXML(){
        return "<soapenv:Envelope xmlns:soapenv=\"http://schemas.xmlsoap.org/soap/envelope/\" xmlns:web=\"http://webservice.inf.busi.nsg.ccs.com/\">\n" +
                "   <soapenv:Header/>\n" +
                "   <soapenv:Body>\n" +
                "      <web:qryFaulEffectDayData>\n" +
                "         <!--Optional:-->\n" +
                "         <arg0>\n" +
                "         <![CDATA[\n" +
                "<?xml version=\"1.0\" encoding=\"GBK\"?>\n" +
                "<RTS_MSG>\n" +
                "    <PARAM_IN>\n" +
                "        <ITEM KEY=\"SERIAL_NO\" VALUE=\"210731762932361\"/>\n" +
                "        <ITEM KEY=\"OPER_NAME\" VALUE=\"gdytd\"/>\n" +
                "        <ITEM KEY=\"OPER_ID\" VALUE=\"5345664734666504359\"/>\n" +
                "        <ITEM KEY=\"NATIVE_ID\" VALUE=\"GD-MM\"/>\n" +
                "        <ITEM KEY=\"START_DATE\" VALUE=\"2021-07-20 00:00:00\"/>\n" +
                "        <ITEM KEY=\"END_DATE\" VALUE=\"2021-07-22 12:00:00\"/>\n" +
                "        <ITEM KEY=\"REFERENCE_TIME\" VALUE=\"2021-07-21 12:00:00\"/>\n" +
                "    </PARAM_IN>\n" +
                "</RTS_MSG>\n" +
                "]]>\n" +
                "         </arg0>\n" +
                "      </web:qryFaulEffectDayData>\n" +
                "   </soapenv:Body>\n" +
                "</soapenv:Envelope>";
    }
}
