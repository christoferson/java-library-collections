package demo;

import java.util.Arrays;
import java.util.Set;

public class DemoJavaLibraryCollections {

	public static void main(String[] args) {
		
		demoSetOfArgumentMustbeUnique();
		
		demoPeekAndFlatMap();
		
	}

	private static void demoPeekAndFlatMap() {
		String[][] arr = {{"a", "d"}, {"n", "d"}, {"a", "x"}};
		Arrays.stream(arr)
		  .peek(v -> v.equals(new String[] {"a", "d"}))
		  .flatMap(u -> Arrays.stream(u))
		  .forEach(System.out::print);
	}

	private static void demoSetOfArgumentMustbeUnique() {
		try {
			Set.of(1, 2, 1); // Exception in thread "main" java.lang.IllegalArgumentException: duplicate element: 1
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
