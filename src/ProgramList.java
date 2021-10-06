import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Collections;

public class ProgramList
{
    Constants constants = new Constants();

    public ProgramList() throws IOException
    {

    }
    public ProgramList(int lock) throws IOException
    {
       PrintAll();
    }
    public void PrintAll()
    {
        Collections.addAll(constants.listProgram,"1.Создать файл.",
                "2.Создать дирректорию.",
                "3.Прочесть файл.",
                "4.Записать текст в файл.",
                "5.Информация по файлу.",
                "6.Перенести файл.",
                "7.Скопировать файл.");
        for(String list : constants.listProgram)
        {
            System.out.println(list);
        }
    }

    public void buildFile() throws IOException
    {
        try(InputStream st = System.in;
            InputStreamReader sr = new InputStreamReader(st);
            BufferedReader scanner = new BufferedReader(sr))
        {

            System.out.println("Введите полный путь до дирриктории, пример: /Users/zenapoznak/Desktop/Новая папка.");
            constants.setPathDirectory(scanner.readLine());


            while(true)
            {
                System.out.println("Введите название файла.");
                constants.setPathFile(scanner.readLine());
                constants.setFullPath(Path.of(constants.getPathDirectory() + "/" + constants.getPathFile() + ".txt"));
                if(!Files.exists(constants.getFullPath()))
                {
                    Files.createFile(constants.getFullPath());
                    System.out.println("Ваш файл создан!");
                    System.out.println("Вот его путь: " + constants.getFullPath());
                    break;
                }
                else
                {
                    System.out.println("Файл с таким именем существует!");
                }
            }
        }
    }
}
