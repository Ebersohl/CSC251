
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Map of <word, how many times it occurs>
 * 
 * @author parks
 *
 */
public class WordFrequencyCounter extends HashMap<String, Integer> {

	public void add(String word) {
		Integer wordCnt = get(word);
		if ("".equals(word.trim()))
			return;
		if (wordCnt == null) {
			put(word, 1);
		} else {
			put(word, wordCnt + 1);
		}
	}

	/**
	 * How many times the most frequently used word occurs
	 * 
	 * @return number of times the most frequently used word(s) occur
	 */
	public int highestFrequency() {
		int freq = 0;
		for (String w : keySet()) {
			int wFreq = get(w);
			if (wFreq > freq)
				freq = wFreq;
		}
		return freq;
	}

	/**
	 * Find all of the words that have a given usage count
	 * 
	 * @param freq the usage count we're interested in
	 * 
	 * @return all of the words with the given usage count
	 */
	public List<String> findByFrequency(int freq) {
		return entrySet()
				.stream()
				.filter(ele -> ele.getValue() == freq)
				.map(e -> e.getKey())
				.collect(Collectors.toList());
	}
}
