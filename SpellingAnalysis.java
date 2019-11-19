
import java.io.IOException;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Collectors;

public class SpellingAnalysis {

	public static void main(String[] args) throws IOException {
		Dictionary dict;
		WordFrequencyCounter spelledCorrectly = new WordFrequencyCounter();
		Set<String> misspelled = new TreeSet<>();
		String fileToRead = "BillOfRights.txt";
		if (args.length > 0)
			fileToRead = args[0];
		if (args.length == 2) {
			String dictFile = args[1];
			dict = new Dictionary(dictFile);
		} else {
			dict = new Dictionary();
		}

		List<String> incoming = Utilities.readAFile(fileToRead);

		// Removed loop. Replaced with a single statement that uses streams
		
		incoming.stream()
			.filter(x -> !x.equals("\n"))
			.forEach(x -> {
				if (dict.contains(x.toLowerCase())) {
					spelledCorrectly.add(x.toLowerCase());
				}
				else {
					misspelled.add(x);}
			});


		

		System.out.println("most frequent words ");
		int highestFreq = spelledCorrectly.highestFrequency();
		System.out.println(spelledCorrectly.findByFrequency(highestFreq));

		// Removed loop. Replaced with a single statement that uses streams
		
		spelledCorrectly.values().stream()
			.sorted(Comparator.reverseOrder())
			.distinct()
			.forEach(x -> System.out.println("\nfrequency: " + x + "\n" 
					+ spelledCorrectly.findByFrequency(x)));
		


		System.out.println("\nmisspelled words");
		System.out.println(misspelled);
	}

}
