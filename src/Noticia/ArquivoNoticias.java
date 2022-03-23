/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Noticia;

import java.io.EOFException;
import java.io.FileNotFoundException;
import java.io.IOError;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author DAW
 */
public class ArquivoNoticias implements Iterable<Noticia>, AutoCloseable {

    private final RandomAccessFile news;
    private final RandomAccessFile nDetails;
    private long lastPos;

    public ArquivoNoticias() throws FileNotFoundException {
        news = new RandomAccessFile("News.dat", "rw");
        nDetails = new RandomAccessFile("NewsDetails.dat", "rw");
    }

    public static int corpoNoticia(String corpo) throws FileNotFoundException, IOException {
        int doubleSize = Double.SIZE / 8;
        int pos;

        try ( RandomAccessFile nDetails = new RandomAccessFile("NewsDetails.dat", "rw")) {
            nDetails.seek(nDetails.length());
            pos = (int) (nDetails.getFilePointer() / doubleSize) + 1;
            nDetails.writeUTF(corpo);
        }
        return pos;
    }

    public Noticia[] listaNoticias() throws FileNotFoundException, Exception {
        ArrayList<Noticia> list = new ArrayList<>();
        try ( ArquivoNoticias not = new ArquivoNoticias()) {
            for (Noticia n : not) {
                list.add(n);
            }
        }
        return list.toArray(new Noticia[0]);
    }

    public boolean add(Noticia n, String corpo) throws IOException {
        boolean ok = false;
        n.setPos(corpoNoticia(corpo));
        write(n);
        return ok;
    }

    @Override
    public Iterator<Noticia> iterator() {
        try {
            news.seek(0);
            return new Iterator<Noticia>() {
                Noticia nova = null;

                @Override
                public boolean hasNext() {
                    Noticia n = new Noticia();
                    try {
                        for (;;) {
                            if (read(n)) {
                                nova = n;
                                break;
                            };
                        }
                    } catch (EOFException e) {
                        return false;
                    } catch (IOException ex) {
                        throw new IOError(ex);
                    }
                    return true;
                }

                @Override
                public Noticia next() {
                    Noticia n = null;
                    if (nova != null) {
                        n = nova;
                    }
                    nova = null;
                    if (n != null) {
                        return n;
                    }

                    try {
                        n = new Noticia();
                        for (;;) {
                            if (read(n)) {
                                break;
                            }
                        }
                    } catch (EOFException e) {
                        throw new NoSuchElementException();
                    } catch (IOException ex) {
                        throw new IOError(ex);
                    }
                    return n;
                }
            };
        } catch (IOException ex) {
            throw new IOError(ex);
        }
    }

    @Override
    public void close() throws Exception {
        news.close();
        nDetails.close();
    }

    private void write(Noticia n) throws IOException {
        lastPos = news.getFilePointer();
        news.writeByte(0);
        news.writeInt(n.getPos());
        news.writeUTF(n.getTitular());
        news.writeUTF(n.getEntradilla());
        nDetails.writeUTF(n.getCorpo());
    }

    private boolean read(Noticia n) throws IOException {
        lastPos = news.getFilePointer();
        byte ok = news.readByte();
        n.setPos(news.readInt());
        n.setTitular(news.readUTF());
        n.setEntradilla(news.readUTF());
        n.setCorpo(nDetails.readUTF());
        return (ok == 0);
    }

}
