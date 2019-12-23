package utils;

import java.io.UnsupportedEncodingException;
import java.util.Collections;
import java.util.Random;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 字符串工具类
 * @author wanghd
 */
public class StringUtil {
	
    /**
     * 判断源字符串是否有值
     * @param str
     * @return
     */
	public static boolean isEmpty(String str){
		return str == null || str.trim().length() <=0;
	}
	
	public static boolean hasText(String str) {
		return str == null || str.trim().length() <=0;
	}
	/**
	 * 判断是否为手机号码
	 * @param str
	 * @return
	 */
	public static boolean isPhone(String str){
		String regex = "1[3|5|6|7|8]\\d{9}";
		return str.matches(regex);
	}
	/**
	 * 2.打开日考中自己编写的工具包工程，在StringUtil里添加一个工具方法（5分）
	 */
	public static boolean judgeTelephoneIsOk(String src){
		//TODO 实现代码
		String regex = "1[3|5|6|7|8]\\d{9}";
		return src.matches(regex);
	}
	/**
	 * 判断是否为电子邮箱
	 * @param str
	 * @return
	 */
	public static boolean isEmail(String str){
		String regex = "\\w+@\\w+(.com|.cn|.cn.com)";
		return str.matches(regex);
	}
	
	/**
	 * 判断是否全部为字母
	 * @param str
	 * @return
	 */
	public static boolean isString(String str){
		String regex = "[a-zA-Z]+";
		return str.matches(regex);
	}
	
	/**
	 * 获取n位随机英文字符串
	 * @param length
	 * @return
	 */
	public static String getString(int length){
		Random random = new Random();
		StringBuffer result = new StringBuffer();
		char[] words = {'A','B','C','D','E','F','G','H','I','J','K','L','M','N','O','P','Q','R','S','T','U','V','W','X','Y','Z'};
		for(int i = 0 ; i < length ; i++){
			int index = random.nextInt(26);
			String word = words[index] + "";
			int bigorsmall = random.nextInt();
			if(bigorsmall % 2 == 0){
				word = word.toLowerCase();
			}
			result.append(word);
		}
		
		return result.toString();
	}
	/**
	 * 获取n位随机英文和数字字符串
	 * @param length
	 * @return
	 */
	public static String getStringAndNumber(int length){
		Random random = new Random();
		StringBuffer result = new StringBuffer();
		char[] words = {'A','B','C','D','E','F','G','H','I','J','K','L','M','N','O','P','Q','R','S','T','U','V','W','X','Y','Z','1','2','3','4','5','6','7','8','9','0'};
		for(int i = 0 ; i < length ; i++){
			int index = random.nextInt(36);
			String word = words[index] + "";
			if(!StringUtil.isNumber(word)){
				int bigorsmall = random.nextInt();
				if(bigorsmall % 2 == 0){
					word = word.toLowerCase();
				}
			}
			result.append(word);
		}
		
		return result.toString();
	}
	
	/**
	 * 获取n位随机数字
	 * @param length
	 * @return
	 */
	public static String getNumber(int length){
		Random random = new Random();
		StringBuffer result = new StringBuffer();
		char[] words = {'1','2','3','4','5','6','7','8','9','0'};
		for(int i = 0 ; i < length ; i++){
			int index = random.nextInt(10);
			String word = words[index] + "";
			if(!StringUtil.isNumber(word)){
				int bigorsmall = random.nextInt();
				if(bigorsmall % 2 == 0){
					word = word.toLowerCase();
				}
			}
			result.append(word);
		}
		
		return result.toString();
	}

	/**
	 * 是否是纯数字
	 * @param str
	 * @return
	 */
	public static boolean isNumber(String str){
		boolean blank = StringUtil.isEmpty(str);
		if(!blank){
			Pattern pattern = Pattern.compile("^\\d*$");
			Matcher matcher = pattern.matcher(str);
			if(matcher.matches()){
				return true;
			}else{
				return false;
			}
		}else{
			return false;
		}
	}
	
	/**
	 * 是否是数字,包含小数
	 * @param str
	 * @return
	 */
	public static boolean isFloat(String str){
		boolean blank = StringUtil.isEmpty(str);
		if(!blank){
			Pattern pattern = Pattern.compile("^\\d+.?\\d*$");
			Matcher matcher = pattern.matcher(str);
			if(matcher.matches()){
				return true;
			}else{
				return false;
			}
		}else{
			return false;
		}
	}
	
	
	/**
	 * 获取n个随机中文字符串
	 * @param j 
	 * @return
	 */
	public static String getAChinese(int length) {
        StringBuilder str = new StringBuilder();
        int hs = 0 ;
        int ls = 0; 
        Random random = new Random();
        for(int i = 0 ; i < length ; i++){
	        hs = (176 + Math.abs(random.nextInt(39))); 
	        ls = (161 + Math.abs(random.nextInt(93)));
	        byte[] b = new byte[2];
	        b[0] = (new Integer(hs).byteValue());
	        b[1] = (new Integer(ls).byteValue());
	        try {
	          str.append(new String(b, "GBk")); 
	        } catch (UnsupportedEncodingException e) {
	          e.printStackTrace();
	        }
        }
        return str.toString();
  }
	/**
	 * 生成随机数
	 * @param start
	 * @param end
	 * @return
	 */
	public static Integer RandomUtil(Integer start, Integer end) {
		Integer num = 0;
		while (true) {
			Integer endm = (int) (Math.random() * end + 1);
			if (endm >= start && endm <= end) {
				num = endm;
				break;
			}
		}
		return num;

	}

	public static void main(String[] args) {
		int names = random(20,40);
		System.out.println(getAChinese(names+20));
		
	}
	private static int random(int i, int j) {
		Integer sum = (int)Math.random()*i+1;
		return sum;
	}
	
}
