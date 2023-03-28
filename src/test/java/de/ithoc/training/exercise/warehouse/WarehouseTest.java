package de.ithoc.training.exercise.warehouse;

import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Random;

import static org.junit.jupiter.api.Assertions.*;

class WarehouseTest {

    /**
     * Füge dem Warehouse ein Lager hinzu.
     * <p>
     * Verwende für das Lager eine Set.
     */
    @Test
    public void warehouseCartons() {
        Warehouse warehouse = new Warehouse();

        int size = warehouse.cartonSize();

        assertEquals(0, size);
    }


    /**
     * Schaffe die Möglichkeit, neue Kartons ins Lager zu legen.
     */
    @Test
    public void warehouseAddCarton() {
        Warehouse warehouse = new Warehouse();
        Carton carton = new Carton(Size.M);

        warehouse.addCarton(carton);

        assertEquals(1, warehouse.cartonSize());
    }


    /**
     * Hole einen Karton aus dem Lager heraus. Wenn das Lager leer ist,
     * gib Null zurück.
     */
    @Test
    public void warehouseTakeOutCarton() {
        Warehouse warehouse = new Warehouse();
        warehouse.addCarton(new Carton(Size.M));
        warehouse.addCarton(new Carton(Size.M));
        warehouse.addCarton(new Carton(Size.M));

        Carton takeOut = warehouse.takeOutCarton();

        assertNotNull(takeOut);
        assertEquals(2, warehouse.cartonSize());
    }

    /**
     * Füge dem Karton dessen Gräße (Enum Size) hinzu. Schreibe eine Methode, die alle Karton
     * einer gegebenen Größe zurückliefert.
     */
    @Test
    public void takeOutCartonsM() {
        Warehouse warehouse = new Warehouse();
        for (int i = 0; i < 100; i++) {
            warehouse.addCarton(new Carton(Size.S));
            warehouse.addCarton(new Carton(Size.M));
            warehouse.addCarton(new Carton(Size.L));
        }

        List<Carton> cartons = warehouse.takeOutCartons(Size.M);

        assertEquals(100, cartons.size());
    }

    /**
     * Lege das Lager für die Items an. Füge eine Methode hinzu, um neue Items in das Lager zu legen.
     * Referenz, also der Key, ist die Item-Nr.
     */
    @Test
    public void addItems() {
        Warehouse warehouse = new Warehouse();
        for (int i = 0; i < 100; i++) {
            Item item = new Item(
                    "" + (i + 1),
                    "Name " + (i + 1),
                    i * new Random().nextInt(100)
            );
            warehouse.addItem(item);
        }

        warehouse.addItem(new Item("222", "Name 222", 222.0f));

        assertEquals(101, warehouse.itemSize());
    }

    /**
     * Lies das Item mit dem höchsten Preis aus dem Lager aus.
     */
    @Test
    public void maxPriceItem() {
        Warehouse warehouse = new Warehouse();
        float maxPrice = Float.MIN_VALUE;

        for (int i = 0; i < 100; i++) {
            int price = i * new Random().nextInt(100);

            if (maxPrice < price) {
                maxPrice = price;
            }

            Item item = new Item("" + (i + 1), "Name " + (i + 1), price);
            warehouse.addItem(item);
        }

        Item item = warehouse.maxPriceItem();

        assertEquals(maxPrice, item.getPrice());
    }


}