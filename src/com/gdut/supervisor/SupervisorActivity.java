package com.gdut.supervisor;


import android.app.ActivityGroup;
import android.os.Bundle;
import android.support.v4.view.PagerTitleStrip;
import android.support.v4.view.ViewPager;

import com.gdut.adapter.SupervisorAdapter;

@SuppressWarnings("deprecation")
public class SupervisorActivity extends ActivityGroup {

    /**
     * ��viewPager ���ڼ���������
     */
    private ViewPager viewPager; 
    /**
     * һ��viewpager��ָʾ����Ч������һ����Ĵֵ��»���
     */
    private PagerTitleStrip pagerTabStrip;
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
		 pagerTabStrip=(PagerTitleStrip)findViewById(R.id.pagertab);
		 
		 //Ϊviewpager����adapter	
		 pagerAdpter =new SupervisorAdapter(SupervisorActivity.this);
    	 viewPager.setAdapter(pagerAdpter);
		}



}
