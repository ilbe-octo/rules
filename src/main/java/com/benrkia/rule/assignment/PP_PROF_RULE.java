package com.benrkia.rule.assignment;

import com.benrkia.dto.Dto;
import com.benrkia.service.AssignmentService;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class PP_PROF_RULE extends AssignmentRule {

  private final AssignmentService assignmentService;

  @Override
  public boolean shouldProcess(final Dto dto) {
    // TODO: test if is PP and CSP = PROF
    return true;
  }

  @Override
  public void process(final Dto dto) {
    boolean processed = assignmentService.assignCR(dto) ||
        assignmentService.assignDA(dto);

    if (!processed) {
      System.out.println("Smth went wrong");
    }
  }
}
