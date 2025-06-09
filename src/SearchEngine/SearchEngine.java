package org.skypro.skyshop.SearchEngine;
import org.skypro.skyshop.exception.BestResultNotFound;
import org.skypro.skyshop.Utilities.ArrayUtil;
import org.skypro.skyshop.search.Searchable;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import java.util.*;

public final class SearchEngine {
    private final Set<Searchable> searchableItems = new HashSet<>();

    public void add(Searchable item) {
        searchableItems.add(item);
    }

    public Set<Searchable> search(String searchString) {

        return searchableItems.stream()
                .filter(item -> item.getName().toLowerCase().contains(searchString.toLowerCase()))
                .collect(Collectors.toCollection(() -> new TreeSet<>(new org.skypro.skyshop.search.SearchResultComparator())));

    }

    public Searchable searchMostRelevant(String search) throws BestResultNotFound {
        Searchable bestMatch = null;
        int maxOccurrences = 0;

        for (Searchable searchable : searchableItems) {
            String searchTerm = searchable.getSearchTerm();
            int occurrences = countOccurrences(searchTerm, search);

            if (occurrences > maxOccurrences) {
                maxOccurrences = occurrences;
                bestMatch = searchable;
            }
        }
        if (bestMatch == null) throw new BestResultNotFound(search);

        return bestMatch;
    }

    private int countOccurrences(String text, String subString) {
        int count = 0;
        int index = 0;
        int subStringIndex;

        while ((subStringIndex = text.indexOf(subString, index)) != -1) {
            count++;
            index = subStringIndex + subString.length();
        }

        return count;


    }
}