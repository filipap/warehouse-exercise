import Warehouse.Product
import Warehouse.Item
import Warehouse.Order

import scala.math.BigDecimal
import java.time.LocalDateTime
import java.time.Month
import scala.collection.mutable.ArrayDeque


class OrdersGenerator {

	val SAMSUNG: String = "Samsung Galaxy S11"
	val IPHONE_14: String = "Iphone 14"
	
	def createProducts() : List[Product] = {
	  val recentDate = LocalDateTime.of(2018, Month.JANUARY, 29, 10, 30, 40)
	  val middleDate = LocalDateTime.of(2017, Month.NOVEMBER, 15, 9, 30, 40)
	  //   val farawayDate = LocalDateTime.of(2013, Month.MAY, 1, 13, 30, 40)
	  
	  val iphone = new Product(IPHONE_14, "Smartphone", recentDate, BigDecimal("1500"))
	  val samsung = new Product(SAMSUNG, "Smartphone", middleDate, BigDecimal("1805.22"))
	  
	  List(iphone, samsung)
	}
	
	private def createItems() : ArrayDeque[Item] = {
	  val products = createProducts();
	  var items = ArrayDeque[Item]()
	  products.foreach(prod => {
		val item: Item = new Item(prod.price, BigDecimal("50.0"), BigDecimal("75"), 1,prod)
		items += item
	  })
	  items
	}
	
	private def createOrdersIphone14(item: Item) : List[Order] = {
	  val date1 = LocalDateTime.of(2018, Month.FEBRUARY, 15, 15, 30, 40)
	  val order1 = new Order("Filipa", "", "", BigDecimal("2500"), date1, Set(item))
	  
	  val date2 = LocalDateTime.of(2018, Month.MARCH, 16, 14, 30, 40)
	  val order2 = new Order("João", "", "", BigDecimal("2700"), date2, Set(item))
	  
	  val date3 = LocalDateTime.of(2018, Month.MAY, 17, 13, 30, 40)
	  val order3 = new Order("Carlos", "", "", BigDecimal("2234"), date3, Set(item))
	  
	  val date4 = LocalDateTime.of(2018, Month.JULY, 18, 19, 30, 40)
	  val order4 = new Order("Ana", "", "", BigDecimal("1820.56"), date4, Set(item))
	  
	  val date5 = LocalDateTime.of(2018, Month.SEPTEMBER, 19, 11, 30, 40)
	  val order5 = new Order("Joana", "", "", BigDecimal("1901.14"), date5, Set(item))

	  
	  List(order1, order2, order3, order4, order5)
	}
	
	private def createOrdersSamsung(item: Item) : List[Order] = {
	  val date1 = LocalDateTime.of(2018, Month.FEBRUARY, 15, 15, 30, 40)
	  val order1 = new Order("Salvador", "", "", BigDecimal("1130"), date1, Set(item))
	  
	  val date2 = LocalDateTime.of(2018, Month.MARCH, 16, 14, 30, 40)
	  val order2 = new Order("Santiago", "", "", BigDecimal("1305"), date2, Set(item))
	  
	  val date3 = LocalDateTime.of(2018, Month.JUNE, 17, 13, 30, 40)
	  val order3 = new Order("Francisca", "", "", BigDecimal("1554"), date3, Set(item))
	  
	  val date4 = LocalDateTime.of(2018, Month.DECEMBER, 18, 19, 30, 40)
	  val order4 = new Order("Juliana", "", "", BigDecimal("900"), date4, Set(item))
	  
	  List(order1, order2, order3, order4)
	}
	
	
	def loadData() : List[Order] = {
	  val items = createItems()
	  var orders = List[Order]()
	  items.foreach(item => {
	    if (item.product.name.equals(IPHONE_14)) {
	    	orders ++= this.createOrdersIphone14(item)
	    } else 
	      orders ++= this.createOrdersSamsung(item)
	    }
	  )
	 println(orders)
	 orders
	}

}


