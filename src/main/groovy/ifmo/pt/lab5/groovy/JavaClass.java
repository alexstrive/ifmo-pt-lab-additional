package ifmo.pt.lab5.groovy;

import java.math.BigDecimal;

class JavaClass {
  void bigDecimalExample() {
    var bigDecimalFirst = new BigDecimal(5);
    var bigDecimalSecond = new BigDecimal(5);

    System.out.println("Big Decimal in Java");

    System.out.printf("bigDecimalFirst.equals(bigDecimalSecond) = %s\n", bigDecimalFirst.equals(bigDecimalSecond));
    System.out.printf("bigDecimalFirst == bigDecimalSecond = %s\n", bigDecimalFirst == bigDecimalSecond);
    System.out.printf("bigDecimalFirst.compareTo(bigDecimalSecond) = %d\n",
        bigDecimalFirst.compareTo(bigDecimalSecond));
    System.out.printf("bigDecimalFirst.add(bigDecimalSecond) = %d\n",
        bigDecimalFirst.add(bigDecimalSecond).toBigInteger());
    System.out.printf("bigDecimalFirst.multiply(bigDecimalSecond) = %d\n",
        bigDecimalFirst.multiply(bigDecimalSecond).toBigInteger());
    System.out.printf("bigDecimalFirst.divide(bigDecimalSecond) = %d\n",
        bigDecimalFirst.divide(bigDecimalSecond).toBigInteger());
    System.out.println("Operators +, /, * is undefined for BigDecimal");
  }

  void instanceOfExample() {
    System.out.println("instanceof operator in Java");

    // Illegal
    // System.out.printf("String instanceof Integer %d", "" instanceof Integer);
    // System.out.printf("Integer instanceof String %d", Integer.parseInt("5")
    // instanceof String);
    System.out.println("Unable to use instanceof for comparing");
  }
}