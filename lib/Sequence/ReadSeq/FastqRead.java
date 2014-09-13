package Sequence.ReadSeq; 
import java.nio.file.*;
import java.nio.charset.Charset;
import java.io.IOExeption;
import Sequence.Sequence; 
import Sequence.Exception.*;
public class FastqRead {
  public FastqRead(String file){
    try{
      fr = Files.newBufferReader(Paths.get(file), Charset.forName("UTF-8"));
      this.file = file;
    }catch(IOException e){
      e.printStackTrace();
      System.exit(1);
    }
  }
  
  public FastqRead(String file,phredOff){
    this(file);
    this.phredOff = phredOff;
  }
  
  public Sequence getAsequence() throws IncorrectSequenceFormatException{
    String[] seq = new String[4];
    int index = 0; 
    while(String txt = fr.readLine() != null){
      inLine++;
      txt.trim();
      if(txt.length() > 0){
        seq[index++] = txt;
      } 
      if(index >= 3) break;
    }
    if(index < 4) throw new IncorrectSequenceFormatException(file + ": The number of lines is not the integer times of 4!");
    if(seq[0].charAt(0) != '@') throw new IncorrectSequenceFormatException(file + ": in line " + (inLine - 3) + " the first character of sequence name is not '@'");
    if(seq[2].charAt(0) != '+') throw new IncorrectSequenceFormatException(file + ": in line " + (inLine - 2) + " the first character of sequence name is not '+'");
    if(seq[1].length() != seq[3].length()) throw new IncorrectSequenceFormatException(file + ": in line " + (inLine - 3) + "The length of sequence and its quality unequal");
    
    return new Sequence(seq[0],seq[1],seq[3],phredOff); 

  }

  private BufferReader fr = null;
  private boolean isOnEnd = false;
  private String file = "";
  private long inLine = -1;
  private int phredOff = 33;
}
