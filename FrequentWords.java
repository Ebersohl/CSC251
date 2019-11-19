
import static org.junit.Assert.assertArrayEquals;
import static org.junit.jupiter.api.DynamicTest.stream;

import java.io.FileNotFoundException;
import java.util.Collection;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.stream.Collectors;

public class FrequentWords {

	public static void main(String[] args) throws FileNotFoundException {

		String filename = "SophieSallyJack.txt";
		if (args.length == 1) {
			filename = args[0];
		}
		Map<String, Integer> wordFrequency = new TreeMap<>();

		List<String> incoming = Utilities.readAFile(filename);
		
		// Removed loop. Replaced with a single statement using streams
		// that populates wordFrequency
		
		wordFrequency = incoming.stream()
			.filter(x -> !x.equals("\n"))
			.collect(Collectors.toMap(
				x -> x.toLowerCase(),x ->1, Integer::sum));
		

		// Removed loop. Replaced with a single statement that uses streams to determine maxCnt
		
		int maxCnt = wordFrequency.values().stream()
			.max(Comparator.naturalOrder())
			.get();
				
		
		System.out.print("Words that appear " + maxCnt + " times:");
		
		// Removed loop. Replaced with a single statement using streams
		// that prints the most frequent words in the document
		
		wordFrequency.entrySet().stream()
			.filter(x -> x.getValue() == maxCnt)
			.map(Map.Entry::getKey)
			.forEach(x -> System.out.print(" " + x));
		

	}

}
