package com.benrkia.rule;

public interface Rule<T, R> {

  boolean shouldProcess(T t);

  void process(R r);
}
