package learnJDBC;

import java.util.ArrayList;
import java.util.List;

public class SaveToList implements Save {
    private ArrayList<Employees> arrayList = new ArrayList<>();

    @Override
    public void save(List<Employees> list) {

        arrayList.addAll(list);
    }

    ArrayList<Employees> getArrayList() {
        return arrayList;
    }
}
