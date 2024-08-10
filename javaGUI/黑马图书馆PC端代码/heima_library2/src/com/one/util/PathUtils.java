package com.one.util;

public class PathUtils {

    private static final String P_PATH="heima_library2\\images\\";

    public static String getRealPath(String relativePath){

        return P_PATH+relativePath;
    }

}
