package app;

import app.discount.Discount;
import app.discount.discountCondition.CozDiscountCondition;
import app.discount.discountCondition.DiscountCondition;
import app.discount.discountCondition.KidDiscountCondition;
import app.discount.discountPolicy.FixedAmountDiscountPolicy;
import app.discount.discountPolicy.FixedRateDiscountPolicy;

import java.util.ArrayList;

public class Order {
    private Cart cart;

    private ArrayList<DiscountCondition> discountConditions;

    private Discount discount;

    public Order(Cart cart, Discount discount) {
        this.cart = cart;
        this.discount = discount;
    }

    public Order(Cart cart, ArrayList<DiscountCondition> discountConditions) {
        this.cart = cart;
        this.discountConditions = discountConditions;
    }

    public Order(Cart cart){
        this.cart = cart;
    }

    public void makeOrder(){


//        CozDiscountCondition cozDiscountCondition = new CozDiscountCondition(new FixedRateDiscountPolicy(10));
//        KidDiscountCondition kidDiscountCondition = new KidDiscountCondition(new FixedAmountDiscountPolicy(500));
//
//        cozDiscountCondition.checkDiscountCondition();
//        kidDiscountCondition.checkDiscountCondition();

        int totalPrice = cart.calculateTotalPrice();
        int finalPrice = discount.discount(totalPrice);

//        if (cozDiscountCondition.isSatisfied()) finalPrice = cozDiscountCondition.applyDiscount(finalPrice);
//        if (kidDiscountCondition.isSatisfied()) finalPrice = kidDiscountCondition.applyDiscount(finalPrice);

//        for (DiscountCondition discountCondition : discountConditions){
//            discountCondition.checkDiscountCondition();
//            if(discountCondition.isSatisfied()) finalPrice = discountCondition.applyDiscount(finalPrice);
//        }
        // discount로 이동


        System.out.println("[📣] 주문이 완료되었습니다. ");
        System.out.println("[📣] 주문 내역은 다음과 같습니다. ");
        System.out.println("-".repeat(60));

        // TODO: 상품 상세 내역 출력
        cart.printCartDetails();

        System.out.println("-".repeat(60));
        System.out.printf("금액 합계      : %d원\n", totalPrice);
        System.out.printf("할인 적용 금액 : %d원\n", finalPrice);
    }
}
