package xpay

/**
  * Created by aworton on 21/02/17.
  */
class payDAdaptor(instance: PayD) extends Xpay{

  override def getCreditCardNo: String = instance.getCustCardNo

  override def setCreditCardNo(creditCardNo: String): Unit = instance.setCustCardNo(creditCardNo)

  override def getCustomerName: String = instance.getCardOwnerName

  override def setCustomerName(customerName: String): Unit = instance.setCardOwnerName(customerName)

  override def getCardExpMonth: String = getMonthFromMonthDate(instance.getCardExpMonthDate)

  override def setCardExpMonth(cardExpMonth: String): Unit = {
    val newYear = getYearFromMonthDate(instance.getCardExpMonthDate)
    instance.setCardExpMonthDate(cardExpMonth + "/" + newYear)
  }

  override def getCardExpYear: String = getYearFromMonthDate(instance.getCardExpMonthDate)

  override def setCardExpYear(cardExpYear: String): Unit = {
    val newMonth = getMonthFromMonthDate(instance.getCardExpMonthDate)
    instance.setCardExpMonthDate(newMonth + "/" + cardExpYear)
  }

  override def getCardCVVNo: Short = instance.getCVVNo.toShort

  override def setCardCVVNo(cardCVVNo: Short): Unit = instance.setCVVNo(cardCVVNo.toInt)

  override def getAmount: Double = instance.getTotalAmount

  override def setAmount(amount: Double): Unit = instance.setTotalAmount(amount)

  def getMonthFromMonthDate(monthDate: String): String = monthDate.substring(0, 2)
  def getYearFromMonthDate(monthDate: String): String = monthDate.substring(3, 5)
}
