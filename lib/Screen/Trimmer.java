public abstract class Trimmer implements Screener {
  public abstract int screen(Sequence seq);
  public abstract long getBasesScreened();
  public abstract long getReadsScreened();
  public abstract long getBasesTrimmed(); 
  public abstract long getReadsTrimmed(); 
  
} 
