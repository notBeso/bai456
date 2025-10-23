package org.yourcompany.yourproject;

public class category {
    int categoryID;
    String name;

    public category(int ID, String name ){
        this.categoryID = ID;
        this.name = name;
    }

    
    public static void printCategory(category c){
        System.out.println("ID: " +c.categoryID + "   NAME: " + c.name);
    }


}

// public category(int ID, String na ){
//         this. = ;
//     }