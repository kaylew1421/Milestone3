package weapons;

import product.SalableProduct;

public abstract class Weapon implements SalableProduct, Comparable<Weapon> {
    protected final String id;
    protected final String name;
    protected final int priceCents;

    public Weapon(String id, String name, int priceCents) {
        this.id = id;
        this.name = name;
        this.priceCents = priceCents;
    }

    @Override public String getId() { return id; }
    @Override public String getName() { return name; }
    @Override public int getPriceCents() { return priceCents; }

    @Override public int compareTo(Weapon o) { return this.name.compareToIgnoreCase(o.name); }

    @Override public String toString() { return name + "($" + priceCents + ")"; }
}
