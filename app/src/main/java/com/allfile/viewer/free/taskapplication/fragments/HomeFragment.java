package com.allfile.viewer.free.taskapplication.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.allfile.viewer.free.taskapplication.R;
import com.allfile.viewer.free.taskapplication.adapters.NewsAdapter;
import com.allfile.viewer.free.taskapplication.adapters.PaymentAdapter;
import com.allfile.viewer.free.taskapplication.databinding.FragmentHomeBinding;
import com.allfile.viewer.free.taskapplication.model.DataModel;

import java.util.ArrayList;

public class HomeFragment extends Fragment {
    private FragmentHomeBinding binding;
    ArrayList<DataModel> dataModelArrayList =new ArrayList<>();
    ArrayList<DataModel> dataModel_payment_ArrayList =new ArrayList<>();
    private NewsAdapter newsAdapter;
    private PaymentAdapter paymentAdapter;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = FragmentHomeBinding.inflate(getLayoutInflater());
        View rootview = binding.getRoot();
        init();
        return rootview;
    }
    private void init()
    {
     new_list();
     payment_list();
    }
    private void new_list()
    {
        DataModel dataModel=new DataModel();
        for (int i=0;i<=10;i++)
        {
            dataModel.setImg_id(R.drawable.show_img);
            dataModel.setImg_txt("picture of K2");
            dataModelArrayList.add(dataModel);
        }
        newsAdapter = new NewsAdapter(dataModelArrayList);
        binding.recNews.setHasFixedSize(true);
        binding.recNews.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, true));
        binding.recNews.setAdapter(newsAdapter);
    }
    private void payment_list()
    {
        DataModel dataModel=new DataModel();
        for (int i=0;i<=10;i++)
        {
            dataModel.setImg_id(R.drawable.ic_money);
            dataModel.setImg_txt("Payment History");
            dataModel_payment_ArrayList.add(dataModel);
        }
        paymentAdapter = new PaymentAdapter(dataModel_payment_ArrayList);
        binding.recPayment.setHasFixedSize(true);
        binding.recPayment.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, true));
        binding.recPayment.setAdapter(paymentAdapter);
    }
}
