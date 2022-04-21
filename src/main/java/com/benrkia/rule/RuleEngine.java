package com.benrkia.rule;

import com.benrkia.exception.RuleProcessingException;

import java.util.List;

public class RuleEngine {

  public static <T, R> void process(
      List<? extends Rule<T, R>> rules,
      T t, R r) throws RuleProcessingException {
    Rule<T, R> matchedRule = rules.stream()
        .filter(rule -> rule.shouldProcess(t))
        .findFirst()
        .orElseThrow(RuleProcessingException::new);

    matchedRule.process(r);
  }
}
