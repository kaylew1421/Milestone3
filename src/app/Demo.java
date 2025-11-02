package app;

import java.util.*;
import product.SalableProduct;
import weapons.*;
import store.*;

public class Demo {
    public static void main(String[] args) {
        SalableProduct bomb = new BombWeapon("B1", "Bomb Mk I", 5000);
        SalableProduct gun  = new GunWeapon("G1", "Laser Pistol", 7500);

        InventoryManager inv = new InventoryManager();
        ShoppingCart cart = new ShoppingCart();
        StoreFront sf = new StoreFront(inv, cart);

        sf.startUp(Arrays.asList(new InventoryItem(bomb, 2), new InventoryItem(gun, 1)));

        sf.purchase("B1");
        sf.purchase("G1");
        sf.cancel("B1");

        System.out.println("Inventory:");
        for (InventoryItem it : sf.viewInventory()) System.out.println(it.product + " x" + it.quantity);
        System.out.println("Cart:");
        for (CartItem it : sf.viewCart()) System.out.println(it.product + " x" + it.quantity);
    }
}
