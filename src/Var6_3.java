import java.io.*;
import java.util.Scanner;

public class Var6_3 {
    public static boolean Pal(String str) throws IOException{
        int len = str.length();
        for (int i = 0;  i < len/2; ++i){
            if(str.charAt(i) != str.charAt(len - i - 1)){
                return false;
            }
        }
        return true;
    }


    public static void main(String[]args) throws IOException{
        Scanner sc = new Scanner(System.in);

        InputStream in = null;
        Reader file = null;
        BufferedReader bufread = null;

        OutputStream out =  null;
        Writer writer = null;
        try{
            in = new FileInputStream("C:\\Java\\in.txt");
            file = new InputStreamReader(in,"utf-8");
            bufread = new BufferedReader(file);
            File f2 = new File("C:\\Java\\out.txt");
            f2.createNewFile();
            out = new FileOutputStream(f2);
            writer = new OutputStreamWriter(out, "utf-8");
            if(f2.exists()){
                String line = " ";
                String [] words;
                while((line = bufread.readLine()) != null){
                    words = line.split(" ");
                    for(int i = 0; i < words.length; i++){
                        if(Pal(words[i])){
                            writer.append(words[i] + " ");
                        }
                    }
                    writer.append("\n");
                }
            }
        }
        catch (IOException e){
            System.out.println("Ошибка: "+ e);
        }
        finally {
            in.close();
            file.close();
            bufread.close();
            writer.flush();
            writer.close();
            out.close();
        }
    }
}