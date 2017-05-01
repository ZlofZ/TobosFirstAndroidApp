package test.apps.mrtobi.tobosfirstandroidapp;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity{
	private long money=0;
	private int progress=0;
	private int addAmount=1;
	private TextView number;
	private ProgressBar pgb;
	private Button upgradeButton;
	private Button addOneDollar;
	
	private void upgradeMoneyMaker(){
		upgradeButton=(Button)findViewById(R.id.upgradeMoneyMaker);
		upgradeButton.setVisibility(3);
		upgradeButton.setOnClickListener(new View.OnClickListener(){
			@Override
			public void onClick(View view){
				progress=0;
				pgb.setProgress(0);
				addAmount*=10;
				upgradeButton.setOnClickListener(null);
				upgradeButton.setVisibility(-1);
				addOneDollar.setText("+"+addAmount+"$");
			}
		});
	}
	
	private boolean isProgressDone(){
		return (pgb.getProgress()>=pgb.getMax());
	}
	
	
	private void addMoney(int addedMoney){
		money+=addedMoney;
		progress++;
		CharSequence cs="Money:"+money+", and progress is:"+progress;
		number.setText(cs);
		pgb.setProgress(progress);
		if(isProgressDone())upgradeMoneyMaker();
	}
	
	private void makeButton(){
		pgb=(ProgressBar)findViewById(R.id.roadToHunnid);
		pgb.setMax(100);
		addOneDollar=(Button)findViewById(R.id.makeDorros);
		number=(TextView) findViewById(R.id.moneyAmount);
		
		
		addOneDollar.setOnClickListener(new View.OnClickListener(){
			@Override
			public void onClick(View view){
				addMoney(addAmount);
			}
		});
	}
	
	
	@Override
	protected void onCreate(Bundle savedInstanceState){
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		
		makeButton();
		
		
		
		Toolbar toolbar=(Toolbar) findViewById(R.id.toolbar);
		setSupportActionBar(toolbar);
		
		FloatingActionButton fab=(FloatingActionButton) findViewById(R.id.fab);
		fab.setOnClickListener(new View.OnClickListener(){
			@Override
			public void onClick(View view){
				Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
						.setAction("Action", null).show();
			}
		});
	}
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu){
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.menu_main, menu);
		return true;
	}
	
	@Override
	public boolean onOptionsItemSelected(MenuItem item){
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id=item.getItemId();
		
		//noinspection SimplifiableIfStatement
		if(id==R.id.action_settings){
			return true;
		}
		
		return super.onOptionsItemSelected(item);
	}
}
