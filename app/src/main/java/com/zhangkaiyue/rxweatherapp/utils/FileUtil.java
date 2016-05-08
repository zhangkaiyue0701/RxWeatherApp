package com.zhangkaiyue.rxweatherapp.utils;

import android.content.ContentResolver;
import android.content.ContentUris;
import android.content.Context;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Environment;
import android.provider.MediaStore;
import android.text.TextUtils;
import android.util.Log;

import java.io.BufferedInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.StreamCorruptedException;
import java.nio.channels.FileChannel;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

import rx.Observable;
import rx.Subscriber;
import rx.schedulers.Schedulers;

public class FileUtil {
    private static final String TAG = "FileUtil";

    /**
     * 读取文本数据
     *
     * @param context  程序上下文
     * @param fileName 文件名
     * @return String, 读取到的文本内容，失败返回null
     */
    public static String readAssets(Context context, String fileName) {
        InputStream is = null;
        String content = null;
        try {
            is = context.getAssets().open(fileName);

            byte[] buffer = new byte[1024];
            ByteArrayOutputStream arrayOutputStream = new ByteArrayOutputStream();
            while (true) {
                int readLength = is.read(buffer);
                if (readLength == -1) break;
                arrayOutputStream.write(buffer, 0, readLength);
            }
            is.close();
            arrayOutputStream.close();
            content = new String(arrayOutputStream.toByteArray());

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
            content = null;
        } finally {
            try {
                if (is != null) is.close();
            } catch (IOException ioe) {
                ioe.printStackTrace();
            }
        }
        return content;
    }

    /**
     * 复制文件
     *
     * @param srcFile src file
     * @param dstFile dst file
     * @return isSuccess
     */
    public static boolean copy(String srcFile, String dstFile) {
        FileInputStream fis = null;
        FileOutputStream fos = null;
        try {

            File dst = new File(dstFile);
            if (!dst.getParentFile().exists()) {
                if (!dst.getParentFile().mkdirs()) {
                    return false;
                }
            }

            fis = new FileInputStream(srcFile);
            fos = new FileOutputStream(dstFile);

            byte[] buffer = new byte[1024];
            int len;

            while ((len = fis.read(buffer)) != -1) {
                fos.write(buffer, 0, len);
            }

        } catch (Exception e) {
            e.printStackTrace();
            return false;
        } finally {
            if (fis != null) {
                try {
                    fis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (fos != null) {
                try {
                    fos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

        }
        return true;
    }


    public static void copyFile(File src, File dst) throws IOException {
        FileChannel inChannel = new FileInputStream(src).getChannel();
        FileChannel outChannel = new FileOutputStream(dst).getChannel();
        try {
            inChannel.transferTo(0, inChannel.size(), outChannel);
        } finally {
            if (inChannel != null)
                inChannel.close();
            if (outChannel != null)
                outChannel.close();
        }
    }

    public static boolean writeObj2SDFile(File filename, Object object) {

        try {
            FileOutputStream fileOutputStream = new FileOutputStream(filename);
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
            objectOutputStream.writeObject(object);
            objectOutputStream.close();
            fileOutputStream.close();
            return true;
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return false;

    }

    public static Object getObjFromSDFile(File filename) {

        try {
            FileInputStream fileInputStream = new FileInputStream(filename);
            ObjectInputStream inputStream = new ObjectInputStream(fileInputStream);
            Object object = inputStream.readObject();
            inputStream.close();
            fileInputStream.close();
            return object;

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (StreamCorruptedException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        return null;

    }

    //保存图片文件
    public static File saveToFile(String fileFolderStr, boolean isDir, Bitmap croppedImage) throws IOException {
        if (croppedImage == null) {
            return null;
        }
        File jpgFile;
        File fileFolder = null;
        // To be safe, you should check that the SDCard is mounted
        // using Environment.getExternalStorageState() before doing this.
        if (isDir) {
            if (TextUtils.isEmpty(fileFolderStr)) {
                fileFolder = new File(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES), "Keep");
            } else {
                fileFolder = new File(fileFolderStr);
            }

            Date date = new Date();
            SimpleDateFormat format = new SimpleDateFormat("yyyyMMddHHmmss"); // 格式化时间
            String filename = format.format(date) + ".jpg";
            if (!fileFolder.exists()) {
                mkdir(fileFolder);
            }
            jpgFile = new File(fileFolder, filename);
        } else {
            if (TextUtils.isEmpty(fileFolderStr)) {
                jpgFile = new File(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES), "Keep");
            } else {
                jpgFile = new File(fileFolderStr);
            }

            if (!jpgFile.getParentFile().exists()) {
                mkdir(jpgFile.getParentFile());
            }
        }
        FileOutputStream outputStream = new FileOutputStream(jpgFile); // 文件输出流

        croppedImage.compress(Bitmap.CompressFormat.PNG, 80, outputStream);
        try {
            if (outputStream != null)
                outputStream.flush();
            outputStream.close();
        } catch (IOException e) {

        }
        return jpgFile;
    }

    public static boolean mkdir(File file) {
        while (!file.getParentFile().exists()) {
            mkdir(file.getParentFile());
        }
        return file.mkdir();
    }

    /**
     * 根据Uri返回文件路径
     *
     * @return String
     * @Title: getInputString
     * @date 2012-12-14 上午9:14:19
     */
    public static String getFilePath(Context context, Uri mUri) {
        try {
            if (mUri.getScheme().equals("file")) {
                return mUri.getPath();
            } else {
                return getFilePathByUri(context, mUri);
            }
        } catch (FileNotFoundException ex) {
            return null;
        } catch (NullPointerException ex) {
            return null;
        }
    }

    /**
     * 此处写方法描述
     *
     * @return String
     * @Title: getFilePathByUri
     * @date 2012-12-14 上午9:16:33
     */
    public static String getFilePathByUri(Context context, Uri mUri) throws FileNotFoundException {
        String imgPath = null;
        Cursor cursor = context.getContentResolver().query(mUri, null, null, null, null);
        if (cursor != null && cursor.moveToFirst()) {
            imgPath = cursor.getString(1); // 图片文件路径
        }
        if (cursor != null) {
            cursor.close();
        }
        return imgPath;
    }

    /**
     * 删除图库中图片并同步图库
     */
    public static boolean deleteImage(Context context, String imgPath) {
        ContentResolver resolver = context.getContentResolver();
        Cursor cursor = MediaStore.Images.Media.query(resolver, MediaStore.Images.Media.EXTERNAL_CONTENT_URI,
                new String[]{MediaStore.Images.Media._ID}, MediaStore.Images.Media.DATA + "=?",
                new String[]{imgPath}, null);
        boolean result = false;
        if (cursor.moveToFirst()) {
            long id = cursor.getLong(0);
            Uri contentUri = MediaStore.Images.Media.EXTERNAL_CONTENT_URI;
            Uri uri = ContentUris.withAppendedId(contentUri, id);
            int count = context.getContentResolver().delete(uri, null, null);
            result = count == 1;
        } else {
            File file = new File(imgPath);
            result = file.delete();
        }

        return result;
    }

    public static void mkdirs(File file) {
        if (!file.exists()) {
            file.mkdirs();
        }
    }

    /**
     * 移动文件夹内容
     *
     * @param oldPath 源文件夹路径
     * @param newPath 目标文件夹路径
     */
    public static void moveFolder(String oldPath, String newPath) {
        // 先复制文件
        copyFolder(oldPath, newPath);
        // 则删除源文件，以免复制的时候错乱
        deleteDir(new File(oldPath));
    }

    /**
     * 复制某个目录及目录下的所有子目录和文件到新文件夹
     *
     * @param oldPath 源文件夹路径
     * @param newPath 目标文件夹路径
     */
    public static void copyFolder(String oldPath, String newPath) {
        try {
            (new File(newPath)).mkdirs();
            File fileList = new File(oldPath);
            String[] file = fileList.list();
            File temp;
            for (String aFile : file) {
                // 如果oldPath以路径分隔符/或者\结尾，那么则oldPath/文件名就可以了
                // 否则要自己oldPath后面补个路径分隔符再加文件名
                if (oldPath.endsWith(File.separator)) {
                    temp = new File(oldPath + aFile);
                } else {
                    temp = new File(oldPath + File.separator + aFile);
                }

                if (temp.isFile()) {
                    FileInputStream input = new FileInputStream(temp);
                    FileOutputStream output = new FileOutputStream(newPath + "/" + temp.getName());
                    byte[] bufferArray = new byte[1024 * 64];
                    int length;
                    while ((length = input.read(bufferArray)) != -1) {
                        output.write(bufferArray, 0, length);
                    }
                    output.flush();
                    output.close();
                    input.close();
                }
                if (temp.isDirectory()) {
                    copyFolder(oldPath + "/" + aFile, newPath + "/" + aFile);
                }
            }
        } catch (Exception e) {
            Log.e("Keep", "复制整个文件夹内容操作出错");
        }
    }

    /**
     * 删除某个目录及目录下的所有子目录和文件
     *
     * @param dir File path
     * @return boolean
     */
    public static boolean deleteDir(File dir) {
        if (dir.isDirectory()) {
            String[] children = dir.list();
            for (String aChildren : children) {
                boolean isDelete = deleteDir(new File(dir, aChildren));
                if (!isDelete) {
                    return false;
                }
            }
        }
        return dir.delete();
    }


    public static String cutLastSegmentOfPath(String path) {
        return path.substring(0, path.lastIndexOf("/"));
    }


    public static void mkdirs(String path) {
        File file = new File(path);
        if (!file.exists()) {
            file.mkdirs();
        }
    }

    private static void writeFile(String fullFilePath, InputStream is) {
        File file = new File(fullFilePath);
        if (!file.exists()) {
            try {
                file.createNewFile();
                FileOutputStream fos = new FileOutputStream(file);
                byte[] temp = new byte[1024];
                int i = 0;
                while ((i = is.read(temp)) > 0) {
                    fos.write(temp, 0, i);
                }
                fos.close();
                is.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static Observable<Boolean> unpackZip(final String path, final String zipName) {
        return Observable.create(new Observable.OnSubscribe<Boolean>() {
            @Override
            public void call(Subscriber<? super Boolean> subscriber) {
                ZipInputStream zis;
                try {
                    String filename;
                    zis = new ZipInputStream(new BufferedInputStream(new FileInputStream(path + zipName)));
                    ZipEntry ze;
                    byte[] buffer = new byte[1024];
                    int count;
                    while ((ze = zis.getNextEntry()) != null) {
                        filename = ze.getName();
                        if (ze.isDirectory()) {
                            File fmd = new File(path + filename);
                            fmd.mkdirs();
                            continue;
                        }
                        FileOutputStream fileOutputStream = new FileOutputStream(path + filename);
                        while ((count = zis.read(buffer)) != -1) {
                            fileOutputStream.write(buffer, 0, count);
                        }

                        fileOutputStream.close();
                        zis.closeEntry();
                    }
                    zis.close();
                    subscriber.onNext(true);
                    subscriber.onCompleted();
                } catch (IOException e) {
                    subscriber.onError(e);
                }

            }
        }).subscribeOn(Schedulers.io());
    }

}
