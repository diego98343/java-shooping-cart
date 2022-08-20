public class item {

    private String name;
    private double price;


    public item(String name,double price){
        if (name == null || name.isBlank()){
            throw new IllegalArgumentException("name cannot be null");
        } else if ( price< 0) {
            throw new IllegalArgumentException("price cannot be below 0");
        }

        this.name = name;
        this.price = price;
    }

    public item(item source){
        this.name= source.name;
        this.price= source.price;
    }

    public String setName(String name){
        if( name== null){
            throw new IllegalArgumentException("name cannot be null");
        }
        return this.name= name;
    }


    public double setPrice(double price){
         if( price <0){
             throw new IllegalArgumentException(" price cannot be below 0");
         }
        return this.price = price;
    }

    public String getName(){

        return this.name;
    }

    public double getPrice(){
        return this.price;
    }

    public String  toString(){
        return this.name + ": $" + this.price + " ";
    }


    public boolean equals(Object obj){
        if(obj == null){
            return false;
        }
        if ( !(obj instanceof item)) {
            return false;
        }

        item item= (item)obj;
        return this.name.equals(item.name) && this.price == item.price;
    }

}
