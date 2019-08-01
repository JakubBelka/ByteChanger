package BinaryFile;
import java.io.IOException;
import java.io.RandomAccessFile;

public class BinaryFile {

    public BinaryFile(String file) {
        this.file = file;
    }
    String file;

    public byte[] readFileToTab() {
        RandomAccessFile stream;
        byte bytes[] ={0};
            try {
                 stream = new RandomAccessFile(file, "rw");
                 bytes = new byte[(int)stream.length()];
                 int liczba = stream.read(bytes);
                 stream.close();

            }
            catch (IOException e) {
                System.out.println("Nie można wczytać pliku");
            }

        return bytes;
    }
    public void writeFile(byte bytes[]) {
        RandomAccessFile stream;

        try {
            stream = new RandomAccessFile(file, "rw");
            stream.write(bytes);
            stream.close();
        }
        catch (IOException e) {

            System.out.println("Nie można zapisać pliku");
        }




    }

}
