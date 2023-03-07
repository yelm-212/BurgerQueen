package app.discount;

import app.discount.discountCondition.DiscountCondition;

import java.util.ArrayList;

public class Discount {
    private ArrayList<DiscountCondition> discountConditions;

    public Discount(ArrayList<DiscountCondition> discountConditions) {
        this.discountConditions = discountConditions;
    }

    public int discount(int price) {

        int discountedPrice = price;

        for (DiscountCondition discountCondition : discountConditions) {
            discountCondition.checkDiscountCondition();
            if (discountCondition.isSatisfied()) discountedPrice = discountCondition.applyDiscount(discountedPrice);
        }

        return discountedPrice;
    }

}
