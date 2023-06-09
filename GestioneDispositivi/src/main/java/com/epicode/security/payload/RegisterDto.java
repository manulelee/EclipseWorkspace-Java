package com.epicode.security.payload;

import java.util.Set;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class RegisterDto {
    private String name;
    private String lastname;
    private String username;
    private String email;
    private String password;
    private Set<String> roles;
}

// Registrazione utente admin
/*  
  { 
    "name": "Emanuele",
    "lastname": "Syrbe",
    "username": "Manu.Lele",
    "email": "e.syrbe@example.com",
    "password": "qwerty",
    "roles":["ADMIN"]
    }
    
    TOKEN ADMIN: eyJhbGciOiJIUzM4NCJ9.eyJzdWIiOiJlLnN5cmJlQGV4YW1wbGUuY29tIiwiaWF0IjoxNjg2MzE1NTg2LCJleHAiOjE2ODcxNzk1ODZ9.o8yXxgm0KtMuklZt-KxHRABxDL2O_TBlVZPKXrLig2IyNK1cBJdYuI3h8bKUKPQJ
 */


//Registrazione utente user
/*  
{ 
  "name": "Emanuele",
  "lastname": "Umberto",
  "username": "Ema.Umbe",
  "email": "e.umberto@example.com",
  "password": "qwerty",
  "roles":["USER"]
  }
  
  TOKEN USER: eyJhbGciOiJIUzM4NCJ9.eyJzdWIiOiJlLnVtYmVydG9AZXhhbXBsZS5jb20iLCJpYXQiOjE2ODYzMTU1NDcsImV4cCI6MTY4NzE3OTU0N30.-kgOOWpMmE3Sz5qE4eGsxxRooOB4I2TCgZsEvPWw_WkJuRB4WBKFDj6coL-VoTzz
*/
