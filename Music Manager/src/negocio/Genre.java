package negocio;

public enum Genre {
  NULL(-1), NOT_LISTED(0), 
  AXE(1), BLUES(2), COUNTRY(3), ELETRONIC(4), LINING(5),
  FUNK(6), GOSPEL(7), HIPHOP(8), JAZZ(9), MPB(10),
  CLASSIC(11), PAGODE(12), POP(13), REAGUE(14), ROCK(15),
  SAMBA(16), BACK_COUNTRY(17);

  private int value;

  Genre(int value) {
    this.value = value;
  }

  public int getValue() {
    return value;
  }

  public String getValueStr() {
    switch (value) {
      case -1: return "NULL";
      case 0: return "NOT_LISTED";
      case 1: return "AXE";
      case 2: return "BLUES";
      case 3: return "COUNTRY";
      case 4: return "ELETRONIC";
      case 5: return "LINING";
      case 6: return "FUNK";
      case 7: return "GOSPEL";
      case 8: return "HIPHOP";
      case 9: return "JAZZ";
      case 10: return "MPB";
      case 11: return "CLASSIC";
      case 12: return "PAGODE";
      case 13: return "POP";
      case 14: return "REAGUE";
      case 15: return "ROCK";
      case 16: return "SAMBA";
      case 17: return "BACK_COUNTRY";
      default: return "NULL";
    }

  }
}
