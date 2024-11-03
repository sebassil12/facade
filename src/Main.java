import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        OnlineShoppingFacade onlineShoppingFacade = new OnlineShoppingFacade();
        Map<String, Integer> paymentDetails = new HashMap<>();
        paymentDetails.put("1234567812345670", 361);
        onlineShoppingFacade.purchaseItem("shampoo head", 2, paymentDetails);
    }
}

