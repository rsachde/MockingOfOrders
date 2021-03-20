package OrderBO;

import OrderDTO.Order;
import OrderDTO.OrderDAOImp;

import java.sql.SQLException;

public class OrderBusinessImpl implements OrderBusiness{

    OrderDAOImp dao;

    public OrderDAOImp getDao() {
        return dao;
    }

    public void setDao(OrderDAOImp dao) {
        this.dao = dao;
    }

    @Override
    public boolean placeOrder(Order order) throws BOException {
        try
        {
            int result=dao.createOrder(order);
            if(result==0)
            {
                return false;
            }

        } catch (SQLException throwables) {
            throw new BOException(throwables);
        }
        return true;
    }

    @Override
    public boolean cancelOrder(int id) throws BOException {
        try
        {
           Order order= dao.read(id);
           order.setStatus("cancelled");
           int result=dao.update(order);
           if(result==0)
           {
               return false;
           }


        } catch (SQLException throwables) {
            throw new BOException(throwables);
        }
        return true;
    }

    @Override
    public boolean deleteOrder(int id) throws BOException {
        try {
           int result= dao.delete(id);
           if(result==0)
           {
               return false;
           }
        }catch (SQLException e)
        {
            throw new BOException(e);
        }

        return true;
    }
}
