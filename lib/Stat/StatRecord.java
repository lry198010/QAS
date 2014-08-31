package Stat;
public class StatRecord {
  public StatRecord(String type, int forwardClipEnd, int forwardClipLength, int reverseClipBegin, int reverseClipLength){
    recordType = type;
    forwardEnd = forwardClipEnd;
    forwardLength = forwardClipLength;
    reverseBegin = reverseClipBegin
    reverseLength = reverseClipLength;
  } 
  
  public int basesClipped(){
    //return (clipStart - seqStart > 0 ? clipStart - seqStart : 0) +
    //       (seqEnd - clipEnd > 0? seqEnd - clipEnd : 0);
    return basesClippedForward() + basesClippedReverse();
  }
  
  public int basesClippedForward(){
    return forwardLength;
  }

  public int basesClippedReverse(){
    return reverseLength;
  }

  private String recordType;
  private int forwardEnd;
  private int forwardLength = 0;
  private int reverseBegin;
  private int reverseLength = 0;
}
