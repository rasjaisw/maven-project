package com.example;

/**
 * This is a class.
 */
public class Greeter {

  /**
   * This is a constructor.
   */
  public Greeter() {

  }

  //TODO: Add javadoc comment
  /*
  *@param: string
  *@return: string
  */
  public final String greet(final String someone) {
    return String.format("Hello, %s!", someone);
  }
}
