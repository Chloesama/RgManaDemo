package com.rgmana.decorator;

import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class DecoratorTest {
    public static void main(String[] args) throws IOException {

        DataInputStream dis = new DataInputStream(new FileInputStream("D:\\abc.txt"));
        System.out.println(dis.read());
        dis.close();
    }
}
