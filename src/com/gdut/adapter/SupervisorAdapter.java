package com.gdut.adapter;

import java.util.ArrayList;
import java.util.List;

import com.gdut.supervisor.FirstItemActivity;
import com.gdut.supervisor.SecondItemActivity;
import com.gdut.supervisor.ThirdItemActivity;
import com.gdut.supervisor.SupervisorActivity;


import android.content.Context;
import android.content.Intent;
import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;

/**
 * ���Զ����SupervisorAdapter�̳���PagerAdapter,���ڼ�����������view��
 * @������(������ҳ��)��view�ɷ���ActivityGroup.getLocalActivityManager().startActivity(String ActivityNmae,
*	Intent intent).getDecorView()�õ���
*
*@���г�Ա�����ĸ�ֵ�����Զ���Ĺ��캯��SupervisorAdapter(Context context)��ʵ�֣�
*����ÿ��ҳ��ı����ṩ��List<String> titleList��ÿ��ҳ���ṩ��List<View> viewList
 */
public class SupervisorAdapter extends PagerAdapter {
	/**
	 * �洢SupervisorActivity�������Ķ��� 
	 */
Context context;
/**
 * ����Ҫ������ҳ����ӵ����list��  
 */	
	private List<View> viewList;
	
	/**
	 * ��List����������ı���ı���
	 */
  private List<String> titleList;
	/**
	 * ����������ͼ����
	 */	
  private LayoutParams param;
  //Ĭ�ϵĹ��캯��
  public SupervisorAdapter(){}
  
  @SuppressWarnings("deprecation")
  //�Զ���Ĺ��캯��
public SupervisorAdapter(Context context)
  {
	    //��ȡSupervisorActivity�������Ķ���
	    this.context=context;
	    //Ϊ���������ñ��⣬����titleList��
	    titleList = new ArrayList<String>();// ÿ��ҳ���Title����  
	    titleList.add("��һ");  
	    titleList.add("����");  
	    titleList.add("����"); 
	    
	    //��ȡ������Activity��Ӧ��view,�����viewList�У�
	    viewList=new ArrayList<View>();
	    //����������view�Ĳ�����ʹ�����������ڲ���
	    param = new LayoutParams(LayoutParams.MATCH_PARENT,
				LayoutParams.MATCH_PARENT);
	    //�õ��������Ĳ���
	    //�õ���һ����FirstItemActivity���ڵ�view
	    View view=((SupervisorActivity)context).getLocalActivityManager().startActivity("FirstItemActivity",
				           new Intent(context,FirstItemActivity.class))
				           .getDecorView();
	    view.setLayoutParams(param);
	    viewList.add(view);
	    
	    //  �õ��ڶ�����SecondItemActivity���ڵ�view
	             view=((SupervisorActivity)context).getLocalActivityManager().startActivity("SecondItemActivity",
				          new Intent(context,SecondItemActivity.class))
				         .getDecorView();
	    view.setLayoutParams(param);
	    viewList.add(view);
	    
	    //  �õ���������ThirdItemActivity���ڵ�view
	           view=((SupervisorActivity)context).getLocalActivityManager().startActivity("ThirdItemActivity",
				         new Intent(context, ThirdItemActivity.class))
				         .getDecorView();
	    view.setLayoutParams(param);
	    viewList.add(view);
  }
  
  /*
   * ���¶��Ǹ���PagerAdapter��δʵ�ַ�����ʵ��
   */
  @Override
	public void destroyItem(ViewGroup container, int position,
			Object object) {
		// TODO Auto-generated method stub
		container.removeView(viewList.get(position));  
	}

	@Override
	public int getItemPosition(Object object) {
		// TODO Auto-generated method stub
		return super.getItemPosition(object);
	}
	 /**
	   * ��ȡ��Ӧҳ��ı��⣬��titleList �ṩ
	   */
	@Override
	public CharSequence getPageTitle(int position) {

		// TODO Auto-generated method stub
	   return titleList.get(position);
	}
	  /**
	   * ��ʼ����Ӧҳ��Ĳ��֣�������viewList�ṩ
	   */
	@Override
	public Object instantiateItem(ViewGroup container, int position) {
		// TODO Auto-generated method stub
		container.addView(viewList.get(position));
		return viewList.get(position);  
	}
	  /**
	   * �õ���viewpager���ص�����ҳ�����ҳ��
	   */
	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return viewList.size();
	}

	@Override
	public boolean isViewFromObject(View arg0, Object arg1) {
		// TODO Auto-generated method stub
		return arg0 == arg1;  
	}

}
