package ua.com.wadyan.githubviewer.communicator;


class BackendCommunicatorStub implements BackendCommunicator {
	private boolean validUsername, validPassword;

	@Override
	public boolean postSignIn(final String userName, final String password) throws InterruptedException {
		Thread.sleep(500);
//		for (int i = 0; i < GlobalConstVar.getUserList().length; i++) {
//			User user = GlobalConstVar.getUserList()[i];
//			validUsername = user.getName().equals(userName);
//			validPassword = user.getPassword().equals(password);
//			GlobalConstVar.setCurrentUser(user);
//			if (validUsername && validPassword) break;
//		}
//		return validUsername && validPassword; TODO
	return true;
	}
}
