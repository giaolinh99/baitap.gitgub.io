package main.java.com.example.demo;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class StudentDao {
    private static final String STUDENT_FILE_NAME = "student.txt";

    public void write(List<Student> studentList){
        FileOutputStream fos = null;
        ObjectOutputStream oos = null;
        try{
            //tạo ra 1 file
            fos = new FileOutputStream(new File(STUDENT_FILE_NAME));
            //tạo ra 1 object ghi vào fos
            oos = new ObjectOutputStream(fos);
            //object đó theo studenList
            oos.writeObject(studentList);
        }catch (FileNotFoundException e){
            e.printStackTrace();
        }
        catch (IOException e){
            e.printStackTrace();
        }
        finally {
            closeStream(fos);
            closeStream(oos);

        }
    }

    public List<Student> read() {
        List<Student> studentList = new ArrayList<>();
        FileInputStream fis = null;
        ObjectInputStream ois = null;
        try {
            //mở 1 file
            fis = new FileInputStream(new File(STUDENT_FILE_NAME));
//ep file thanh 1 object
            ois = new ObjectInputStream(fis);
            //doc duwxlieu trong object file
            studentList = (List<Student>) ois.readObject();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            //lỗi nhập
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            //đóng
            closeStream(fis);
            closeStream(ois);
        }
        return studentList;
    }

    private void closeStream(InputStream is) {
        if (is != null) {
            try {
                is.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }


    private void closeStream(OutputStream os) {
        if (os != null) {
            try {
                os.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
