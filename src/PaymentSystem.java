import java.util.Map;

public class PaymentSystem {
    public boolean processPayment(Map<String, Integer> paymentDetails){
        String numberCard = "";
        Integer security = 0;
        for (Map.Entry<String, Integer> entry : paymentDetails.entrySet()) {
            numberCard = entry.getKey();
            security = entry.getValue();
            System.out.println("Procesando el pago con tarjeta: " + entry.getKey());
        }
        Boolean numberCorrect = isValidCard(numberCard);
        Boolean SecurityCodeCorrect = security != null && security.equals(361);
        return numberCorrect && SecurityCodeCorrect;
    }

    private static boolean isValidCard(String cardNumber) {
        int sum = 0;
        boolean alternate = false;
        for (int i = cardNumber.length() - 1; i >= 0; i--) {
            int n = Character.getNumericValue(cardNumber.charAt(i));
            if (alternate) {
                n *= 2;
                if (n > 9) {
                    n -= 9;
                }
            }
            sum += n;
            alternate = !alternate;
        }
        return (sum % 10 == 0);
    }
}

