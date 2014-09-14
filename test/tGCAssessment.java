import Sequence.*;
import Sequence.ReadSeq.*;
import Screen.*;

public class tGCAssessment {
  public static void main(String[] args) {
    String file = "tes1.fq";
    FastqRead fqr = new FastqRead(file,33);
    try{
      Screener sc = new GCAssessment();
      while(fqr.hasNext()){
        sc.screen(fqr.getASequence()); 
      }
      for(long[] t : ((GCAssessment)sc).getGC()){
        long total = 0;
        for(long g : t) {
          System.out.print(g +" ");
          total += g;
        }
        System.out.println(total);
      }
    }catch(Exception e){
      e.printStackTrace();
    }
  }
} 
