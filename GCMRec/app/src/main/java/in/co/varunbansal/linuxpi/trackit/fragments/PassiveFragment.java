package in.co.varunbansal.linuxpi.trackit.fragments;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

import in.co.varunbansal.linuxpi.trackit.R;

import static in.co.varunbansal.linuxpi.trackit.helper.StaticConstants.*;

public class PassiveFragment extends Fragment {

    public static String FRAGMENT_TAG;
    private static ArrayAdapter<String> adapter;
    private static ArrayList<String> activeUsers;
    private ListView activeUsersList;

    public PassiveFragment() {

    }

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View myView = inflater.inflate(R.layout.passive_layout, container, false);

        activeUsers = new ArrayList<>();
        adapter = new ArrayAdapter<>(getActivity(), android.R.layout.simple_list_item_1, activeUsers);

        activeUsersList = (ListView) myView.findViewById(R.id.active_user_list);
        activeUsersList.setAdapter(adapter);

        FRAGMENT_TAG = getTag();

        return myView;
    }

    public void updateActiveUsersList(ArrayList<String> list) {
//        activeUsers.remove(0);
        emptyList();
        activeUsers.addAll(list);
        adapter.notifyDataSetChanged();

        Log.i(LOG_TAG, "Task Complete");
    }

    public void emptyList(){
        activeUsers.clear();
        adapter.notifyDataSetChanged();
    }

    public void addNewActiveUser(String unKey) {
        activeUsers.add(unKey);
        adapter.notifyDataSetChanged();
    }

    public void removeActiveUser(String unKey) {
        Log.i(LOG_TAG,"removing entry :: "+unKey);
        if(activeUsers.contains(unKey)) {
            activeUsers.remove(activeUsers.indexOf(unKey));
            adapter.notifyDataSetChanged();
        }
    }
}

