package net.nh.constants;

/**
 * This class finds the local path of various HTML pages stored on the classpath.
 */
public class PageUrl {

    // Find the path to the page we will use on the file system
    public static final String INTERACTING_WITH_PAGE_CLASSPATH_LOCATION = "html/the-form.html";
    public static final String INTERACTING_WITH_PAGE_URL;
    static {
        var pageFileLocalPath = ClassLoader.getSystemClassLoader().getResource(INTERACTING_WITH_PAGE_CLASSPATH_LOCATION);
        if (pageFileLocalPath == null) {
            throw new RuntimeException("Unable to locate classpath resource: " + INTERACTING_WITH_PAGE_CLASSPATH_LOCATION);
        }
        System.out.println(pageFileLocalPath.getPath());
        INTERACTING_WITH_PAGE_URL = "file:" + pageFileLocalPath.getPath();
    }
}
