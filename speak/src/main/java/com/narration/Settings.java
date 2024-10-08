package com.narration;

public class Settings {
    private boolean emailNotifications;
    private boolean isDarkMode;
    private User user ;

    public void toggleDarkMode(boolean isDarkMode){

    }

    public boolean getDarkMode(){
        return this.isDarkMode;
    }

    public void toggleEmailNotificaiton(boolean emailNotification){

    }

    public boolean getEmailNotifications(){
        return this.emailNotifications;
    }
}
