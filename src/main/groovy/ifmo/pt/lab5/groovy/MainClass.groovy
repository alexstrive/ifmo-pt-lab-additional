package ifmo.pt.lab5.groovy

def java = new JavaClass()

// Lesson 1
println "Welcome, Groovy"

try {
  def firstClassGeneratedThroughNamedParameters = new FirstClass(id:1, title:"John", isBlocked:false, rating:32.2f) // illegal when constructur is defined
} catch (Exception e) {
  println "Unable to create FirstClass instance through named parameters"
}


def firstClassGeneratedThroughConstructor = new FirstClass(1, "John", false, 32.2f)

def firstClassValues = new Binding(id: 2, title: "Will")

firstClassGeneratedThroughConstructor.setId(firstClassValues.getVariable('id'))
firstClassGeneratedThroughConstructor.setTitle(firstClassValues.getVariable('title'))

println "New id for FirstClass ${firstClassGeneratedThroughConstructor.id}"

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

def firstDate = Date.parse('1973/07/21')

// Lesson 3
def division = { a, b -> a / b }
println "15 / 3 = ${division(15, 3)}"
println "3 / 15 = ${division(3, 15)}"

def substraction = { d, c -> d - c }
println "33 - 6 = ${substraction(33, 6)}"

def combined = { a, b, c -> substraction(division(a, b), c) }
println "15 / 3 - 10 = ${combined(15, 3, 10)}"

// Lesson 4