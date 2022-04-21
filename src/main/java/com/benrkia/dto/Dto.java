package com.benrkia.dto;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class Dto {
  private final String id;
  private final String personType;
  private final String market;
  private final String login;
  private final String agency;
}
