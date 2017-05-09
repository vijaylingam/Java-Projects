/**
 * Created by vijaychandra on 10/5/16.
 */

import java.io.IOException;
import java.lang.String;
import java.nio.file.*;
import java.util.*;

/**
 * Filetypesize Class when executed prints out print the total size of the files of each type(extension) in bytes and then prints out the
 * time taken to execute
 */
public class Filetypesize {

    static String[] TYPES = new String[]{"jpg", "png", "gif", "mp4", "mp3", "exe", "psd", "html", "xml"}; //modify the extension types here
    static List<List<String>> filescount = new ArrayList<List<String>>();
    /**
     * @param filePath refers to the directory of the file
     * @param ext referes to the extension type
     * @return size
     * @throws IOException
     * streamDirectory method takes in as input 'filepath' and 'ext' of type String and returns 'size' of all the files that are of the type ext
     */
    public static long streamDirectory(String filePath, String ext, int extnum) throws IOException {
        long size = 0;
        Path dir = FileSystems.getDefault().getPath(filePath);
        DirectoryStream<Path> stream = Files.newDirectoryStream(dir); //creates a directory stream for the given directory (dir)
        for (Path path : stream) {
            if (Files.isDirectory(path)) {
                size += streamDirectory(path.toString(), ext, extnum); //if the current selection is not a file, a recursive call is made with filepath being the path of the current selection and the ext (extension type) remains the same

            } else {
                if(path.toString().endsWith(ext)) {
                    filescount.get(extnum).add(path.toString());
                    size += path.toFile().length(); //if the current selection is a file and the selection's extension matches with 'ext', the size of selected file is calculated and added to 'size'
                }
            }
        }
        stream.close(); //closing the stream
        //System.out.println(statistics[0] + " " + ext);
        return size; //returns 'size' (type - long)
    }

    static class MyThread extends java.lang.Thread {
        String extensionname;
        String path;
        int extnumber;

        //MyThread's constructor with 2 arguments: directory and extension name (ext)
        public MyThread(String dir, String ext, int extnum) {
            extensionname = ext; //
            path = dir;
            extnumber = extnum;
        }

        //MyThread's constructor with 0 arguments
        public MyThread(){

        }

        @Override
        public void run(){ //This is executed first when a thread is started
            try {
                long size = streamDirectory(path, extensionname, extnumber);
                System.out.println(extensionname +" -  " + filescount.get(extnumber).size() + "  "+String.format("%,d",size));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * @param args
     * @throws IOException
     * @throws InterruptedException
     * main method takes in nothing as input and returns nothing as output. It takes in a directory and creates a thread for different
     * extension types available in TYPES with directory (filepath) as parameter. Each thread invokes streamDirectory method. When all the threads
     * finish their task, main method prints out the time taken by this program to execute.
     */

    public static void main(String[] args) throws IOException, InterruptedException {
        long starttime = System.currentTimeMillis();
        String filepath = "/Users/vijaychandra/Desktop"; //set the directory here
        MyThread[] threads = new MyThread[TYPES.length]; //creating an array of threads with array size being equal to number of extensions present in TYPES

        for(int ext=0; ext<TYPES.length; ext ++ ) {
            List<String> list = new ArrayList<>();
            filescount.add(list);
            threads[ext] = new MyThread(filepath, TYPES[ext], ext); //creating thread for each ext with filepath (directory), and extension as parameters.
            threads[ext].start(); //starting the thread; this executes the run method in MyThread.

        }

        for(int x = 0; x<TYPES.length;x++) //this will make sure that all the threads finish their task before going to the below instructions.
            threads[x].join();

        long terminationtime = System.currentTimeMillis();
        long executiontime = terminationtime - starttime;
        System.out.println("Program executed in " + String.format("%,d", executiontime) +" milliseconds.");
    }
}
