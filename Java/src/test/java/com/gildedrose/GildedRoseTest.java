package com.gildedrose;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class GildedRoseTest {

    @Test
    void foo() {
        Item[] items = new Item[] { new Item("foo", 0, 0) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals("foo", app.items[0].name);
    }

    @Test
    void SellInCanBeNegative() {
        Item[] items = new Item[] { new Item("foo", 0, 0) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(-1,  app.items[0].sellIn);
    }

    @Test
    void QualityCantBeNegative() {
        Item[] items = new Item[] { new Item("foo", 10, 0) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(0, app.items[0].quality);
    }

    @Test
    void QualityDegradesEveryDay() {
        Item[] items = new Item[] { new Item("foo", 10, 50) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(49, app.items[0].quality);
    }

    @Test
    void expiredOrdinaryItemDegradesTwice() {
        Item[] items = { new Item("foo", 0, 30) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(28, app.items[0].quality);
    }

    @Test
    void expiredOrdinaryItemWithQualityLeft() {
        Item[] items = { new Item("foo", -2, 30) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(28, app.items[0].quality);
    }

    @Test
    void QualityCantBeSuperiorTo50() {
        Item[] items = new Item[] { new Item("Aged Brie", 2, 50) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(50, app.items[0].quality);
    }

    @Test
    void ItemsDegradeTwiceAsFastAfterSellInDate() {
        Item[] items = new Item[] { new Item("foo", 0, 30) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(28, app.items[0].quality);
    }

    @Test
    void agedBrieQualityDoesNotExceed50AfterSellIn() {
        Item[] items = { new Item("Aged Brie", 0, 50) };
        GildedRose app = new GildedRose(items);

        app.updateQuality();

        assertEquals(50, app.items[0].quality);
    }


    // Sulfuras
    @Test
    void SulfurasQualityCanBeSuperiorTo50() {
        Item[] items = new Item[] { new Item("Sulfuras, Hand of Ragnaros", 0, 80) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertTrue(app.items[0].quality > 50);
    }

    @Test
    void SulfurasDoesNotAge() {
        Item[] items = new Item[] { new Item("Sulfuras, Hand of Ragnaros", 30, 80) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(30, app.items[0].sellIn);
    }

    @Test
    void SulfurasSellInDoesNotDecrease() {
        Item[] items = new Item[] { new Item("Sulfuras, Hand of Ragnaros", 30, 80) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(80, app.items[0].quality);
    }

    @Test
    void expiredSulfurasWithQualityLeft() {
        Item[] items = { new Item("Sulfuras, Hand of Ragnaros", -2, 80) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(80, app.items[0].quality);
    }

    // test Brie
    @Test
    void AgedBrieAgesWell() {
        Item[] items = new Item[] { new Item("Aged Brie", 10, 30) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertTrue(app.items[0].quality > 30);
    }

    @Test
    void AgedBrieStillAgesWhenSellInAreOutOfRange() {
        Item[] items = new Item[] { new Item("Aged Brie", 0, 30) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(32, app.items[0].quality);
    }

    // Backstage passes To a TAFKAL80ETC concert
    @Test
    void BackstageQualityIncrease3When5Daysleft() {
        Item[] items = new Item[] { new Item("Backstage passes to a TAFKAL80ETC concert", 1, 30) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(33, app.items[0].quality);
    }

    @Test
    void BackstageQualityIncrease2When10Daysleft() {
        Item[] items = new Item[] { new Item("Backstage passes to a TAFKAL80ETC concert", 9, 30) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(32, app.items[0].quality);
    }

    @Test
    void BackstageQualityIncrease1When10DaysOrMore() {
        Item[] items = new Item[] { new Item("Backstage passes to a TAFKAL80ETC concert", 11, 30) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(31, app.items[0].quality);
    }

    @Test
    void BackstagePassesToATAFKAL80ETCConcertDropToZeroWhenConcertIsDone() {
        Item[] items = new Item[] { new Item("Backstage passes to a TAFKAL80ETC concert", 0, 50) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(0, app.items[0].quality);
    }
}
