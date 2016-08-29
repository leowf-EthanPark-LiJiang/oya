package com.oya.common.dto;

import com.oya.common.constant.JsonDtoFlag;
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

   public JsonDto formSuccessDto() {
      this.resultCode = JsonDtoFlag.SUCCESS_CODE;
      this.resultMessage = JsonDtoFlag.SUCCESS_MESSAGE;
      return this;
   }

   public JsonDto formFailureDto(Exception e) {
      this.resultCode = JsonDtoFlag.FAILURE_CODE;
      this.resultMessage = e.getMessage();
      return this;
   }
}
