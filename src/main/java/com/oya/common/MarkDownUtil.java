package com.oya.common;

import org.pegdown.Extensions;
import org.pegdown.PegDownProcessor;

/**
 * Author: EthanPark <br/>
 * Date: 2016/8/30<br/>
 * Email: byp5303628@hotmail.com
 */
public class MarkDownUtil {
   public static String toHtml(String s) {
      PegDownProcessor pegDownProcessor = new PegDownProcessor(Extensions.ALL);
      return pegDownProcessor.markdownToHtml(s);
   }
}
