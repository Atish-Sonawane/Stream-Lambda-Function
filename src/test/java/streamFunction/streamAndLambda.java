package streamFunction;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.testng.Assert;
import org.testng.annotations.Test;

public class streamAndLambda {

	// @Test
	public void regular() {
		ArrayList<String> array = new ArrayList<String>();
		array.add("Atish");
		array.add("ashish");
		array.add("ram");
		array.add("Abhi");
		int count = 0;

		for (int i = 0; i < array.size(); i++) {
			String actual = array.get(i);
			if (actual.startsWith("A")) {
				count++;
			}
		}
		System.out.println(count);

	}

//************************* Using streams  *********************************
	// @Test
	public void stramFilter() {
		ArrayList<String> array = new ArrayList<String>();
		array.add("Atish");
		array.add("ashish");
		array.add("ram");
		array.add("Abhi");

		// start with A
		long count = array.stream().filter(s -> s.startsWith("A")).count();
		System.out.println(count);

		// length is > 4
		array.stream().filter(s -> s.length() > 4).forEach(s -> System.out.println(s));

		// use limit
		array.stream().filter(s -> s.length() > 2).limit(1).forEach(s -> System.out.println(s));

	}

//************************* Using map  *********************************

	// @Test
	public void streamMap() {

		// to upperCase
		Stream.of("Atish", "ashish", "ram", "Abhi").map(s -> s.toUpperCase()).forEach(e -> System.out.println(e));

		// to upperCase with filter
		Stream.of("Atish", "ashish", "ram", "Abhi").filter(s -> s.endsWith("h")).map(s -> s.toUpperCase())
				.forEach(e -> System.out.println(e));

		// use stream function on arrays
		String[] ar = { "Alice", "Bob", "Atish", "David", "Eva" };
		List<String> arlist = Arrays.asList(ar);
		arlist.stream().filter(s -> s.startsWith("A")).sorted().map(s -> s.toLowerCase())
				.forEach(f -> System.out.println(f));
	}

//************************* Concatenation  *********************************
	// @Test
	public void concatStream() {
		ArrayList<String> list1 = new ArrayList<String>();
		list1.add("Atish");
		list1.add("ashish");
		list1.add("ram");
		list1.add("Abhi");

		List<String> list2 = Arrays.asList("Alok", "mayur", "raj");

		// merge to List
		Stream<String> newStream = Stream.concat(list1.stream(), list2.stream());
		newStream.sorted().forEach(s -> System.out.println(s));

		// check assert
		Stream<String> newStream1 = Stream.concat(list1.stream(), list2.stream());
		boolean flag = newStream1.anyMatch(s -> s.equalsIgnoreCase("RaM"));
		System.out.println(flag);
		Assert.assertTrue(flag);
	}

//************************* Using stream Collection *********************************
	// @Test
	public void streamCollect() {
		List<String> list1 = Arrays.asList("Mohan", "Mayur", "Aalesh", "Pandit");

		// make changes on list using stream and collect in new list
		List<String> list2 = list1.stream().sorted().map(s -> s.toUpperCase()).collect(Collectors.toList());
		System.out.println(list2.get(1));

		// make changes on Stream and collect in list
		List<String> list3 = Stream.of("Mohan", "Mayur", "Aalesh", "Pandit").sorted().map(s -> s.toUpperCase())
				.collect(Collectors.toList());
		System.out.println(list3.get(0));
	}

//************************* Using stream Collection *********************************
	@Test
	public void StremOnInteger() {

		List<Integer> list1 = Arrays.asList(2, 3, 4, 4, 3, 2, 1, 4, 6, 7, 6, 4, 3, 2, 21, 7, 8, 9, 6, 5);
		List<Integer> list2 = Arrays.asList(2, 3, 4, 4, 3, 2, 1, 4, 6, 7, 6, 4, 3, 2, 21, 7, 8, 9, 6, 5);
		List<Integer> list3 = Arrays.asList(2, 3, 4, 4, 3, 2, 1, 4, 6, 7, 6, 4, 3, 2, 21, 7, 8, 9, 6, 5);

		// print distinct number
		list1.stream().distinct().forEach(s -> System.out.println(s));
		
		// print distinct number with sorted
		list2.stream().distinct().sorted().forEach(s -> System.out.println(s));
		List<Integer> uniqueList = list3.stream().distinct().sorted().collect(Collectors.toList());
		int sec = uniqueList.get(2);
		System.out.println(sec);
		
	}

}
