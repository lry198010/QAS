import Sequence.*;
import Sequence.ReadSeq.*;

public class tFastqRead {
  public static void main(String[] args) {
    String file = "tes1.fq";
    FastqRead fqr = new FastqRead(file,33);
    try{
      System.out.println(fqr.getASequence());
    }catch(Exception e){
      e.printStackTrace();
    }
  }
} 
