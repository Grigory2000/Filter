package ru.sbt.bit.ood.hw1;

/**
 * Created by Григорий on 20.12.2016.
 */

public class TradeJobMain {
    private final TradesDAO tradesDAO;
    private Downloader downloader;
    public Parser parser;

    public TradeJobMain(){ tradesDAO = null;}
    public TradeJobMain(TradesDAO tradesDAO, String fileName, Parser parser, Downloader downloader) {
        this.tradesDAO = tradesDAO;
        this.downloader = downloader;
        this.parser = parser;
    }

    public void run() {
        String filename = downloader.downloadTradesFile();
        Iterable<Trade> tradeRecords = parser.parse();
        updateTrades(tradeRecords);
    }



    private void updateTrades(Iterable<Trade> trades) {
        tradesDAO.deleteAll();
        if(trades != null)
            for (Trade tradeRecord : trades) {
                tradesDAO.save(tradeRecord);
            }
    }
}
