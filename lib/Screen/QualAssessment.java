package Screen;

import Sequence.Sequence;
import Sequence.Exception.*;
public class QualAssessment extends Assessment {
  public QualAssessment(int seqMaxLen, int phredOffset) throws Exception{
    if(seqMaxLen <= 0){
      throw new Exception("Error: seqMaxLen = " + seqMaxLen + ", Max sequence length should > 0!");
    }
    if(phredOffset <= 32){
      throw new Exception("Error: phredOffset = " + seqMaxLen + ", char for coding quality should > 32!");
    }
    if(phredOffset == 33){
      qualCharBegin = 33;
      qualCharEnd = qualCharBegin + 41;
    }else{
      qualCharBegin = 59;
      qualCharEnd = qualCharBegin + 40;
    } 
    assessments = new long[seqMaxLen][qualCharEnd - qualCharBegin + 1];
    type = "Qual";
  }
  
  public QualAssessment(int seqMaxLen) throws Exception{
    if(seqMaxLen <= 0){
      throw new Exception("Error: seqMaxLen = " + seqMaxLen + ", Max sequence length should > 0!");
    }
    //this.seqMaxLen = seqMaxLen;
    qualCharBegin = 33;
    qualCharEnd = 126; 
    assessments = new long[seqMaxLen][qualCharEnd - qualCharBegin + 1];
    type = "Qual";
  }
  
  public QualAssessment() throws Exception{
    //seqMaxLen = 0;
    qualCharBegin = 33;
    qualCharEnd = 126; 
    assessments = new long[MAXSEQLEN][qualCharEnd - qualCharBegin + 1];
    type = "Qual";
  }
  
  public int screen(Sequence seq){
    if(seq == null) return 0;
   
    String qualStr = seq.getQual();
    c2SeqMaxLen(qualStr.length());
    char[] qualC = qualStr.toCharArray();    
    for(int i = 0; i < qualC.length; i++){
      assessments[i][qualC[i] - qualCharBegin]++;
    }
    
    addScreens(seq); 
    
    return 1; 
  }
  
  public long[][] getQA(){
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
