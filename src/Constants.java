import java.io.IOException;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Collections;

public class Constants
{
    public Constants() throws IOException
{

}
    private String PathDirectory;
    public void setPathDirectory(String pathDirectory) {
        PathDirectory = pathDirectory;
    }
    public String getPathDirectory() {
        return PathDirectory;
    }

    private String PathFile;
    public String getPathFile() {
        return PathFile;
    }
    public void setPathFile(String pathFile) {
        PathFile = pathFile;
    }

    private Path fullPath;
    public Path getFullPath() {
        return fullPath;
    }
    public void setFullPath(Path fullPath) {
        this.fullPath = fullPath;
    }

    public final ArrayList<String> listProgram = new ArrayList<>(){};

}
