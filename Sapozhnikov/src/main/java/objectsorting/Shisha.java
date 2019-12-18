package objectsorting;

public abstract class Shisha {
   public abstract int getWeight ();
   public int getCupWeight (){
       return 10;
   }
   public abstract double getRating();

    public String smoke() {
        return "Буль-буль ";
    }
}
