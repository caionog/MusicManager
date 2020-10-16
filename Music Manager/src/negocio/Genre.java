package negocio;

public enum Genre {

  AXE(1), BLUES(2), COUNTRY(3), ELETRONIC(4), LINING(5),
  FUNK(6), GOSPEL(7), HIPHOP(8), JAZZ(9), MPB(10),
  CLASSIC(11), PAGODE(12), POP(13), REAGUE(14), ROCK(15),
  SAMBA(16), BACK_COUNTRY(17);

  private int value;

  Genre(int value) {
    this.value = value;
  }
}
