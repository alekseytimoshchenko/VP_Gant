package com.example.krokosha.vpgant.ui.diagramsModule.adapter;

import android.content.Context;
import android.graphics.Color;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.krokosha.vpgant.R;
import com.example.krokosha.vpgant.data.objects.ProjectObj;
import com.example.krokosha.vpgant.utils.Easing;
import com.github.mikephil.charting.charts.PieChart;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.PieData;
import com.github.mikephil.charting.data.PieDataSet;
import com.github.mikephil.charting.data.PieEntry;
import com.github.mikephil.charting.formatter.PercentFormatter;
import com.github.mikephil.charting.highlight.Highlight;
import com.github.mikephil.charting.listener.OnChartValueSelectedListener;
import com.github.mikephil.charting.utils.ColorTemplate;
import com.github.mikephil.charting.utils.MPPointF;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created with care by Alexey.T on 04/08/2018.
 */
public abstract class BaseDiagramAdapter extends RecyclerView.Adapter<BaseDiagramAdapter.ViewHolder>
{
	private List<ProjectObj> mProjectsList;
	
	protected BaseDiagramAdapter(List<ProjectObj> iPieEntries)
	{
		mProjectsList = iPieEntries;
	}
	
	public void setData(List<ProjectObj> iPieEntries)
	{
		mProjectsList = iPieEntries;
		notifyDataSetChanged();
	}
	
	@NonNull
	@Override
	public ViewHolder onCreateViewHolder(@NonNull final ViewGroup iParent, final int iI)
	{
		return new ViewHolder(LayoutInflater.from(iParent.getContext()).inflate(R.layout.item_diagram_layout, iParent, false), iParent.getContext());
	}
	
	@Override
	public void onBindViewHolder(@NonNull final ViewHolder iViewHolder, final int iI)
	{
		iViewHolder.bind(mProjectsList.get(iI));
	}
	
	@Override
	public int getItemCount()
	{
		return mProjectsList.size();
	}
	
	class ViewHolder extends RecyclerView.ViewHolder
	{
		@BindView(R.id.pc_diagram)
		PieChart mChart;
		
		private Context mContext;
		
		private ProjectObj mProjectObj;
		
		ViewHolder(@NonNull final View itemView, Context iContext)
		{
			super(itemView);
			ButterKnife.bind(this, itemView);
			mContext = iContext;
		}
		
		void bind(ProjectObj iPieEntries)
		{
			mProjectObj = iPieEntries;
			
			mChart.setCenterText(mProjectObj.getProjName());
			mChart.setHoleColor(Color.WHITE);
			mChart.setTransparentCircleColor(Color.WHITE);
			mChart.setHoleRadius(58f);
			mChart.setTransparentCircleRadius(61f);
			// enable rotation of the chart by touch
			mChart.setRotationEnabled(true);
			mChart.setHighlightPerTapEnabled(false);
			
			setData(mProjectObj.getEntries());
			
			mChart.animateY(1400, Easing.EaseInOutQuad);
			mChart.getLegend().setEnabled(false);
			mChart.setEntryLabelColor(mContext.getColor(R.color.blue_color_light));
			mChart.setEntryLabelTextSize(8f);
			mChart.setOnChartValueSelectedListener(mListener);
			mChart.setDrawHoleEnabled(true);
			mChart.setHighlightPerTapEnabled(true);
		}
		
		private void setData(List<PieEntry> iPieEntries)
		{
			PieDataSet dataSet = new PieDataSet(iPieEntries, "Project stat");
			dataSet.setDrawIcons(false);
			dataSet.setSliceSpace(3f);
			dataSet.setIconsOffset(new MPPointF(0, 40));
			dataSet.setSelectionShift(5f);
			
			ArrayList<Integer> colors = new ArrayList<>();
			
			for (int c : ColorTemplate.VORDIPLOM_COLORS)
			{
				colors.add(c);
			}
			
			colors.add(ColorTemplate.getHoloBlue());
			
			dataSet.setColors(colors);
			//dataSet.setSelectionShift(0f);
			
			PieData data = new PieData(dataSet);
			data.setValueFormatter(new PercentFormatter());
			data.setValueTextSize(9f);
			data.setValueTextColor(mContext.getColor(R.color.blue_color_dark));
			mChart.setData(data);
			
			// undo all highlights
			mChart.highlightValues(null);
			mChart.invalidate();
		}
		
		private OnChartValueSelectedListener mListener = new OnChartValueSelectedListener()
		{
			@Override
			public void onValueSelected(final Entry e, final Highlight h)
			{
				itemClick(mProjectObj.getId());
			}
			
			@Override
			public void onNothingSelected()
			{
				itemClick(mProjectObj.getId());
			}
		};
	}
	
	protected abstract void itemClick(int iPosition);
}
