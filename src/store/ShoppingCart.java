package store;

import java.util.*;
import product.SalableProduct;

public class ShoppingCart {
    private final Map<String, CartItem> items = new LinkedHashMap<>();

    public void initialize() { items.clear(); }

    public void add(SalableProduct p) {
        CartItem it = items.get(p.getId());
        int q = it == null ? 0 : it.quantity;
        items.put(p.getId(), new CartItem(p, q + 1));
    }

    public void remove(SalableProduct p) {
        CartItem it = items.get(p.getId());
        if (it == null) return;
        int q = it.quantity - 1;
        if (q <= 0) items.remove(p.getId());
        else items.put(p.getId(), new CartItem(it.product, q));
    }

    public void empty() { items.clear(); }

    public Collection<CartItem> getItems() {
        return Collections.unmodifiableCollection(items.values());
    }
}
