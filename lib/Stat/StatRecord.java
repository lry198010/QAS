package Stat;
public class StatRecord {
  public StatRecord(String type, int start, int end){
    recordType = type;
    clipStart = start; 
    clipEnd = end;
  } 
  
  public int basesClipped(int seqStart, int seqEnd){
    //return (clipStart - seqStart > 0 ? clipStart - seqStart : 0) +
    //       (seqEnd - clipEnd > 0? seqEnd - clipEnd : 0);
    return basesClippedForward(seqStart) + basesClippedReverse(seqEnd);
  }
  
  public int basesClippedForward(int seqStart){
    return clipStart - seqStart > 0 ? clipStart - seqStart : 0;
  }

  public int basesClippedReverse(int seqStart){
    return seqEnd - clipEnd > 0? seqEnd - clipEnd : 0;
  }

  private String recordType;
  private int clipStart;
  private int clipEnd;
}
