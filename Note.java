import java.time.format.DateTimeFormatter;
import java.time.LocalDateTime;

//Note Object
public class Note {
  String title;
  String timestamp;
  String content;
  public Note(){
    title = null;
    content = null;
  }

  public Note(String title, String content){
    DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
    LocalDateTime now = LocalDateTime.now();

    this.title = title;
    this.timestamp = dtf.format(now);
    this.content = content;
  }

  public String getTitle(Note note){
    return note.title;
  }

  //allows Note Object to be printable
  public String toString() {
    return String.format("title: "+ title +".%n"+"timestamp: "+ timestamp + ".%n"+ "content: "+ content);
  }
}
