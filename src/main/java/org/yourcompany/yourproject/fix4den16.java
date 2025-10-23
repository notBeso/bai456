package org.yourcompany.yourproject;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class fix4den16 {
    public static void main(String[] args) {

// CREATE PRODUCT LIST
        product p1 = new product("CPU", 750, 5 ,1 );
        product p2 = new product("RAM",50,2,2);
        product p3 = new product("HDD",70,1,2);
        product p4 = new product("Main",400,3,1);
        product p5 = new product("Keyboard",30,8,4);
        product p6 = new product("Mouse",25,50,4);
        product p7 = new product("VGA",60,35,3);
        product p8 = new product("Monitor",120,28,2);
        product p9 = new product("Case",120,28,5);
        ArrayList<product> listProduct = new ArrayList<product>();
        listProduct.add(p1);
        listProduct.add(p2);
        listProduct.add(p3);
        listProduct.add(p4);
        listProduct.add(p5);
        listProduct.add(p6);
        listProduct.add(p7);
        listProduct.add(p8);
        listProduct.add(p9);

    // TESTING
    // for (product p : listProduct){
    //     product.printProduct(p);
    // }

// CREATE CATEGORY LIST
        category c1 = new category(1, "Computer");
        category c2 = new category(2, "Memory");
        category c3 = new category(3, "Card");
        category c4 = new category(4, "Acsesory");
        ArrayList<category> listCategory = new ArrayList<category>();
        listCategory.add(c1);
        listCategory.add(c2);
        listCategory.add(c3);
        listCategory.add(c4);

    // TESTING
    // for (category c : listCategory){
    //     category.printCategory(c);
    // }


//CALL FUCTION

        // findProduct(listProduct, "HDD");

        // findProductByCategory(listProduct, "2");

        // findProductByPrice(listProduct,100);

        // sortByPrice(listProduct);
 
        // sortByName(listProduct);

        // sortByCategoryName(listProduct, listCategory);

        // mapProductByCategory(listProduct, listCategory);
        HashMap<product,String> test = mapProductByCategory(listProduct, listCategory);
        for (Map.Entry<product,String> entry : test.entrySet()) {
            
            System.out.print("CATEGORY:  " + entry.getValue() + "   " );
            product.printProduct(entry.getKey());
        }
        // minByPrice(listProduct);
        product.printProduct(minByPrice(listProduct));
        // maxByPrice(listProduct);
        product.printProduct(maxByPrice(listProduct));
//TESTING
    //     ArrayList<product> test = sortByCategoryName(listProduct, listCategory);
    //     for (product p : test){
    //         product.printProduct(p);
    //     }
    


    }

//BAI 4
    public static ArrayList<product> findProduct(ArrayList<product> listProduct,String nameProduct) {
        ArrayList<product> result = new ArrayList<product>();
        for (product p : listProduct){
            if(p.name == nameProduct){
                result.add(p);
            }
        }

        return result;
    }

//BAI 5
    public static ArrayList<product> findProductByCategory(ArrayList<product> listProduct,int categoryId) {
        ArrayList<product> result = new ArrayList<product>();
        for (product p : listProduct){
            if(p.categoryID == categoryId){
                result.add(p);
            }
        }

        return result;
    }

// BAI 6
    public static ArrayList<product> findProductByPrice(ArrayList<product> listProduct,int  price) {
        ArrayList<product> result = new ArrayList<product>();
        for (product p : listProduct){
            if(p.price <= price){
                result.add(p);
            }
        }

        return result;
    }

// BAI 11

    public static ArrayList<product> sortByPrice (ArrayList<product> listProduct) {
        ArrayList<product> result = listProduct;
        for(int count = 0 ; count < result.size() ; count++){
            boolean check = false;
            for (int i = 0 ; i < result.size() -1 ; i++) {
                if(listProduct.get(i).price > listProduct.get(i+1).price){
                    Collections.swap(result,i,i+1);
                    check = true;
                }
            }
            if(check == false){
                break;
            }
        }
        return result;
    }

// BAI 12
    public static ArrayList<product> sortByName (ArrayList<product> listProduct) {
        ArrayList<product> result = listProduct;
        for(int i = 1 ; i < result.size() ; i++){
            int p = i -1;
            product hold = result.get(i);
            while (p >= 0 && result.get(p).name.length() > hold.name.length()){
                Collections.swap(result,p+1,p);
                p --;
            }
            Collections.replaceAll(result,result.get(p+1), hold);
        }
        return result;
    }

// BAI 13
    public static ArrayList<product> sortByCategoryName (ArrayList<product> listProduct, ArrayList<category> listCategory) {
        ArrayList<category> sort = listCategory;
        for(int i = 1 ; i < sort.size(); i++){
            int p = i - 1;
            category hold = sort.get(i);
            while (p >= 0 && sort.get(p+1).name.compareToIgnoreCase(sort.get(p).name) >=0){
                Collections.swap(sort,p+1,p);
                p --;
            }
            Collections.replaceAll(sort,sort.get(p+1), hold);
        }
        

        ArrayList<product> result = new ArrayList<product>();
        for(category c : sort){
            for( product p : listProduct) {
                if(c.categoryID == p.categoryID){
                    result.add(p);
                }
            }
        }
        return result;
    }
// BAI 14
    public static HashMap <product,String> mapProductByCategory(ArrayList<product> listProduct, ArrayList<category> listCategory) {
        // ArrayList<product> result = new ArrayList<product>();
        HashMap <product,String> result = new HashMap<>();
        for(product p : listProduct){
            for (category c : listCategory){
                if(p.categoryID == c.categoryID){
                    result.put(p, c.name);
                }
            }
        }
        return result;
    }
// BAI 15
    public static product minByPrice(ArrayList<product> listProduct) {
        product min = listProduct.get(0);
        for (product p : listProduct){
            if(p.price < min.price){
                min = p;
            }
        }
        return min;
    }
// BAI 16
    public static product maxByPrice(ArrayList<product> listProduct) {
        product max = listProduct.get(0);
        for (product p : listProduct){
            if(p.price > max.price){
                max = p;
            }
        }
        return max;
        
    }

}


