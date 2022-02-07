package spring.basics.resource.loading;

import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Component;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

@Component
public class Whizlabs {
    private final ResourceLoader resourceLoader;

    public Whizlabs(ResourceLoader resourceLoader) {
        this.resourceLoader = resourceLoader;
    }

    public void loadResourceFromClassPath() throws IOException {
        Resource resource = resourceLoader.getResource("classpath:resource/mission.txt");
        File file = resource.getFile();
        Files.lines(file.toPath()).forEach(System.out::println);
    }

    public void loadResourceFromFileSystem() throws IOException {
        Resource resource = resourceLoader.getResource("file:resource/mission.txt");
        File file = resource.getFile();
        Files.lines(file.toPath()).forEach(System.out::println);
    }
}
