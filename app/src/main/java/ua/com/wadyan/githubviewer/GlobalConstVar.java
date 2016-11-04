package ua.com.wadyan.githubviewer;


import android.util.Log;

import ua.com.wadyan.githubviewer.Model.User;

/**
 * Created by << Wad + >> on 04.11.2016.
 */

public class GlobalConstVar {
    public static final String LOG_TAG = "Wad";

    private static User currentUser;

    public static User getCurrentUser() {
        return currentUser;
    }

    public static void setCurrentUser(User currentUser) {
        GlobalConstVar.currentUser = currentUser;
    }

}
