package org.skypro.skyshop.search;
public interface Searchable {
    public  String getSearchTerm();

    public String getContentType();

    String getName();

    default String getStringRepresentation() {
        return getName() + "-" + getContentType();
    }
}