import java.util.HashMap;
import java.util.Map;

public class Inventory {
    private Map<String, Integer> products;

    public Inventory() {
        products = new HashMap<>();
        products.put("shampoo head", 10);
        products.put("soap bar", 20);
        products.put("toothpaste", 15);
    }

    public boolean checkStock(String itemId) {
        if (products.containsKey(itemId)) {
            int quantity = products.get(itemId);
            System.out.println("Verificando inventario para el item: " + itemId + " - Cantidad disponible: " + quantity);
            return quantity > 0;
        } else {
            System.out.println("El ítem " + itemId + " no está en inventario.");
            return false;
        }
    }

    public void reduceStock(String itemId, int quantity) {
        if (products.containsKey(itemId) && products.get(itemId) >= quantity) {
            products.put(itemId, products.get(itemId) - quantity);
            System.out.println("Se ha reducido el stock de " + itemId + " en " + quantity + " unidades.");
        } else {
            System.out.println("No hay suficiente stock para " + itemId + " o el producto no existe.");
        }
    }
}



