
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

class WordFrequencyCounterTest {

   @Test
   void testAdd() {
      WordFrequencyCounter cntr = new WordFrequencyCounter();
      cntr.add("a");
      assertEquals(Integer.valueOf(1), cntr.get("a"));
   }

   @Test
   void testHighestFrequency0() {
      WordFrequencyCounter cntr = new WordFrequencyCounter();
      assertEquals(0, cntr.highestFrequency());
   }

   @Test
   void testHighestFrequency1() {
      WordFrequencyCounter cntr = new WordFrequencyCounter();
      cntr.add("a");
      assertEquals(1, cntr.highestFrequency());
   }

   @Test
   void testFindByFrequency() {
      WordFrequencyCounter cntr = new WordFrequencyCounter();
      cntr.add("a");
      List<String> l = new ArrayList<>();
      l.add("a");
      assertEquals(l, cntr.findByFrequency(1));
   }

}
