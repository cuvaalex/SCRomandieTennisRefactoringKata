package com.gildedrose;

import org.approvaltests.combinations.CombinationApprovals;
import org.junit.Test;

public class GildedRoseTest {

    @Test
    public void combinationUpdateQuality() {
        String[] names = new String[]{"Aged Brie", "Backstage passes to a TAFKAL80ETC concert", "blablabla"};
        Integer[] sellIns = new Integer[]{-5, -1, 0, 1, 5, 6, 10, 11};
        Integer[] qualities = new Integer[]{0, 1, 20, 49, 50};
        CombinationApprovals.verifyAllCombinations(
                (name, sellIn, quality) -> {
                    Item item = new Item(name, sellIn, quality);
                    GildedRose gildedRose = new GildedRose(new Item[]{item});

                    gildedRose.updateQuality();
                    return item.toString();
                }, names, sellIns, qualities);
    }
}