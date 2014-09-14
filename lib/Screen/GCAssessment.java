import Sequence.Sequence;
import Sequence.Exception.*;
public class GCAssessment extends Assessment {
  public GCAssessment(int seqMaxLen, int phredOffSet) throws Exception{
    if(seqMaxLen <= 0){
      throw new Exception("Error: seqMaxLen = " + seqMaxLen + ", Max sequence length should > 0!");
    }
    //this.seqMaxLen = seqMaxLen;
    atcgn = new long[seqMaxLen][5]; 
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
    qc = new long[seqMaxLen][qualCharEnd - qualCharBegin + 1];
  }
  
  public GCAssessment(int seqMaxLen) throws Exception{
    if(seqMaxLen <= 0){
      throw new Exception("Error: seqMaxLen = " + seqMaxLen + ", Max sequence length should > 0!");
    }
    //this.seqMaxLen = seqMaxLen;
    atcgn = new long[seqMaxLen][5]; 
    qualCharBegin = 33;
    qualCharEnd = 126; 
    qc = new long[seqMaxLen][qualCharEnd - qualCharBegin + 1];
  }
  
  public GCAssessment() throws Exception{
    //seqMaxLen = 0;
    atcgn = new long[MAXSEQLEN][5]; 
    qualCharBegin = 33;
    qualCharEnd = 126; 
    qc = new long[seqMaxLen][qualCharEnd - qualCharBegin + 1];
  }
  
  public int screen(Sequence seq){
    String seqStr = seq.getSeq(); 
    String qualStr = seq.getQual();
    c2SeqMaxLen(seqStr.length());
    char[] seqC = seqStr.toCharArray();
    for(int i=0; i < seqb.length; i++){
      switch(seqC[i]){
        case 'A':
          atcgn[i][0]++;
          break;
        case 'C':
          atcgn[i][1]++;
          break;
        case 'G':
          atcgn[i][2]++;
          break;
        case 'T':
          atcgn[i][3]++;
          break;
        default:
          atcgn[i][4]++;
          break;
      } 
    }
   
    char[] qualC = qualStr.toCharArray();    
    for(int i = 0; i < qualC.length; i++){
      qc[i][qualC[i] - qualCharBegin]++;
    }
    
  }
  
  public long[][] getGC(){
    long[][] r = new long[seqMaxLen][];
    for(int i = 0; i < seqMaxLen; i++){
      r[i] = atcgn[i];
    }
    return r;
  }
  //protected long basesScreened = 0; 
  //protected long readsScreened = 0; 
  //protected long[][] atcgn = new long[MAXSEQLEN][5];
  //protected long[][] qc = new long[MAXSEQLEN][94];
  //protected int seqMaxLen = 0;
  //protected int qualCharBegin = 33;
  //protected int qualCharEnd = 74;
}
