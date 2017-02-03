/*
 * The MIT License (MIT)
 *
 * Copyright (c) 2017, Ferhat Erata <ferhat@computer.org>
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */

package playground;

import com.google.common.collect.ArrayListMultimap;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.Multimap;

import java.util.*;

public class GuavaTester_MultiMap1 {
    private static final Set<String> farmAnimals = Collections.unmodifiableSet(new HashSet<>(Arrays.asList("Cow","Pig","Sheep")));
    private static final Set<String> farmAnimals1 = ImmutableSet.of("Cow","Pig","Sheep");

    // use copyOf()...
    public void doStuffWithList(List<Object> unsafeList) {
        List<Object> safeList = ImmutableList.copyOf(unsafeList);
    }

    public static void main(String... args) {

        Multimap<String, String> myMultimap = ArrayListMultimap.create();
        // Adding some key/value
        myMultimap.put("Fruits", "Banana");
        myMultimap.put("Fruits", "Apple");
        myMultimap.put("Fruits", "Pear");
        myMultimap.put("Vegetables", "Carrot");

        // Getting the size
        int size = myMultimap.size();
        System.out.println(size); // 4

        // Getting values
        Collection<String> fruits = myMultimap.get("Fruits");
        System.out.println(fruits); // [Bannana, Apple, Pear]

        Collection<String> vegetables = myMultimap.get("Vegetables");
        System.out.println(vegetables); // [Carrot]

        // Iterating over entire Mutlimap
        for(String value : myMultimap.values()) {
            System.out.println(value);
        }

        // Removing a single value
        myMultimap.remove("Fruits","Pear");
        System.out.println(myMultimap.get("Fruits")); // [Bannana, Pear]

        // Remove all values for a key
        myMultimap.removeAll("Fruits");
        System.out.println(myMultimap.get("Fruits")); // [] (Empty Collection!)

    }
}


