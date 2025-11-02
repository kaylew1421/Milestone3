package store;

import product.SalableProduct;

public class CartItem {
    public final SalableProduct product;
    public final int quantity;
    public CartItem(SalableProduct product, int quantity) {
        this.product = product;
        this.quantity = quantity;
    }
}
