package com.oya.note.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.oya.common.dto.JsonDto;

/**
 * Created by baiyp on 2016/8/24.
 */
@RestController
@RequestMapping
public class NoteController {

   @RequestMapping("/save.ep")
   public JsonDto save() {
      return JsonDto.successDto();
   }

   @RequestMapping("/report.ep")
   public JsonDto outputReport() {
      return JsonDto.successDto();
   }
}
