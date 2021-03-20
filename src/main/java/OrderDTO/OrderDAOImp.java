package OrderDTO;

import java.sql.SQLException;

public class OrderDAOImp implements  OrderDao{

    @Override
    public int createOrder(Order order) throws SQLException {
        return 0;
    }

    @Override
    public Order read(int d) throws SQLException {
        return null;
    }

    @Override
    public int delete(int id) throws SQLException {
        return 0;
    }

    @Override
    public int update(Order order) throws SQLException {
        return 0;
    }
}
