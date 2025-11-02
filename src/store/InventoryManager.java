package store;

import java.util.*;
import product.SalableProduct;

public class InventoryManager {
    private final Map<String, InventoryItem> stock = new LinkedHashMap<>();

    public void initialize(Collection<InventoryItem> items) {
        stock.clear();
        for (InventoryItem it : items) stock.put(it.product.getId(), it);
    }

    public boolean add(SalableProduct p) {
        InventoryItem it = stock.get(p.getId());
        int q = it == null ? 0 : it.quantity;
        stock.put(p.getId(), new InventoryItem(p, q + 1));
        return true;
    }

    public boolean remove(SalableProduct p) {
        InventoryItem it = stock.get(p.getId());
        if (it == null || it.quantity <= 0) return false;
        int q = it.quantity - 1;
        if (q == 0) stock.remove(p.getId());
        else stock.put(p.getId(), new InventoryItem(it.product, q));
        return true;
    }

    public Optional<SalableProduct> findAvailableById(String id) {
        InventoryItem it = stock.get(id);
        return it == null || it.quantity <= 0 ? Optional.empty() : Optional.of(it.product);
    }

    public Collection<InventoryItem> getInventory() {
        return Collections.unmodifiableCollection(stock.values());
    }
}
