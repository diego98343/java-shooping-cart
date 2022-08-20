public class Store {
    private item[][] items;


   public Store(){
       this.items= new item[7][3];
   }

   public item getItem(int row, int column){
       return new item( this.items[row][column]);
   }

   public void setItem(int row, int column,item item){
        this.items[row][column] = new item(item);
   }


   public String toString(){
       String temp="";
       for (int i = 0; i <items.length ; i++) {
           switch (i) {
               case 0: temp += "\tDRINKS:        "; break;
               case 1: temp += "\tCEREAL:        "; break;
               case 2: temp += "\tDAIRY:         "; break;
               case 3: temp += "\tDELI:          "; break;
               case 4: temp += "\tGREENS:        "; break;
               case 5: temp += "\tCLOTHING:      "; break;
               case 6: temp += "\tELECTRONICS:   "; break;
           }
           for (int j = 0; j <items[i].length ; j++) {
               temp += items[i][j].toString();
           }
           temp+= "\n\n";
       }
       temp +="\t***************************************************";
       return temp;
   }

}
