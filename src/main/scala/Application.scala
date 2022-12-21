//package orders_tool
import scala.collection.Map
import scala.collection.mutable.HashMap
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter
import scala.collection.mutable.LinkedHashMap

object Application {
  
	def main(args: Array[String]): Unit = {
		
		var result: HashMap[String,Int] = new HashMap[String, Int]()
		val service : OrdersService = new OrdersService()
		if (args.length == 1) {
				var months: Array[String] = args(0).split("-")
				println("**** Group: " + args(0))
				result = filterByMonthsInterval(months(0), months(1))
			} else if (args.length > 1) {
			println("**** All Groups")
			result = filterByDateInterval(args(0), args(1))
			}
		
		if (!result.isEmpty) {
			result.foreach(res => println(res))
		} else {
			println("Not found")
		}
	}
	
	private def filterByMonthsInterval(init: String, end: String): HashMap[String,Int] =
			try {
					val initMonth: Integer = int2Integer(Integer.parseInt(init))
						val endMonth: Integer = int2Integer(Integer.parseInt(end))
						if (initMonth > endMonth) {
							null
						}
						val service: OrdersService = new OrdersService()
						service.filterOrdersBySpecificInterval(initMonth, endMonth)
			} catch {
			case e: NumberFormatException => {
				println("*** error: cannot parse string to integer. More info: "+ e.getMessage)
				null
			}

			}
		  
	private def filterByDateInterval(dateInitStr: String, dateEndStr: String): HashMap[String,Int] =
		  try {
		    val dateInit : LocalDateTime = convertStrToDate(dateInitStr)
    		val dateEnd: LocalDateTime = convertStrToDate(dateEndStr)
		    val service: OrdersService = new OrdersService()
		    service.filterAllOrders(dateInit, dateEnd)
		  } catch {
		  case e: NumberFormatException => {
			  println("*** error: cannot parse string to integer. More info: "+ e.getMessage)
			  null
		  }

		  }
		  
	def convertStrToDate(dateStr: String) : LocalDateTime = {
	  val formatter : DateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")
		LocalDateTime.parse(dateStr, formatter)
	}
  
}
