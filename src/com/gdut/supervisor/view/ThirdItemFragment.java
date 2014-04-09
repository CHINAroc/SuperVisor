package com.gdut.supervisor.view;

import java.text.SimpleDateFormat;
import java.util.Date;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.RadioGroup.OnCheckedChangeListener;
import android.widget.Toast;
import com.gdut.supervisor.R;

/**
 * ��������
 */
public class ThirdItemFragment extends Fragment implements OnClickListener, OnCheckedChangeListener
{
	private Button btn_summit_time;
	private RadioGroup rdoGop_if_ontime;
	private EditText edtTxt_summit_time, edtTxt_remark, edtTxt_teacher_name, edtTxt_supervisor;

	@Override
	public void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
	{

		View rootView = inflater.inflate(R.layout.third, container, false);
		addViewListener(rootView);
		return rootView;

	}

	@Override
	public void onDestroy()
	{
		super.onDestroy();
	}

	@Override
	public void onDestroyView()
	{
		super.onDestroyView();
	}

	/**
	 * �ؼ�
	 */
	private void addViewListener(View view)
	{
		// ��ʦ�Ƿ�ʱ��У
		rdoGop_if_ontime = (RadioGroup) view.findViewById(R.id.rdoGop_if_ontime);
		rdoGop_if_ontime.setOnCheckedChangeListener(this);
		// ��ȡʱ�䰴ť
		btn_summit_time = (Button) view.findViewById(R.id.btn_submit_time);
		btn_summit_time.setOnClickListener(this);
		// �ύʱ��
		edtTxt_summit_time = (EditText) view.findViewById(R.id.edtTxt_submitTime);
		// �ον�ʦ
		edtTxt_teacher_name = (EditText) view.findViewById(R.id.edtTxt_teacher_name);
		// ����Ա
		edtTxt_supervisor = (EditText) view.findViewById(R.id.edtTxt_supervisor);
		// ��ע
		edtTxt_remark = (EditText) view.findViewById(R.id.edtTxt_remark);
	}

	/**
	 * �ύʱ���ļ���
	 */
	@Override
	public void onClick(View v)
	{
		switch (v.getId())
		{
		// �ον�ʦ
		case R.id.edtTxt_teacher_name:
			break;
		// ����Ա
		case R.id.edtTxt_supervisor:
			break;
		// �����ȡ��ǰʱ��
		case R.id.btn_submit_time:
			SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			Date curDate = new Date(System.currentTimeMillis());
			String curTime = formatter.format(curDate);
			edtTxt_summit_time.setText(curTime);
			break;
		// ��ע
		case R.id.edtTxt_remark:
			break;
		default:
			break;
		}
	}

	/**
	 * RadioGroup�ον�ʦ�Ƿ�ʱ��У�ļ���
	 */
	@Override
	public void onCheckedChanged(RadioGroup group, int checkedId)
	{
		switch (checkedId)
		{
		// ��
		case R.id.rdoBtn_yes:
			Toast.makeText(getActivity(), "��", 0).show();
			break;
		// ��
		case R.id.rdoBtn_no:
			Toast.makeText(getActivity(), "��", 0).show();
			break;
		default:
			break;
		}
	}

}
