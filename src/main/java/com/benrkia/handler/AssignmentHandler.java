package com.benrkia.handler;

import com.benrkia.dto.Dto;
import com.benrkia.exception.RuleProcessingException;
import com.benrkia.rule.RuleEngine;
import com.benrkia.rule.assignment.AssignmentRule;
import lombok.RequiredArgsConstructor;

import java.util.List;

@RequiredArgsConstructor
public class AssignmentHandler {
  private final List<AssignmentRule> assignmentRules;

  public void handleEvent() {
    // TODO: build the DTO using received event data
    Dto dto = Dto.builder().build();

    try {
      RuleEngine.process(assignmentRules, dto, dto);
    } catch (RuleProcessingException e) {
      System.out.println("Smth went wrong");
    }

  }

}
