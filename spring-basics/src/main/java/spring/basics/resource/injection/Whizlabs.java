package spring.basics.resource.injection;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.io.InputStream;
import java.util.Scanner;

@Component
public class Whizlabs {
    private final Resource resource;

    public Whizlabs(@Value("resource/mission.txt") Resource resource) {
        this.resource = resource;
    }

    public void printResourceContent() throws IOException {
        InputStream inputStream = resource.getInputStream();
        Scanner scanner = new Scanner(inputStream);
        while(scanner.hasNext()) {
            String line = scanner.nextLine();
            System.out.println(line);
        }
        scanner.close();
    }
}
