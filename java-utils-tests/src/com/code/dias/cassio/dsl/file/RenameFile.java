package com.code.dias.cassio.dsl.file;

import java.io.File;

/**
 * Rename file util using DSL example.
 * <br>
 * <i>
 * <b>Exemple of usage:</b><br>
 * RenameFile("C://folder//file.extension").to("C://folder//fileRenamed.extension"");
 * </i>
 * 
 * @author C‡ssio Dias
 */
public class RenameFile {
    
    String fromFile;
    
    public RenameFile(String fromFile){
        this.fromFile = fromFile;
    }
    
    public void to(String newFile){
        File f = new File(this.fromFile);
        f.renameTo(new File(newFile));
    }
    
    public static void main(String[] args) {
        new RenameFile("/user/file.txt").to("/user/fileChanged.txt");
    }
}