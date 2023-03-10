package app;

import app.product.Product;
import app.product.subproduct.Drink;
import app.product.subproduct.Hamburger;
import app.product.subproduct.Side;

import java.util.ArrayList;

public class Menu {
    private ArrayList<Product> products;

    public Menu(ArrayList<Product> products) {
        this.products = products;
    }

    public void printMenu(){
        System.out.println("[๐ป] ๋ฉ๋ด");
        System.out.println("-".repeat(60));

        printHamburgers(true);

        printSides(true);

        printDrinks(true);

        System.out.println();
        System.out.println("๐งบ (0) ์ฅ๋ฐ๊ตฌ๋");
        System.out.println("๐ฆ (+) ์ฃผ๋ฌธํ๊ธฐ");
        System.out.println("-".repeat(60));
        System.out.print("[๐ฃ] ๋ฉ๋ด๋ฅผ ์ ํํด์ฃผ์ธ์ : ");
    }

    protected void printDrinks(boolean printPrice) {
        System.out.println("๐ฅค ์๋ฃ");
        //TODO: ์ฌ๊ธฐ์์ ์๋ฃ ์ถ๋ ฅ
        for (Product product : products) {
            if (product instanceof Drink) {
                printEachMenu(product, printPrice);
            }
        }
        System.out.println();
    }

    protected void printSides(boolean printPrice) {
        System.out.println("๐ ์ฌ์ด๋");
        //TODO: ์ฌ๊ธฐ์์ ์ฌ์ด๋ ์ถ๋ ฅ
        for (Product product : products) {
            if (product instanceof Side) {
                printEachMenu(product,printPrice);
            }
        }
        System.out.println();
    }

    private void printHamburgers(boolean printPrice) {
        System.out.println("๐ ํ๋ฒ๊ฑฐ");
        for (Product product : products) {
            if (product instanceof Hamburger) {
                printEachMenu(product,printPrice);
            }
        }
        System.out.println();
    }

    private static void printEachMenu(Product product,boolean printPrice) {
        if (printPrice){
            System.out.printf(
                    "   (%d) %s %5dKcal %5d์\n",
                    product.getId(), product.getName(), product.getKcal(), product.getPrice());

        }else {
            System.out.printf(
                    "   (%d) %s %5dKcal\n",
                    product.getId(), product.getName(), product.getKcal());
        }
    }

}
