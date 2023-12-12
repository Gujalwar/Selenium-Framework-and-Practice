package pom.eurotech.test.day14_PropertiesFile_Singleton;

public class Singleton {

  private Singleton() {
  }

  private static String str;

  public static String getInstance(){
    if (str==null){
      System.out.println("str is null, assign a value to it");
      str="some value";
    }else {
      System.out.println("it has value, just return the value");
    }
    return str;
  }
}
