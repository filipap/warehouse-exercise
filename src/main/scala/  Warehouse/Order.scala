package Warehouse

import java.time.LocalDateTime

class Order (
    var customerName: String, 
    var contact: String,
    var shippingAddress: String,
    var grandTotal: BigDecimal,
    var dateOrder: LocalDateTime,
    var items: Set[Item]) {
}