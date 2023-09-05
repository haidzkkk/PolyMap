package com.example.polymap.ui.chat

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.polymap.R


class ChatFragment : Fragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.e("TAG", "ChatFragment onCreate: " )
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        Log.e("TAG", "ChatFragment onCreateView: " )
        return inflater.inflate(R.layout.fragment_chat, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        Log.e("TAG", "ChatFragment onViewCreated: " )
    }

    override fun onPause() {
        Log.e("TAG", "ChatFragment onPause: " )
        super.onPause()
    }

    override fun onResume() {
        Log.e("TAG", "ChatFragment onResume: " )
        super.onResume()
    }

    override fun onDestroyView() {
        Log.e("TAG", "ChatFragment onDestroyView: " )
        super.onDestroyView()
    }

    override fun onDestroy() {
        Log.e("TAG", "ChatFragment onPause: " )
        super.onDestroy()
    }
}