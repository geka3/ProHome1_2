import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

/**
 * Created by 1 on 04.12.2016.
 */
@SaveTo(path = "d:\\file.txt")
public class TextContainer {

    String str = "My String";
  //  String fileName = null;

@SaverMethod
    private void save(String fileName){
    if (fileName == null){
        System.out.println("fileName is null");
        return;
    }
    File f = new File(fileName);
    try{
        if (!f.exists()){ f.createNewFile();}
    }catch (IOException e){
        e.printStackTrace();
    }


    try( FileWriter fw = new FileWriter(f);){

        fw.write(str);
        System.out.println("file is written to " + f.getAbsolutePath());

        }catch (IOException e){

        }
    }
}
