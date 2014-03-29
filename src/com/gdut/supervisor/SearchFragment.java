package com.gdut.supervisor;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;
import android.widget.Toast;

import com.gdut.supervisor.utils.SearchFormAdapter;
/**
 * ����ѯ��Fragment
 * @author Mr.Zheng
 *
 */
public class SearchFragment extends Fragment implements OnItemClickListener
{
	private ListView listView;
	private View view;
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
	{
		view = inflater.inflate(R.layout.search_fragment, container, false);
		listView = (ListView)view.findViewById(R.id.lv_searchform_everyday);
		listView.setOnItemClickListener(this);
		listView.setAdapter(new SearchFormAdapter(getActivity(), null));
		return view;
	}
	//Item�������
	@Override
	public void onItemClick(AdapterView<?> parent, View view, int position, long id)
	{
		Toast.makeText(getActivity(), "����˵�:" + (position+1) + "��", 0).show();
	}
}
