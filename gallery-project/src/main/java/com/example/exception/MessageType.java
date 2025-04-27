package com.example.exception;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;


@Getter
public enum MessageType {
    NO_RECORD_EXIST("1004", "Kayıt Bulunamadı"),
    TOKEN_IS_EXPIRED("1005", "Tokenin süresi bitmiştir"),
    USERNAME_NOT_FOUND("1006", "Username bulunamadı"),
    USERNAME_OR_PASSWORD_INVALID("1007","Kullanıcı adı veya şifre hatalı"),
    REFRESH_TOKEN_NOT_FOUND("1008","Refresh token bulunamadı"),
    REFRESH_TOKEN_EXPIRED("1009","Refresh token süresi bitti"),
    GENERAL_EXCEPTION("9999", "Genel Bir hata oluştur");
    
    private String code;
    private String message;

    MessageType(String code, String message){
        this.code = code;
        this.message = message;
    }
}
