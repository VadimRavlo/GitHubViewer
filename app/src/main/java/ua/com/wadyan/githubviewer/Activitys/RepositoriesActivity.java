package ua.com.wadyan.githubviewer.Activitys;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import butterknife.Bind;
import butterknife.ButterKnife;
import ua.com.wadyan.githubviewer.GlobalConstVar;
import ua.com.wadyan.githubviewer.Model.User;
import ua.com.wadyan.githubviewer.R;

public class RepositoriesActivity extends Activity  {


	@Override
	public void onCreate(final Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_repositories);
		ButterKnife.bind(this);

		User user = GlobalConstVar.getCurrentUser(); //TODO

	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.menu_repo, menu);
		return super.onCreateOptionsMenu(menu);
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		switch (item.getItemId()){
			case R.id.action_search:
				//TODO
				break;
			default:
				break;
		}
		return super.onOptionsItemSelected(item);
	}

	@Override
	protected void onDestroy() {
		super.onDestroy();
		ButterKnife.unbind(this);
	}

}
