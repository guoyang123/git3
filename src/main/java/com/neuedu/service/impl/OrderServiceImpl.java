package com.neuedu.service.impl;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.logging.log4j.core.config.Order;

import com.neuedu.consts.OrderStatusEnum;
import com.neuedu.dao.CartDao;
import com.neuedu.dao.ProductDao;
import com.neuedu.dao.UserOrderDao;
import com.neuedu.dao.UserOrderItemDao;
import com.neuedu.dao.impl.CartDaoImpl;
import com.neuedu.dao.impl.OrderDaoImpl;
import com.neuedu.dao.impl.ProductDaoImpl;
import com.neuedu.dao.impl.UserOrderItemDaoImpl;
import com.neuedu.entity.Cart;
import com.neuedu.entity.PageModel;
import com.neuedu.entity.Product;
import com.neuedu.entity.UserOrder;
import com.neuedu.entity.UserOrderItem;
import com.neuedu.entity.vo.OrderVO;
import com.neuedu.exception.CartDaoException;
import com.neuedu.exception.OrderDaoException;
import com.neuedu.exception.UserOrderItemDaoException;
import com.neuedu.service.IOrderService;

/**
 * ����ҵ���߼�������
 * */
public class OrderServiceImpl implements IOrderService {
 
	private CartDao  cartDao=new CartDaoImpl();
	private ProductDao productDao=new ProductDaoImpl();
	private UserOrderDao orderDao=new OrderDaoImpl();
	private UserOrderItemDao userOrderItemDao=new UserOrderItemDaoImpl();
	@Override
	public Order createOrder(Integer user_id, HttpServletRequest request) throws OrderDaoException {
		// TODO Auto-generated method stub
		//step1:��ȡ��ַid
		String shipping_id=request.getParameter("shipping_id");
		if(shipping_id==null|| shipping_id.equals("")) {
			throw  new OrderDaoException("�������͵�ַ����!!!");
		}
		
		Integer _shipping_id=null;
		try {
			_shipping_id=Integer.parseInt(shipping_id);
		}catch(NumberFormatException e) {
			e.printStackTrace();
			throw new OrderDaoException("��ַId���ݲ���ȷ!!!");
		}
		
		//step2:��ѯ�û��µ�����Ʒ���ӹ��ﳵ��ȡ
		List<Cart> carts=cartDao.findCartListByUserid(user_id);
		
		//step3:��ȡ������ϸ
		List<UserOrderItem> userorderitems= convertCartToUserOrderItems(user_id,carts);
		
		//step4:���㶩���ܼ۸�
		BigDecimal totalPriceDecimal=getTotalPrice(userorderitems);
		
		//step4: ��������
		
		UserOrder order=createOrder(user_id, _shipping_id,totalPriceDecimal);
		if(order!=null) {//�����ɹ����뵽���ݿ�
			//��������ϸ���뵽���ݿ�
			addOrderItemToDB(order,userorderitems);
			
		}
	
		 //step5:������Ʒ���
		 
		for(UserOrderItem orderItem:userorderitems) {
			productDao.reduceProductStock(orderItem.getProduct_id(), orderItem.getQuantity());
		}
		
		//step6:��չ��ﳵ
		cartDao.deleteCheckedProductByUserid(user_id);
		
		//step7��������ϸ��Ϣ
		return null;
	}

	/**
	 * �����ﳵcart-->������ϸUserOrderItem 
	 * */
	private  List<UserOrderItem> convertCartToUserOrderItems(Integer user_id,List<Cart> carts){
		
		List<UserOrderItem> list=new ArrayList<UserOrderItem>();
		for(Cart cart:carts) {
			UserOrderItem orderItem=new UserOrderItem();
			//����product_id��ȡ��Ʒ��Ϣ
			Product product=productDao.findProductById(cart.getProduct_id());
			if(product!=null) {
				orderItem.setProduct_id(cart.getProduct_id());
				orderItem.setProduct_image(product.getMain_image());
				orderItem.setProduct_name(product.getName());
				orderItem.setCurrent_unit_price(product.getPrice());
				
				//������Ʒ�ܵļ۸�
				orderItem.setQuantity(cart.getQuantity());
			//	double _totalprice=( product.getPrice().doubleValue())*cart.getQuantity();
				BigDecimal _totalprice=new BigDecimal("0");
				_totalprice=orderItem.getCurrent_unit_price().multiply(new BigDecimal(cart.getQuantity()));
				orderItem.setTotal_price(_totalprice);
				
				orderItem.setUser_id(user_id);
				list.add(orderItem);
			}
			
		}
		
		
		return  list;
	}
	
	
	/**
	 * ��������
	 * */
	
	private UserOrder createOrder(Integer user_id,Integer shipping_id,BigDecimal payment) {
		UserOrder order=new UserOrder();
		//������
		order.setOrder_no(generateOrderNo());
		//user_id
		order.setUser_id(user_id);
		//�ջ���ַ
		order.setShipping_id(shipping_id);
		//�����ܽ��
		order.setPayment(payment);
		order.setPayment_type(1);
		order.setPostage(0);
		//���ö���״̬
		order.setStatus(OrderStatusEnum.UNPAY.getStatus());
		
		//���������뵽���ݿ�
		int row=orderDao.addOrder(order);
		if(row>0) {//����ɹ�
			return order;
		}else {
			throw new OrderDaoException("��������ʧ��!!!");
		}
		
		
	}

	/**
	 * ���ɶ������
	 * */
	private long  generateOrderNo() {
		
		return  System.currentTimeMillis()+(int)(Math.random()*100);
	}
	
	
	/**
	 * ����۸�
	 * */
	
	private  BigDecimal  getTotalPrice(List<UserOrderItem> orderItems) {
		
		BigDecimal bigDecimal=new BigDecimal("0");
		
		for(UserOrderItem orderItem:orderItems) {
			bigDecimal=bigDecimal.add(orderItem.getTotal_price());
		}
		
		return  bigDecimal;
		
	}
	
	/**
	 * ��������ϸ���뵽���ݿ�
	 * */
  private  int  addOrderItemToDB(UserOrder order,List<UserOrderItem> orderItems) {
	  
	  //Ϊÿһ��������ϸ��Ӷ�����
	  for(UserOrderItem orderItem:orderItems) {
		  orderItem.setOrder_no(order.getOrder_no());
		  //�ж���Ʒ����Ƿ����
		  long stock=productDao.getProductStock(orderItem.getProduct_id());
		  if(stock<orderItem.getQuantity()) {//��治��
			  throw  new UserOrderItemDaoException("��治��!!!");
		  }
	  }
	  //��������ϸ���뵽���ݿ�
	 return  userOrderItemDao.addBatch(orderItems);
	  
  }

	@Override
	public PageModel<OrderVO> findUserOrderByPage(Integer userid, HttpServletRequest request)
			throws OrderDaoException {
		// TODO Auto-generated method stub
		String pageNo=request.getParameter("pageNo");
		String pageSize=request.getParameter("pageSize");
		Integer _pageNo=0;
		Integer _pageSize=0;
		
		if(pageNo==null||pageSize==null) {
			throw new OrderDaoException("��ҳ��ѯ���������봫��pageSize��pageNo");
		}
		
		
		try {
		_pageNo=Integer.parseInt(pageNo);
		_pageSize=Integer.parseInt(pageSize);
		}catch(NumberFormatException e) {
			e.printStackTrace();
			throw new CartDaoException("��ҳ��ȡ�������ݣ�PageNo����pageSize���󣡣���");
		}
		
	     PageModel<UserOrder>  pageModel=orderDao.findUserOrderByPage(userid, _pageNo, _pageSize);
		
	     return convertUserOrderToOrderVo(pageModel);
	     
	     
		
	}  
	
	
	
	/**
	 * ��UserOrder-->OrderVO
	 * 
	 * */
	
	private  PageModel<OrderVO>  convertUserOrderToOrderVo( PageModel<UserOrder>  pageModel) {
		PageModel<OrderVO> _pageModel=new PageModel<OrderVO>();
		
		if(pageModel!=null) {
			List<OrderVO> list=new ArrayList<OrderVO>();
			List<UserOrder> orders=pageModel.getData();
			for(UserOrder order:orders) {
				OrderVO orderVo=new OrderVO();
			    orderVo.convertUserOrderToOrderVo(order);	
			    list.add(orderVo);
			}
		  _pageModel.setTotalPage(pageModel.getTotalPage());
		  _pageModel.setData(list);
		}
		return _pageModel;
	}
	
	
	
	
	
	
	
	
}
