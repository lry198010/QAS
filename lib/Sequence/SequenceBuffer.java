import Sequence;
import java.nio.file.*;
import java.io.IOException;
import static java.nio.file.StandardOpenOtion.*;
public class SequenceBuffer {
  public SequenceBuffer(String file){
    Path fp = Paths.get(file);
    try( fr = Files.newBufferReader(fp)){

    }catch(IOException e){
      e.printStackTrace();
    } 
  }

  public SequenceBuffer(String file, int numSeqs){
    String
  }
  
  public Sequence getASequence(){

  }

  public Sequence[] getSequences(){

  }

  private BufferReader fr = null;  
  
}
