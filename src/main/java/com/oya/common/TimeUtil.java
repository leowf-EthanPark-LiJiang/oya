package com.oya.common;

import static java.lang.System.currentTimeMillis;

import java.sql.Date;

/**
 * Author: EthanPark <br/>
 * Date: 2016/8/30<br/>
 * Email: byp5303628@hotmail.com
 */
public class TimeUtil {
   public static Date now() {
      return new Date(currentTimeMillis());
   }
}
