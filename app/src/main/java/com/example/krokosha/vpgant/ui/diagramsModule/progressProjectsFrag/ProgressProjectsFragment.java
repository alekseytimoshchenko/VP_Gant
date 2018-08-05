package com.example.krokosha.vpgant.ui.diagramsModule.progressProjectsFrag;

import android.arch.lifecycle.ViewModelProviders;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.krokosha.vpgant.App;
import com.example.krokosha.vpgant.R;
import com.example.krokosha.vpgant.ui.descriptionModule.DescriptionActivity;
import com.example.krokosha.vpgant.utils.Constants;

import java.util.Collections;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created with care by Alexey.T on 02/08/2518.
 * <p>
 * TODO: Add a class header comment!
 */
public class ProgressProjectsFragment extends Fragment
{
	@BindView(R.id.rv_progress_frag)
	RecyclerView mRv;
	
	@Inject
	ProgressFragModelFactory mFactory;
	
	private ProgressViewModel mProgressViewModel;
	
	@Override
	public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
	{
		View root = inflater.inflate(R.layout.frag_progress_projects_layout, container, false);
		ButterKnife.bind(this, root);
		return root;
	}
	
	@Override
	public void onActivityCreated(@Nullable final Bundle savedInstanceState)
	{
		super.onActivityCreated(savedInstanceState);
		App.getApp(getActivity()).getComponentsHolder().getActivityComponent(getClass()).inject(this);
		obtainViewModel();
		setProgressAdapter();
		observeViewModel();
	}
	
	private void obtainViewModel()
	{
		mProgressViewModel = ViewModelProviders.of(this, mFactory).get(ProgressViewModel.class);
	}
	
	private void observeViewModel()
	{
		mProgressViewModel.entitySingleLiveData.observe(//
				this, //
				iListSparseArray -> ((ProgressDiagramAdapter) mRv.getAdapter()).setData(iListSparseArray)//
		);
		
		mProgressViewModel.itemClicked.observe(this, iPosition -> {
			Intent i = new Intent(getContext(), DescriptionActivity.class);
			i.putExtra(Constants.ITEM_POSITION, iPosition);
			startActivity(i);
			getActivity().overridePendingTransition(R.anim.anim_slide_in_left, R.anim.anim_slide_out_left);
		});
	}
	
	private void setProgressAdapter()
	{
		mRv.setAdapter(new ProgressDiagramAdapter(Collections.EMPTY_LIST, mProgressViewModel));
	}
	
	@Override
	public void setUserVisibleHint(final boolean isVisibleToUser)
	{
		super.setUserVisibleHint(isVisibleToUser);
		
		if (isVisibleToUser)
		{
			mProgressViewModel.getEntities();
		}
	}
}
