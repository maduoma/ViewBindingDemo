package com.dodemy.viewbindingdemo

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.Toast
import com.dodemy.viewbindingdemo.databinding.Fragment1Binding


class Fragment1 : Fragment() {
    // assign the _binding variable initially to null and
    // also when the view is destroyed again it has to be set to null
    private var _binding: Fragment1Binding? = null

    // with the backing property of the kotlin we extract
    // the non null value of the _binding
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        // inflate the layout and bind to the _binding
        _binding = Fragment1Binding.inflate(inflater, container, false)

        // retrieve the entered data by the user
        binding.doneButton1.setOnClickListener {
            val str: String = binding.editText1.text.toString()
            if (str.isNotEmpty()) {
                Toast.makeText(activity, str, Toast.LENGTH_SHORT).show()
            } else {
                Toast.makeText(activity, "Please Enter Data", Toast.LENGTH_SHORT).show()
            }
        }

        // handle the button from the host activity using findViewById method
        val submitButton: Button = requireActivity().findViewById(R.id.submitBtn)
        submitButton.setOnClickListener {
            Toast.makeText(activity, "Host Activity Element Clicked from Fragment 1", Toast.LENGTH_SHORT).show()
        }

        // Inflate the layout for this fragment
        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}