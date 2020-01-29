package learnJDBC;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

public interface SaveRead {
    void save(List<Employees> list) throws IOException, SQLException;

    List<Employees> read() throws IOException, SQLException;
}
