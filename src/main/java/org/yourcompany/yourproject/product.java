package org.yourcompany.yourproject;

public class product {
    String name;
    double price;
    int quanity;
    int categoryID;
    String category;

    public product(String name, double price, int quanity, int categoryId ){
        this.name = name;
        this.price = price;
        this.quanity = quanity;
        this.categoryID = categoryId;
    }

    public void addCategory (product p, String category){
        this.category = category;
    }

    public static void printProduct(product p) {
        System.out.print("NAME: " +p.name + "   PRICE: " + p.price + "   QUANITY: " + p.quanity + "   ID: " + p.categoryID );
        if (p.category != null){
            System.out.print("   CATEGORY: " + p.category);
        }
        System.out.println();
    }

    public static void removeProduct(product p) {
        p = null;
    }

}
