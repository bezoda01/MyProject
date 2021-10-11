import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

class buildDir implements Run{

    @Override
    public void run() throws IOException
    {
        try(InputStream st = System.in;
            InputStreamReader sr = new InputStreamReader(st);
            BufferedReader scanner = new BufferedReader(sr))
        {
            System.out.println("Это метод по созданию директории");
        }
    }
}
