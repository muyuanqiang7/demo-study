package com.funi.muyq.demo.study.loader;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * @Author: [muyuanqiang]
 * @CreateDate: [2018/6/1 19:05]
 */
public class ResourceClassLoader extends ClassLoader {
    private String resourceName;

    public ResourceClassLoader(String resourceName) {
        this.resourceName = resourceName;
    }

    @Override
    protected Class<?> findClass(String name) throws ClassNotFoundException {
        try {
            InputStream is = ResourceClassLoader.class.getClassLoader().getResourceAsStream(resourceName);
            ByteArrayOutputStream bos = new ByteArrayOutputStream();
            int len;
            try {
                while ((len = is.read()) != -1) {
                    bos.write(len);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }

            byte[] data = bos.toByteArray();
            is.close();
            bos.close();

            return defineClass(name, data, 0, data.length);

        } catch (IOException e) {
            e.printStackTrace();
        }

        return super.findClass(name);
    }
}
