package TranDucManh_25020258_Week6.Bai06.src;

import java.util.ArrayList;
import java.util.List;

interface FileSystemItem {
    void print(String indent );
}

class FileItem implements FileSystemItem {
    int size ;
    String name ;
    public FileItem (String name , int size  ){
        this.name = name ;
        this.size = size ;
    }
    @Override
    public void print(String indent ){
        System.out.println(indent + "File : " + this.name + " - size : " + size );
    }
}

class ShortCut implements FileSystemItem {
    private String name ;
    private FileSystemItem target ;
    public ShortCut ( String name , FileSystemItem target){
        this.name = name ; 
        this.target = target ;
    }
    @Override
    public void print(String indent ){
        System.out.print(indent + "Shortcut: " + name + "->");
        target.print(indent + "");
    }
}

class Folder implements FileSystemItem {
    private String name ;
    private List<FileSystemItem> items = new ArrayList<>();
    public Folder (String name ){
        this.name = name;
        this.items = new ArrayList<>();
    }
    public void add(FileSystemItem file) {
        items.add(file);
    }
    @Override
    public void print(String indent ){
        System.out.println(indent + "Folder :" + this.name );
        for ( FileSystemItem t : items ){
            t.print(indent +"    ");
        }
    }
}

public class chap6 {
    public static void main(String[] args) {
        Folder root = new Folder("Bai06");

        Folder build = new Folder("build");
        Folder lib = new Folder("lib");
        Folder src = new Folder("src");
        root.add(build);
        root.add(lib);
        root.add(src);


        FileItem abc = new FileItem("abc.txt", 100);
        FileItem ducmanh = new FileItem("ducmanh.txt", 200);
        FileItem t1 = new FileItem("t1.txt", 150);

        src.add(abc);
        src.add(ducmanh);
        src.add(t1);


        ShortCut linkToDucManh = new ShortCut("ShortcutEX", ducmanh);
        src.add(linkToDucManh);

        FileItem readme = new FileItem("readme.md", 4);
        root.add(readme);

        root.print("");
    }
}
