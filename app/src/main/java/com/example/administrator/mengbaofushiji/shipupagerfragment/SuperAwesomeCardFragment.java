/*
 * Copyright (C) 2013 Andreas Stuetz <andreas.stuetz@gmail.com>
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.example.administrator.mengbaofushiji.shipupagerfragment;
import com.example.administrator.mengbaofushiji.R;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
public class SuperAwesomeCardFragment extends Fragment {

	private static final String ARG_POSITION = "position";

	private int position;
	private static final int[] layout = {
            R.layout.pager_fushi_six_fragment,
            R.layout.pager_fushi_seven_fragment,
            R.layout.pager_fushi_eight_fragment,
            R.layout.pager_fushi_nine_fragment,
            R.layout.pager_fushi_ten_fragment,
            R.layout.pager_fushi_elen_fragment,
            R.layout.pager_fushi_twe_fragment,
            R.layout.pager_fushi_one_fragment,
            R.layout.pager_fushi_two_fragment,
            R.layout.pager_fushi_three_fragment
            };

	public static SuperAwesomeCardFragment newInstance(int position) {
		SuperAwesomeCardFragment f = new SuperAwesomeCardFragment();
		Bundle b = new Bundle();
		b.putInt(ARG_POSITION, position);
		f.setArguments(b);
		return f;
	}
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		position = getArguments().getInt(ARG_POSITION);
	}
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view=inflater.inflate(layout[position],container,false);
		return view;
	}


}