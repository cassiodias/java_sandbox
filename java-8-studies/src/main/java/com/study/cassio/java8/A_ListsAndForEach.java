package com.study.cassio.java8;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

import com.study.cassio.java8.model.User;

/**
 * Class to show different ways to show a list with forEach method and lambdas.
 * 
 * @author Cassio Dias.
 */
public class A_ListsAndForEach {
	
	public static void main(String[] args) {
		List<User> list = Arrays.asList(new User("Cassio"), new User(
				"Cassio Dias"));
		
		execute_foreach_with_anonymous_consumer(list);

		execute_foreach_lambda_with_type(list);

		execute_foreach_lambda_without_type(list);
		
		execute_foreach_with_after_lambda(list);
		
		execute_foreach_with_inner_lambda(list);
		
	}

	private static void execute_foreach_with_anonymous_consumer(List<User> list) {
		list.forEach(new Consumer<User>() {
				@Override
				public void accept(User user) {
					System.out.println(user.getName());
				}
			});
	}

	private static void execute_foreach_lambda_with_type(List<User> list) {
		Consumer<User> consumer = (User user) -> { 
			System.out.println(user.getName()); 
		};
		list.forEach(consumer);
	}

	private static void execute_foreach_lambda_without_type(List<User> list) {
		Consumer<User> consumer;
		consumer = (user) -> { 
			System.out.println(user.getName()); 
		};
		list.forEach(consumer);
	}

	private static void execute_foreach_with_after_lambda(List<User> list) {
		Consumer<User> consumer;
		consumer = (user) -> { 
			System.out.println("Printing something before (decorator pattern)"); 
		};
		list.forEach(consumer.andThen(user -> System.out.println(user.getName())));
	}

	private static void execute_foreach_with_inner_lambda(List<User> list) {
		list.forEach(
				(User user) -> 
					System.out.println(user.getName())
				// works also without type	
				//user -> 
				//	System.out.println(user.getName())	
			);
	}
}
