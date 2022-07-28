package junseok.snr.study.pattern.design.structural.facade;

import java.io.File;

public class Demo {
    public static void main(String[] args) {
        final VideoConversionFacade converter = new VideoConversionFacade();
        final File mp4Video = converter.convertVideo("youtubevideo.ogg", "mp4");
    }
}
