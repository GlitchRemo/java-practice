package com.tw.step;

public class OuterClass {
//  public void staticFunction() {
//    class LocalClass {
//      public static void anotherStaticFunction() {
//        System.out.println("Inside static function of local class");
//      }
//    }
//
//    LocalClass.anotherStaticFunction();
//  }

  public void sayGoodbyeInEnglish() {
    class EnglishGoodbye {
      public static void sayGoodbye() {
        System.out.println("Bye bye");
      }
    }
    EnglishGoodbye.sayGoodbye();
  }
}
