package BinaryFile;
import java.io.File;


public class ByteChanger {

    byte a;
    byte b;
    int j=0;
    public int nrOfOperations = 0;
    public Boolean foundByte;

    public ByteChanger(byte a, byte b) {
        this.a = a;
        this.b = b;
    }

    public byte[] changeBytes(byte bytes[]){
        for(int i =0 ; i<bytes.length;i++){
            int inta = (int)bytes[i];
            int intb = (int) a;
            if(inta==intb){
                bytes[i]=b;
                nrOfOperations=nrOfOperations+1;

            }
        }
    return bytes;
    }

    public void isByteFound(File file, byte bytes[]){

            int inta = (int)bytes[j];
            int intb = (int) a;
            do{
                if(inta==intb){
                    foundByte=true;
                }
                else{
                    foundByte=false;
                }
            }
            while(j<=bytes.length & inta!=intb);



        }

    }





