/*
 * Project: Recipe Web Application
 * Assignment: Assignment 1
 * Author(s): Jeremy Buchanan
 * Student Number: 100928225
 * Date: 2021-11-07
 * Description: Class to create DTO for search form.
 */
package ca.gbc.comp3095.assignment1.web.datatransfer;

public class SearchKeywordDataTransfer {
    private String keyword;

    public SearchKeywordDataTransfer() {
    }

    public String getKeyword() {
        return keyword;
    }

    public void setKeyword(String keyword) {
        this.keyword = keyword;
    }
}
