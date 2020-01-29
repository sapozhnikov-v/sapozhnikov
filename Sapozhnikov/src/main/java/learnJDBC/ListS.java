package learnJDBC;

import java.util.ArrayList;
import java.util.List;

public class ListS implements SaveRead {
    private ArrayList<Employees> arrayList = new ArrayList<>();

    @Override
    public void save(List<Employees> list) {

        arrayList.addAll(list);
    }


    @Override
    public List<Employees> read() {
        return arrayList;
    }
}
