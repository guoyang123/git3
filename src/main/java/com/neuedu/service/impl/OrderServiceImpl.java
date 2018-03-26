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
 * 订单业务逻辑处理类
 * */
public class OrderServiceImpl implements IOrderService {
 
	private CartDao  cartDao=new CartDaoImpl();
	private ProductDao productDao=new ProductDaoImpl();
	private UserOrderDao orderDao=new OrderDaoImpl();
	private UserOrderItemDao userOrderItemDao=new UserOrderItemDaoImpl();
	@Override
	public Order createOrder(Integer user_id, HttpServletRequest request) throws OrderDaoException {
		// TODO Auto-generated method stub
		//step1:获取地址id
		String shipping_id=request.getParameter("shipping_id");
		if(shipping_id==null|| shipping_id.equals("")) {
			throw  new OrderDaoException("订单配送地址必填!!!");
		}
		
		Integer _shipping_id=null;
		try {
			_shipping_id=Integer.parseInt(shipping_id);
		}catch(NumberFormatException e) {
			e.printStackTrace();
			throw new OrderDaoException("地址Id传递不正确!!!");
		}
		
		//step2:查询用户下单的商品，从购物车获取
		List<Cart> carts=cartDao.findCartListByUserid(user_id);
		
		//step3:获取订单明细
		List<UserOrderItem> userorderitems= convertCartToUserOrderItems(user_id,carts);
		
		//step4:计算订单总价格
		BigDecimal totalPriceDecimal=getTotalPrice(userorderitems);
		
		//step4: 创建订单
		
		UserOrder order=createOrder(user_id, _shipping_id,totalPriceDecimal);
		if(order!=null) {//订单成功插入到数据库
			//将订单明细插入到数据库
			addOrderItemToDB(order,userorderitems);
			
		}
	
		 //step5:减少商品库存
		 
		for(UserOrderItem orderItem:userorderitems) {
			productDao.reduceProductStock(orderItem.getProduct_id(), orderItem.getQuantity());
		}
		
		//step6:清空购物车
		cartDao.deleteCheckedProductByUserid(user_id);
		
		//step7：订单详细信息
		return null;
	}

	/**
	 * 将购物车cart-->订单明细UserOrderItem 
	 * */
	private  List<UserOrderItem> convertCartToUserOrderItems(Integer user_id,List<Cart> carts){
		
		List<UserOrderItem> list=new ArrayList<UserOrderItem>();
		for(Cart cart:carts) {
			UserOrderItem orderItem=new UserOrderItem();
			//根据product_id获取商品信息
			Product product=productDao.findProductById(cart.getProduct_id());
			if(product!=null) {
				orderItem.setProduct_id(cart.getProduct_id());
				orderItem.setProduct_image(product.getMain_image());
				orderItem.setProduct_name(product.getName());
				orderItem.setCurrent_unit_price(product.getPrice());
				
				//计算商品总的价格
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
	 * 创建订单
	 * */
	
	private UserOrder createOrder(Integer user_id,Integer shipping_id,BigDecimal payment) {
		UserOrder order=new UserOrder();
		//订单号
		order.setOrder_no(generateOrderNo());
		//user_id
		order.setUser_id(user_id);
		//收货地址
		order.setShipping_id(shipping_id);
		//订单总金额
		order.setPayment(payment);
		order.setPayment_type(1);
		order.setPostage(0);
		//设置订单状态
		order.setStatus(OrderStatusEnum.UNPAY.getStatus());
		
		//将订单插入到数据库
		int row=orderDao.addOrder(order);
		if(row>0) {//插入成功
			return order;
		}else {
			throw new OrderDaoException("订单插入失败!!!");
		}
		
		
	}

	/**
	 * 生成订单编号
	 * */
	private long  generateOrderNo() {
		
		return  System.currentTimeMillis()+(int)(Math.random()*100);
	}
	
	
	/**
	 * 计算价格
	 * */
	
	private  BigDecimal  getTotalPrice(List<UserOrderItem> orderItems) {
		
		BigDecimal bigDecimal=new BigDecimal("0");
		
		for(UserOrderItem orderItem:orderItems) {
			bigDecimal=bigDecimal.add(orderItem.getTotal_price());
		}
		
		return  bigDecimal;
		
	}
	
	/**
	 * 将订单明细插入到数据库
	 * */
  private  int  addOrderItemToDB(UserOrder order,List<UserOrderItem> orderItems) {
	  
	  //为每一个订单明细添加订单号
	  for(UserOrderItem orderItem:orderItems) {
		  orderItem.setOrder_no(order.getOrder_no());
		  //判断商品库存是否充足
		  long stock=productDao.getProductStock(orderItem.getProduct_id());
		  if(stock<orderItem.getQuantity()) {//库存不足
			  throw  new UserOrderItemDaoException("库存不足!!!");
		  }
	  }
	  //将订单明细插入到数据库
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
			throw new OrderDaoException("分页查询订单，必须传递pageSize和pageNo");
		}
		
		
		try {
		_pageNo=Integer.parseInt(pageNo);
		_pageSize=Integer.parseInt(pageSize);
		}catch(NumberFormatException e) {
			e.printStackTrace();
			throw new CartDaoException("分页获取订单数据，PageNo或者pageSize有误！！！");
		}
		
	     PageModel<UserOrder>  pageModel=orderDao.findUserOrderByPage(userid, _pageNo, _pageSize);
		
	     return convertUserOrderToOrderVo(pageModel);
	     
	     
		
	}  
	
	
	
	/**
	 * 将UserOrder-->OrderVO
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
