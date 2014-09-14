package Screen;

import Sequence.Sequence;
import Sequence.Exception.*;
import static java.lang.Math.ceil;
public class AveQualAssessment extends Assessment {
  public AveQualAssessment(int phredOffset) throws Exception{
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
    assessments = new long[qualCharEnd - qualCharBegin + 1][1];
    type = "AveQual";
  }
  
  public AveQualAssessment() throws Exception{
    //seqMaxLen = 0;
    qualCharBegin = 33;
    qualCharEnd = 126; 
    assessments = new long[qualCharEnd - qualCharBegin + 1][1];
    type = "AveQual";
  }
  
  public int screen(Sequence seq){
    if(seq == null) return 0;
   
    String qualStr = seq.getQual();
    double totalQual = 0;
    for(char ch : qualStr.toCharArray()){
      totalQual += ch; 
    }
    int aveQual = (int)ceil(totalQual/qualStr.length()) - qualCharBegin;  
    c2SeqMaxLen(aveQual);
    assessments[aveQual - 1][0]++; 
    addScreens(seq); 
    
    return 1; 
  }
  
  public long[][] getAveQA(){
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
