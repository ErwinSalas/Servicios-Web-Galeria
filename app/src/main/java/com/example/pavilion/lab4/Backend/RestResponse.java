package com.example.pavilion.lab4.Backend;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Pavilion on 2/6/2017.
 */
public class RestResponse {
    ArrayList<String> messages;
    ArrayList<Pais> result;

    public RestResponse(ArrayList<String> messages, ArrayList<Pais> result) {
        this.messages = messages;
        this.result = result;
    }

    public ArrayList<String> getMessages() {
        return messages;
    }

    public void setMessages(ArrayList<String> messages) {
        this.messages = messages;
    }

    public ArrayList<Pais> getResult() {
        return result;
    }

    public void setResult(ArrayList<Pais> result) {
        this.result = result;
    }
}

