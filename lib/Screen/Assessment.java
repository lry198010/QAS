import Sequence.Sequence;
import java.lang.Math.max;
public abstract class Assessment implements Screener {
  public final static MAXSEQLEN = 1024;
  public int screen(Sequence seq);
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
  
  protected long basesScreened = 0; 
  protected long readsScreened = 0; 
  protected int seqMaxLen = 0;
  protected int qualCharBegin = 33;
  protected int qualCharEnd = 74;
  protected long[][] atcgn = null; // A:0,C:1,G:2, T:3, N:4; = new long[MAXSEQLEN][5];
  protected long[][] qc = null; //= new long[MAXSEQLEN][qualCharEnd - qualCharBegin];
}
