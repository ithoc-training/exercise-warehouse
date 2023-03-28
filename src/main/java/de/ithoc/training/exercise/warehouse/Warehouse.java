package de.ithoc.training.exercise.warehouse;


import java.util.*;

/**
 * Erstelle eine Lagerhaltung mit einem Lager (Warehouse) für Gegenstände (Items) und Verpackungen (Cartons).
 * <p>
 * Ein Carton hat drei unterschiedliche, aber feste größen S, M oder L. Verwende dafür ein Enum.
 * Das Item besitzt eine eindeutige Nummer, einen Namen und einen Preis.
 * Das Warehouse lagert seine Items im Lager und referenziert mit der Item-Nr. darauf.
 * <p>
 * Der Einfachheit halber gibt es pro Item-Nr. nur ein Item.
 */
public class Warehouse {

    private final Set<Carton> cartons = new HashSet<>();
    private final Map<String, Item> items = new HashMap<>();


    public int cartonSize() {

        return cartons.size();
    }


    public void addCarton(Carton carton) {

        cartons.add(carton);
    }


    public Carton takeOutCarton() {

        if (cartons.isEmpty()) {
            return null;
        }

        Carton next = cartons.iterator().next();
        cartons.remove(next);

        return next;
    }


    public List<Carton> takeOutCartons(Size size) {

        List<Carton> cartons = new LinkedList<>();
        for (Carton carton : this.cartons) {
            if (carton.size().equals(size)) {
                cartons.add(carton);
            }
        }

        return cartons;
    }


    public void addItem(Item item) {

        items.put(item.getNumber(), item);
    }


    public int itemSize() {

        return items.size();
    }


    public Item maxPriceItem() {

        Item maxItem = null;
        for (Item item : items.values()) {
            if (maxItem == null || (maxItem.getPrice() < item.getPrice())) {
                maxItem = item;
            }
        }

        return maxItem;
    }

}
