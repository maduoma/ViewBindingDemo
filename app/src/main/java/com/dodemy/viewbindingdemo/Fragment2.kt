package com.dodemy.viewbindingdemo

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.Toast
import com.dodemy.viewbindingdemo.databinding.Fragment2Binding

class Fragment2 : Fragment() {
    // assign the _binding variable initially to null and
    // also when the view is destroyed again it has to be
    // set to null
    private var _binding: Fragment2Binding? = null

    // with the backing property of the kotlin
    // we extract
    // the non null value of the _binding
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        // inflate the layout and bind to the _binding
        _binding = Fragment2Binding.inflate(inflater, container, false)

        // retrieve the entered data by the user
        binding.doneButton2.setOnClickListener {
            val str: String = binding.editText2.text.toString()
            if (str.isNotEmpty()) {
                Toast.makeText(activity, str, Toast.LENGTH_SHORT).show()
            } else {
                Toast.makeText(activity, "Please Enter Data", Toast.LENGTH_SHORT).show()
            }
        }

        // handle the button from the host activity using findViewById method
        val submitButton: Button = requireActivity().findViewById(R.id.submitBtn)
        submitButton.setOnClickListener {
            Toast.makeText(activity, "Host Activity Element Clicked from Fragment 2", Toast.LENGTH_SHORT).show()
        }

        // Inflate the layout for this fragment
        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}