package com.oya.common.dto;

import com.oya.note.constant.NoteConstant;

/**
 * Created by baiyp on 2016/8/24.
 */
public class JsonDto implements Dto {
   private int resultCode;
   private String resultMessage;

   public int getResultCode() {
      return resultCode;
   }

   public void setResultCode(int resultCode) {
      this.resultCode = resultCode;
   }

   public String getResultMessage() {
      return resultMessage;
   }

   public void setResultMessage(String resultMessage) {
      this.resultMessage = resultMessage;
   }

   public static JsonDto successDto() {
      JsonDto dto = new JsonDto();
      dto.setResultCode(NoteConstant.SUCCESS_CODE);
      dto.setResultMessage(NoteConstant.SUCCESS_MESSAGE);
      return dto;
   }
}
