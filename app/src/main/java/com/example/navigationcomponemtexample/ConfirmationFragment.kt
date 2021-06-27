package com.example.navigationcomponemtexample

import android.os.Bundle
import android.os.Parcelable
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.NavController
import androidx.navigation.Navigation
import kotlinx.android.synthetic.main.fragment_confirmation.*


class ConfirmationFragment : Fragment(),View.OnClickListener {

    private lateinit var list: ArrayList<DummyModel>
    private  lateinit var  navControler: NavController

    lateinit var recipient: String
    lateinit var money: Money
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        recipient = requireArguments().getString("recipient").toString()
        money = requireArguments().getParcelable("amount")!!
            list=arguments?.getParcelableArrayList<DummyModel>("list") as ArrayList<DummyModel>


    }
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_confirmation, container, false)
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        navControler= Navigation.findNavController(view)

        Home_btn.setOnClickListener(this)
        val amount=money!!.amount

        confirmation_message.text = "You have sent $amount to $recipient"

        print("debug: $list")
    }
    override fun onClick(v: View?) {
        when (v!!.id){
            R.id.Home_btn->navControler!!.navigate(R.id.action_confirmationFragment_to_mainFragment2)

        }

    }


}