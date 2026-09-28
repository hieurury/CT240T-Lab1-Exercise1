package source;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ProductInventory {

    private List<Product> products;

    public ProductInventory() {
        this.products = new ArrayList<>();
    }

    public ProductInventory(List<Product> products) {
        this.products = products != null ? new ArrayList<>(products) : new ArrayList<>();
    }

    /**
     * Thêm sản phẩm vào kho hàng.
     *
     * @param product sản phẩm cần thêm
     */
    public void addProduct(Product product) {
        if (product != null) {
            this.products.add(product);
        }
    }

    /**
     * Xóa sản phẩm khỏi kho hàng.
     *
     * @param product sản phẩm cần xóa
     */
    public void delProduct(Product product) {
        if (product != null) {
            this.products.remove(product);
        }
    }

    /**
     * Tìm kiếm sản phẩm đầu tiên có tên khớp (không phân biệt chữ hoa, chữ thường).
     *
     * @param name tên sản phẩm cần tìm
     * @return Product nếu tìm thấy, hoặc null nếu không có
     */
    public Product findProductByName(String name) {
        if (name == null) {
            return null;
        }
        for (Product product : products) {
            if (product.getName() != null && product.getName().equalsIgnoreCase(name.trim())) {
                return product;
            }
        }
        return null;
    }

    /**
     * Tính tổng giá trị kho hàng dựa trên giá bán cuối cùng
     *
     * @return tổng giá trị của toàn bộ sản phẩm trong kho
     */
    public double calculateTotalValue() {
        double total = 0.0;
        for (Product product : products) {
            total += product.calculateFinalPrice();
        }
        return total;
    }

    /**
     * Lấy danh sách sản phẩm
     *
     * @return danh sách sản phẩm không thể chỉnh sửa trực tiếp từ bên ngoài
     */
    public List<Product> getProducts() {
        return Collections.unmodifiableList(this.products);
    }
}