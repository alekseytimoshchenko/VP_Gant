package com.example.krokosha.vpgant.ui.diagramsModule.finishProjectFrag;

import com.example.krokosha.vpgant.data.objects.ProjectObj;
import com.example.krokosha.vpgant.ui.diagramsModule.adapter.BaseDiagramAdapter;

import java.util.List;

/**
 * Created with care by Alexey.T on 04/08/2018.
 * <p>
 * TODO: Add a class header comment!
 */
public class FinishedDiagramAdapter extends BaseDiagramAdapter
{
	private FinishedFragViewModel mModel;
	
	FinishedDiagramAdapter(final List<ProjectObj> iPieEntries, FinishedFragViewModel iModel)
	{
		super(iPieEntries);
		mModel = iModel;
	}
	
	@Override
	protected void itemClick(final int iPosition)
	{
		mModel.itemClicked(iPosition);
	}
}
