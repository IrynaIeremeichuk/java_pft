package ru.stqa.pft.sandbox;

import com.sun.org.apache.xpath.internal.SourceTree;

public class MyFirstProgram {

  public static void main(String[] args) {
    hello("world");
    hello("user");
    hello("Iriska");

    Square s = new Square(5);
    System.out.println("Площадь квадрата со стороной " + s.l + " = " + s.area());

    Rectangle r = new Rectangle(4, 6);
    System.out.println("Площадь прямоугольника со сторонами " + r.a + " и " + r.b + " = " + r.area());

    Point a = new Point(5, 9);
    Point b = new Point(3, 5);
    System.out.println("Расстояние между точками с координатами " + a.x + "," + a.y + " и " + b.x + "," + b.y + " = " + a.distance (b));

    }


  public static void hello(String somebody) {
    System.out.println("Hello, " + somebody + "!");
  }

}