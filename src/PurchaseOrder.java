import java.math.BigDecimal;
import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;

/**
 * A PurchaseOrder tracks a sales contract between Amazon and a vendor
 */
public final class PurchaseOrder {

    private final ZonedDateTime orderDate;
    private final BigDecimal subtotal;
    private final String vendor;
    private final List<String> items;

    /**
     * Constructor.
     * @param orderDate - Date purchase was made
     * @param subtotal - Subtotal of purchase
     * @param vendor - Vendor name
     * @param items - List of items purchased.
     */
    public PurchaseOrder(ZonedDateTime orderDate, BigDecimal subtotal, String vendor, List<String> items) {
        this.subtotal = subtotal;
        this.vendor = vendor;
        this.items = new ArrayList<>(items);
        this.orderDate = ZonedDateTime.from(orderDate);
    }

    /**
     * Determine the total billable cost including taxes.
     * @param taxRate - The appropriate tax rate.
     * @return Cost including tax rate.
     */
    public BigDecimal determineBillableCost(Double taxRate) {
        return subtotal.multiply(BigDecimal.valueOf(1 + taxRate));
    }

    /**
     * Getter for subtotal.
     * @return subtotal
     */
    public BigDecimal getSubtotal() {
        return subtotal;
    }

    /**
     * Getter for vendor.
     * @return vendor
     */
    public String getVendor() {

        return vendor;
    }

    /**
     * Getter for item list.
     * @return item list
     */
    public List<String> getItems() {
        return new ArrayList<>(items);
    }

    /**
     * Getter for Order Date.
     * @return Order Date
     */
    public ZonedDateTime getOrderDate() {
        return ZonedDateTime.from(orderDate);
    }
}
