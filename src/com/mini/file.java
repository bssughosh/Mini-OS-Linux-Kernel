package com.mini;


class file {
    String fileName;
    private String filePermissions;

    file(){}

    file(String fileName, String filePermissions) {
        this.fileName = fileName;
        this.filePermissions = filePermissions;
    }

    void read(boolean isRoot) {
        int position = 3;

        if (filePermissions.charAt(position) == 'r' || (isRoot && filePermissions.charAt(position-3) == 'r')) {
            System.out.println("Permission Granted");
        }

        else System.out.println("Permission Denied");
    }

    void write(boolean isRoot) {
        int position = 4;

        if (filePermissions.charAt(position) == 'w' || (isRoot && filePermissions.charAt(position-3) == 'w')) {
            System.out.println("Permission Granted");
        } else System.out.println("Permission Denied");
    }

    void execute(boolean isRoot) {
        int position = 5;

        if (filePermissions.charAt(position) == 'x' || (isRoot && filePermissions.charAt(position-3) == 'x')) {
            System.out.println("Permission Granted");
        }

        else System.out.println("Permission Denied");
    }
}
