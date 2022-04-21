package com.benrkia.rule;

public enum Flags {
  PP(1),
  PM(2),
  TPE(4),
  MRE(1 << 3),
  CR(1 << 4),
  CC(1 << 5),
  CRTPE(1 << 6),
  GL(1 << 7);

  private final int flag;

  Flags(final int flag) {
    assertPowerOfTwo(flag);
    this.flag = flag;
  }

  public int set(int flags) {
    return flags | this.flag;
  }

  private void assertPowerOfTwo(int flag) {
    if (flag < 1 || (flag & (flag - 1)) == 0)
      throw new IllegalStateException("flag must be power of 2");
  }
}
