package junseok.snr.study.pattern.design.structural.facade;

import java.io.File;

public class VideoConversionFacade {
    public File convertVideo(String fileName, String format) {
        System.out.println("VideoConversionFacade: conversion started.");
        final VideoFile file = new VideoFile(fileName);
        Codec sourceCodec = CodecFactory.extract(file);
        Codec destinationCodec;
        if (format.equals("mp4")) {
            destinationCodec = new MPEG4CompressionCodec();
        } else {
            destinationCodec = new OggCompressionCodec();
        }

        final VideoFile buffer = BitrateReader.read(file, sourceCodec);
        final VideoFile intermediateResult = BitrateReader.convert(buffer, destinationCodec);
        final File result = new AudioMixer().fix(intermediateResult);
        System.out.println("VideoConversionFacade: conversion completed.");
        return result;
    }
}
