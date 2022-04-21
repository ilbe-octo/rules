package com.benrkia.exception;

import lombok.NoArgsConstructor;

@NoArgsConstructor
public class RuleProcessingException extends Exception {

  public RuleProcessingException(String msg) {
    super(msg);
  }
}
