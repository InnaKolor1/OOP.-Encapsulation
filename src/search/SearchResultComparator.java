package org.skypro.skyshop.search;

import java.util.Comparator;

public class SearchResultComparator implements Comparator<org.skypro.skyshop.search.Searchable> {

    @Override
    public int compare(org.skypro.skyshop.search.Searchable o2, org.skypro.skyshop.search.Searchable o1) {
        int lengthCompare = Integer.compare(o2.getName().length(), o1.getName().length());
        if (lengthCompare == 0) {
            return o2.getName().compareToIgnoreCase(o1.getName());
        }
        return lengthCompare;
    }
}