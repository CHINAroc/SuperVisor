package com.gdut.supervisor;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
/**
 * ʹ�ð�����Fragment
 */
@SuppressLint("ValidFragment")
public class HelpFragment extends Fragment
{
	public static HelpFragment helpFragment;
	
	/**
	 * ˽�л����췽��
	 */
	private HelpFragment()
	{
		Log.v("log", "-->HelpFragment-HelpFragment()");
	}
	/**
	 * ����HelpFragment����ʹ��ͬ����
	 */
	private static synchronized void syscInt()
	{
		if(helpFragment == null)
		{
			Log.v("log", "-->HelpFragment-syscInt()");
			helpFragment = new HelpFragment();
		}
	}
	/**
	 *�ṩ�ⲿ����HelpFragment����ķ����� 
	 */
	public static  HelpFragment getInstance()
	{
		if(helpFragment == null)
		{
			Log.v("log", "-->HelpFragment-getInstance()");
			syscInt();
		}
		return helpFragment;
	}
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
	{
		return inflater.inflate(R.layout.help_fragment, container, false);
	}
}
