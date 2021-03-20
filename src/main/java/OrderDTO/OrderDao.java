package OrderDTO;

import java.sql.SQLException;

public interface OrderDao {

    int createOrder(Order order) throws SQLException;
    Order read(int d) throws SQLException;
    int update(Order order) throws SQLException;
    int delete(int id) throws SQLException;

}
