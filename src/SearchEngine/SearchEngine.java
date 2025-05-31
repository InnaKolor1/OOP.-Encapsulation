package org.skypro.skyshop.SearchEngine;
import org.skypro.skyshop.exception.BestResultNotFound;
import org.skypro.skyshop.Utilities.ArrayUtil;
import org.skypro.skyshop.search.Searchable;

import java.util.ArrayList;
import java.util.List;

public final class SearchEngine {
    private final List<Searchable> searchableItems = new ArrayList<>();

    public void add(Searchable searchable) {
        if (searchable == null) {
            throw new IllegalArgumentException("Элемент поиска не может быть нулевым");
        }
        searchableItems.add(searchable);
    }

    public List<Searchable> search(String query) {
        List<Searchable> results = new ArrayList<>();
        for (Searchable searchable : searchableItems) {
            if (searchable.getSearchTerm().contains(query)) {
                results.add(searchable);
            }
        }
        return results;
    }

    public static int countMatches(String searchTerm, String query) {
        if (searchTerm.isEmpty() || query.isEmpty()) {
            return 0;
        }
        int count = 0;
        int fromIndex = 0;
        int queryLength = query.length();
        while ((fromIndex = searchTerm.indexOf(query, fromIndex)) != -1) {
            count++;
            fromIndex += queryLength;
        }
        return count;
    }

    public Searchable searchMostRelevant(String query) throws BestResultNotFound {
        if (searchableItems.isEmpty()) {
            throw new BestResultNotFound("Массив для поиска элементов пуст");
        }

        Searchable mostRelevant = null;
        int maxCount = -1;

        for (Searchable item : searchableItems) {
            int count = countMatches(item.getSearchTerm(), query);
            if (count > maxCount) {
                maxCount = count;
                mostRelevant = item;
            }
        }

        if (maxCount <= 0) {
            throw new BestResultNotFound("Совпадений не найдено");
        }

        return mostRelevant;
    }
}