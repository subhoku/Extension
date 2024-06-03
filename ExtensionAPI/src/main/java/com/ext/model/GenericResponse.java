package com.ext.model;

public class GenericResponse
{
   private String id;
   private boolean success;
   private String detailMessage;
   
   public String getId()
   {
      return id;
   }
   
   public void setId(String id)
   {
      this.id = id;
   }

   public boolean isSuccess()
   {
      return success;
   }

   public void setSuccess(boolean success)
   {
      this.success = success;
   }

   public String getDetailMessage()
   {
      return detailMessage;
   }

   public void setDetailMessage(String detailMessage)
   {
      this.detailMessage = detailMessage;
   }
}
