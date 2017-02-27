package xpay

/**
  * Created by aworton on 21/02/17.
  */
class payDAdaptor(instance: PayD) extends Xpay{
  override def getCreditCardNo: String = instance.getCustCardNo

  override def setCreditCardNo(creditCardNo: String): Unit = instance.setCustCardNo(creditCardNo)

  override def getCustomerName: String = instance.getCardOwnerName

  override def setCustomerName(customerName: String): Unit = instance.setCardOwnerName(customerName)

  override def getCardExpMonth: String = instance.getCardExpMonthDate

  override def setCardExpMonth(cardExpMonth: String): Unit = instance.setCardExpMonthDate(cardExpMonth)

  override def getCardExpYear: String = instance.

  override def setCardExpYear(cardExpYear: String): Unit = ???

  override def getCardCVVNo: Short = instance.getCVVNo

  override def setCardCVVNo(cardCVVNo: Short): Unit = ???

  override def getAmount: Double = ???

  override def setAmount(amount: Double): Unit = ???
}
