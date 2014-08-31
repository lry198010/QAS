package ReadSequence;
import ReadSequence.Exception.*;
public class Sequence {
  public Sequence(String name, String seq, String qual) throws BaseQualNumberNotEqualException {
    seq = seqQualTrim(seq);
    qual = seqOrQual(qual);
    if (seq.length() != qual.length()) {
       throws new BaseQualNumberNotEqualException(name,seq,qual);
    } 
    this.name = name;
    this.seq = seq;
    this.qual = qual;
  }  
  
  public static String seqQualTrim(String seqOrQual){
     
  }
  private String name;
  private String seq;
  private String qual;
  private int begin; 
  private int end;
  
}
