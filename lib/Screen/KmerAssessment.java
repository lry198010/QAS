package Screen;

import Sequence.Sequence;
import Sequence.Exception.*;
public class KmerAssessment extends Assessment {
  public KmerAssessment(int kmer) throws Exception{
    if(kmer <= 0){
      throw new Exception("Error: kmer = " + seqMaxLen + ",  kmer length should > 0!");
    }
    //this.seqMaxLen = seqMaxLen;
    assessments = new long[seqMaxLen][5]; 
    type = "Kmer";
  }
  
  public GCAssessment() throws Exception{
    //seqMaxLen = 0;
    assessments = new long[MAXSEQLEN][5]; 
    type = "Kmer";
  }
  
  public int screen(Sequence seq){
    if(seq == null) return 0;

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
