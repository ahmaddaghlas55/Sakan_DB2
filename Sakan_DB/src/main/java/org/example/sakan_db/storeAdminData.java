package org.example.sakan_db;

public class storeAdminData {

    private static String adminName;
    private static String adminImagePath; // relative or absolute path

    public static String getAdminName() {
        return adminName;
    }

    public static void setAdminName(String name) {
        adminName = name;
    }

    public static String getAdminImagePath() {
        return adminImagePath;
    }

    public static void setAdminImagePath(String path) {
        adminImagePath = path;
    }

}
