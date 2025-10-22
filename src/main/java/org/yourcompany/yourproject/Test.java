package org.yourcompany.yourproject;
import java.io.FileReader;
import java.io.IOException;

import com.google.gson.Gson;



public class Test {

    // public void findProduct (ArrayList<String> listProduct, String nameProduct){
        
    //     for (String name : listProduct){
    //         if(name == nameProduct){
    //             return ;
    //         }
    //     }
    // }

    public class Product {
        private String name;
        private int price;
        private int quality;
        private int categoryId;

        public String getName() {
        return name;
    }
    }
    public static void main(String[] args)  {
        String filePath = "C:\\Users\\n" + //
                        "ckph\\.vscode\\bai456\\src\\main\\java\\org\\yourcompany\\yourproject\\product.json";
         
        Gson gson = new Gson();
        try (FileReader reader = new FileReader(filePath)) {
                Product data = gson.fromJson(reader, Product.class);
                System.out.println("Name: " + data.getName());
                // System.out.println("Price: " + data.get());
        } 
        catch (IOException e) {
            e.printStackTrace();
        }

    }
}
