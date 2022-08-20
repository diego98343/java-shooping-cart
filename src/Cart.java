import java.util.ArrayList;

public class Cart {
     ArrayList<item> items;


// constructor is empty because the arrayList from above is empty from the beguining
    public Cart(){
       this.items= new ArrayList<item>();
    }

    public boolean isEmpty(){
        return this.items.isEmpty();
    }



    public ArrayList<item> itemsWholeThing(){
        return this.items;
    }

    public item getItemFromItems(int index){
        return new item(this.items.get(index));
    }


    public item setItemFromItems(int index, item item){
        return this.items.set(index,new item(item));
    }


    public boolean addItem(item item) {
        if( this.items.contains(item)){
            return false;
        }

        this.items.add(new item(item));
        return true;
    }

    public void addItemCase2(item item){
        this.items.add(new item(item));
    }


    public void remove (String name){
        if(items.isEmpty()){
            throw new IllegalStateException("you cannot remove items from an empty car");
        }
        for (int i = 0; i <items.size() ; i++) {
            if(this.items.get(i).getName().equals(name)){
              this.items.remove(i);
            }
        }
    }

    public String checkOut(){

        if(items.isEmpty()){
            throw new IllegalStateException("Cannot check out an empty cart");
        }
        double[] measure = new double[3];
        for (int i = 0; i <this.items.size(); i++) {
            measure[0] += this.items.get(i).getPrice();
        }
        measure[1] = measure[0]* 0.13;
        // BELOW WE RETURN THE TOTAL + TAX
        measure[2]= measure[0]+measure[1];

        return  "\tRECEIPT\n\n" +
                "\tSubtotal: $" + measure[0] + "\n" +
                "\tTax: $" + measure[1] + "\n" +
                "\tTotal: $" + measure[2] + "\n";
    }



    public String toString(){
        String temp="";
        for (int i = 0; i <items.size() ; i++) {
           temp += this.items.get(i).toString();
           temp += "";
        }

        return  temp;
    }


}
