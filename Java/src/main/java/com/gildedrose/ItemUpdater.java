package com.gildedrose;

public class ItemUpdater {
    public ItemUpdater() {}

    public void checkSellInForExtraQualityUpdate(Item item) {
        if (item.sellIn <= 0 && qualityNotMaxed(item.quality))
            increaseQuality(item);
    }

    public void checkSellInForExtraQualityDegradation(Item item) {
        if (item.sellIn <= 0)
            decreaseQuality(item);
    }

    public void decreaseSellIn(Item item) {
        item.sellIn--;
    }

    public void increaseQuality(Item item) {
        item.quality++;
    }

    public void decreaseQuality(Item item) {
        if (item.quality > 0) item.quality--;
    }

    public boolean qualityNotMaxed(int quality) {
        return quality < 50;
    }
}


