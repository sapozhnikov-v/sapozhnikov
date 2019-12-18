package learnJDBC;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public interface Save {
    void save(List<Employees> list) throws IOException, SQLException;
}
