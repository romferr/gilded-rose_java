package com.gildedrose.strategies;

import com.gildedrose.Item;
import com.gildedrose.ItemUpdater;
import com.gildedrose.QualityStrategy;

public class BackstagePasseStrategy implements QualityStrategy {
    ItemUpdater updater = new ItemUpdater();

    @Override
    public void update(Item item) {
        if (item.sellIn == 0) {
            item.quality = 0;
            return;
        }

        if (updater.qualityNotMaxed(item.quality)) {
            updater.increaseQuality(item);
        }

        if (updater.qualityNotMaxed(item.quality) && item.sellIn < 11) {
            updater.increaseQuality(item);
        }

        if (updater.qualityNotMaxed(item.quality) && item.sellIn < 6) {
            updater.increaseQuality(item);
        }

        updater.decreaseSellIn(item);
    }
}
