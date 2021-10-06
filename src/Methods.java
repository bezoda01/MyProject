import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class Methods
{
    ProgramList programList = new ProgramList();
    public Methods() throws IOException
    {
        menyProgram();
    }

    public void menyProgram() throws IOException
    {
        try(InputStream st = System.in;
            InputStreamReader sr = new InputStreamReader(st);
            BufferedReader scanner = new BufferedReader(sr))
        {
            System.out.println("Что хотите сделать?");
            System.out.println("Введите номер действия.");
            ProgramList programList = new ProgramList(1);
            whileProgram(scanner.readLine());
        }
    }

    public void whileProgram(String number) throws IOException
    {
        switch (number) {
            case "1":
                //создание файла
                programList.buildFile();
                break;
            case "2":
                //создание дирректории
                break;
            case "3":
                //прочесть файл
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
            default:
                menyProgram();
                break;
        }
    }
}
