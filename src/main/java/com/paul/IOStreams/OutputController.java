package com.paul.IOStreams;

import java.io.IOException;
import java.io.OutputStream;
import java.util.Locale;
import java.util.ResourceBundle;

public class OutputController {
    private final OutputStream output;
    private String language;
    private String country;
    private Locale currentLocale;
    private ResourceBundle messages;


    public void switchLanguage() {
        if (language.equals("en"))language="pl";
        else language="en";
        if (country.equals("US"))country="PL";
        else country ="US";
        currentLocale = new Locale(language, country);
        messages = ResourceBundle.getBundle("Language", currentLocale);
    }
    public OutputController(OutputStream output) {
        this.output=output;
        this.language="en";
        this.country="US";
        this.currentLocale=new Locale(language,country);
        this.messages = ResourceBundle.getBundle("Language",currentLocale);
    }
     public void writeOut(String message) {
        try {
            String nLineMessage = messages.getString(message);
            output.write(nLineMessage.getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void writeOut(String message,Object property) {
        try {
            String nLineMessage = messages.getString(message) + property.toString();
            output.write(nLineMessage.getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
