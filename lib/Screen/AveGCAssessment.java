package Screen;

import Sequence.Sequence;
import Sequence.Exception.*;
import static java.lang.Math.ceil;
public class AveGCAssessment extends Assessment {
  
  public AveGCAssessment() throws Exception{
    //seqMaxLen = 0;
    seqMaxLen = 100;
    assessments = new long[100][6]; 
    type = "AveGC";
  }
  
  public int screen(Sequence seq){
    if(seq == null) return 0;

    String seqStr = seq.getSeq(); 
    char[] seqC = seqStr.toCharArray();
    long[] numOfBases = new long[5]; 
    for(int i=0; i < seqC.length; i++){
      switch(seqC[i]){
        case 'A':
          numOfBases[0]++;
          break;
        case 'C':
          numOfBases[1]++;
          break;
        case 'G':
          numOfBases[2]++;
          break;
        case 'T':
          numOfBases[3]++;
          break;
        default:
          numOfBases[4]++;
          break;
      } 
    }
    for(int i = 0; i < numOfBases.length; i++){
      int percenter = (int)(seqMaxLen * numOfBases[i]/seqStr.length());
      assessments[percenter][i]++;
    }
    int percenter = (int)((numOfBases[1] + numOfBases[2]) * seqMaxLen/seqStr.length());
    assessments[percenter][5]++;
    addScreens(seq); 
    return 1; 
  }
  
  public long[][] getAveGc(){
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
