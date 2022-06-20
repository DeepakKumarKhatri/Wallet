

import java.io.*;
import java.util.ArrayList;

public class FileOperations {
    ObjectOutputStream objectOutputStream = null;

    public void writeInFile(User user, boolean append) {
        try {
            File file = new File("UsersData.ser");
            if (file.exists()) {
                objectOutputStream = new MyObjectOutputStream(new FileOutputStream(file, append));
                objectOutputStream.writeObject(user);
            } else {
                objectOutputStream = new ObjectOutputStream(new FileOutputStream(file, append));
                objectOutputStream.writeObject(user);
            }
        } catch (IOException e) {
            System.out.println("Error In File Writing");
            e.printStackTrace();
        } finally {
            try {
                objectOutputStream.close();
            } catch (Exception e) {
                System.out.println("Error In File Writing");
                e.printStackTrace();
            }
        }
    }

    ObjectInputStream objectInputStream;

    public ArrayList<User> readInFile() {
        ArrayList<User> list = new ArrayList<>();
        try {
            objectInputStream = new ObjectInputStream(new FileInputStream("UsersData.ser"));
            while (true) {
                list.add((User) objectInputStream.readObject());
            }
        } catch (Exception e) {
            return list;
        }
    }
}
