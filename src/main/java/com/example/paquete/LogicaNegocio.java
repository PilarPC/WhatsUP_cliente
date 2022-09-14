package com.example.paquete;

import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;

// Patrón Singleton para sólo tener una instancia de la clase
public class LogicaNegocio {

    private static LogicaNegocio INSTANCE;

    public String conectados = "";
    public String contactoElegido = "";
    public int llave = 0;


    private LogicaNegocio() {

    }

    public static LogicaNegocio getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new LogicaNegocio();
        }
        return INSTANCE;
    }

    public String readChatFile(int key) throws IOException {
        return switch (key) {
            case 1 -> Files.readString(Paths.get("chatMiguelPilar.txt"));
            case 2 -> Files.readString(Paths.get("chatMiguelSantiago.txt"));
            case 3 -> Files.readString(Paths.get("chatPilarSantiago.txt"));
            default -> "";
        };
    }

    public void saveChatFile(String sender, String receiver, String content) throws IOException {
        if (sender.equals("Miguel") && receiver.equals("Pilar") || sender.equals("Pilar") && receiver.equals("Miguel")) {
            FileWriter myWriter = new FileWriter("chatMiguelPilar.txt", true);
            myWriter.append(content);
            myWriter.close();
        }
        else if (sender.equals("Miguel") && receiver.equals("Santiago") || sender.equals("Santiago") && receiver.equals("Miguel")) {
            FileWriter myWriter = new FileWriter("chatMiguelSantiago.txt", true);
            myWriter.append(content);
            myWriter.close();
        }
        else if (sender.equals("Pilar") && receiver.equals("Santiago") || sender.equals("Santiago") && receiver.equals("Pilar")) {
            FileWriter myWriter = new FileWriter("chatPilarSantiago.txt", true);
            myWriter.append(content);
            myWriter.close();
        }
    }
}