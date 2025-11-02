package store;

import java.util.*;
import product.SalableProduct;

public class StoreFront {
    private final InventoryManager inventory;
    private final ShoppingCart cart;

    public StoreFront(InventoryManager inventory, ShoppingCart cart) {
        this.inventory = inventory;
        this.cart = cart;
    }

    public void startUp(Collection<InventoryItem> initial) {
        inventory.initialize(initial);
        cart.initialize();
    }

    public boolean purchase(String productId) {
        Optional<SalableProduct> p = inventory.findAvailableById(productId);
        if (!p.isPresent()) return false;
        boolean ok = inventory.remove(p.get());
        if (ok) cart.add(p.get());
        return ok;
    }

    public boolean cancel(String productId) {
        Optional<SalableProduct> p = inventory.findAvailableById(productId);
        if (!p.isPresent()) return false;
        cart.remove(p.get());
        inventory.add(p.get());
        return true;
    }

    public Collection<InventoryItem> viewInventory() { return inventory.getInventory(); }
    public Collection<CartItem> viewCart() { return cart.getItems(); }
}
