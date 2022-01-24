package net.preibisch.bdvshare.core.serialization.serializers;

import mpicbg.spim.data.sequence.ViewId;

import java.io.Serializable;

public class ViewIdSerializable implements Serializable {

	private int timepoint;
	private int setup;

	public ViewIdSerializable(int timePoint, int setup) {
		this.timepoint = timePoint;
		this.setup = setup;
	}

	public ViewIdSerializable(ViewId viewId) {
		this(viewId.getTimePointId(), viewId.getViewSetupId());
	}

	public int getSetup() {
		return setup;
	}

	public int getTimepoint() {
		return timepoint;
	}
	
	public ViewId toViewId() {
		return new ViewId(timepoint, setup);
	}
}
