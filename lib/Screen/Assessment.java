package Screen;

import Sequence.Sequence;
import static java.lang.Math.max;
public abstract class Assessment implements Screener {
  public final static int MAXSEQLEN = 1024;
  public abstract int screen(Sequence seq);
  public long getBasesScreened(){
    return basesScreened; 
  }
  public long getReadsScreened(){
    return readsScreened;
  }
  public long getBasesTrimmed(){
    return 0;
  } 
  public long getReadsTrimmed(){ 
    return 0; 
  }
  
  protected void c2SeqMaxLen(int seqLen){
    seqMaxLen = max(seqMaxLen,seqLen);
  }
  
  protected void addScreens(long bases, long reads){
    basesScreened += bases;
    readsScreened += reads;
  }
  
  protected void addScreens(Sequence seq){
    if(seq != null) addScreens(seq.getSeq().length(), 1);
  }

  protected void addScreens(long bases){
    addScreens(bases,0);
  }
  
  public long[][] getAssessments(){
    long[][] r = new long[seqMaxLen][];
    for(int i = 0; i < seqMaxLen; i++){
      r[i] = assessments[i];
    }
    return r;
  }
  
  public abstract String getScreenType();
  
  protected long basesScreened = 0; 
  protected long readsScreened = 0; 
  protected int seqMaxLen = 0;
  protected int qualCharBegin = 33;
  protected int qualCharEnd = 74;
  protected long[][] assessments;
  protected String type = "Assessment"; 
  //protected long[][] atcgn = null; // A:0,C:1,G:2, T:3, N:4; = new long[MAXSEQLEN][5];
  //protected long[][] qc = null; //= new long[MAXSEQLEN][qualCharEnd - qualCharBegin];
}
