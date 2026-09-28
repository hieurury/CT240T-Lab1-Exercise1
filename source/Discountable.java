package source;

/**
 * Interface cho các sản phẩm hoặc đối tượng có khả năng áp dụng chiết khấu/giảm
 * giá.
 */
public interface Discountable {

    /**
     * Giảm giá sản phẩm theo tỷ lệ phần trăm.
     *
     * @param percent tỷ lệ phần trăm giảm giá (ví dụ: 10 đại diện cho 10%)
     */
    void applyDiscount(double percent);
}