package wxrp.rad.zip;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.URI;
import java.nio.file.CopyOption;
import java.nio.file.FileSystem;
import java.nio.file.FileSystems;
import java.nio.file.FileVisitResult;
import java.nio.file.Files;
import java.nio.file.LinkOption;
import java.nio.file.Path;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.StandardCopyOption;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.HashMap;
import java.util.Map;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

public class Zipper {
	
	public static void zip(Path source) throws IOException {

        // get current working directory
        String currentPath = System.getProperty("user.dir") + File.separator;

        // get folder name as zip file name
        // can be other extension, .foo .bar .whatever
        String zipFileName = source.getFileName().toString() + ".zip";
        URI uri = URI.create("jar:file:" + currentPath + zipFileName);

        Files.walkFileTree(source, new SimpleFileVisitor<>() {
            @Override
            public FileVisitResult visitFile(Path file,
                BasicFileAttributes attributes) {

                // Copying of symbolic links not supported
                if (attributes.isSymbolicLink()) {
                    return FileVisitResult.CONTINUE;
                }

                Map<String, String> env = new HashMap<>();
                env.put("create", "true");

                try (FileSystem zipfs = FileSystems.newFileSystem(uri, env)) {

                    Path targetFile = source.relativize(file);
                    Path pathInZipfile = zipfs.getPath(targetFile.toString());

                    // NoSuchFileException, need create parent directories in zip path
                    if (pathInZipfile.getParent() != null) {
                        Files.createDirectories(pathInZipfile.getParent());
                    }

                    // copy file attributes
                    CopyOption[] options = {
                            StandardCopyOption.REPLACE_EXISTING,
                            StandardCopyOption.COPY_ATTRIBUTES,
                            LinkOption.NOFOLLOW_LINKS
                    };
                    // Copy a file into the zip file path
                    Files.copy(file, pathInZipfile, options);

                } catch (IOException e) {
                    e.printStackTrace();
                }

                return FileVisitResult.CONTINUE;
            }

            @Override
            public FileVisitResult visitFileFailed(Path file, IOException exc) {
                System.err.printf("Unable to zip : %s%n%s%n", file, exc);
                return FileVisitResult.CONTINUE;
            }

        });

    }
	
    public void unzip(Path source, Path target, String entry_name) throws IOException {

        try (ZipInputStream zis = new ZipInputStream(new FileInputStream(source.toFile()))) {
            ZipEntry zipEntry = zis.getNextEntry();
            entry_name = zipEntry.getName().replace("/", "");
            
            while (zipEntry != null) {
            	
                boolean isDirectory = false;
                if (zipEntry.getName().endsWith(File.separator)) {
                    isDirectory = true;
                }
                
                Path newPath = zipSlipProtect(zipEntry, target);

                if (isDirectory) {
                    Files.createDirectories(newPath);
                } else {

                    if (newPath.getParent() != null) {
                        if (Files.notExists(newPath.getParent())) {
                            Files.createDirectories(newPath.getParent());
                        }
                    }

                    Files.copy(zis, newPath, StandardCopyOption.REPLACE_EXISTING);
                }

                zipEntry = zis.getNextEntry();
            }
            zis.closeEntry();
        }
    }

    public static Path zipSlipProtect(ZipEntry zipEntry, Path targetDir)
        throws IOException {
        Path targetDirResolved = targetDir.resolve(zipEntry.getName());
        Path normalizePath = targetDirResolved.normalize();
        if (!normalizePath.startsWith(targetDir)) {
            throw new IOException("Bad zip entry: " + zipEntry.getName());
        }
        return normalizePath;
    }
}
