package com.campuslostfound.util;
import java.nio.file.Path;
public class BackupService extends Thread {private final CsvExporter exporter;public BackupService(CsvExporter e){exporter=e;}public void run(){try{exporter.exportItems(Path.of("data","items_backup.csv"));System.out.println("[Backup Thread] Backup completed: data/items_backup.csv");}catch(Exception e){System.out.println("[Backup Thread] Backup failed: "+e.getMessage());}}}
