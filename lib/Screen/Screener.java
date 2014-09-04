package Screen; 
import Sequence.*;
public interface Screener {
  public int screen(Sequence seq);
  public long getBasesScreened();
  public long getReadsScreened();
  public long getBasesTrimmed(); 
  public long getReadsTrimmed(); 
}
