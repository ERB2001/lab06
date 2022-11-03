package it.unibo.collections;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.HashMap;
import java.util.concurrent.TimeUnit;

/**
 * Example class using {@link List} and {@link Map}.
 *
 */
public final class UseListsAndMaps {

    private final static int START_RANGE = 1000;
    private final static int STOP_RANGE = 2000;
    private final static int FIRST_INDEX = 0;
    private final static int LAST_INDEX = 999;
    private final static int MAX_ELEMENTS = 100000;
    private final static long ASIA = 4298723000L;
    private final static long AFRICA = 1110635000L;
    private final static long AMERICAS = 972005000L;
    private final static long EUROPE = 742452000L;
    private final static long OCEANIA = 38304000L;
    private final static long ANATRTICA = 0;
    

    private UseListsAndMaps() {
    }

    private static long timeInitialitation() {
        long time = System.nanoTime();
        return time;
    }
    
    private static long returnTime(long time) {
        time = System.nanoTime() - time;
        long millis = TimeUnit.NANOSECONDS.toMillis(time);
        return  millis;
    }

    /**
     * @param s
     *            unused
     */
    public static void main(final String... s) {
        /*
         * 1) Create a new ArrayList<Integer>, and populate it with the numbers
         * from 1000 (included) to 2000 (excluded).
         */
        final ArrayList<Integer> arraylist = new ArrayList<Integer>();
        arraylist.ensureCapacity(STOP_RANGE-START_RANGE);
        for (int i = START_RANGE; i < STOP_RANGE; i++) {
            arraylist.add(i);
        }
        //System.out.println(arraylist);
        /*
         * 2) Create a new LinkedList<Integer> and, in a single line of code
         * without using any looping construct (for, while), populate it with
         * the same contents of the list of point 1.
         */
        final LinkedList<Integer> llist = new LinkedList<Integer>(arraylist);
        /*
         * 3) Using "set" and "get" and "size" methods, swap the first and last
         * element of the first list. You can not use any "magic number".
         * (Suggestion: use a temporary variable)
         */
        int tmp =  llist.get(FIRST_INDEX);
        llist.set(FIRST_INDEX, llist.get(LAST_INDEX));
        llist.set(llist.size() - 1, tmp);
        //System.out.println("La quantità di elementi nella lista è: " + llist.size());
        //System.out.println("Gli elementi nella lista con il primo e l'ultimo elemento invertito sono: " + llist);
        /*
         * 4) Using a single for-each, print the contents of the arraylist.
         */
        for (final int element : arraylist) {
            System.out.print("[" + element + "]");
        }
        /*
         * 5) Measure the performance of inserting new elements in the head of
         * the collection: measure the time required to add 100.000 elements as
         * first element of the collection for both ArrayList and LinkedList,
         * using the previous lists. In order to measure times, use as example
         * TestPerformance.java.
         */
       // long time = System.nanoTime(); 

        long time = timeInitialitation();
        for (int i = 0; i < MAX_ELEMENTS; i++) {
            llist.addFirst(i);
        }
        //time = returnTime(time);
        System.out.println(returnTime(time));

        long time2 = timeInitialitation();
        for (int i = 0; i < MAX_ELEMENTS; i++) {
            arraylist.add(i);
        }
        System.out.println(returnTime(time2));
        /*
         * 6) Measure the performance of reading 1000 times an element whose
         * position is in the middle of the collection for both ArrayList and
         * LinkedList, using the collections of point 5. In order to measure
         * times, use as example PerfTest.java.
         */
        long time3 = timeInitialitation();
        for (int i = 0; i < START_RANGE; i++) {
            llist.get(llist.size() / 2);
        }
        System.out.println(returnTime(time3));

        long time4 = timeInitialitation();
        for (int i = 0; i < START_RANGE; i++) {
          arraylist.get(arraylist.size() / 2);  
        }
        System.out.println(returnTime(time4));
        /*
         * 7) Build a new Map that associates to each continent's name its
         * population:
         *
         * Africa -> 1,110,635,000
         *
         * Americas -> 972,005,000
         *
         * Antarctica -> 0
         *
         * Asia -> 4,298,723,000
         *
         * Europe -> 742,452,000
         *
         * Oceania -> 38,304,000
         */
        final Map<String, Long> map = new HashMap<>();
        map.put("Asia", ASIA);
        map.put("Africa", AFRICA);
        map.put("Americas", AMERICAS);
        map.put("Europe", EUROPE);
        map.put("Oceania", OCEANIA);
        map.put("Antartica", ANATRTICA);
        /*
         * 8) Compute the population of the world
         */
        long globalPopulation = 0; 
        for(final long nation : map.values()) {
            globalPopulation += nation;
        }
        map.put("Global Population", globalPopulation);
        System.out.println(globalPopulation);
    }    
}
