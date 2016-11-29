package ru.stqa.pft.sandbox;

import com.sun.org.apache.xpath.internal.SourceTree;

public class MyFirstProgram {

  public static void main(String[] args) {
    hello("world");
    hello("user");
    hello("Iriska");

    Square s = new Square(5);
    System.out.println("Площадь квадрата со стороной " + s.l + " = " + area(s));

    Rectangle r = new Rectangle(4, 6);
    System.out.println("Площадь прямоугольника со сторонами " + r.a + " и " + r.b + " = " + area (r));

    Point p1 = new Point(5, 9);
    Point p2 = new Point(3, 5);
    System.out.println("Расстояние между точками с координатами " + p1.x + "," + p1.y + " и " + p2.x + "," + p2.y + " = " + distance (p1, p2));

    }


  public static void hello(String somebody) {
    System.out.println("Hello, " + somebody + "!");
  }

  public static double area(Square s) {
    return s.l * s.l;
  }
  public static double area(Rectangle r) {
    return r.a * r.b;
  }
  public static double distance(Point p1, Point p2) {
    return Math.sqrt((p2.x - p1.x) * (p2.x - p1.x) + (p2.y - p1.y) * (p2.y - p1.y));
  }
}