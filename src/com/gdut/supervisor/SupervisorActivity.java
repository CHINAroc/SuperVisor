package com.gdut.supervisor;


import com.gdut.adapter.SupervisorAdapter;
import com.gdut.supervisor.R;

import android.support.v4.view.PagerTabStrip;
import android.support.v4.view.ViewPager;
import android.support.v4.view.PagerTitleStrip;
import android.app.ActivityGroup;
import android.os.Bundle;

@SuppressWarnings("deprecation")
public class SupervisorActivity extends ActivityGroup {

    /**
     * ��viewPager ���ڼ�����������
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
    SupervisorAdapter  pagerAdpter;
    
	protected void onCreate(Bundle savedInstanceState) {
		  super.onCreate(savedInstanceState);
		  setContentView(R.layout.form);
        //ʵ�����ؼ�
		 viewPager=(ViewPager)findViewById(R.id.viewpager);		 
		 pagerTabStrip=(PagerTabStrip)findViewById(R.id.pagertab);
		 
		 //Ϊviewpager����adapter	
		 pagerAdpter =new SupervisorAdapter(SupervisorActivity.this);
    	 viewPager.setAdapter(pagerAdpter);
		}



}