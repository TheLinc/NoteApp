
import java.util.Scanner; //imports scanner class
import java.util.LinkedList;

public class NoteApp{

  public static void main(String []args){
    LinkedList<Note> notelist = new LinkedList<Note>();

    String exit = "no";
    String cont = "yes";

    System.out.println("-----------------------------------------------");
    System.out.println("*                                             *");
    System.out.println("*            WELCOME TO NOTEAPP!              *");
    System.out.println("*                                             *");
    System.out.println("-----------------------------------------------");

    //loop for exiting program
    while(exit.equals("no")){

      System.out.println("");
      System.out.println("            Menu              ");
      System.out.println("..............................");
      System.out.println("|    1-Create Note           |");
      System.out.println("|    2-Search for Note       |");
      System.out.println("|    3-List Created Notes    |");
      System.out.println("|    4-Delete Created Note   |");
      System.out.println("|    5-Exit NoteApp          |");
      System.out.println("..............................");

      Scanner menuq = new Scanner(System.in);
      System.out.println("Select Operation from Menu: ");
      String menu = menuq.nextLine();

      //Create Note
      if(menu.equals("1")){
        //loop for writing notes
        while(cont.contains("y")){

          //entering title
          Scanner givenTitle = new Scanner(System.in);
          System.out.println("Enter Note Title: ");
          String title = givenTitle.nextLine();

          //entering note content
          Scanner givenContent = new Scanner(System.in);
          System.out.println("Enter Note Content: ");
          String content = givenContent.nextLine();

          //adding note to linked list to be stored
          Note note = new Note(title, content);
          notelist.add(note);

          boolean loop=true;

          //opton to write another note
          while(loop==true){
            Scanner anothernote = new Scanner(System.in);
            System.out.println("Would you like to create another note? (Y/N)");
            cont = anothernote.nextLine();

            if (cont.contains("y")) {
                loop=false;
            }
            else if (!(cont.contains("y") || cont.contains("n"))) {
              System.out.println("You did not enter a valid response. Please try again");
              loop=true;
            }
            else{
              loop=false;
            }
          }
        }
        continue;
      }

      //Search for Note
      else if(menu.equals("2")){
        String notename = null;
        Scanner notenameq = new Scanner(System.in);
        System.out.println("enter the title of the note you would like to find: ");
        notename = notenameq.nextLine();
        int size = notelist.size();
        boolean found = false;
        Note foundNote = new Note();
        int location = 0;

        for (int n=0; n < size; n++){
          //if note title matches element
          if (notelist.get(n).title.equals(notename)){
            System.out.println("");
            System.out.println("----------------------------");
            System.out.println(notelist.get(n));
            foundNote = notelist.get(n);
            found = true;
            location = n;

          }

          //if note title does not match element, and the end of the linked list is reached
          else if (!(notelist.get(n).title.equals(notename)) && n==size-1 && found==false){
            System.out.println(notelist.size()+" notes searched, with 0 results found for search term: "+ notename);
          }

          else{
          }
        }

          if(found==true){
            Boolean inedit = true;
            while (inedit == true){
              Scanner editq = new Scanner(System.in);
              System.out.println("Would you like to:    ");
              System.out.println("-----------------------");
              System.out.println("| a-Edit Note Title   |");
              System.out.println("| b-Edit Note Content |");
              System.out.println("| c-Exit Note         |");
              System.out.println("-----------------------");
              String edit = editq.nextLine();

              if(edit.equals("a")){
                Scanner newtitleq = new Scanner(System.in);
                System.out.println("Enter new title of note: ");
                String newtitle = newtitleq.nextLine();
                foundNote.title= newtitle;
                notelist.add(location, foundNote);
                System.out.print("");
                System.out.println("--------------------------");
                System.out.print(notelist.get(location));
                System.out.println("");
              }
              else if(edit.equals("b")){
                System.out.println("title: "+ foundNote.title);
                Scanner newcontentq = new Scanner(System.in);
                System.out.println("Enter new content of note: ");
                String newcontent = newcontentq.nextLine();
                foundNote.content= newcontent;
                notelist.add(location, foundNote);
                System.out.print(notelist.get(location));
              }
              else if(edit.equals("c")){
                inedit=false;
                continue; //jump to top of menu while loop
              }
              else{
                System.out.print("You entered: "+ edit +". Please select either a,b, or c.");
                System.out.println("");
                continue; //jumps to top of while loop
              }
            }
          }

         else{
         }
      }

      //list created Notes
      else if(menu.equals("3")){
        Note[] noteArray = notelist.toArray(new Note[notelist.size()]);
        System.out.println("");
        System.out.println("Note List:");
        System.out.println("-----------------------");

        if(notelist.size()>0){
          for (int i=0; i<(noteArray.length); i++){
            System.out.println("-"+ noteArray[i].title);
            System.out.println("");
          }
        }
        else{
          System.out.println("Error: No notes have been created.");
          System.out.println("");
        }
        continue;
      }

      //delete created note
      else if(menu.equals("4")){
        Scanner delnoteq = new Scanner(System.in);


        Note[] noteArray = notelist.toArray(new Note[notelist.size()]);
        System.out.println("");
        if(notelist.size()>0){
          System.out.println("Note List:");
          System.out.println("-----------------------");
          for (int i=0; i<(noteArray.length); i++){
            System.out.println(i+" - "+ noteArray[i].title);

          }
          System.out.println("-----------------------");
          System.out.println("Which note would you like to delete?");

        }
        else{
          System.out.println("Error: No notes have been created.");
          System.out.println("");
          continue;
        }

        String delname = delnoteq.nextLine();
        int del=Integer.parseInt(delname);
        notelist.remove(del);
        System.out.println("");
        System.out.println("Note Deleted.");
        System.out.println("");
        continue;
      }

      //exit application
      else if(menu.equals("5")){
        exit="yes";
        continue; //jump to top of menu while loop
      }

      else{
        System.out.println("You did not enter a valid selection. Please try again.");
        System.out.println("");
        continue; // makes the program jump to top of menu while loop
      }

    Scanner exitq = new Scanner(System.in);
    System.out.println("Would you like to exit note app? (y/n)");
    exit = exitq.nextLine();
  }//while


}  //main
}  //class
