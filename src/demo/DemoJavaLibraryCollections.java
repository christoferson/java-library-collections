package demo;

import java.util.Arrays;
import java.util.Set;
import java.util.function.Consumer;
import java.util.function.Function;

public class DemoJavaLibraryCollections {

	public static void main(String[] args) {
		
		demoSetOfArgumentMustbeUnique(); System.out.println();
		
		demoPeekAndFlatMap(); System.out.println();
		
		demoConsumer(); System.out.println();
		
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
	
	static class Value {
		static Integer counterC = 1;
		static Integer counterF = 1;
	}

	private static void demoConsumer() {

		Consumer<Integer> addC = i -> Value.counterC += i;
		Consumer<Integer> showC = i -> System.out.print(i);
		addC.andThen(showC).accept(1);

		Function<Integer, Integer> addF = i -> Value.counterF += i;
		Function<Integer, Integer> showF = i -> {
			System.out.print(i);
			return i;
		};
		addF.andThen(showF).apply(1);
	}
	
}
