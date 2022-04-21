package com.benrkia.handler;

import com.benrkia.dto.Dto;
import com.benrkia.exception.RuleProcessingException;
import com.benrkia.rule.Flags;
import com.benrkia.rule.RuleEngine;
import com.benrkia.rule.reassignment.ReAssignmentRule;
import lombok.RequiredArgsConstructor;

import java.util.List;

@RequiredArgsConstructor
public class ReAssignmentHandler {
  private final List<ReAssignmentRule> assignmentRules;

  public void handleEvent() {
    // TODO: build the DTO using received event data
    Dto dto = Dto.builder().build();
    int flags = mapFlags(dto);

    try {
      RuleEngine.process(assignmentRules, flags, dto);
    } catch (RuleProcessingException e) {
      System.out.println("Smth went wrong");
    }
  }

  private int mapFlags(final Dto dto) {
    int flags = 0;

    if ("MRE".equals(dto.getMarket())) {
      flags = Flags.MRE.set(flags);
    } else if ("TPE".equals(dto.getMarket())) {
      flags = Flags.TPE.set(flags);
    }

    if ("PP".equals(dto.getPersonType())) {
      flags = Flags.PP.set(flags);
    }

    return flags;
  }

}
