package com.gdut.supervisor.ui;

import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.RadioGroup;
import android.widget.RadioGroup.OnCheckedChangeListener;

import com.gdut.supervisor.R;
import com.gdut.supervisor.view.EducationalFragment;
import com.gdut.supervisor.view.EvaluateFragment;
import com.gdut.supervisor.view.SupervisorFragment;
import com.gdut.supervisor.view.ToolsFragment;

/**
 * ���˵�����,�赼��support-v7-appcompat֧�ְ�
 */
public class MainActivity extends ActionBarActivity implements OnClickListener
{
	private RadioGroup mTabRg;
	private EvaluateFragment evaluateFragment;
	private SupervisorFragment supervisorFragment;
	private EducationalFragment searchFragment;
	private ToolsFragment helpFragment;

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
		getMenuInflater().inflate(R.menu.popup_menu, menu);
		return super.onCreateOptionsMenu(menu);
	}

	/**
	 * ��ʼ������
	 */
	private void InitView()
	{
		//��ʼ���ĸ�Fragment
		evaluateFragment = EvaluateFragment.getInstance();
		supervisorFragment = SupervisorFragment.getInstance();
		searchFragment = EducationalFragment.getInstance();
		helpFragment = ToolsFragment.getInstance();
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
					fragmentTransaction.replace(R.id.fragment_content, supervisorFragment);
					break;
				// ��ѯ��
				case R.id.tab_rb_2:
					fragmentTransaction.replace(R.id.fragment_content, searchFragment);
					break;
				// ������ʦ
				case R.id.tab_rb_3:
					fragmentTransaction.replace(R.id.fragment_content,evaluateFragment);
					break;
				// ʹ�ð���
				case R.id.tab_rb_4:
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

}
