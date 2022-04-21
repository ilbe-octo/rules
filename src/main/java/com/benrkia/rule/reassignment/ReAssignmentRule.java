package com.benrkia.rule.reassignment;

import com.benrkia.dto.Dto;
import com.benrkia.rule.Rule;
import com.benrkia.service.ReAssignmentService;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public abstract class ReAssignmentRule implements Rule<Integer, Dto> {
  protected final ReAssignmentService reAssignmentService;
}
