package com.oya.note.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Author: EthanPark <br/>
 * Date: 2016/8/30<br/>
 * Email: byp5303628@hotmail.com
 */
@Controller
@RequestMapping("/note")
public class NotePageController {

   private static final Logger LOGGER = LoggerFactory
         .getLogger(NotePageController.class);

   @RequestMapping("/note.html")
   public String notePage() {
      LOGGER.info("Enter into note.html");
      return "note/note";
   }
}
