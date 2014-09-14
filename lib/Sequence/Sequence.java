package Sequence;
import Sequence.Exception.*;
import Stat.StatRecord;
public class Sequence {
  //public Sequence(String name, String seq, String qual, int phredOffset) throws BaseQualNumberNotEqualException, QuailOffsetNegativeException {
  public Sequence(String name, String seq, String qual, int phredOffset) throws BaseQualNumberNotEqualException{
    this.seq = seq.trim().toUpperCase();
    this.qual = qual.trim();
    if (this.seq.length() != this.qual.length()) {
       throw new BaseQualNumberNotEqualException(name,this.seq,this.qual);
    } 
    this.name = name;
    if(phredOffset < 0) {
      //throw new QuailOffsetNegativeException(phredOffset);
      throw new BaseQualNumberNotEqualException(name,this.seq,this.qual);
    }
    this.phredOffset = phredOffset; // Sanger
    begin = 0;
    end = this.seq.length();
    seqType = 0;
  }  
  
  //public Sequence(String name, String seq, String qual) throws BaseQualNumberNotEqualException, QuailOffsetNegativeException {
  public Sequence(String name, String seq, String qual) throws BaseQualNumberNotEqualException {
    this(name,seq,qual,33);  
  }

  // for fasta format
  //public Sequence(String name, String seq) throws BaseQualNumberNotEqualException, QuailOffsetNegativeException { // for Fast
  public Sequence(String name, String seq) throws BaseQualNumberNotEqualException { //, QuailOffsetNegativeException { // for Fast
    this(name,seq,seq.replaceAll(".","I"),33);
    seqType = 1;
  }

  //public Sequence(Sequence seqRecord, int forwardClipEnd, int reverseClipBegin) throws BaseQualNumberNotEqualException, QuailOffsetNegativeException {
  public Sequence(Sequence seqRecord, int forwardClipEnd, int reverseClipBegin) throws BaseQualNumberNotEqualException { //, QuailOffsetNegativeException {
    this(seqRecord.getName(), seqRecord.getSeq(), seqRecord.getQual(),seqRecord.getPhredOffset());
    records[recordIndex++] = new StatRecord("ByInitial",forwardClipEnd,forwardClipEnd,reverseClipBegin,seqRecord.getSeq().length() - reverseClipBegin + 1);
  }

  public String getName(){
    return name;
  }

  public String getRawSeq(){
    return seq;
  }

  public String getRawQual(){
    return qual;
  }
  
  public boolean isEmpty(){
    if(seq == null) return true;
    if(begin >= end) return true;
    return false;
  }
  
  public String getSeq(){
    if (isEmpty()) return null;
    return seq.substring(begin,end);
  }
  
  public String getQual(){
    if (isEmpty()) return null;
    return qual.substring(begin,end);
  }  

  public int[] getQualNumber(){
    if (isEmpty()) return null;
    String qual = getQual();
    int[] qualDigit = new int[qual.length()];
    for(int i = 0; i < qualDigit.length; i++){
      qualDigit[i] = (int)(qual.charAt(i)) - phredOffset;
    }
    return qualDigit;
  }
  
  public void setPhredOffset(int offset){
    phredOffset = offset;
  }
  
  public int getPhredOffset(){
    return phredOffset;
  }
  
  public int getSeqType(){
    return seqType;
  }  

  public void setSeqType(int seqType){
    this.seqType = seqType ;
  }  
  
  public double getGC(){
    return 15.6; 
  }

  public String toString(){
    return toFastq();
  }  

  public String toFastq(){
    return getName() + "\n" + getSeq() + "\n+\n" + getQual();
  }
 
  private String name;
  private String seq;
  private String qual;
  private int begin; 
  private int end;
  private StatRecord[] records = new StatRecord[20];
  private int recordIndex = 0;
  private int phredOffset = 33;
  private int seqType; // 0:fastq, 1:fasta
}
