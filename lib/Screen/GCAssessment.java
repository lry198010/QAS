package Screen;

import Sequence.Sequence;
import Sequence.Exception.*;
public class GCAssessment extends Assessment {
  public GCAssessment(int seqMaxLen) throws Exception{
    if(seqMaxLen <= 0){
      throw new Exception("Error: seqMaxLen = " + seqMaxLen + ", Max sequence length should > 0!");
    }
    //this.seqMaxLen = seqMaxLen;
    assessments = new long[seqMaxLen][5]; 
    type = "GC";
  }
  
  public GCAssessment() throws Exception{
    //seqMaxLen = 0;
    assessments = new long[MAXSEQLEN][5]; 
    type = "GC";
  }
  
  public int screen(Sequence seq){
    if(seq == null) return 0;

    String seqStr = seq.getSeq(); 
    c2SeqMaxLen(seqStr.length());
    char[] seqC = seqStr.toCharArray();
    for(int i=0; i < seqC.length; i++){
      switch(seqC[i]){
        case 'A':
          assessments[i][0]++;
          break;
        case 'C':
          assessments[i][1]++;
          break;
        case 'G':
          assessments[i][2]++;
          break;
        case 'T':
          assessments[i][3]++;
          break;
        default:
          assessments[i][4]++;
          break;
      } 
    }
    addScreens(seq); 
    return 1; 
  }
  
  public long[][] getGC(){
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
