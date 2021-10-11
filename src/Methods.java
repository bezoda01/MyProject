import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

class Methods
{

    private String FilePath;
    public String getFilePath() {
        return FilePath;
    }
    public void setFilePath(String filePath) {
        FilePath = filePath;
    }

    ArrayList<String> PathList = new ArrayList<>();

    public Methods() throws IOException
    {
        menyProgram();
    }
    public Methods(int temp) throws IOException
    {

    }

    public void menyProgram() throws IOException
    {
        try (InputStream st = System.in;
             InputStreamReader sr = new InputStreamReader(st);
             BufferedReader scanner = new BufferedReader(sr))
        {
            System.out.println("Что хотите сделать?");
            System.out.println("Введите номер действия.");
            PrintAll();
            whileProgram(scanner.readLine());
        }
    }

    public void whileProgram(String number) throws IOException
    {
        ArrayList<Run> ListMethods = new ArrayList<>();
        Collections.addAll(ListMethods, new buildDir(), new buildFile());
        switch (number)
        {
            case "1":
                //создание файла
                for(Object list : ListMethods)
                {
                    if(list instanceof Run)
                    {
                        Run running = (Run) list;
                        if(running instanceof buildFile)
                            running.run();
                    }
                }
                break;
            case "2":
                //создание дирректории
                for(Object list : ListMethods)
                {
                    if(list instanceof Run)
                    {
                        Run running = (Run) list;
                        if(running instanceof buildDir)
                            running.run();
                    }
                }
                break;
            case "3":
                //прочесть файл
                for(String list : PathList)
                {
                    System.out.println(list);
                }
                break;
            case "4":
                //записать текст
                break;
            case "5":
                //информация по файлу
                break;
            case "6":
                //перенести файл
                break;
            case "7":
                //скопировать файл
                break;
            case "8":
                System.out.println("Программа завершена!");
                break;
            default:
                menyProgram();
                break;
        }
    }

    public void PrintAll()
    {
        ArrayList<String> listProgram = new ArrayList<>();
        Collections.addAll(listProgram,
                "1.Создать файл.",
                "2.Создать дирректорию.",
                "3.Прочесть файл.",
                "4.Записать текст в файл.",
                "5.Информация по файлу.",
                "6.Перенести файл.",
                "7.Скопировать файл.",
                "8.Завершить программу.");
        for (String list : listProgram) {
            System.out.println(list);
        }
    }
}
