package source;

public class Main {
    public static void main(String[] args) {
        System.out.println("=== TEST ===");

        // 1. Khởi tạo kho hàng
        ProductInventory inventory = new ProductInventory();

        ElectronicProduct laptop = new ElectronicProduct("EP01", "Laptop Dell XPS", 20000000, 24);
        ElectronicProduct smartphone = new ElectronicProduct("EP02", "iPhone 15", 25000000, 12);
        ElectronicProduct headphones = new ElectronicProduct("EP03", "Sony WH-1000XM5", 8000000, 12);

        inventory.addProduct(laptop);
        inventory.addProduct(smartphone);
        inventory.addProduct(headphones);

        System.out.println("\n--- DA THEM 3 SAN PHAM ---");
        System.out.printf("+-----+--------------------+----------------+----------------+----------------+%n");
        System.out.printf("| %-3s | %-18s | %-14s | %-14s | %-14s |%n", "STT", "Ten san pham", "Gia goc (VND)",
                "VAT (10%)", "Gia cuoi (VND)");
        System.out.printf("+-----+--------------------+----------------+----------------+----------------+%n");
        int stt = 1;
        for (Product p : inventory.getProducts()) {
            double vat = p.calculateFinalPrice() - p.getPrice();
            System.out.printf("| %-3d | %-18s | %,14.0f | %,14.0f | %,14.0f |%n",
                    stt++, p.getName(), p.getPrice(), vat, p.calculateFinalPrice());
        }
        System.out.printf("+-----+--------------------+----------------+----------------+----------------+%n");

        // Bang gia Iphone
        System.out.println("\n--- AP DUNG GIAM GIA 10%% CHO IPHONE 15 ---");
        smartphone.applyDiscount(10);
        System.out.printf("+-----+--------------------+--------------------+----------------------+%n");
        System.out.printf("| %-3s | %-18s | %-18s | %-20s |%n", "STT", "Ten san pham", "Gia giam (VND)",
                "Gia cuoi (10% VAT)");
        System.out.printf("+-----+--------------------+--------------------+----------------------+%n");
        System.out.printf("| %-3d | %-18s | %,18.0f | %,20.0f |%n", 1, smartphone.getName(), smartphone.getPrice(),
                smartphone.calculateFinalPrice());
        System.out.printf("+-----+--------------------+--------------------+----------------------+%n");

        System.out.println("\n--- TIM KIEM SAN PHAM THEO TEN 'LAPTOP DELL XPS' ---");
        Product found = inventory.findProductByName("laptop dell xps");
        if (found != null) {
            System.out.printf("+-----+--------------------+----------------+----------------+----------------+%n");
            System.out.printf("| %-3s | %-18s | %-14s | %-14s | %-14s |%n", "STT", "Ten san pham", "Gia goc (VND)",
                    "VAT (10%)", "Gia cuoi (VND)");
            System.out.printf("+-----+--------------------+----------------+----------------+----------------+%n");
            System.out.printf("| %-3d | %-18s | %,14.0f | %,14.0f | %,14.0f |%n", 1, found.getName(), found.getPrice(),
                    found.calculateFinalPrice() - found.getPrice(), found.calculateFinalPrice());
            System.out.printf("+-----+--------------------+----------------+----------------+----------------+%n");
        } else {
            System.out.println("> Khong tim thay san pham!");
        }

        // 6. Tính tổng giá trị kho hàng
        System.out.println("\n--- TONG GIA TRI KHO HANG ---");
        System.out.printf("Tong gia tri: %,.0f VNĐ%n", inventory.calculateTotalValue());

        // 7. Xóa sản phẩm và tính lại
        System.out.println("\n--- XOA SAN PHAM TAI NGHE (SONY WH-1000XM5) ---");
        inventory.delProduct(headphones);
        System.out.printf("Tong gia tri sau khi xoa: %,.0f VNĐ%n", inventory.calculateTotalValue());
    }
}
