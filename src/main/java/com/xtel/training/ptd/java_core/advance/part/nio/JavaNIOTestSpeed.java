package com.xtel.training.ptd.java_core.advance.part.nio;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

public class JavaNIOTest {

    public static String FILE_INPUT_PATH = "D:/Setup/VGA_HDA_Win10.zip";

    public static void main(String[] args) throws Exception {
        useNormalIO();
        useFileChannel();
    }

    private static void useNormalIO() throws Exception {
        File file = new File(FILE_INPUT_PATH);
        File oFile = new File("D:/developer/test/ok");

        FileInputStream is = new FileInputStream(file);
        FileOutputStream fos = new FileOutputStream(oFile);

        byte[] buf = new byte[64 * 1024];
        int len = 0;
        long time1 = System.currentTimeMillis();
        while ((len = is.read(buf)) != -1) {
            fos.write(buf, 0, len);
        }
        long time2 = System.currentTimeMillis();

        System.out.println("useNormalIO: time taken " + (time2 - time1) + " ms");
        fos.close();
        is.close();
        fos.close();
        is.close();
    }

    private static void useFileChannel() throws Exception {
        File file = new File(FILE_INPUT_PATH);
        File oFile = new File("D:/developer/test/ok2");

        FileInputStream is = new FileInputStream(file);
        FileOutputStream fos = new FileOutputStream(oFile);

        FileChannel fc = is.getChannel();
        FileChannel fc2 = fos.getChannel();
        ByteBuffer buf = ByteBuffer.allocateDirect(64 * 1024);
        long time1 = System.currentTimeMillis();
        long len = 0;
        while ((len = fc.read(buf)) != -1) {
            buf.flip();
            fc2.write(buf);
            buf.clear();
        }
        long time2 = System.currentTimeMillis();

        System.out.println("useFileChannel: time taken " + (time2 - time1) + " ms");
        fc2.close();
        fc.close();
        fos.close();
        is.close();
    }
}
