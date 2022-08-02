package test;

import figure.*;

public class TestFIgure {
  public static void main(String[] args)
  {
      rectangulo rect = new rectangulo("rectangulo");
      
      rect.undefine();
      System.out.println(rect.toString());
      System.out.println(rect.getFigure());
  }
}
