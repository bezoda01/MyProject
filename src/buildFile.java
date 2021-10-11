import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.file.Files;
import java.nio.file.Path;

public class buildFile implements Run {
    Methods methods;

    {
        try {
            methods = new Methods(1);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void run() throws IOException
    {
        try(InputStream stream = System.in;
            InputStreamReader sr = new InputStreamReader(stream);
            BufferedReader scanner = new BufferedReader(sr))
        {
            while(true)
            {
                System.out.println("Введите от корней до папки где должен храниться файл!");
                System.out.println("Пример: /Users/zenapoznak/Desktop/Новая папка");
                String tempPath = scanner.readLine();
                if(!Files.exists(Path.of(tempPath)))
                {
                    System.out.println("Введите существующий путь!");
                }
                else
                {
                    System.out.println("Введите имя файла и разшерение файла через точку!");
                    System.out.println("Пример: Text.txt or pages.png");
                    String tempFile = scanner.readLine();
                    methods.setFilePath(tempPath + "/" + tempFile);
                    if(Files.exists(Path.of(methods.getFilePath())))
                    {
                        System.out.println("Такой файл существует!");
                    }
                    else
                    {
                        Files.createFile(Path.of(methods.getFilePath()));
                        if(Files.exists(Path.of(methods.getFilePath())))
                        {
                            System.out.println("Ваш файл создан, вот его путь: " + methods.getFilePath());
                            System.out.println("Путь файла добавлен в список.");
                            methods.PathList.add(methods.getFilePath());
                            Methods methods = new Methods();
                        }
                    }
                }
            }
        }
    }
}

