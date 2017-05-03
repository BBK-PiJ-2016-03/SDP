package proxy.virtualproxy

case class Employee(
  var employeeName: String,
  var employeeSalary: Double,
  var employeeDesignation: String
) {

  override def toString(): String = {
    s"Employee Name: $employeeName, " +
    s"EmployeeDesignation: $employeeDesignation, " +
    s"Employee Salary: $employeeSalary"
  }
}
