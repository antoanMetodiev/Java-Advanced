import java.util.*;

public class ProductShop {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        Map<String, Store> storeMap = new TreeMap<>();

        while (!"Revision".equals(input)) {

            String[] data = input.split(",\\s");
            String store = data[0]; // key
            String product = data[1];
            double price = Double.parseDouble(data[2]);

            if (!storeMap.containsKey(store)) {

                Store shop = new Store(new ArrayList<>(), new ArrayList<>());
                shop.getProducts().add(product);
                shop.getPrices().add(price);
                storeMap.put(store, shop);
            } else {
                storeMap.get(store).getProducts().add(product);
                storeMap.get(store).getPrices().add(price);
            }
            input = scanner.nextLine();
        }

        storeMap.forEach((key, value) -> {
            System.out.printf("%s->\n", key);

            for (String product : storeMap.get(key).getProducts()) {
                System.out.printf("Product: %s, ", product);
                for (Double price : storeMap.get(key).getPrices()) {
                    System.out.printf("Price: %.1f\n", price);
                    storeMap.get(key).getPrices().remove(price);
                    break;
                }
            }
        });
    }

    static class Store {
        private List<String> products;
        private List<Double> prices;

        public Store(List<String> products, List<Double> prices) {
            this.products = products;
            this.prices = prices;
        }

        public List<String> getProducts() {
            return products;
        }

        public void setProducts(List<String> products) {
            this.products = products;
        }

        public List<Double> getPrices() {
            return prices;
        }

        public void setPrices(List<Double> prices) {
            this.prices = prices;
        }
    }
}
