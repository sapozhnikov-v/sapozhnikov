package learnJDBC;


public class ReadFromList implements Read {

    private SaveToList list = new SaveToList();

    @Override
    public void read() {
        System.out.println(list.getArrayList());
    }
}

