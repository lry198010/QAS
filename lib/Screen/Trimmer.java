package Screen;

import Sequence.Sequence;
import Sequence.Exception.*;
import static java.lang.Math.ceil;
public abstract class Trimmer implements Screener {
  public abstract int screen(Sequence seq);
  public long getBasesScreened(){
    return totalBasesScreened; 
  }
  public long getReadsScreened(){
    return totalReadsScreened;
  }
  public long getBasesTrimmed(){ 
    return totalBasesTrimmed;
  }
  public long getReadsTrimmed(){ 
    return totalReadsTrimmed; 
  }
  
  public getBasesTrimRation(Trimmer[] trimmers){
    long totalBasesTrimmed = 0;
    long totalBasesScreened = 0;
    for(Trimmer T : trimmers){
      totalBasesTrimmed += T.getBasesTrimmed();
      totalBasesScreened += T.getBasesScreened(); 
    }
    return ((double)totalBasesTrimmed)/totalBasesScreened;
  }
  
  protected long totalBasesScreened = 0;
  protected long totalReadsScreened = 0;
  protected long totalBasesTrimmed = 0;
  protected long totalReadsTrimmed = 0; 
} 
