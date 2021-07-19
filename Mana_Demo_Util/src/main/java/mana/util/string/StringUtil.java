package mana.util.string;


import org.apache.commons.lang.StringUtils;

public class StringUtil {

    /*
        将str转成char数组
     */
    public static char[] getCharsFromString(String str) {
        char[] arr = null;
        if (StringUtils.isNotBlank(str)) {
            arr = str.toCharArray();
        }
        return arr;
    }

    public static String[] getStringsFromString(String str) {
        char[] charsFromString = getCharsFromString(str);
        String[] strs = new String[charsFromString.length];
        for (int i = 0; i < charsFromString.length; i++) {
            strs[i] = String.valueOf(charsFromString[i]);
        }
        return strs;
    }

    /*
        区分大小写,判断str2是否存在str1
     */
    public static boolean isContainsStr(String str1, String str2) {
        return str1.contains(str2);
    }

    /*
       不区分大小写,判断str2是否存在str1
    */
    public static boolean isContainsStrCase(String str1, String str2) {
        return toLowerCase(str1).contains(toLowerCase(str2));
    }

    /*
        str全部转成小写
     */
    public static String toLowerCase(String str) {
        return str.toLowerCase();
    }

    /*
        str全部转大写
     */
    public static String toUpperCase(String str) {
        return str.toUpperCase();
    }

    public static boolean isNotBlank(String str) {
        return StringUtils.isNotBlank(str);
    }

    public static boolean isBlank(String str) {
        return StringUtils.isBlank(str);
    }


}
