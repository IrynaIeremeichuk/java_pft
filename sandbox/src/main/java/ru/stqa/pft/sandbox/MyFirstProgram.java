package ru.stqa.pft.sandbox;

public class MyFirstProgram {

	public static void main(String[] args) {
    hello("world");
    hello("user");
    hello("Iriska");

    Square s = new Square(5);
    System.out.println("Площадь квадрата со стороной " + s.l + " = " + area(s));

    Rectangle t = new Rectangle(4, 6);
    System.out.println("Площадь прямоугольника со сторонами " + t.a + " и "+ t.b + " = " + area(t));

    Point a = new Point (1, 2);
    Point b = new Point (3, 4);
    System.out.println("Расстояние между точками = " + distance(a, b));
  }

	public static void hello(String somebody) {
    System.out.println("Hello, " + somebody + "!");
  }
  public static double area(Square s) {
    return s.l * s.l;
  }
  public static double area(Rectangle t) {
    return t.a * t.b;
  }
  public static double distance(Point a, Point b) {
    return Math.sqrt((b.x - a.x)*(b.x - a.x) + (b.y - a.y)*(b.y - a.y));
  }
} 