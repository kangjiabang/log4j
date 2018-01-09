package com.kang.log4j.core;

import java.util.LinkedList;
import java.util.List;

/**
 * @Author：zeqi
 * @Date: Created in 21:42 8/1/18.
 * @Description:
 */
public class RootLogger extends  Logger  {

   public RootLogger(Level level) {
       super("root");
       this.setLevel(level);
   }

}
