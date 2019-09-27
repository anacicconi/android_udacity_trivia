package com.example.android.navigation


import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import androidx.databinding.DataBindingUtil
import androidx.navigation.Navigation
import androidx.navigation.findNavController
import androidx.navigation.ui.NavigationUI
import com.example.android.navigation.databinding.FragmentTitleBinding

/**
 * A simple [Fragment] subclass.
 */
class TitleFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {

        val binding = DataBindingUtil.inflate<FragmentTitleBinding>(inflater, R.layout.fragment_title, container, false)

        /* binding.playButton.setOnClickListener { view: View ->
            //Navigation.findNavController(view).navigate(R.id.action_titleFragment_to_gameFragment)
            // another possibility for kotlin
            view.findNavController().navigate(R.id.action_titleFragment_to_gameFragment)
        } */

        binding.playButton.setOnClickListener { view: View ->
            // Navigation.createNavigateOnClickListener(R.id.action_titleFragment_to_gameFragment))
            view.findNavController().navigate(TitleFragmentDirections.actionTitleFragmentToGameFragment())
        }

        // only this fragment will have the menu
        setHasOptionsMenu(true)

        return binding.root
    }

    // in order to create the menu we have to manually inflate it
    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        inflater?.inflate(R.menu.overflow_menu, menu)
    }

    // when an item is selected in the menu this method is called
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return NavigationUI.onNavDestinationSelected(item!!,
                view!!.findNavController())
                || super.onOptionsItemSelected(item)
    }
}
