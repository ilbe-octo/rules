package com.benrkia.rule.reassignment;

import com.benrkia.dto.Dto;
import com.benrkia.rule.Flags;
import com.benrkia.service.ReAssignmentService;

public class PP_TPE_RULE extends ReAssignmentRule {

  private final int activeFlags;

  public PP_TPE_RULE(final ReAssignmentService reAssignmentService) {
    super(reAssignmentService);
    this.activeFlags = prepareActiveFlags();
  }

  private int prepareActiveFlags() {
    int flags = 0;

    flags = Flags.PP.set(flags);
    flags = Flags.TPE.set(flags);

    return flags;
  }

  @Override
  public boolean shouldProcess(final Integer flags) {
    return activeFlags == flags;
  }

  @Override
  public void process(final Dto dto) {
    boolean processed = reAssignmentService.reAssignCRTPE(dto) ||
        reAssignmentService.reAssignCR(dto) ||
        reAssignmentService.reAssignDA(dto);

    if (!processed) {
      System.out.println("Smth went wrong");
    }
  }
}
