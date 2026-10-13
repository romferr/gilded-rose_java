package com.gildedrose.strategies;

import com.gildedrose.Item;
import com.gildedrose.ItemUpdater;
import com.gildedrose.QualityStrategy;

public class OrdinaryItem implements QualityStrategy {
    ItemUpdater updater = new ItemUpdater();

    @Override
    public void update(Item item) {
        if(item.quality > 0)
            updater.decreaseQuality(item);

        updater.checkSellInForExtraQualityDegradation(item);
        updater.decreaseSellIn(item);
    }

}
