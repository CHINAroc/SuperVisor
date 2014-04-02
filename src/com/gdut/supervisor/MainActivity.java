package com.gdut.supervisor;

import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarActivity;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.RadioGroup;
import android.widget.RadioGroup.OnCheckedChangeListener;
import android.widget.Toast;

/**
 * ���˵�����,�赼��support-v7-appcompat֧�ְ�
 */
public class MainActivity extends ActionBarActivity implements OnClickListener
{
	private RadioGroup mTabRg;
	private ActionBar mActionBar;
	private Menu mMenu;
	private EvaluateFragment evaluateFragment;
	private SupervisorFragment supervisorFragment;
	private SearchFragment searchFragment;
	private HelpFragment helpFragment;

	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		// ��ʼ��
		InitView();
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu)
	{
		this.mMenu = menu;
		return true;
	}

	/**
	 * ��ʼ������
	 */
	private void InitView()
	{
		//��ʼ���ĸ�Fragment
		evaluateFragment = EvaluateFragment.getInstance();
		supervisorFragment = SupervisorFragment.getInstance();
		searchFragment = SearchFragment.getInstance();
		helpFragment = HelpFragment.getInstance();
		// ����ActionBar������ɫ
		mActionBar = getSupportActionBar();
		mActionBar.setBackgroundDrawable(getResources().getDrawable(R.color.actionbar_background));
		// �״ν���ʱ����SupervisorFragment(��������)��������
		final android.support.v4.app.FragmentManager fragmentManager = getSupportFragmentManager();
		android.support.v4.app.FragmentTransaction fragmentTransaction = fragmentManager
				.beginTransaction();
		fragmentTransaction.replace(R.id.fragment_content, supervisorFragment);
		fragmentTransaction.commit();

		mTabRg = (RadioGroup) findViewById(R.id.tab_rg_menu);
		// Ϊ�ײ��˵�������Ӽ���
		mTabRg.setOnCheckedChangeListener(new OnCheckedChangeListener()
		{
			@Override
			public void onCheckedChanged(RadioGroup group, int checkedId)
			{
				final android.support.v4.app.FragmentTransaction fragmentTransaction = fragmentManager
						.beginTransaction();
				switch (checkedId)
				{
				// ��������
				case R.id.tab_rb_1:
					// ����˵�
					mMenu.clear();
					fragmentTransaction.replace(R.id.fragment_content, supervisorFragment);
					break;
				// ��ѯ��
				case R.id.tab_rb_2:
					mMenu.clear();
					getMenuInflater().inflate(R.menu.actionbar_searchform, mMenu);
					fragmentTransaction.replace(R.id.fragment_content, searchFragment);
					break;
				// ������ʦ
				case R.id.tab_rb_3:
					mMenu.clear();
					getMenuInflater().inflate(R.menu.actionbar_evaluate, mMenu);
					fragmentTransaction.replace(R.id.fragment_content,evaluateFragment);
					break;
				// ʹ�ð���
				case R.id.tab_rb_4:
					mMenu.clear();
					fragmentTransaction.replace(R.id.fragment_content, helpFragment);
					break;
				default:
					break;
				}
				fragmentTransaction.commit();
			}
		});
	}

	/**
	 * ���ؼ�����Ӧ
	 */
	@Override
	public boolean dispatchKeyEvent(KeyEvent event)
	{
		if (event.getKeyCode() == KeyEvent.KEYCODE_BACK)
		{
			if (event.getAction() == KeyEvent.ACTION_DOWN && event.getRepeatCount() == 0)
			{
				new AlertDialog.Builder(this).setTitle("��ʾ").setMessage("ȷ���˳���")
						.setPositiveButton("ȷ��", new DialogInterface.OnClickListener()
						{
							@Override
							public void onClick(DialogInterface dialog, int which)
							{
								finish();
							}
						}).setNegativeButton("ȡ��", null).show();
			}
			return true;
		}
		return super.dispatchKeyEvent(event);
	}

	/**
	 * Button��Ӧ
	 */
	@Override
	public void onClick(View v)
	{
		AlertDialog.Builder builder = new Builder(MainActivity.this);
		builder.setCancelable(false);
		LayoutInflater inflater = LayoutInflater.from(MainActivity.this);
		View view = inflater.inflate(R.layout.alertdialog_searchform_datechoose_datepicker, null);
		switch (v.getId())
		{
		// ѡ��ʼʱ���Button
		case R.id.btn_searchform_begindate:
			builder.setTitle("ʱ��");
			builder.setView(view);
			builder.setPositiveButton("ȷ��", null);
			builder.setNegativeButton("ȡ��", null);
			builder.create().show();
			break;
		// ѡ�����ʱ���Button
		case R.id.btn_searchform_enddate:
			builder.setTitle("ʱ��");
			builder.setView(view);
			builder.setPositiveButton("ȷ��", null);
			builder.setNegativeButton("ȡ��", null);
			builder.create().show();
			break;
		// ������Button
		// ...
		default:
			break;
		}
	}

	/**
	 * �������˵�������Ӧ
	 */
	@Override
	public boolean onOptionsItemSelected(MenuItem item)
	{
		AlertDialog.Builder builder = new Builder(MainActivity.this);
		builder.setInverseBackgroundForced(true);
		builder.setIcon(R.drawable.icon);
		// �����Ƿ������Եȡ����ʾ��2.3Ĭ��
		builder.setCancelable(false);
		LayoutInflater inflater = LayoutInflater.from(MainActivity.this);
		View view = null;
		switch (item.getItemId())
		{
		// ��ѯ���Ĳ˵�Button
		case R.id.menu_actionbar_searchform:
			view = inflater.inflate(R.layout.alertdialog_serarchform_datechoose, null);
			builder.setTitle("��ѡ��ʱ��");
			builder.setPositiveButton("ȷ��", null);
			builder.setNegativeButton("ȡ��", null);
			Button btn1, btn2;
			btn1 = (Button) view.findViewById(R.id.btn_searchform_begindate);
			btn2 = (Button) view.findViewById(R.id.btn_searchform_enddate);
			btn1.setOnClickListener(this);
			btn2.setOnClickListener(this);
			builder.setView(view);
			builder.create().show();
			break;
		// ������ʦ�Ĳ˵�Button
		case R.id.menu_actionbar_evaluate_summit:
			builder.setTitle("�ύ��");
			view = inflater.inflate(R.layout.alertdialog_evaluate_summit, null);
			builder.setNegativeButton("ȡ��", null);
			builder.setView(view);
			builder.create().show();
			break;
		case android.R.id.home:
			Toast.makeText(this, "����", 0).show();
		default:
			break;
		}
		
		return true;
	}
}
