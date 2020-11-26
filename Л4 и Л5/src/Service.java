import java.io.*;

public class Service {

    public static void write(University university) throws Exception {
        try (FileOutputStream fos = new FileOutputStream("inputUniversity.txt");
             BufferedOutputStream bos = new BufferedOutputStream(fos);
             ObjectOutputStream oos = new ObjectOutputStream(bos)
        ) {
            oos.writeObject(university);
        }
    }

    public static University reader() throws Exception {
        try (FileInputStream fis = new FileInputStream("inputUniversity.txt");
             BufferedInputStream bis = new BufferedInputStream(fis);
             ObjectInputStream ois = new ObjectInputStream(bis)
        ) {
            return (University) ois.readObject();
        }

    }
}
