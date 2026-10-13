package com.gildedrose;

import com.gildedrose.strategies.BackstagePasseStrategy;
import com.gildedrose.strategies.BrieStrategy;
import com.gildedrose.strategies.OrdinaryItem;
import com.gildedrose.strategies.SulfurasStrategy;

class GildedRose {
    Item[] items;

    public GildedRose(Item[] items) {
        this.items = items;
    }

    public void updateQuality() {
        for (Item item : items) {
            QualityStrategy strategy = strategyFor(item);
            strategy.update(item);
        }
    }

    private QualityStrategy strategyFor(Item item) {
        if (item.name.equals("Sulfuras, Hand of Ragnaros")) {
            return new SulfurasStrategy();
        }
        if (item.name.equals("Aged Brie")) {
            return new BrieStrategy();
        }
        if (item.name.equals("Backstage passes to a TAFKAL80ETC concert")) {
            return new BackstagePasseStrategy();
        }
        return new OrdinaryItem();
    }

}
