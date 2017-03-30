package com.nt.najboljekafane.view;

import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;

import com.google.android.gms.maps.GoogleMap.InfoWindowAdapter;
import com.google.android.gms.maps.model.Marker;
import com.nt.najboljekafane.R;

public class KafanaMapInfoAdapter implements InfoWindowAdapter {
	LayoutInflater inflater = null;

	public KafanaMapInfoAdapter(LayoutInflater inflater) {
		this.inflater = inflater;
	}

	@Override
	public View getInfoWindow(Marker marker) {
		return (null);
	}

	@Override
	public View getInfoContents(Marker marker) {
		View popup = inflater.inflate(R.layout.kafana_popup, null);

		TextView tv = (TextView) popup.findViewById(R.id.title);

		tv.setText(marker.getTitle());
		tv = (TextView) popup.findViewById(R.id.snippet);
		String[] snip = marker.getSnippet().split("#");
		tv.setText(snip[0]);
		if (snip.length > 1) {
			tv = (TextView) popup.findViewById(R.id.radno_vreme);
			tv.setText(snip[1]);
		}

		return (popup);
	}
}
