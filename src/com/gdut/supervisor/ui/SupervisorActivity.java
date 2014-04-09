package com.gdut.supervisor.ui;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.PagerTabStrip;
import android.support.v4.view.PagerTitleStrip;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.widget.Button;

import com.gdut.supervisor.R;
import com.gdut.supervisor.adapter.SupervisorAdapter;

/**
 * ����������FragmentActivity
 */
public class SupervisorActivity extends FragmentActivity
{
	/**
	 * ��viewPager ���ڼ���������
	 */
	private ViewPager viewPager;
	/**
	 * һ��viewpager��ָʾ����Ч������һ����Ĵֵ��»���
	 */
	private PagerTabStrip pagerTabStrip;
	//
	private PagerTitleStrip pagerTitleStrip;
	/**
	 * װ����viewpager�е�Adpter
	 */
	SupervisorAdapter pagerAdpter;
	/**
	 * װ��
	 */
	FragmentManager myFragmentManager;

	protected void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.form);
		// ʵ�����ؼ�
		viewPager = (ViewPager) findViewById(R.id.viewpager);
		pagerTabStrip = (PagerTabStrip) findViewById(R.id.pagertab);
		//
		myFragmentManager = getSupportFragmentManager();
		// Ϊviewpager����adapter
		SupervisorAdapter mySupervisorAdapter = new SupervisorAdapter(myFragmentManager);
		viewPager.setAdapter(mySupervisorAdapter);
	}
}
