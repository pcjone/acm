package com.acm.test.redis;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Test {
	public static void main(String[] args) throws UnsupportedEncodingException {
		List<String> list = new ArrayList<String>();
		list.add("abc");
		list.add("bbc");
		list.add("cbc");
		Iterator<String> it = list.iterator();
		while (it.hasNext()) {
			String str = it.next();
			System.out.println(str);
			if (str.equals("abc")) {
				it.remove();
			}
		}
		System.out.println("-------------------");
		for (int i = 0; i < list.size(); i++) {
			System.out.println(list.get(i));
		}
	}
}
