package OrderBO;

import OrderDTO.Order;
import OrderDTO.OrderDAOImp;
import OrderDTO.OrderDao;
import junit.framework.TestCase;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;
import org.mockito.junit.jupiter.MockitoExtension;

import java.sql.SQLException;

import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class OrderBusinessImplTest extends TestCase {

    //Stub-out the dependency
    @Mock
    OrderDAOImp orderDao;

    @InjectMocks
    OrderBusinessImpl orderBusiness;

    @Before
    public void setup()
    {
        //We need this because at runtime it will scan all the references of OrderDao and mock the object
        System.out.println("Hey");
        MockitoAnnotations.initMocks(this);
        orderBusiness=new OrderBusinessImpl();
        orderBusiness.setDao(orderDao);
    }
    //Positive Test Case
    @Test
    public void testPlaceOrder() throws SQLException, BOException {
        //When is an important method which is used to mock out the object call
        Order order= new Order();
        //Set the expectations
        when(orderDao.createOrder(order)).thenReturn(new Integer(1));
        boolean results=orderBusiness.placeOrder(order);

        //Verify the results
        assertTrue(results);

        verify(orderDao.createOrder(order));
    }

    //Negative Test Case

    @Test
    public void testPlaceOrderShouldNotCreateAnOrder() throws SQLException, BOException {

        //When is an important method which is used to mock out the object call
        Order order= new Order();
        //Set the expectations
        when(orderDao.createOrder(order)).thenReturn(new Integer(0));
        boolean results=orderBusiness.placeOrder(order);

        //Verify the results
        assertFalse(results);
        verify(orderDao.createOrder(order));
    }

    @Test(expected = BOException.class)
    public void testPlaceOrderShouldThrowBOException() throws SQLException, BOException {
        Order order= new Order();
        when(orderDao.createOrder(order)).thenThrow(SQLException.class);
        boolean result=orderBusiness.placeOrder(order);


    }
    public void testCancelOrder() throws SQLException, BOException {
        Order order= new Order();
        orderDao.update(order);
        when(orderDao.read(1)).thenReturn(new Order());
        when(orderDao.update(order)).thenReturn(1);
        boolean result=orderBusiness.cancelOrder(1);
        assertTrue(result);

        verify(orderDao).read(1);
        verify(orderDao).update(order);

    }

    public void testDeleteOrder() {
    }
}