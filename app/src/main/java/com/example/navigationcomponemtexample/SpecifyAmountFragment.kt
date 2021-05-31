package com.example.navigationcomponemtexample

import android.annotation.SuppressLint
import android.os.Bundle
import android.text.TextUtils
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.navigation.NavController
import androidx.navigation.Navigation
import kotlinx.android.synthetic.main.fragment_specify_amount.*
import java.math.BigDecimal


class SpecifyAmountFragment : Fragment() ,View.OnClickListener{
    private lateinit var model: DummyModel
    val dummyList: MutableList<DummyModel> = java.util.ArrayList()

    private  lateinit var  navControler: NavController
    lateinit var recipient : String

    @SuppressLint("UseRequireInsteadOfGet")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        recipient= arguments!!.getString("recipient")!!

        println("debug: $recipient")
    }


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_specify_amount, container, false)
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        navControler= Navigation.findNavController(view)
        send_btn.setOnClickListener(this)
        text_recipient.setText("Sending money to $recipient")
        dummydata()

    }

    private fun dummydata() {
        for (i in 1..5){
            if (i==1)
             model=DummyModel("Arindam","02/08/1991")
            else if (i==2)
                model=DummyModel("Android","02/08/1991")

            else
                model=DummyModel("Dummy","02/08/1991")


            dummyList.add(model)

        }

        print("debug: $dummyList")
    }

    override fun onClick(v: View?) {
        when(v!!.id){

            R.id.send_btn->{
                if (!TextUtils.isEmpty(input_amount.text.toString())){
                    val amount=Money(BigDecimal(input_amount.text.toString()))
                    val bundle= bundleOf("recipient" to recipient,"amount" to amount,"list" to dummyList)

                    navControler!!.navigate(R.id.action_specifyAmountFragment_to_confirmationFragment,bundle)
                }

            }
        }
    }


}