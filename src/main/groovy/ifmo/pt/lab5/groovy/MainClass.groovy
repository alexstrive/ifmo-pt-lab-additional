package ifmo.pt.lab5.groovy

import groovy.time.TimeCategory
import java.time.*
import java.util.*

def java = new JavaClass()

// Lesson 1
println "Welcome, Groovy"

try {
  def firstClassGeneratedThroughNamedParameters = new FirstClass(id:1, title:"John", isBlocked:false, rating:32.2f) // illegal when constructur is defined
} catch (Exception e) {
  println "Unable to create FirstClass instance through named parameters"
}

def firstClassGeneratedThroughConstructor = new FirstClass(1, "John", false, 32.2f)

def firstClassWithBindings = new FirstClass()
println firstClassWithBindings.binding.title

println "Integer instanceof String: ${5 instanceof String}"
println "String instanceof Integer ${"" instanceof Integer}"

java.instanceOfExample()

println "Method with final value without return: ${firstClassGeneratedThroughConstructor.getId()}"

// Lesson 2

int methodReturnsInt(Integer a) { a }

Integer methodReturnsInteger(Integer a) { a }

try {
  println methodReturnsInt(null)
} catch (Exception e) {
  println "Method which returns int has failed"
}

try {
  println methodReturnsInteger(null)
} catch (Exception e) {
  println "Method which returns Integer has failed"
}

def bigDecimalFirst = new BigDecimal(5)
def bigDecimalSecond = new BigDecimal(5)

println "System.identityHashCode(bigDecimalFirst) = ${System.identityHashCode(bigDecimalFirst)}"
println "System.identityHashCode(bigDecimalSecond) = ${System.identityHashCode(bigDecimalSecond)}"
println "Are objects at the same memory address? ${System.identityHashCode(bigDecimalFirst) == System.identityHashCode(bigDecimalSecond)}"

println "bigDecimalFirst.equals(bigDecimalSecond) = ${bigDecimalFirst.equals(bigDecimalSecond)}"
println "bigDecimalFirst == bigDecimalSecond = ${bigDecimalFirst == bigDecimalSecond}"
println "bigDecimalFirst.compareTo(bigDecimalSecond) = ${bigDecimalFirst.compareTo(bigDecimalSecond)}"
println "bigDecimalFirst.add(bigDecimalSecond) = ${bigDecimalFirst.add(bigDecimalSecond)}"
println "bigDecimalFirst + bigDecimalSecond = ${bigDecimalFirst + bigDecimalSecond}"
println "bigDecimalFirst.divide(bigDecimalSecond) = ${bigDecimalFirst.divide(bigDecimalSecond)}"
println "bigDecimalFirst / bigDecimalSecond = ${bigDecimalFirst / bigDecimalSecond}"
println "bigDecimalFirst.multiply(bigDecimalSecond) = ${bigDecimalFirst.multiply(bigDecimalSecond)}"
println "bigDecimalFirst * bigDecimalSecond = ${bigDecimalFirst * bigDecimalSecond}"

java.bigDecimalExample()

def exampleVariable = "first"
println "exampleVariable type: ${exampleVariable.getClass()}"
exampleVariable = 10
println "exampleVariable type: ${exampleVariable.getClass()}"
exampleVariable = 'f'
println "exampleVariable type: ${exampleVariable.getClass()}"

Date firstDate = new GregorianCalendar(2015, Calendar.FEBRUARY, 28).getTime();
Date secondDate = new GregorianCalendar(2015, Calendar.JANUARY, 31).getTime();

println firstDate
println secondDate
def dateDifference = firstDate.getTime() - secondDate.getTime()

println "firstDate - secondDate ${dateDifference}"

use(TimeCategory) {
  def firstDateMinusMonth = firstDate - 1.month

  println firstDateMinusMonth

  def firstDateMinusMonthPlusMonthAndDay = firstDateMinusMonth + 1.month + 1.day

  println firstDateMinusMonthPlusMonthAndDay
}

// Lesson 3
def division = { a, b -> a / b }
println "15 / 3 = ${division(15, 3)}"
println "3 / 15 = ${division(3, 15)}"

def substraction = { d, c -> d - c }
println "33 - 6 = ${substraction(33, 6)}"

def combined = { a, b, c -> substraction(division(a, b), c) }
println "15 / 3 - 10 = ${combined(15, 3, 10)}"

// Lesson 4
def db = [url: "jdbc:postgresql://localhost/mpa", user: "postgres", password: "password"]
def sql = groovy.sql.Sql.newInstance(db.url, db.user, db.password, "org.postgresql.Driver")
def rows = sql.rows('select * from patient')

println rows.join('\n')
assert rows.size() == 6