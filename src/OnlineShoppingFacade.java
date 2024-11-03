import java.util.Map;

public class OnlineShoppingFacade {
    private Inventory inventory;
    private PaymentSystem payment;
    private ShippingSystem shipping;

    public OnlineShoppingFacade() {
        this.inventory = new Inventory();
        this.payment = new PaymentSystem();
        this.shipping = new ShippingSystem();
    }

    public void purchaseItem(String itemId, int quantity, Map<String, Integer> paymentDetails) {
        System.out.println("Iniciando proceso de compra...");

        if (inventory.checkStock(itemId)) {
            if (payment.processPayment(paymentDetails)) {
                shipping.arrangeShipping(itemId);
                inventory.reduceStock(itemId, quantity);
                System.out.println("Compra completada con éxito.");
            } else {
                System.out.println("Error: El pago falló.");
            }
        } else {
            System.out.println("Error: El ítem no está en inventario.");
        }
    }
}

