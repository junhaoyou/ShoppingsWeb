package dorm.shop.DAO;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import dorm.shop.javabean.Book;
import dorm.shop.javabean.User;


public class Db {
	private static Map<String,Book>map=new LinkedHashMap<String, Book>();
	
	static {
		map.put("1", new Book("1","��������Ŷ���ֻ�ܸɵ�����","��ΰ",66));
		map.put("2", new Book("2","������������������","����",39));
		map.put("3", new Book("3","��ҹ���Ǳˮͧ��","�´���",88));
		map.put("4", new Book("4","�����µ�������","����",25));
		map.put("5", new Book("5","������ũ����","���Ρ�������",52));
	}
	
	public static Map getAll() {
		return map;
	}
	
	public static void main(String[] args) {
		Map<String, Book>map=Db.getAll();
		for(Map.Entry<String, Book>entry:map.entrySet()) {
			Book book=entry.getValue();
			System.out.println(book.getName()+"<a href='BuyServlet? id="+book.getId()+"'target='_blank'>����</a><br/>");
		}
	}
}

