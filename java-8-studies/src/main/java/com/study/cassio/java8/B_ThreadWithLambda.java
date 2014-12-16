package com.study.cassio.java8;

/**
 * Lambda works for any interface with just one method (before 1.8), so,
 * runnable is able to be "lambdable".
 * 
 * @author Cassio Dias
 */
public class B_ThreadWithLambda {

	public static void main(String[] args) {
		execute_thread_with_runnable_lambda();
		// OR...
		execute_thread_with_inner_runnable_lambda();
		
		// just showing what happen when compile lambda
		// lambda translations
		// @see http://cr.openjdk.java.net/\char126briangoetz/lambda/lambda-translation.html
		Runnable o = () -> {
			System.out.println("Who am I?");
		};
		System.out.println(o); //com.study.cassio.java8.ThreadWithLambda$$Lambda$1/1175962212@24d46ca6
		System.out.println(o.getClass()); //class com.study.cassio.java8.ThreadWithLambda$$Lambda$1/1175962212
		
	}

	private static void execute_thread_with_runnable_lambda() {
		Runnable runnableLambda = () -> {
			for (int i = 0; i <= 1000; i++) {
				System.out.println(i);
			}
		};
		new Thread(runnableLambda).start();
	}
	
	private static void execute_thread_with_inner_runnable_lambda() {
		new Thread(
				() -> {
					for (int i = 0; i <= 1000; i++) {
						System.out.println(i);
					}
				}).start();
	}
	
}
