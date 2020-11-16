package model;

import java.math.BigDecimal;
import java.text.NumberFormat;
import java.util.Locale;
import java.util.Objects;
/*
 Item stores information about an individual item.
 */
public final class Item {
    /** The product name. */
    private final String myProductName;

    /** The product price. */
    private final BigDecimal myPrice;

    public Item(final String theName, final BigDecimal thePrice) {
        myProductName = Objects.requireNonNull(theName, "theName can't be null!");
        myPrice       = Objects.requireNonNull(thePrice, "thePrice cant' be null!");
    }

    /**
     * Calculate the cost for a given quantity of the Item.
     */
    public BigDecimal calculateItemTotal(final int theQuantity) {
        BigDecimal itemTotal;
        itemTotal = myPrice.multiply(new BigDecimal(theQuantity));
        return itemTotal;
    }

    /**
     * A String representation of this Item will be formatted like:
     * "Pencil, $10.10"
     */
    @Override
    public String toString() {
        final NumberFormat nf = NumberFormat.getCurrencyInstance(Locale.US);
        final StringBuilder sb = new StringBuilder();
        sb.append(myProductName);
        sb.append(", ");
        sb.append(nf.format(myPrice));
        return sb.toString();
    }
}