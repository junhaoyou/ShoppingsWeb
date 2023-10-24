package shop;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import enter.User;


public class Db {
	private static Map<String,Book>map=new LinkedHashMap<String, Book>();
	
	static {
		map.put("1", new Book("1","《不会带团队你只能干到死》","赵伟",66));
		map.put("2", new Book("2","《少年的你如此美丽》","玖月晞",39));
		map.put("3", new Book("3","《夜晚的潜水艇》","陈春成",88));
		map.put("4", new Book("4","《办事的艺术》","章岩",25));
		map.put("5", new Book("5","《动物农场》","乔治·奥威尔",52));
	}
	
	public static Map getAll() {
		return map;
	}
	
	public static void main(String[] args) {
		Map<String, Book>map=Db.getAll();
		for(Map.Entry<String, Book>entry:map.entrySet()) {
			Book book=entry.getValue();
			System.out.println(book.getName()+"<a href='BuyServlet? id="+book.getId()+"'target='_blank'>购买</a><br/>");
		}
	}
}

