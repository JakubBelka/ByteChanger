package BinaryFile;
import java.io.File;
import java.util.ArrayList;
import java.util.List;


public class FileFinder {
   private static File folder;
   public static String filesName="";
   public static List<String> filePathToChange = new ArrayList<>();
   public static List<String> fileNameToChange = new ArrayList<>();


   public static String getFilesName() {
      for(String name : fileNameToChange){
         filesName=filesName+"\n"+name;
      }
      return filesName;
   }


   public static void findFile(File directory, String type){
      folder = new File(directory.getPath());
      for (final File fileEntry : folder.listFiles()) {

         if (fileEntry.isDirectory()) {
         FileFinder.findFile(fileEntry,type);
         }
         else if(fileEntry.getName().endsWith(type)) {
            filePathToChange.add(fileEntry.getPath());
            fileNameToChange.add(fileEntry.getName());
         }
      }
   }
   public static void cleanList(){
      filesName = "";
      while(!filePathToChange.isEmpty()){
      filePathToChange.remove(0);
      }
      while(!fileNameToChange.isEmpty()){
         fileNameToChange.remove(0);
      }
   }
}



