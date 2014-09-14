import Sequence.*;
import Sequence.ReadSeq.*;
import Screen.*;

public class tGCAssessment {
  public static void main(String[] args) {
    String file = "tes1.fq";
    FastqRead fqr = new FastqRead(file,33);
    try{
      Screener[] screeners = { new GCAssessment(), 
                               new QualAssessment(),
                               new AveQualAssessment(),
                               new LenAssessment()
                             };
      while(fqr.hasNext()){
        Sequence seq = fqr.getASequence();
        for(Screener sc : screeners){
          sc.screen(seq);
        } 
      }
      for(Screener sc : screeners){
        System.out.println("Screen Type: " + sc.getScreenType());
        System.out.println("Total reads screened: " + sc.getReadsScreened());
        System.out.println("Total bases screened: " + sc.getBasesScreened());
        for(long[] t : ((Assessment)sc).getAssessments()){
          long total = 0;
          for(long g : t) {
            System.out.print(g +" ");
            total += g;
          }
          System.out.println(total);
        }
      }
    }catch(Exception e){
      e.printStackTrace();
    }
  }
} 
