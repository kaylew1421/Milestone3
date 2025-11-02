package store;

import product.SalableProduct;

public class InventoryItem {
    public final SalableProduct product;
    public final int quantity;
    public InventoryItem(SalableProduct product, int quantity) {
        this.product = product;
        this.quantity = quantity;
    }
}
