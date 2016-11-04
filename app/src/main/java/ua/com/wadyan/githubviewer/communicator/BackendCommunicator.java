package ua.com.wadyan.githubviewer.communicator;


public interface BackendCommunicator {
	boolean postSignIn(String userName, String password) throws InterruptedException;
}
