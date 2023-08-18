package com.comic.blank.proxy;

import java.lang.reflect.Proxy;

/**
 * @author ..w-chen..
 */
public class JavaDynamicProxy {

    public static void main(String[] args) {
        JavaDeveloper wchen = new JavaDeveloper("wchen");
        Developer wchenProxy = (Developer) Proxy.newProxyInstance(wchen.getClass().getClassLoader(), wchen.getClass().getInterfaces(), (proxy, method, agrs) -> {
            if (method.getName().equals("code")) {
                System.out.println("wchen is praying for the code!");
                return method.invoke(wchen, agrs);
            }
            if (method.getName().equals("debug")) {
                System.out.println("wchen's have no bug ! No need to debug!");
                return method.invoke(wchen, agrs);
            }
            return null;
        });
        wchenProxy.code();
        wchenProxy.debug();
    }

}
