package pagination_helper;

import java.util.*;

public class PaginationHelper<I> {

    private List<I> items;
    private Map<I, Integer> filledPages = new HashMap<>();

    /**
     * The constructor takes in an array of items and a integer indicating how many
     * items fit within a single page
     */
    public PaginationHelper(List<I> items, int itemsPerPage) {
        this.items = new ArrayList<>(items);
        int page = 0;
        for (int i = 0; i < items.size(); i++) {
            I item = items.get(i);
            filledPages.putIfAbsent(item, page);
            if ((i+1) % itemsPerPage == 0){
                page++;
            }
        }
    }

    /**
     * returns the number of items within the entire collection
     */
    public int itemCount() {
        return items.size();
    }

    /**
     * returns the number of pages
     */
    public int pageCount() {
        List<Integer> pages = new ArrayList<>(filledPages.values());
        Collections.sort(pages);
        return pages.get(pages.size()-1) + 1;
    }

    /**
     * returns the number of items on the current page. page_index is zero based.
     * this method should return -1 for pageIndex values that are out of range
     */
    public int pageItemCount(int pageIndex) {
        if (pageIndex > pageCount()-1){
            return -1;
        }
        int items = 0;
        for (int page : filledPages.values()){
            if (page == pageIndex){
                items++;
            }
        }
        return items;
    }

    /**
     * determines what page an item is on. Zero based indexes
     * this method should return -1 for itemIndex values that are out of range
     */
    public int pageIndex(int itemIndex) {
        if (itemIndex > items.size()-1 || itemIndex < 0){
            return -1;
        } else return filledPages.getOrDefault(items.get(itemIndex), -1);
    }
}
