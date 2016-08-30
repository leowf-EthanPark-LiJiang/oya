package com.oya.note.controller;

import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.oya.common.MarkDownUtil;
import com.oya.common.TimeUtil;
import com.oya.common.dto.Dto;
import com.oya.common.dto.JsonDto;
import com.oya.note.constant.NoteConstant;
import com.oya.note.domain.Note;
import com.oya.note.service.NoteService;
import com.oya.user.domain.User;
import com.oya.user.service.UserService;

/**
 * Created by baiyp on 2016/8/24.
 */
@RestController
@RequestMapping("/rest")
public class NoteRestController {

   private static final Logger LOGGER = LoggerFactory
         .getLogger(NoteRestController.class);

   @Autowired
   private NoteService noteService;

   @Autowired
   private UserService userService;

   @RequestMapping("/save.ep")
   public JsonDto save(@RequestBody NoteDto dto) {
      try {
         Note note = dto.toDomain();
         note.setUser(userService.getUserById(1));
         noteService.saveNote(note);
         return new JsonDto().formSuccessDto();
      } catch (Exception ex) {
         LOGGER.error("Save Failed!", ex);
         return new JsonDto().formFailureDto(ex);
      }
   }

   //TODO: 按照文峰要求来写单独的渲染函数
   @RequestMapping("/{userId}/report.ep")
   public JsonDto outputReport(@PathVariable long userId) {

      Map<Integer, List<Note>> notes = noteService.getNotesByUserId(userId);

      if (notes.isEmpty())
         return new ReportJsonDto("").formSuccessDto();

      User user = userService.getUserById(userId);

      StringBuilder sb = new StringBuilder();

      sb.append("# 用户信息").append("\n");
      sb.append("用户名 : ").append(user.getUsername()).append("\n");
      sb.append("E-mail : ").append(user.getEmail()).append("\n");

      String title = null;

      for (Map.Entry<Integer, List<Note>> entry : notes.entrySet()) {
         switch (entry.getKey()) {
         case NoteConstant.GAIN:
            title = "收获";
            break;
         case NoteConstant.GROWN_UP:
            title = "成长";
            break;
         case NoteConstant.INTELLIGENCE:
            title = "资质";
            break;
         case NoteConstant.PAYMENT:
            title = "付出";
            break;
         }

         if (title == null || entry.getValue().isEmpty())
            continue;

         sb.append("## ").append(title).append("\n");

         for (Note note : entry.getValue()) {
            sb.append(note.getPrizeGrade()).append(" *")
                  .append(note.getRecordDate()).append("*\n");
            sb.append("**获奖描述**: ").append(note.getPrizeDesc()).append("\n");
            sb.append("---\n");
         }
      }

      String result = MarkDownUtil.toHtml(sb.toString());

      return new ReportJsonDto(result).formSuccessDto();
   }

   private static class ReportJsonDto extends JsonDto {
      private String content;

      public ReportJsonDto(String content) {
         this.content = content;
      }

      public String getContent() {
         return content;
      }

      public void setContent(String content) {
         this.content = content;
      }
   }

   public static class NoteDto implements Dto {
      private int type;
      private String prizeGrade;
      private String prizeDesc;

      public int getType() {
         return type;
      }

      public void setType(int type) {
         this.type = type;
      }

      public String getPrizeGrade() {
         return prizeGrade;
      }

      public void setPrizeGrade(String prizeGrade) {
         this.prizeGrade = prizeGrade;
      }

      public String getPrizeDesc() {
         return prizeDesc;
      }

      public void setPrizeDesc(String prizeDesc) {
         this.prizeDesc = prizeDesc;
      }

      public Note toDomain() {
         Note note = new Note();
         note.setPrizeDesc(prizeDesc);
         note.setPrizeGrade(prizeGrade);
         note.setType(type);
         note.setRecordDate(TimeUtil.now());
         return note;
      }
   }
}
