package OrderBO;

import OrderDTO.Order;

public interface OrderBusiness {

    boolean placeOrder(Order order) throws BOException;
    boolean cancelOrder(int id)throws BOException;
    boolean deleteOrder(int id)throws BOException;
}
