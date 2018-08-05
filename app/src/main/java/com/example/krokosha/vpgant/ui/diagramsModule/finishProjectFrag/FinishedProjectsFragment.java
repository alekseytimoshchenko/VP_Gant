package com.example.krokosha.vpgant.ui.diagramsModule.finishProjectFrag;

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
 * Created with care by Alexey.T on 02/08/2018.
 * <p>
 * TODO: Add a class header comment!
 */
public class FinishedProjectsFragment extends Fragment
{
	@BindView(R.id.rv_finished_frag)
	RecyclerView mRv;
	
	@Inject
	FinishedFragModelFactory mFactory;
	
	private FinishedFragViewModel mModel;
	
	@Override
	public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
	{
		View root = inflater.inflate(R.layout.frag_finish_projects_layout, container, false);
		ButterKnife.bind(this, root);
		return root;
	}
	
	@Override
	public void onActivityCreated(@Nullable final Bundle savedInstanceState)
	{
		super.onActivityCreated(savedInstanceState);
		App.getApp(getActivity()).getComponentsHolder().getActivityComponent(getClass()).inject(this);
		obtainViewModel();
		setFinishedAdapter();
		observeViewModel();
		mModel.getEntities();
		setRvScrollListener();
	}
	
	private void setRvScrollListener()
	{
		mRv.addOnScrollListener(new RecyclerView.OnScrollListener()
		{
			@Override
			public void onScrollStateChanged(@NonNull final RecyclerView recyclerView, final int newState)
			{
				super.onScrollStateChanged(recyclerView, newState);
			}
			
			@Override
			public void onScrolled(@NonNull final RecyclerView recyclerView, final int dx, final int dy)
			{
				super.onScrolled(recyclerView, dx, dy);
			}
		});
	}
	
	private void observeViewModel()
	{
		mModel.entitySingleLiveData.observe(this, iProjectObjs -> ((FinishedDiagramAdapter) mRv.getAdapter()).setData(iProjectObjs));
		
		mModel.itemClicked.observe(this, iPosition -> {
			Intent i = new Intent(getContext(), DescriptionActivity.class);
			i.putExtra(Constants.ITEM_POSITION, iPosition);
			startActivity(i);
			getActivity().overridePendingTransition(R.anim.anim_slide_in_left, R.anim.anim_slide_out_left);
		});
	}
	
	private void obtainViewModel()
	{
		mModel = ViewModelProviders.of(this, mFactory).get(FinishedFragViewModel.class);
	}
	
	private void setFinishedAdapter()
	{
		mRv.setAdapter(new FinishedDiagramAdapter(Collections.EMPTY_LIST, mModel));
	}
	
	@Override
	public void setUserVisibleHint(final boolean isVisibleToUser)
	{
		super.setUserVisibleHint(isVisibleToUser);
		
		if (isVisibleToUser && mModel != null)
		{
			mModel.getEntities();
		}
	}
}
