package com.oya.note.controller;

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
   @RequestMapping("/note.html")
   public String notePage() {
      return "note/note";
   }
}
