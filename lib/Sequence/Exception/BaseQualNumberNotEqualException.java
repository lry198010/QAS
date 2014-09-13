package Sequence.Exception;
public class BaseQualNumberNotEqualException extends Exception {
  public BaseQualNumberNotEqualException(String name, String seq, String qual) {
    super("The length of Sequence and Quality was not equal:\n sequence length:" + seq.length() + ":" + seq + "\nquality length:" + qual.length()); 
    this.name = name;
    this.seq = seq;
    this.qual = qual;
  } 
  private String name;
  private String seq;
  private String qual;
}
