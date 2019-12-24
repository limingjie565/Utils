package utils;

import java.util.ArrayList;
import java.util.List;

public class BuildName {
	
	
	
	/*随机生成多个人名，通过list实现*/
	public static List<String> lineName(int index, int sex) {
		List<String> nameList = new ArrayList<String>();
		BuildFirstName firstName = new BuildFirstName();
		BuildLastName lastName = new BuildLastName();
		
		for (int i = 0; i < index; i++) {
			nameList.add(firstName.insideFirstName()+lastName.insideLastName(sex));
		}
		return nameList;
	}
	
	public static void main(String[] args) {
		
		List<String> lineName = lineName(5, 1);
		
		for (String string : lineName) {
			System.out.println(string);
		}
		
	}
	
}
