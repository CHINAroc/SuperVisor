package com.gdut.supervisor;


import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageButton;
/**
 * �������ܵ�Fragment
 */
@SuppressLint("ValidFragment")
public class SupervisorFragment extends Fragment implements OnClickListener
{
	private ImageButton btn_directwrite, btn_preparewrite;
	public static SupervisorFragment supervisorFragment;

	/**
	 * ˽�л����췽��
	 */
	private SupervisorFragment()
	{
		Log.v("log", "-->SupervisorFragment-SupervisorFragment()");
	}
	/**
	 * ����SupervisorFragment����ʹ��ͬ����
	 */
	private static synchronized void syscInt()
	{
		if (supervisorFragment == null)
		{
			Log.v("log", "-->SupervisorFragment-syscInt()");
			supervisorFragment = new SupervisorFragment();
		}
	}
	/**
	 *�ṩ�ⲿ����SupervisorFragment����ķ����� 
	 */
	public static SupervisorFragment getInstance()
	{
		if (supervisorFragment == null)
		{
			Log.v("log", "-->SupervisorFragment-getInstance()");
			syscInt();
		}
		return supervisorFragment;
	}
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
	{
		View parentView = inflater.inflate(R.layout.supervisor_fragment, container, false);
		btn_directwrite = (ImageButton)parentView.findViewById(R.id.ib_supervisor_directwrite);
		btn_preparewrite = (ImageButton)parentView.findViewById(R.id.ib_supervisor_preparewrite);
		btn_directwrite.setOnClickListener(this);
		btn_preparewrite.setOnClickListener(this);
		return parentView;
	}
	//Ϊ��ť��Ӽ���
	@Override
	public void onClick(View v)
	{
		switch (v.getId())
		{
		//Ԥ��¼�밴ť
		case R.id.ib_supervisor_preparewrite:
			
			break;
		//ֱ��¼�밴ť
		case R.id.ib_supervisor_directwrite:
			Intent intent = new Intent();
			intent.setClass(getActivity(), SupervisorActivity.class);
		    startActivity(intent);
			break;
		default:
			break;
		}
		
	}
}
