package com.narration;

public class Settings {
    private boolean emailNotifications;
    private boolean isDarkMode;
    private User user ;

    public Settings(boolean emailNotif, boolean darkMode) {
        this.emailNotifications = emailNotif;
        this.isDarkMode = darkMode;
    }

    public void toggleDarkMode(boolean isDarkMode){
        this.isDarkMode = isDarkMode;
    }

    public boolean getDarkMode(){
        return this.isDarkMode;
    }

    public void toggleEmailNotificaiton(boolean emailNotification){
        this.emailNotifications = emailNotification;
    }

    public boolean getEmailNotifications(){
        return this.emailNotifications;
    }
}
