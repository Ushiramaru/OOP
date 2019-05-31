import shape.Shape;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;

public class ShapesLoader extends ClassLoader {

    private String pathBin;
    private String packageName;
    private ArrayList<Shape> shapes = new ArrayList<>();

    public ShapesLoader(String pathBin, String packageName, ClassLoader parent) {
        super(parent);
        this.pathBin = pathBin;
        this.packageName = packageName;
    }

    @Override
    public Class<?> findClass(String className) throws ClassNotFoundException {
        byte[] b;
        try {
            File readFile = new File(pathBin + className + ".class");
            int contentLength = (int) readFile.length();
            FileInputStream fileReader = new FileInputStream(readFile);
            b = new byte[contentLength];
            int wasRead = 0;
            while (wasRead != contentLength) {
                wasRead += fileReader.read(b, wasRead, contentLength - wasRead);
            }
            fileReader.close();
        } catch (IOException e) {
            e.printStackTrace();
            return super.findClass(className);
        }
        return defineClass(packageName + '.' + className, b, 0, b.length);
    }

    public void startLoad() {
        File modulesFolder = new File(pathBin);
        String[] modules = modulesFolder.list();
        try {
            if (modules != null) {
                for (String module : modules) {
                    if (!Files.isDirectory(Path.of(pathBin + module))) {
                        String moduleName;
                        try {
                            moduleName = module.substring(0,module.lastIndexOf(".class"));
                        } catch (IndexOutOfBoundsException e) {
                            System.out.println(module + " isn't class extension");
                            continue;
                        }
                        Class loadedClass = this.loadClass(moduleName);
                        if (loadedClass != null) {
                            if (Shape.class.isAssignableFrom(loadedClass)) {
                                shapes.add((Shape) loadedClass.newInstance());
                            } else {
                                System.out.println(module + " isn't Shape");
                            }
                        }
                    }
                }
            }
        } catch (IllegalAccessException | InstantiationException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public ArrayList<Shape> getShapes() {
        return shapes;
    }
}
