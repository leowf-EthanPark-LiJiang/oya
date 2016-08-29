package com.oya.note.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
@RequestMapping
public class NoteController {

   @Autowired
   private NoteService noteService;

   @Autowired
   private UserService userService;

   @RequestMapping("/save.ep")
   public JsonDto save() {
      return new JsonDto().formSuccessDto();
   }

   @RequestMapping("/{userId}/report.ep")
   public JsonDto outputReport(@PathVariable long userId) {

      Map<Integer, List<Note>> notes = noteService.getNotesByUserId(userId);

      if (notes.isEmpty())
         return new ReportJsonDto("").formSuccessDto();

      User user = userService.getUserById(userId);

      StringBuilder sb = new StringBuilder();

      sb.append("# UserInfo").append("\n");
      sb.append("User : ").append(user.getUsername()).append("\n");
      sb.append("Email : ").append(user.getEmail()).append("\n");

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

         sb.append("# ").append(title).append("\n");

         for (Note note : entry.getValue()) {
            sb.append(note.getPrizeGrade()).append(" ")
                  .append(note.getRecordDate()).append("\n");
            sb.append(note.getPrizeDesc()).append("\n");
            sb.append("---\n");
         }
      }

      return new ReportJsonDto(sb.toString()).formSuccessDto();
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
}
