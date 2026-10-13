package com.gildedrose.strategies;

import com.gildedrose.Item;
import com.gildedrose.ItemUpdater;
import com.gildedrose.QualityStrategy;

public class BrieStrategy implements QualityStrategy {
    ItemUpdater updater = new ItemUpdater();

    @Override
    public void update(Item item) {
        if (updater.qualityNotMaxed(item.quality)) {
            updater.increaseQuality(item);
            updater.checkSellInForExtraQualityUpdate(item);
        }
        updater.decreaseSellIn(item);
    }
}
