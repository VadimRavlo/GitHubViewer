package ua.com.wadyan.githubviewer.Activitys;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import butterknife.Bind;
import butterknife.ButterKnife;
import ua.com.wadyan.githubviewer.R;
import ua.com.wadyan.githubviewer.signin.SignInModel;
import ua.com.wadyan.githubviewer.signin.SignInWorkerFragment;

import static ua.com.wadyan.githubviewer.GlobalConstVar.LOG_TAG;

public class SignInActivity extends Activity implements SignInModel.Observer {
	private static final String TAG_WORKER = "TAG_WORKER";

	@Bind(R.id.view_username) EditText userName;
	@Bind(R.id.view_password) EditText password;
	@Bind(R.id.view_submit) View submit;
	@Bind(R.id.view_progress) View progress;

	private SignInModel signInModel;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		Log.i(LOG_TAG, "onCreate");
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_sign_in);
		ButterKnife.bind(this);

		submit.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(final View v) {
				final String userName = SignInActivity.this.userName.getText().toString();
				final String password = SignInActivity.this.password.getText().toString();

				signInModel.signIn(userName, password);
			}
		});

		final SignInWorkerFragment retainedWorkerFragment =
				(SignInWorkerFragment) getFragmentManager().findFragmentByTag(TAG_WORKER);

		if (retainedWorkerFragment != null) {
			signInModel = retainedWorkerFragment.getSignInModel();
		} else {
			final SignInWorkerFragment workerFragment = new SignInWorkerFragment();

			getFragmentManager().beginTransaction()
					.add(workerFragment, TAG_WORKER)
					.commit();

			signInModel = workerFragment.getSignInModel();
		}
		signInModel.registerObserver(this);
	}

	@Override
	protected void onDestroy() {
		Log.i(LOG_TAG, "onDestroy");
		super.onDestroy();
		signInModel.unregisterObserver(this);
		ButterKnife.unbind(this);

		if (isFinishing()) {
			signInModel.stopSignIn();
		}
	}

	@Override
	public void onSignInStarted(final SignInModel signInModel) {
		Log.i(LOG_TAG, "onSignInStarted");
		showProgress(true);
	}

	@Override
	public void onSignInSucceeded(final SignInModel signInModel) {
		Log.i(LOG_TAG, "onSignInSucceeded");
		finish();
		startActivity(new Intent(this, RepositoriesActivity.class));
	}

	@Override
	public void onSignInFailed(final SignInModel signInModel) {
		Log.i(LOG_TAG, "onSignInFailed");
		showProgress(false);
		Toast.makeText(this, R.string.sign_in_error, Toast.LENGTH_SHORT).show();
	}

	private void showProgress(final boolean show) {
		userName.setEnabled(!show);
		password.setEnabled(!show);
		submit.setEnabled(!show);
		progress.setVisibility(show ? View.VISIBLE : View.GONE);
	}
}
