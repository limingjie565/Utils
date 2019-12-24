package utils;

public class RandomUtil {
	
	private static long count = 1;
	
	/**
	 * 随机生成任意长度的数字
	 * @param num
	 * @return
	 */
	public static long getRandom(int num) {
		double random = Math.random();
		for (int i = 0; i < num; i++) {
			count *= 10;
		}
		return (long)(random*count);
	}
	
	public static void main(String[] args) {
		System.out.println(getRandom(11));
	}
	
}
