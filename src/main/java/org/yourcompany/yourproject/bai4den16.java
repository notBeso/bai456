package org.yourcompany.yourproject;

public class bai4den16 {
    public static void main(String[] args){
        String[][] listProduct = {
            {"CPU","750","10","1"},
            {"RAM","50","2","2"},
            {"HDD","70","1","2"},
            {"Main","400","3","1"},
            {"Keyboard","30","8","4"},
            {"Mouse","25","50","4"},
            {"VGA","60","35","3"},
            {"Monitor","120","28","2"},
            {"Case","120","28","5"}
        };
        
        String[][] listCategory ={
            {"1","Computer"},
            {"2","Memory"},
            {"3","Card"},
            {"4","Acsesory"}
        };
//CALL FUCTION

        // findProduct(listProduct, "HDD");

        // findProductByCategory(listProduct, "2");

        // findProductByPrice(listProduct,100);

        // sortByPrice(listProduct);
 
        // sortByName(listProduct);

        //sortByCategoryName(listProduct, listCategory);

        // mapProductByCategory(listProduct, listCategory);

        // minByPrice(listProduct);

        // maxByPrice(listProduct);

    //TESTING
        String[][] test = mapProductByCategory(listProduct, listCategory);
        for(int r = 0; r < test.length; r++){
            for(int c = 0; c < test[r].length; c++){
                if( test[r][c] != null ){
                    System.out.print(test[r][c]+ "   ");
                }   
            }
            System.out.println();
        }
    }
 
    
//BAI 4
    public static String[][] findProduct(String[][] listProduct,String nameProduct) {
        String[][] result = new String[listProduct.length][listProduct[0].length];
        for (int name = 0 ; name < listProduct.length; name ++){
            if (listProduct[name][0] == nameProduct){
                for (int data = 0 ; data < listProduct[name].length ; data++){   
                    result[name][data] = listProduct[name][data];
                }
            }
        }

        return result;
    }

//BAI 5
    public static String[][] findProductByCategory(String[][] listProduct,String categoryId) {
        String[][] result = new String[listProduct.length][listProduct[0].length];
        for (int track = 0; track < listProduct.length; track ++){
            if (listProduct[track][3] == categoryId){
                for (int data = 0 ; data < listProduct[track].length ; data++){   
                    result[track][data] = listProduct[track][data];
                }
            }
        }
        return result;
    }

// BAI 6
    public static String[][] findProductByPrice(String[][] listProduct,int  price) {
        String[][] result = new String[listProduct.length][listProduct[0].length];
        for (int track = 0; track < listProduct.length; track ++){
            if (Integer.parseInt(listProduct[track][1]) <= price){
                for (int data = 0 ; data < listProduct[track].length ; data++){   
                    result[track][data] = listProduct[track][data];
                }
            }
        }
        return result;
    }

// BAI 11

    public static String[][] sortByPrice (String[][] listProduct) {
        String[][] result = listProduct;
        for(int count = 0 ; count < result.length ; count++){
            boolean check = false;
            for (int track = 0 ; track < result.length-1 ; track++) {
                if(Integer.parseInt(result[track][1]) > Integer.parseInt(result[track+1][1])){
                    swap(result, track, track+1 );
                    check = true;
                }
            }
            if(check==false){
                break;
            }
        }
        return result;
    }
//SUPPORT   11 
    public static void swap(String[][] listProduct, int pA, int pB){
        String[] sub = new String[listProduct[pA].length];
        for (int data = 0; data < listProduct[pA].length; data++){
            sub[data] = listProduct[pA][data];
            listProduct[pA][data] = listProduct[pB][data];
            listProduct[pB][data] = sub[data];
        }
    }
// BAI 12
    public static String[][] sortByName (String[][] listProduct) {
        String[][] result = listProduct;
        for(int count = 1 ; count < result.length ; count++){
            int track = count -1;
            String[] hold = result[count];
            while (track >= 0 && result[track][0].length() > hold[0].length()){
                result[track+1] = result[track];
                track --;
            }
            result[track+1] = hold;
        }
        return result;
    }

// BAI 13
    public static String[][] sortByCategoryName (String[][] listProduct, String[][] listCategory) {
        String[][] sort = listCategory;
        for(int count = 1 ; count < sort.length; count++){
            int track = count - 1;
            String hold[] = sort[count];
            while (track >= 0 && sort[count-1][1].compareToIgnoreCase(sort[count][1]) >= 0){
                sort[track+1] = sort[track];
                track --;
            }
            sort[track+1] = hold;
        }

        String[][] result = new String[listProduct.length][listProduct[0].length];
        int pointer = 0;
        for(int check = 0; check < sort.length; check++){
            for(int r = 0; r < listProduct.length; r++){
                if ( listProduct[r][3] == sort[check][0] ){
                    result[pointer] = listProduct[r];
                    pointer ++;
                }
            }   
        }
        return result;
    }
// BAI 14
    public static String[][] mapProductByCategory(String[][] listProduct, String[][] listCategory) {
        String[][] result = new String[listProduct.length][listProduct[0].length+1];
        for(int r = 0; r < listProduct.length; r++){
            for(int c = 0; c < listProduct[r].length; c++){
                result[r][c] = listProduct[r][c];
                if( c == 3 ){
                    result[r][c+1] = extractCategory(listCategory, listProduct[r][c]);
                }   
            }
            System.out.println();
        }
        return result;
    }
//SUPPORT   14
    public static String extractCategory(String[][] listCategory, String categoryId) {
        String result = "null";
        for(int r = 0; r < listCategory.length; r++){
            if (listCategory[r][0] == categoryId){
                result = listCategory[r][1];
            }
        }
        return result;
    }
// BAI 15
    public static String[] minByPrice(String[][] listProduct) {
        int min = Integer.parseInt(listProduct[0][1]);
        int pointer = 0;
        for(int row = 1 ; row < listProduct.length; row++){
            int compare = Integer.parseInt(listProduct[row][1]);
            if (min > compare) {
                pointer = row;
                min = compare;
            }
        }
        String[] result = listProduct[pointer];
        System.out.println(result);
        for( String e : result){
            System.out.println(e);
        }
        return result ;
    }
// BAI 16
    public static String[] maxByPrice(String[][] listProduct) {
        int max = Integer.parseInt(listProduct[0][1]);
        int pointer = 0;
        for(int row = 1 ; row < listProduct.length; row++){
            int compare = Integer.parseInt(listProduct[row][1]);
            if (max < compare) {
                pointer = row;
                max = compare;
            }
        }
        String[] result = listProduct[pointer];
        System.out.println(result);
        for( String e : result){
            System.out.println(e);
        }
        return result ;
    }
}


