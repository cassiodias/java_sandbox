package com.study.cassio.java8;

import java.util.ArrayList;
import java.util.List;

import com.study.cassio.java8.model.User;

/**
 * Example how to use removeIf - predicate lambda
 * 
 * @author Cassio Dias
 */
public class B_ListsAndRemoveIf {
	
	public static void main(String[] args) {
		List<User> list = new ArrayList<>();
		list.add(new User("Cassio", 12));
		list.add(new User("Cassio Dias", 112));
		
		// using lambda predicate
		list.removeIf(user -> user.getPoint() > 100);
		
		list.forEach(user -> System.out.println(user.getName()));
		
	}
}
