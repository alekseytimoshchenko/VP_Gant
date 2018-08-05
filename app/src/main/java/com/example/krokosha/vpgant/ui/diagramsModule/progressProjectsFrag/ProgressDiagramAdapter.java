package com.example.krokosha.vpgant.ui.diagramsModule.progressProjectsFrag;

import com.example.krokosha.vpgant.data.objects.ProjectObj;
import com.example.krokosha.vpgant.ui.diagramsModule.adapter.BaseDiagramAdapter;

import java.util.List;

/**
 * Created with care by Alexey.T on 04/08/2018.
 * <p>
 * TODO: Add a class header comment!
 */
class ProgressDiagramAdapter extends BaseDiagramAdapter
{
	private ProgressViewModel mModel;
	
	ProgressDiagramAdapter(final List<ProjectObj> iPieEntries, ProgressViewModel iProgressViewModel)
	{
		super(iPieEntries);
		mModel = iProgressViewModel;
	}
	
	@Override
	protected void itemClick(final int iPosition)
	{
		mModel.itemClicked(iPosition);
	}
}
