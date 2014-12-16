package com.study.cassio.java8;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import com.study.cassio.java8.model.User;

public class C_ListSort {

	public static void main(String[] args) {
		List<User> users = new ArrayList<>();
		users.add(new User("Cassio zz", 12));
		users.add(new User("Cassio Dias", 112));

		users.sort((user1, user2) -> user1.getName().compareTo(user2.getName()));
		for (User user : users) {
			System.out.println(user.getName());
		}
		
		//Using Comparator.comparing (yes! static method on interfaces)
		users.add(new User("XDias", 112));
		users.add(new User("Cassio zzyy", 12));
		users.sort(Comparator.comparing(user -> user.getName()));

		System.out.println("Using Comparator.comparing");
		for (User user : users) {
			System.out.println(user.getName());
		}
	}
}
