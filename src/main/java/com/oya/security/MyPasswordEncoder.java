package com.oya.security;

import org.springframework.security.authentication.encoding.MessageDigestPasswordEncoder;
import org.springframework.util.DigestUtils;

/**
 * Created by baiyp on 2016/8/24.
 */
public class MyPasswordEncoder extends MessageDigestPasswordEncoder {
   public MyPasswordEncoder(String algorithm) {
      super(algorithm);
   }

   @Override
   public boolean isPasswordValid(String encPass, String rawPass, Object salt) {
      return encPass.equals(DigestUtils.md5DigestAsHex(rawPass.getBytes()));
   }
}
