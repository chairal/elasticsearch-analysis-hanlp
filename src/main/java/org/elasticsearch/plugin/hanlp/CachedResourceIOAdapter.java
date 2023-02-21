package org.elasticsearch.plugin.hanlp;

import com.hankcs.hanlp.corpus.io.IIOAdapter;
import com.hankcs.hanlp.corpus.io.IOUtil;

import java.io.*;
import java.nio.file.Files;

public class CachedResourceIOAdapter implements IIOAdapter {

    public static final int INDEX_NOT_FOUND = -1;

    private static final String TMP_DIR;

    static {
        try {
//            TMP_DIR = Files.createTempDirectory("hanlp").toAbsolutePath().toString();
            TMP_DIR = Files.createTempDirectory("hanlp").toAbsolutePath().toString();
        } catch (IOException e) {
            throw new UncheckedIOException(e);
        }
    }

    private static final String SEP = File.separator;

    @Override
    public InputStream open(String path) throws IOException {
        String cachePath = cachePath(path);
        return IOUtil.isFileExisted(cachePath) ? new FileInputStream(cachePath) : IOUtil.getResourceAsStream("/" + path);
    }

    @Override
    public OutputStream create(String path) throws IOException {
        String cachePath = cachePath(path);
        if (IOUtil.isResource(path)) {
            mkdir(cachePath);
            return new FileOutputStream(cachePath);
        }
        return new FileOutputStream(path);
    }

    private String cachePath(String path) {
        return new File(TMP_DIR + "/" + path).getPath().intern();
    }

    private void mkdir(String path) {
        if (new File(path).exists()) {
            return;
        }
        String dir = path.endsWith(SEP) ? path : substringBeforeLast(path, SEP);
        new File(dir).mkdirs();
    }

    public static String substringBeforeLast(String str, String separator) {
        if (isEmpty(str) || isEmpty(separator)) {
            return str;
        }
        int pos = str.lastIndexOf(separator);
        if (pos == INDEX_NOT_FOUND) {
            return str;
        }
        return str.substring(0, pos);
    }

    public static boolean isEmpty(String str) {
        return str == null || str.length() == 0;
    }

}