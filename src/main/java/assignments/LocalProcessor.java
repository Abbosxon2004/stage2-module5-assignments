package assignments;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.LinkedList;
import java.util.ListIterator;
import java.util.Scanner;

import assignments.annotations.FullNameProcessorGeneratorAnnotation;
import assignments.annotations.ListIteratorAnnotation;
import assignments.annotations.ReadFullProcessorNameAnnotation;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class LocalProcessor {
    private String processorName;
    private Long period = 10000000000000L;
    private String processorVersion;
    private Integer valueOfCheap;
    private Scanner informationScanner;
    private LinkedList<String> stringArrayList = new LinkedList<>();

    public LocalProcessor(String processorName, long period, String processorVersion, Integer valueOfCheap,
                          Scanner informationScanner, LinkedList<String> stringArrayList) {
        this.processorName = processorName;
        this.period = period;
        this.processorVersion = processorVersion;
        this.valueOfCheap = valueOfCheap;
        this.informationScanner = informationScanner;
        this.stringArrayList = stringArrayList;
    }

    public LocalProcessor() {
    }

    @ListIteratorAnnotation
    public void listIterator(LinkedList<String> stringList) {
//        stringArrayList = new LinkedList<>(stringList);
//        for (int i = 0; i < period; i++) {
//            System.out.println(stringArrayList.get(i).hashCode());
//        }
        ListIterator<String> iterator = stringList.listIterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next().hashCode());
        }
    }

    @FullNameProcessorGeneratorAnnotation
    public String fullNameProcessorGenerator() {
//        for (int i = 0; i < stringArrayList.size(); i++) {
//            processorName+=stringList.get(i)+' ';
//        }
//        return processorName;
        StringBuilder builder = new StringBuilder();
        for (String str : stringArrayList) {
            builder.append(str).append(' ');
        }
        processorName = builder.toString();
        return processorName;
    }

    @ReadFullProcessorNameAnnotation
    public void readFullProcessorName(File file) throws FileNotFoundException {
        informationScanner = new Scanner(file);
        StringBuilder builder = new StringBuilder();
        while (informationScanner.hasNextLine()) {
            builder.append(informationScanner.nextLine());
        }
        processorVersion = builder.toString();
    }
}
