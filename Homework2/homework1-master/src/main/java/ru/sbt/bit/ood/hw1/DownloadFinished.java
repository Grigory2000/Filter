package ru.sbt.bit.ood.hw1;


/**
 * Created by Григорий on 20.12.2016.
 */

public class DownloadFinished implements Downloader {
    public String downloadTradesFile() {
        System.out.println("Downloading finished");
        return null;
    }
}