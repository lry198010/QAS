package Screen;

import Sequence.Sequence;
import Sequence.Exception.*;
public class LenAssessment extends Assessment {
  public LenAssessment(int seqMaxLen) throws Exception{
    if(seqMaxLen <= 0){
      throw new Exception("Error: seqMaxLen = " + seqMaxLen + ", Max sequence length should > 0!");
    }
    //this.seqMaxLen = seqMaxLen;
    assessments = new long[seqMaxLen][1]; 
    type = "Len";
  }
  
  public LenAssessment() throws Exception{
    //seqMaxLen = 0;
    assessments = new long[MAXSEQLEN][1]; 
    type = "Len";
  }
  
  public int screen(Sequence seq){
    if(seq == null) return 0;

    String seqStr = seq.getSeq(); 
    c2SeqMaxLen(seqStr.length());
    assessments[seqStr.length()-1][0]++;
    addScreens(seq); 
    return 1; 
  }
  
  public long[][] getLen(){
    return getAssessments();
  }
  
  public String getScreenType(){
    return type;
  }
  
  //protected long basesScreened = 0; 
  //protected long readsScreened = 0; 
  //protected long[][] atcgn = new long[MAXSEQLEN][5];
  //protected long[][] qc = new long[MAXSEQLEN][94];
  //protected int seqMaxLen = 0;
  //protected int qualCharBegin = 33;
  //protected int qualCharEnd = 74;
}
