package rgmana.test7;

import org.junit.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @ClassName T1
 * @Description TODO
 * @Author RgMana
 * @Date 2021/12/21 16:54
 * @Version 1.0
 **/
public class T1 {
    public static void main(String[] args) {

        DateTimeFormatter df = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

        LocalDateTime now = LocalDateTime.now();
        System.out.println(df.format(now));
    }

    @Test
    public void t1(){
        String value = "show this\n" +
                "!&lt;MSAN&gt;\n" +
                "  dhcpv4-l2-relay-agent enable\n" +
                "  dhcpv4-l2-relay-agent trust false add\n" +
                "  dhcpv6-l2-relay-agent enable\n" +
                "  dhcpv6-l2-relay-agent trust false add\n" +
                "  pppoe-intermediate-agent enable\n" +
                "  pppoe-intermediate-agent trust true replace\n" +
                "!&lt;/MSAN&gt;\n" +
                "Z.NS.HGLDCYDJF1.XGGT-1.C600($-profile-pppoe_plus)#\n" +
                "show port-identification ope$dentification ope           r          a         t        o       r      -     p    r   o  f$ion operator-prof           i          l         e                g      l     o    b   a  \n" +
                "Globally applied operator profile pppoe_plus\n" +
                "Z.NS.HGLDCYDJF1.XGGT-1.C600($-profile-pppoe_plus)#\n" +
                "show port-identification glo$dentification glo           b          a         l        \n" +
                "access-node-name      : 12.5.132.25\n" +
                "access-node-id-type   : access-node-name \n" +
                "format-pon-protection : work-pon \n" +
                "rackno    : 1\n" +
                "frameno   : 1\n" +
                "\n" +
                "Z.NS.HGLDCYDJF1.XGGT-1.C600($-profile-pppoe_plus)#\n" +
                "show pppoe-intermediate-agen$intermediate-agen           t                    v        l       a      n          a   l  l$te-agent vlan all           \n" +
                "vlan total  : 200\n" +
                "2401-2600  \n" +
                "Z.NS.HGLDCYDJF1.XGGT-1.C600($-profile-pppoe_plus)#";

        String content = "";
        boolean is_match = false;

        String regexCompress = "pppoe-intermediate-agent enable|pppoe-intermediate-agent trust true replace|Globally applied operator profile pppoe_plus|access-node-name  .{0,30}|rackno.{0,30}.|frameno.{0,30}|2401-2600";

        Pattern pt = Pattern.compile(regexCompress);

        Matcher mt = pt.matcher(value);

        while (mt.find()) {
            if(!mt.group(0).trim().equals("")){
                if(is_match){
                    content = content + "," + mt.group(0);
                }
                else{
                    content = mt.group(0);
                }
                is_match = true;
            }
        }

        System.out.println(content);
        System.out.println(is_match);

        boolean b = doAnalysisContentByFileCmd(content.trim(), "STRING", "like",
                "pppoe-intermediate-agent enable&&pppoe-intermediate-agent trust true replace&&Globally applied operator profile pppoe_plus&&rackno    : 1&&frameno   : 1&&2401-2600&&access-node-name");
        System.out.println(b);
    }

    public static boolean doAnalysisContentByFileCmd(String fileContent, String compareType, String compareOperator, String compareValue){

        /**字符串比较*/
        if("STRING".equals(compareType)){

            if(compareValue.contains("||")){
                String[] value = compareValue.trim().split("\\|\\|");
                for(int i=0;i<value.length;i++){
                    if(StringComparator(compareOperator, value[i].trim(), fileContent)){
                        return true;
                    }
                }
                return false;
            }

            else if(compareValue.contains("&&")){
                String[] value = compareValue.trim().split("&&");
                String[] results = fileContent.trim().split(",");
                for(int i=0;i<value.length;i++){
                    Boolean compaResult =false;
                    for (int j = 0; j < results.length; j++) {
                        if(StringComparator(compareOperator, value[i].trim(), results[j])){
                            compaResult = true;
                        }
                    }
                    if(!compaResult){
                        return false;
                    }
                }
                return true;
            }

            else{
                return StringComparator(compareOperator, compareValue, fileContent);
            }
        }

        /**日期比较*/
        if("DATE".equals(compareType)){
            return DateComparator(compareOperator, compareValue, fileContent);
        }
        /**数值比较*/
        if("NUMBER".equals(compareType)){
            if(fileContent.contains(",")){
                String[] results = fileContent.trim().split(",");
                for(int i=0;i<results.length;i++){
                    if(NumberComparator(compareOperator, compareValue, results[i])){
                        return true;
                    }
                }
                return false;
            }
            else{
                return NumberComparator(compareOperator, compareValue, fileContent);
            }
        }
        /**IP地址合法*/
        if("IP".equals(compareType)) {
            return IpComparator(compareOperator, compareValue, fileContent);
        }

        return true;
    }

    public static boolean StringComparator(String compareOperator, String compareValue, String fileContent){
        // 对于包含指定内容即是规范的情况。比较值会配置为*，截取内容的正则表达式不包含.*，就配要包含的内容
        if ("*".equals(compareValue)) {
            return true;
        }
        //比较符号like分析
        if("like".equals(compareOperator)){
            if(fileContent != null && fileContent.contains(compareValue)){
                return true;
            }
        }

        if("not like".equals(compareOperator)){
            if(fileContent != null && !fileContent.contains(compareValue)){
                return true;
            }
        }
        //比较符号equals分析
        if("equals".equals(compareOperator) || "=".equals(compareOperator)){
            if(fileContent != null && fileContent.equals(compareValue)){
                return true;
            }
        }

        return false;
    }

    private static String regularTimeFile1 = "(\\d+:\\d+)";//匹配时间日期表达式(00:00)

    private static String regularTimeFile2 = "(\\d+:\\d+:\\d+)";//匹配时间日期表达式(00:00)


    public static boolean DateComparator(String compareOperator, String compareValue, String fileContent){
        //SimpleDateFormat sdf1 = new SimpleDateFormat("HH:mm");//暂时定的日期时间格式，以后作修改
        SimpleDateFormat sdf2 = new SimpleDateFormat("HH:mm:ss");//暂时定的日期时间格式，以后作修改
        //暂时只支持00:00:00或00:00格式匹配
        String content = "";
        //先匹配00:00:00，如果匹配上则无需分析00:00
        Pattern p = Pattern.compile(regularTimeFile2);
        Matcher matcher = p.matcher(fileContent);
        while (matcher.find()) {
            content =  matcher.group(1).trim();
            break;//只匹配一个结果
        }
        if(!content.equals("")) {
            try {
                if(">".equals(compareOperator)){
                    //compareValue必须符合00:00:00
                    if(compareValue.split(":").length < 3) {//compareValue="00:00"
                        compareValue += ":00";
                    }
                    Date targetDt = sdf2.parse(content);
                    Date sourceDt = sdf2.parse(compareValue);
                    if(targetDt.getTime() > sourceDt.getTime()){//超过规定时间
                        return true;
                    }
                }
                if("<".equals(compareOperator)){
                    //compareValue必须符合00:00:00
                    if(compareValue.split(":").length < 3) {//compareValue="00:00"
                        compareValue += ":00";
                    }
                    Date targetDt = sdf2.parse(content);
                    Date sourceDt = sdf2.parse(compareValue);
                    if(targetDt.getTime() < sourceDt.getTime()){//未超过规定时间
                        return true;
                    }
                }
                if("between".equals(compareOperator)){//在某个时间范围内
                    //传两个时间过来,如：2013-12-04 09:18:54,2013-12-04 09:18:55
                    String[] dts = compareValue.trim().split(",");
                    if(dts[0].split(":").length < 3) {//compareValue="00:00"
                        dts[0] += ":00";
                    }
                    if(dts[1].split(":").length < 3) {//compareValue="00:00"
                        dts[1] += ":00";
                    }
                    Date targetDt = sdf2.parse(content);
                    Date beginDt = sdf2.parse(dts[0]);
                    Date endDt	  = sdf2.parse(dts[1]);
                    if(targetDt.getTime()>=beginDt.getTime() && targetDt.getTime()<=endDt.getTime()){
                        return true;
                    }
                }
            } catch (ParseException e) {
                e.printStackTrace();
            }
        }else {
            //匹配00:00
            Pattern p1 = Pattern.compile(regularTimeFile1);
            Matcher matcher1 = p1.matcher(fileContent);
            while (matcher1.find()) {
                content =  matcher1.group(1).trim();
                break;//只匹配一个结果
            }
            if(!content.equals("")) {
                //compareValue值在页面填入时，格式为00:00，此处统一转成00:00:00
                content += ":00";//content="00:00"
                try {
                    if(">".equals(compareOperator)){
                        if(compareValue.split(":").length < 3) {//compareValue="00:00"
                            compareValue += ":00";
                        }
                        Date targetDt = sdf2.parse(content);
                        Date sourceDt = sdf2.parse(compareValue);
                        if(targetDt.getTime() > sourceDt.getTime()){//超过规定时间
                            return true;
                        }
                    }
                    if("<".equals(compareOperator)){
                        if(compareValue.split(":").length < 3) {//compareValue="00:00"
                            compareValue += ":00";
                        }
                        Date targetDt = sdf2.parse(content);
                        Date sourceDt = sdf2.parse(compareValue);
                        if(targetDt.getTime() < sourceDt.getTime()){//未超过规定时间
                            return true;
                        }
                    }
                    if("between".equals(compareOperator)){//在某个时间范围内
                        //compareValue传两个时间过来,如：09:18,09:20
                        String[] dts = compareValue.trim().split(",");
                        if(dts[0].split(":").length < 3) {//compareValue="00:00"
                            dts[0] += ":00";
                        }
                        if(dts[1].split(":").length < 3) {//compareValue="00:00"
                            dts[1] += ":00";
                        }
                        Date targetDt = sdf2.parse(content);
                        Date beginDt = sdf2.parse(dts[0]);
                        Date endDt	  = sdf2.parse(dts[1]);
                        if(targetDt.getTime()>=beginDt.getTime() && targetDt.getTime()<=endDt.getTime()){
                            return true;
                        }
                    }
                } catch (ParseException e) {
                    e.printStackTrace();
                }
            }
        }
        return false;
    }

    public static boolean NumberComparator(String compareOperator, String compareValue, String fileContent){

        String content = fileContent.trim();
        String content1 = "";
        if(content != null && !"".equals(content)){
            for(int i=0;i<content.length();i++){
                if(content.charAt(i)>=48 && content.charAt(i)<=57){
                    content1+=content.charAt(i);
                }
            }

        }

        if(content1.equals("")) {
            return false;//没有匹配到结果，直接返回false
        }
        if(">".equals(compareOperator)){
            double targetValue = Double.parseDouble(content1);		//巡检结果内容转为double型
            double sourceValue = Double.parseDouble(compareValue);	//参考值转为double型
            if(targetValue-sourceValue >= 0){
                return true;
            }
        }
        if("<".equals(compareOperator)){
            double targetValue = Double.parseDouble(content1);		//巡检结果内容转为double型
            double sourceValue = Double.parseDouble(compareValue);	//参考值转为double型
            if(sourceValue-targetValue >= 0){
                return true;
            }
        }
        if("=".equals(compareOperator)){
            double targetValue = Double.parseDouble(content1);		//巡检结果内容转为double型
            double sourceValue = Double.parseDouble(compareValue);	//参考值转为double型
            if(sourceValue == targetValue){
                return true;
            }
        }
        if("between".equals(compareOperator)){
            String[] values	   = compareValue.trim().split(",");
            double value1 	   = Double.parseDouble(values[0]);		//参考值转为double型
            double value2 	   = Double.parseDouble(values[1]);		//参考值转为double型
            double targetValue = Double.parseDouble(content1);		//巡检结果内容转为double型
            if(value1<=targetValue && targetValue<=value2){
                return true;
            }
        }
        return false;
    }

    private static String regularIp = "\\d{1,3}\\.\\d{1,3}\\.\\d{1,3}\\.\\d{1,3}";//合法ip正则表达式

    public static boolean IpComparator(String compareOperator, String compareValue, String fileContent){
        Boolean flag = null;
        Pattern p = Pattern.compile(regularIp);
        Matcher matcher = p.matcher(fileContent);
        while (matcher.find()) {
            if(matcher.group().equals("0.0.0.0")){
                flag = false;
                break;
            } else {
                flag = true;
            }
        }
        if(flag!= null && flag){
            return true;
        }
        else{
            return false;
        }
    }
}
