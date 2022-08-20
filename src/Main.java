import java.awt.*;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    static Store store= new Store();
    static Cart cart= new Cart();

    public static void manageItems(){
        Scanner scan = new Scanner(System.in);

        while(true){

            System.out.println("\n\t******************************JAVA GROCERS******************************\n");
            System.out.println(store);
//            cart.addItem(new item("item",2.99));
//            cart.checkOut();

            System.out.println("Options: \n\ta) Add to cart\n\tb) Remove from cart \n\tc) Checkout");
            String response = scan.nextLine();

            switch(response){
                case "a" : System.out.print("\nChoose an aisle number between: 1 – 7: ");
                int row = scan.hasNextInt() ? scan.nextInt() -1: 404;
                scan.nextLine();

                System.out.print("Choose an item number between: 1 – 3: ");
                int column = scan.hasNextInt() ? scan.nextInt() -1 : 404;
                scan.nextLine();

                if(row== 404 || column== 404){
                    System.out.println("");
                    System.out.println("\n****INVALID INPUT TRY AGAIN****\n");
                    continue;

                } else if(row < 0|| row >6 || column<0 || column > 2){
                    System.out.println("");
                    System.out.println("\n****INVALID INPUT TRY AGAIN****\n");
                    continue;
                }

                item item = store.getItem(row,column);
                boolean itemReturnedValue= cart.addItem(item);// RETURN


               if(!itemReturnedValue){
                   System.out.println("you already added this product..Would you like to add it again?");
                   String secondResponse= scan.next();
                   scan.nextLine();

                   if(secondResponse.equalsIgnoreCase("yes")){
                       System.out.println(item.getName()+" product added");
                       cart.addItemCase2(item);

                   } else if(secondResponse.equalsIgnoreCase("no")){
                       System.out.println("you already have " + item.getName());
                   }
               } break;



                case "b" :
                    if(cart.isEmpty()){
                        System.out.println("Empty car");
                        continue;

                    }
                    System.out.println("\n*** Enter the item you'd like to remove ***\n");
                    String name= scan.next();
                    cart.remove(name);
                    break;

                case "c" :
                    if (cart.isEmpty()){
                        System.out.println("\n*** the cart is empty ***\n");
                        continue;
                    }
                    System.out.print(cart.checkOut());

                    // return in used to stop the loop
                    return;

            }

            System.out.println("\n\nSHOPPING CART\n\n" + cart);

            System.out.println("\n*** Enter anything to continue ***\n");
            scan.nextLine();

        }
    }


    public static void main(String[] args){

        try{
            loadItems("src/products.txt");
            manageItems();

        } catch(FileNotFoundException e){

            System.out.println(e.getMessage());
        }


        }

        public static void loadItems (String file) throws FileNotFoundException{

         FileInputStream fil= new FileInputStream(file);
            Scanner scanFile = new Scanner(fil);

            for (int i =0; scanFile.hasNextLine(); i++){
             String line = scanFile.nextLine();
             String[] items = line.split(";");

                for (int j = 0; j <items.length ; j++) {
                   String[] fields = items[j].split("=");
                   store.setItem(i,j,new item(fields[0], Double.parseDouble(fields[1])));

                }

            }
            scanFile.close();

        }



    }






